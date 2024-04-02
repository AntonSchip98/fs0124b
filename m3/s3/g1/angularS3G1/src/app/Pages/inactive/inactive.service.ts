import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class InactiveService {
  constructor() {}

  isLogged() {
    return false;
  }
}
