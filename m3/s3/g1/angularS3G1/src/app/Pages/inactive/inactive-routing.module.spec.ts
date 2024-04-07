import { TestBed } from '@angular/core/testing';
import { InactiveRoutingModule } from './inactive-routing.module';

describe('InactiveRoutingModule', () => {
  let pipe: InactiveRoutingModule;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [InactiveRoutingModule] });
    pipe = TestBed.inject(InactiveRoutingModule);
  });

  it('can load instance', () => {
    expect(pipe).toBeTruthy();
  });
});
