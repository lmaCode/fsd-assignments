import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NewCourse } from '../models/newCourse';
import { NewRate } from '../models/newRate';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient) { }

  addCourse(course: NewCourse) {
    return this.http.post(`${environment.gatewayurl}/training/api/training/add`, course);
  }

  findCourses() {
    return this.http.get(`${environment.gatewayurl}/search/api/search/course/list`);
  }

  searchCourses() {
    return this.http.get(`${environment.gatewayurl}/training/api/training/enable/list`);
  }

  bookCourses(id: number, username: string, mentorname: string) {
    return this.http.post(`${environment.gatewayurl}/training/api/training/book/${id}/${username}`,{});
  }

  findUserCourses(tabIndex: number, username: string) {
    if(tabIndex == 2){
        return this.http.get(`${environment.gatewayurl}/training/api/training/my/list/user/completed/${username}`);
    }else{
        return this.http.get(`${environment.gatewayurl}/training/api/training/my/list/user/going/${username}`);
    }
  }

  findMentorCourses(tabIndex: number, username: string) {
    if(tabIndex == 2){
        return this.http.get(`${environment.gatewayurl}/training/api/training/my/list/mentor/completed/${username}`);
    }else{
        return this.http.get(`${environment.gatewayurl}/training/api/training/my/list/mentor/going/${username}`);
    }
  }

  deactivateCourses(id: number) {
    return this.http.post(`${environment.gatewayurl}/training/api/training/deactivate/${id}`,{});
  }
}
