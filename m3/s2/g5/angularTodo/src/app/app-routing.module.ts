import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/Pages/home/home.component';
import { CompletedComponent } from './Components/Pages/completed/completed.component';
import { NotCompletedComponent } from './Components/Pages/not-completed/not-completed.component';
import { UserPageComponent } from './Components/Pages/user-page/user-page.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
  },
  {
    path: 'completed',
    component: CompletedComponent,
  },
  {
    path: 'notCompleted',
    component: NotCompletedComponent,
  },
  {
    path: 'user',
    component: UserPageComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
