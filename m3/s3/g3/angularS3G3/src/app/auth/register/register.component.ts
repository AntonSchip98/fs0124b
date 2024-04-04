import { Component } from '@angular/core';
import { IUser } from '../../Interface/i-user';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  registeData: Partial<IUser> = {};

  constructor(private authSvc: AuthService, private router: Router) {}

  signUp() {
    this.authSvc.register(this.registeData).subscribe((data) => {
      this.router.navigate(['dashboard']);
    });
  }
}
