import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { UpdateProfileComponent } from './profile/update-profile/update-profile.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { LoginComponent } from './users/login/login.component';


const routes: Routes = [
  {path: "view-employees", component: ViewEmployeesComponent },
  {path: "view-profile", component: ViewProfileComponent },
  {path: "view-reimbursements", component: ViewReimbursementsComponent},
  {path: "view-requests", component: ViewRequestsComponent},
  {path: "login", component: LoginComponent},
  {path: "update-profile", component: UpdateProfileComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
