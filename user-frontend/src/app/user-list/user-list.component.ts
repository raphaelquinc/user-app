import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
selector: 'app-user-list',
templateUrl: './user-list.component.html',
styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

groups: Map<string, User[]>;

constructor(private userService: UserService) {

  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.groups = data;
    });
  }

  delete(event) {
    let userId: string = event.target.id;
    this.userService.delete(userId).subscribe(result => this.ngOnInit());
  }
}
