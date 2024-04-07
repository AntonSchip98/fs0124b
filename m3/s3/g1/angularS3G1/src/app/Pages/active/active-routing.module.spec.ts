import { TestBed } from '@angular/core/testing';
import { ActiveRoutingModule } from './active-routing.module';

describe('ActiveRoutingModule', () => {
  let pipe: ActiveRoutingModule;

  beforeEach(() => {
    TestBed.configureTestingModule({ providers: [ActiveRoutingModule] });
    pipe = TestBed.inject(ActiveRoutingModule);
  });

  it('can load instance', () => {
    expect(pipe).toBeTruthy();
  });
});
