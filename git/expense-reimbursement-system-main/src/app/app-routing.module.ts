import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeeRequestsComponent } from './employees/view-employee-requests/view-employee-requests.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { LoginComponent } from './users/login/login.component';


const routes: Routes = [
  {path: "employees", component: ViewEmployeesComponent },
  {path: "view-profile", component: ViewProfileComponent },
  {path: "reimbursements", component: ViewReimbursementsComponent},
  {path: "requests", component: ViewRequestsComponent},
  {path: "employeeRequests/:uid", component: ViewEmployeeRequestsComponent},
  //{path: "view-reimbursements", component: ViewReimbursementsComponent},
  {path: "login", component: LoginComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
