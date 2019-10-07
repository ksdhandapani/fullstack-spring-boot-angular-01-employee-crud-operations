import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees(){
    this.employeeService.getEmployeesList().subscribe(
      data => {
        this.employees = data.responseData;
        console.log(data);
      },
      error => console.log(error));
    }

    deleteEmployee(id: number) {
      this.employeeService.deleteEmployee(id)
        .subscribe(
          data => {
            console.log(data);
            this.getEmployees();
          },
          error => console.log(error));
    }
  
    employeeDetails(id: number){
      this.router.navigate(['details', id]);
    }
}
