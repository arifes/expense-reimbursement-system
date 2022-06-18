import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeeRequestsComponent } from './employees/view-employee-requests/view-employee-requests.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { UpdateProfileComponent } from './profile/update-profile/update-profile.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { UpdateReimbursementsComponent } from './reimbursements/update-reimbursements/update-reimbursements.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { LogOutComponent } from './users/log-out/log-out.component';
import { LoginComponent } from './users/login/login.component';


const routes: Routes = [
  {path: "view-employees", component: ViewEmployeesComponent },
  {path: "view-profile", component: ViewProfileComponent },
  {path: "view-reimbursements", component: ViewReimbursementsComponent},
  {path: "view-requests", component: ViewRequestsComponent},
  {path: "employeeRequests/:uid", component: ViewEmployeeRequestsComponent},
  {path: "view-reimbursements", component: ViewReimbursementsComponent},
  {path: "view-reimbursements/:status", component: ViewReimbursementsComponent},
  {path: "update-reimbursements", component: UpdateReimbursementsComponent},
  {path: "update-profile", component: UpdateProfileComponent},
  {path: "login", component: LoginComponent},
  {path: "log-out", component: LogOutComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
