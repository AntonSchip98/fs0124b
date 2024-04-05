import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { ILogData } from '../../Interface/i-log-data';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  loginData: ILogData = {
    email: '',
    password: '',
  };

  constructor(private authSvc: AuthService, private router: Router) {}

  signIn() {
    this.authSvc.login(this.loginData).subscribe((data) => {
      this.router.navigate(['/movieList']);
    });
  }
}
