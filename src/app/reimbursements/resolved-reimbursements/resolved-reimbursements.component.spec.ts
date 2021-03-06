import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResolvedReimbursementsComponent } from './resolved-reimbursements.component';

describe('ResolvedReimbursementsComponent', () => {
  let component: ResolvedReimbursementsComponent;
  let fixture: ComponentFixture<ResolvedReimbursementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ResolvedReimbursementsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResolvedReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
