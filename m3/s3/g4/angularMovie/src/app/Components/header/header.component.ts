import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import {
  faRightFromBracket,
  faUserGear,
} from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent {
  show: boolean = false;
  isUserLoggedIn: boolean = false;
  isUserRegistered: boolean = false;
  faUser = faUserGear;
  faexit = faRightFromBracket;
  constructor(private authSvc: AuthService) {}

  ngOnInit() {
    this.authSvc.isLoggedIn$.subscribe((data) => {
      this.isUserLoggedIn = data;
    });

    this.authSvc.isUserRegistered$.subscribe((data) => {
      this.isUserRegistered = data;
    });
  }

  logout() {
    this.authSvc.logout();
  }
}
