import { TestBed } from '@angular/core/testing';
import { ActiveModule } from './active.module';

describe('ActiveModule', () => {
  let pipe: ActiveModule;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [ActiveModule] });
    pipe = TestBed.inject(ActiveModule);
  });

  it('can load instance', () => {
    expect(pipe).toBeTruthy();
  });
});
