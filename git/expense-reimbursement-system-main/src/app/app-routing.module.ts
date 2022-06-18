import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeeRequestsComponent } from './employees/view-employee-requests/view-employee-requests.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { UpdateReimbursementsComponent } from './reimbursements/update-reimbursements/update-reimbursements.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';


const routes: Routes = [
  {path: "employees", component: ViewEmployeesComponent },
  {path: "profile", component: ViewProfileComponent },
  {path: "reimbursements", component: ViewReimbursementsComponent},
  {path: "view-requests", component: ViewRequestsComponent},
  {path: "employeeRequests/:uid", component: ViewEmployeeRequestsComponent},
  {path: "view-reimbursements", component: ViewReimbursementsComponent},
  {path: "view-reimbursements/:status", component: ViewReimbursementsComponent},
  {path: "update-reimbursements", component: UpdateReimbursementsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
