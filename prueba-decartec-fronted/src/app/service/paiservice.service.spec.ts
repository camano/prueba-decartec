import { TestBed } from '@angular/core/testing';

import { PaiserviceService } from './paiservice.service';

describe('PaiserviceService', () => {
  let service: PaiserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PaiserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
