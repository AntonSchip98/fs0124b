import { TestBed } from '@angular/core/testing';
import { ActivatedRouteSnapshot } from '@angular/router';
import { RouterStateSnapshot } from '@angular/router';
import { GuardGuard } from './guard.guard';

describe('GuardGuard', () => {
  let service: GuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [GuardGuard] });
    service = TestBed.inject(GuardGuard);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });
});
