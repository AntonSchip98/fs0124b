import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  formData!: FormGroup;

  setFormData(data: FormGroup) {
    this.formData = data;
  }

  getFormData() {
    return this.formData;
  }
}
