import { Injectable } from '@angular/core';
import {
  ActivatedRouteSnapshot,
  GuardResult,
  MaybeAsync,
  RouterStateSnapshot,
} from '@angular/router';
import { InactiveService } from './inactive/inactive.service';

@Injectable({
  providedIn: 'root',
})
export class InactiveGuard {
  constructor(private inactiveSvc: InactiveService) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): MaybeAsync<GuardResult> {
    return this.inactiveSvc.isLogged();
  }
  canActivateChild(
    childRoute: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): MaybeAsync<GuardResult> {
    return this.canActivate(childRoute, state);
  }
}
