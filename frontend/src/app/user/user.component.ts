import { Component, OnInit, NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { UserService } from "../shared/user/user.service";

@NgModule({
  imports: [NgbModule]
})

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})

export class UserComponent implements OnInit {
  title: 'User Profile';
  users: Array<any>;

  constructor(private userService: UserService) { }

 ngOnInit(){
    this.userService.getAll().subscribe(
      data => {
        this.users = data;
      },
      error => console.log(error)
    )
  }
}
