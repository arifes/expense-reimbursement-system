import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateReimbursementsComponent } from './update-reimbursements.component';

describe('UpdateReimbursementsComponent', () => {
  let component: UpdateReimbursementsComponent;
  let fixture: ComponentFixture<UpdateReimbursementsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateReimbursementsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateReimbursementsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
