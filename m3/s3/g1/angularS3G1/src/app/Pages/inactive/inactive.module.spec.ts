import { TestBed } from '@angular/core/testing';
import { InactiveModule } from './inactive.module';

describe('InactiveModule', () => {
  let pipe: InactiveModule;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [InactiveModule] });
    pipe = TestBed.inject(InactiveModule);
  });

  it('can load instance', () => {
    expect(pipe).toBeTruthy();
  });
});
