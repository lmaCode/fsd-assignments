import { Component, OnInit, Inject, Input } from '@angular/core';
import {FormBuilder, Validators, FormGroup} from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import * as moment from 'moment';
import { NewCourse } from '../models/newCourse';
import { CourseService } from '../service/course.service';
import { AlertService } from '../service/alert.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {

  form: FormGroup;
  loading = false;
  submitted = false;
  username: string;
  constructor(
    private fb: FormBuilder,
    private dialogRef: MatDialogRef<AddCourseComponent>,
    @Inject(MAT_DIALOG_DATA) {username},
    private courseService: CourseService,
    private alertService: AlertService) {
      this.username = username;
      this.form = fb.group({
        startAt: [moment(), Validators.required],
        endAt: [moment(), Validators.required],
        skillId: ['', Validators.required],
        fees: ['', Validators.required],
        mentorName: [username]
        });
    }

  ngOnInit() {
  }

  save() {
    if (this.form.valid) {
      const course: NewCourse = {
        skillId: this.form.value.skillId,
        skillName: '',
        startDate: this.form.value.startAt,
        endDate: this.form.value.endAt,
        mentorId: '',
        mentorName: this.form.value.mentorName,
        fees: this.form.value.fees
      };
      this.submitted = true;

      // reset alerts on submit
      this.alertService.clear();

      this.loading = true;
      this.courseService.addCourse(course)
      .pipe(first())
        .subscribe(
            data => {
              // tslint:disable-next-line:no-string-literal
                // tslint:disable-next-line:no-string-literal
                this.alertService.success(data.toString());
            },
            error => {
                this.alertService.error(error);
                this.loading = false;
            });
      this.dialogRef.close(course);
    }
}

close() {
    this.dialogRef.close();
}

}
