import { TestBed } from '@angular/core/testing';

import { AppointmentlistforadminService } from './appointmentlistforadmin.service';

describe('AppointmentlistforadminService', () => {
  let service: AppointmentlistforadminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AppointmentlistforadminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
