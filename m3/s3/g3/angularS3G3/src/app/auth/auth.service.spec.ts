import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { Router } from '@angular/router';
import { ILogData } from '../Interface/i-log-data';
import { AuthService } from './auth.service';

describe('AuthService', () => {
  let service: AuthService;

  beforeEach(() => {
    const routerStub = () => ({ navigate: array => ({}) });
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [AuthService, { provide: Router, useFactory: routerStub }]
    });
    service = TestBed.inject(AuthService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  it(`registerUrl has default value`, () => {
    expect(service.registerUrl).toEqual(environment.registerUrl);
  });

  it(`loginUrl has default value`, () => {
    expect(service.loginUrl).toEqual(environment.loginUrl);
  });

  describe('login', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      const iLogDataStub: ILogData = <any>{};
      spyOn(component, 'autoLogout').and.callThrough();
      service.login(iLogDataStub).subscribe(res => {
        expect(res).toEqual(iLogDataStub);
      });
      expect(service.autoLogout).toHaveBeenCalled();
      const req = httpTestingController.expectOne('environment.registerUrl');
      expect(req.request.method).toEqual('POST');
      req.flush(iLogDataStub);
      httpTestingController.verify();
    });
  });

  describe('logout', () => {
    it('makes expected calls', () => {
      const routerStub: Router = TestBed.inject(Router);
      spyOn(routerStub, 'navigate').and.callThrough();
      service.logout();
      expect(routerStub.navigate).toHaveBeenCalled();
    });
  });

  describe('restoreUser', () => {
    it('makes expected calls', () => {
      spyOn(component, 'autoLogout').and.callThrough();
      service.restoreUser();
      expect(service.autoLogout).toHaveBeenCalled();
    });
  });
});
