import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InactiveGuard } from './Pages/inactive.guard';

const routes: Routes = [
  {
    path: '',
    loadChildren: () =>
      import('./Pages/home/home.module').then((m) => m.HomeModule),
  },
  {
    path: 'active',
    loadChildren: () =>
      import('./Pages/active/active.module').then((m) => m.ActiveModule),
  },
  {
    path: 'inactive',
    loadChildren: () =>
      import('./Pages/inactive/inactive.module').then((m) => m.InactiveModule),
    canActivate: [InactiveGuard],
    canActivateChild: [InactiveGuard],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
