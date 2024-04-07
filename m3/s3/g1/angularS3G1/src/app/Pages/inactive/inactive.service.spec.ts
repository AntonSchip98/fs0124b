import { TestBed } from '@angular/core/testing';
import { InactiveService } from './inactive.service';

describe('InactiveService', () => {
  let service: InactiveService;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [InactiveService] });
    service = TestBed.inject(InactiveService);
  });

  it('can load instance', () => {
    expect(service).toBeTruthy();
  });
});
