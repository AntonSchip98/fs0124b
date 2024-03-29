import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotCompletedComponent } from './not-completed.component';

describe('NotCompletedComponent', () => {
  let component: NotCompletedComponent;
  let fixture: ComponentFixture<NotCompletedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NotCompletedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NotCompletedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
