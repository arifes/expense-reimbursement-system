import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeeRequestsComponent } from './employees/view-employee-requests/view-employee-requests.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { UpdateReimbursementsComponent } from './reimbursements/update-reimbursements/update-reimbursements.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { AuthenticationGuard } from './users/authentication.guard';
import { LoginComponent } from './users/login/login.component';
import { LogoutComponent } from './users/logout/logout.component';


const routes: Routes = [
  {path: "employees", component: ViewEmployeesComponent, canActivate:[AuthenticationGuard] },
  {path: "profile", component: ViewProfileComponent, canActivate:[AuthenticationGuard]  },
  {path: "reimbursements", component: ViewReimbursementsComponent, canActivate:[AuthenticationGuard] },
  {path: "view-requests", component: ViewRequestsComponent, canActivate:[AuthenticationGuard] },
  {path: "employeeRequests/:uid", component: ViewEmployeeRequestsComponent, canActivate:[AuthenticationGuard] },
  {path: "view-reimbursements", component: ViewReimbursementsComponent, canActivate:[AuthenticationGuard] },
  {path: "view-reimbursements/:status", component: ViewReimbursementsComponent, canActivate:[AuthenticationGuard] },
  {path: "update-reimbursements", component: UpdateReimbursementsComponent, canActivate:[AuthenticationGuard] },
  {path: "login", component: LoginComponent},
  {path: "logout", component: LogoutComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
