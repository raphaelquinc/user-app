import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

private usersUrl: string;
private usersPath: string;
private userPath: string;

constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080';
    this.usersPath = "/users";
    this.userPath = "/user";
  }

  public findAll(): Observable<Map<string, User[]>> {
    return this.http.get<Map<string, User[]>>(this.usersUrl.concat(this.usersPath));
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl.concat(this.userPath), user);
  }

  public delete(userId: string) {
    return this.http.delete<User>(this.usersUrl.concat(this.userPath).concat("?userId=").concat(userId));
  }
}
