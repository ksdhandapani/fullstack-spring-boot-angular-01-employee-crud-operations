import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app.routing.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpErrorInterceptor } from '../app/interceptors/HttpErrorInterceptor';

import { AppComponent } from './app.component';
import { CreateEmployeeComponent } from './pages/employees/create-employee/create-employee.component';
import { EditEmployeeComponent } from './pages/employees/edit-employee/edit-employee.component';
import { EmployeeDetailsComponent } from './pages/employees/employee-details/employee-details.component';
import { EmployeeListComponent } from './pages/employees/employee-list/employee-list.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule, AppRoutingModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpErrorInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
