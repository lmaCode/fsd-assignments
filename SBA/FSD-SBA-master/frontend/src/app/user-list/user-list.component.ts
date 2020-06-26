import { Component, OnInit, Input } from '@angular/core';
import { Course } from '../models/course';
import { CourseService } from '../service/course.service';
import { AlertService } from '../service/alert.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  loading = false;
  courses: any;
  showCourse: boolean;
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
    this.showCourse = true;
    this.courseservice.searchCourses().subscribe(courses => {
      // tslint:disable-next-line:no-string-literal
        this.courses = courses;
        this.showCourse = false;
    },
    error => {
          this.alertService.error(error);
          this.showCourse = false;
          });
  }

  vote() {
    console.log('vote');
  }

  book(id: number, mentor: string) {

    this.loading = true;
    this.username = JSON.parse(localStorage.getItem('currentUser')).username;
    this.courseservice.bookCourses(id, this.username, mentor).subscribe(data => {
        this.alertService.success(data.toString());
        this.loading = false;
        this.searchCourses();
    },
    error => {
      this.alertService.error(error);
      this.loading = false;
      });


  }

  selectCourseClick(tab) {

    this.username = JSON.parse(localStorage.getItem('currentUser')).username;

    if (tab.index === 0) {
      this.searchCourses();
    } else {
      this.showCourse = true;
      this.courseservice.findUserCourses(tab.index, this.username).subscribe(data => {
        this.showCourse = false;
        this.courses = data;
    },
    error => {
      this.showCourse = false;
      this.alertService.error(error);
      });
  }
    }


}
