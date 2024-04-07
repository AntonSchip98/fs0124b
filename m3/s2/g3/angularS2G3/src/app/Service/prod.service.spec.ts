import { TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController
} from '@angular/common/http/testing';
import { IProd } from '../Models/i-prod';
import { ProdService } from './prod.service';

describe('ProdService', () => {
  let service: ProdService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [ProdService]
    });
    service = TestBed.inject(ProdService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });

  it(`apiUrl has default value`, () => {
    expect(service.apiUrl).toEqual(`https://dummyjson.com/products`);
  });

  describe('getAll', () => {
    it('makes expected calls', () => {
      const httpTestingController = TestBed.inject(HttpTestingController);
      service.getAll().subscribe(res => {
        expect(res).toEqual();
      });
      const req = httpTestingController.expectOne(
        'https://dummyjson.com/products'
      );
      expect(req.request.method).toEqual('GET');
      req.flush();
      httpTestingController.verify();
    });
  });
});
