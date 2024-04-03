import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RegisterService } from '../../Service/register.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.scss',
})
export class RegistrationComponent {
  register!: FormGroup;

  constructor(private fb: FormBuilder, private formDataSvc: RegisterService) {}

  selectedGenres: string = '';

  genres: string[] = ['uomo', 'donna', 'altro'];

  ngOnInit() {
    this.register = this.fb.group({
      name: this.fb.control(null, [Validators.required]),
      surname: this.fb.control(null, [Validators.required]),
      password: this.fb.control(null, [Validators.required]),
      confirmPassword: this.fb.control(null, [Validators.required]),
      select: this.fb.control(null, [Validators.required]),
      biography: this.fb.control(null),
      username: this.fb.control(null, [Validators.required]),
    });

    this.formDataSvc.setFormData(this.register);
  }
}
