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

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ViewEmployeesComponent,
    ViewRequestsComponent,
    ViewProfileComponent,
    LoginComponent,
    ViewReimbursementsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
