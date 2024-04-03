import { Component, ViewChild } from '@angular/core';
import { RegisterService } from '../../Service/register.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  @ViewChild('f', { static: true }) form!: NgForm;

  loginObj = {
    username: '',
    password: '',
  };

  registerObj = {
    name: '',
    surname: '',
    password: '',
    confirmPassword: '',
    select: '',
    biography: '',
    username: '',
  };

  constructor(private registerSvc: RegisterService, private router: Router) {}

  ngOnInit() {
    this.registerObj = this.registerData();
    console.log(this.registerObj);
  }

  submit(form: NgForm) {
    this.loginObj = this.form.value;
    if (
      this.loginObj.username === this.registerObj.username &&
      this.loginObj.password === this.registerObj.password
    ) {
      this.router.navigate(['/']);
      console.log('va');
    }
    // console.log(this.loginObj); //posso anche leggerlo grazie a viewChild
  }

  registerData() {
    return this.registerSvc.getFormData().value;
  }
}
