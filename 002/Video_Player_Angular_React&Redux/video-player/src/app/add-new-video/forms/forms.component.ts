import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

import { VideoService } from '../../videoService';

//import { SnackbarComponent } from '~components/snackbar/snackbar.component';

@Component({
    selector: 'app-forms',
    templateUrl: './forms.component.html',
    styleUrls: ['./forms.component.css'],
    providers: [VideoService,MatSnackBar]
})

export class FormsComponent {
    frm: FormGroup;

    constructor(
        public dialogRef: MatDialogRef<FormsComponent>,
        @Inject(MAT_DIALOG_DATA)
        public data: any,
        private fb: FormBuilder,
        private videoService: VideoService,
        public snack: MatSnackBar
    ) { }

    onNoClick(): void {
        this.dialogRef.close();
    }

    ngOnInit() {
        this.initializeForm();
    }

    // openSnack(data) {
    //     this.snack.openFromComponent(SnackbarComponent, {
    //         data: { data: data },
    //         duration: 3000
    //     });
    // }

    initializeForm() {
        const IS_EDITING = this.data.action === 'edit';
        let data = this.data.data;

        this.frm = this.fb.group({
            title: new FormControl(IS_EDITING ?  data.title : null, [Validators.required, Validators.minLength(3)]),
            url: new FormControl(IS_EDITING ? data.url : null, [Validators.required, Validators.minLength(3)]),
            id: new FormControl(IS_EDITING ? data.id : null),
            status: new FormControl(IS_EDITING ?  data.status : null, [Validators.required, Validators.minLength(3)]),
            approved: new FormControl("false"),
            likes: new FormControl(IS_EDITING ? data.likes : null),
            unlike: new FormControl(IS_EDITING ?  data.unlike : null, [Validators.required, Validators.minLength(3)]),
            currentStatus: new FormControl(IS_EDITING ? data.currentStatus : null, [Validators.required, Validators.minLength(3)]),
            exitplayprogress: new FormControl(IS_EDITING ? data.exitplayprogress : null)
        });
    }

     // test:Video={
  //   "title": "Test Me",
  //   "url": "https://www.youtube.com/watch?v=pAluQXDTM9g",
  //   "status": "added",
  //   "approved": true,
  //   "likes": 22,
  //   "unlike": 4,
  //   "currentStatus": "playing",
  //   "exitplayprogress": 30
  // }

    save(form: FormGroup) {
        this.videoService.save(form.value).subscribe((data: any) => {
            if (data.success) {
                this.dialogRef.close(true);
                //this.openSnack(data);
            } else {
               // this.openSnack(data);
            }
        });
    }

    update(form: FormGroup) {
      this.videoService.update(form.value).subscribe((data: any) => {
              this.dialogRef.close(true);

      });
  }

    getNameErrorMessage() {
        return this.frm.controls.title.hasError('required') ? 'First name is required' :
            this.frm.controls.title.hasError('minlength') ? 'Al menos 2 caracteres' : '';
    }
    getLastNameErrorMessage() {
        return this.frm.controls.url.hasError('required') ? 'Last name is required' :
            this.frm.controls.url.hasError('minlength') ? 'Al menos 2 caracteres' : '';
    }
    // getAgeErrorMessage() {
    //     return this.frm.controls.age.hasError('required') ? 'Age is required' :
    //         this.frm.controls.age.hasError('minlength') ? 'Al menos un numero debe ser ingresado' : '';
    // }
    // getGenderErrorMessage() {
    //     return this.frm.controls.gender.hasError('required') ? '' : '';
    // }
}
