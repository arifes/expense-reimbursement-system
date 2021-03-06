import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { ViewEmployeesComponent } from './employees/view-employees/view-employees.component';
import { ViewRequestsComponent } from './requests/view-requests/view-requests.component';
import { ViewProfileComponent } from './profile/view-profile/view-profile.component';
import { LoginComponent } from './users/login/login.component';
import { ViewReimbursementsComponent } from './reimbursements/view-reimbursements/view-reimbursements.component';
import { ViewEmployeeRequestsComponent } from './employees/view-employee-requests/view-employee-requests.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UpdateReimbursementsComponent } from './reimbursements/update-reimbursements/update-reimbursements.component';
import { ResolvedReimbursementsComponent } from './reimbursements/resolved-reimbursements/resolved-reimbursements.component';
import { LogoutComponent } from './users/logout/logout.component';
import { UpdateProfileComponent } from './profile/update-profile/update-profile.component';
import { AddRequestComponent } from './requests/add-request/add-request.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ViewEmployeesComponent,
    ViewRequestsComponent,
    ViewProfileComponent,
    LoginComponent,
    ViewReimbursementsComponent,
    ViewEmployeeRequestsComponent,
    UpdateReimbursementsComponent,
    ResolvedReimbursementsComponent,
    LogoutComponent,
    UpdateProfileComponent,
    AddRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
