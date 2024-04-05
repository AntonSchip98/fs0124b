import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisteredUserComponent } from './registered-user.component';

const routes: Routes = [{ path: '', component: RegisteredUserComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegisteredUserRoutingModule { }
