import { TestBed } from '@angular/core/testing';
import { ActivatedRouteSnapshot } from '@angular/router';
import { RouterStateSnapshot } from '@angular/router';
import { AuthService } from './auth.service';
import { AuthGuard } from './auth.guard';

describe('AuthGuard', () => {
  let service: AuthGuard;

  beforeEach(() => {
    const authServiceStub = () => ({ isLoggedIn$: {} });
    TestBed.configureTestingModule({
      providers: [
        AuthGuard,
        { provide: AuthService, useFactory: authServiceStub }
      ]
    });
    service = TestBed.inject(AuthGuard);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });
});
