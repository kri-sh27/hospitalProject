import { TestBed } from '@angular/core/testing';

import { GetappointmentbyidService } from './getappointmentbyid.service';

describe('GetappointmentbyidService', () => {
  let service: GetappointmentbyidService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetappointmentbyidService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
