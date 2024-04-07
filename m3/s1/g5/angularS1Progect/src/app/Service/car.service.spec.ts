import { TestBed } from '@angular/core/testing';
import { CarService } from './car.service';

describe('CarService', () => {
  let service: CarService;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [CarService] });
    service = TestBed.inject(CarService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });
});
