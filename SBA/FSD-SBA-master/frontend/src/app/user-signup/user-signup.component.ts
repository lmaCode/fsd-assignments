import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { UserService } from '../service/user.service';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { NewUser } from '../models/newUser';
import { AlertService } from '../service/alert.service';
import { AuthenticationService } from '../service/authentication.service';
@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent implements OnInit {
  userForm: FormGroup;

  loading = false;
  submitted = false;

  constructor(private userService: UserService,
              private router: Router,
              private alertService: AlertService,
              private authenticationService: AuthenticationService) {
              // redirect to home if already logged in
              if (this.authenticationService.currentUserValue) {
                this.router.navigate(['/']);
      }
              }

  ngOnInit() {
    this.userForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      role: new FormControl('', Validators.required)
    });
  }
  hasError = (controlName: string, errorName: string) => {
    return this.userForm.controls[controlName].hasError(errorName);
  }



  addUser(userFormValue) {
    if (this.userForm.valid) {
      const user: NewUser = {
        email: userFormValue.email,
        pwd: userFormValue.password,
        role: userFormValue.role
      };
      this.submitted = true;

      // reset alerts on submit
      this.alertService.clear();

      this.loading = true;
      this.userService.addUser(user)
        .subscribe(
            data => {
                this.alertService.success('Registration successful', true);
                this.router.navigate(['/login']);
            },
            error => {
                this.alertService.error(error);
                this.loading = false;
            });
  }
}

}
