import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NewUser } from '../models/newUser';
import { environment } from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  addUser(user: NewUser) {
    return this.http.post(`${environment.gatewayurl}/security/api/auth/register`, user);
  }

  findUser(username: string) {
    return this.http.get(`${environment.gatewayurl}/user/api/user/findByEmail/${username}`);
  }

}
