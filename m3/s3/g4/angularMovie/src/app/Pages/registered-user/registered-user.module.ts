import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegisteredUserRoutingModule } from './registered-user-routing.module';
import { RegisteredUserComponent } from './registered-user.component';


@NgModule({
  declarations: [
    RegisteredUserComponent
  ],
  imports: [
    CommonModule,
    RegisteredUserRoutingModule
  ]
})
export class RegisteredUserModule { }
