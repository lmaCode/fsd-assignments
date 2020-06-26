import { Component, OnInit, Input } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../service/course.service';
import { AlertService } from '../service/alert.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  loading = false;
  courses: any;
  showInProgressCourse: boolean;
  showCompletedCourse: boolean;
  @Input() userRole: string;
  @Input() searchText: string;
  rating: string;
  username: string;

  constructor(private courseservice: CourseService,
                            private alertService: AlertService) { }

  ngOnInit() {
    this.searchCourses();
  }

  searchCourses() {
    this.showInProgressCourse = true;
    this.username = JSON.parse(localStorage.getItem('currentUser')).username;
    this.courseservice.findMentorCourses(1, this.username).subscribe(courses => {
      // tslint:disable-next-line:no-string-literal
        this.courses = courses;
        this.showInProgressCourse = false;
    },
    error => {
          this.alertService.error(error);
          this.showInProgressCourse = false;
          });
  }

  selectCourseClick(tab) {

    this.username = JSON.parse(localStorage.getItem('currentUser')).username;

    if (tab.index === 0) {
      this.searchCourses();
    } else {
      this.showInProgressCourse = true;
      this.courseservice.findMentorCourses(2, this.username).subscribe(data => {
        this.showInProgressCourse = false;
        this.courses = data;
    },
    error => {
      this.showInProgressCourse = false;
      this.alertService.error(error);
      });
  }
    }


  deactivate(id: number) {

    this.loading = true;
    this.courseservice.deactivateCourses(id).subscribe(data => {
        this.alertService.success(data.toString());
        this.loading = false;
        this.searchCourses();
    },
    error => {
      this.alertService.error(error);
      this.loading = false;
        this.searchCourses();
      });


  }
}
