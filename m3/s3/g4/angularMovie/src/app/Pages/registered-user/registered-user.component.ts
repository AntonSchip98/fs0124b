import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { IUser } from '../../Interface/i-user';

@Component({
  selector: 'app-registered-user',
  templateUrl: './registered-user.component.html',
  styleUrl: './registered-user.component.scss',
})
export class RegisteredUserComponent {
  userArr: IUser[] = [];

  constructor(private authSvc: AuthService) {}

  ngOnInit() {
    this.authSvc.getAll().subscribe((users) => {
      this.userArr = users;
    });
  }
}
