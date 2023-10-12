import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentlistforadminComponent } from './appointmentlistforadmin.component';

describe('AppointmentlistforadminComponent', () => {
  let component: AppointmentlistforadminComponent;
  let fixture: ComponentFixture<AppointmentlistforadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentlistforadminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointmentlistforadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
