import { TestBed } from '@angular/core/testing';

import { RequestsHttpService } from './requests-http.service';

describe('RequestsHttpService', () => {
  let service: RequestsHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RequestsHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
