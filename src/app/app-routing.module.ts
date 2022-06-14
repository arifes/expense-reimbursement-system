import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';


const routes: Routes = [
  {path: "employees", component: ViewEmployeesComponent },
  {path: "profile", component: ViewProfileComponent },
  {path: "reimbursements", component: ViewReimbursementsComponent},
  {path: "requests", component: ViewRequestsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
