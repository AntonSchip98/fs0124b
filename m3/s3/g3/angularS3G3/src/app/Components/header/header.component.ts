import { Component } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss',
})
export class HeaderComponent {
  show: boolean = false;
  isUserLoggedIn: boolean = false;

  constructor(private authSvc: AuthService, private router: Router) {}

  ngOnInit() {
    this.authSvc.isLoggedIn$.subscribe((data) => {
      this.isUserLoggedIn = data;
    });
  }

  exitButton(): boolean {
    return this.router.url === '/dashboard';
  }

  logout() {
    this.authSvc.logout();
  }
}
