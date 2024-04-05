import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardGuard } from './auth/guard.guard';
import { AuthGuard } from './auth/auth.guard';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./auth/auth.module').then((m) => m.AuthModule),
    canActivate: [GuardGuard],
    canActivateChild: [GuardGuard],
  },
  {
    path: 'movieList',
    loadChildren: () =>
      import('./Pages/movie-list/movie-list.module').then(
        (m) => m.MovieListModule
      ),
    canActivate: [AuthGuard],
  },
  {
    path: 'registeredUser',
    loadChildren: () =>
      import('./Pages/registered-user/registered-user.module').then(
        (m) => m.RegisteredUserModule
      ),
    canActivate: [AuthGuard],
  },
  {
    path: 'userProfile',
    loadChildren: () =>
      import('./Pages/user-profile/user-profile.module').then(
        (m) => m.UserProfileModule
      ),
    canActivate: [AuthGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
