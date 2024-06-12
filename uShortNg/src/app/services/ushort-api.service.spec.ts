import { TestBed } from '@angular/core/testing';

import { UshortApiService } from '../services/ushort-api.service';

describe('UshortApiService', () => {
  let service: UshortApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UshortApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
