import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  submitted = false;

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit() {
  }

  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data => console.log(data), error => console.log(error));
    this.employee = new Employee();
    this.redirectToEmployeeList();
  }

  onSubmit() {
    this.submitted = true;
    this.saveEmployee();
  }

  redirectToEmployeeList(){
    this.router.navigate(['/employees']);
  }
}
