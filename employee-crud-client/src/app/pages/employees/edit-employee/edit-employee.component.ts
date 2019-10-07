import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from 'src/app/services/employee.service';
import { Employee } from 'src/app/models/Employee.model';

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {

  employeeId: number;
  employee: Employee;

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private employeeService: EmployeeService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.employeeId = this.activatedRoute.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.employeeId).subscribe(
      data => {
        this.employee = data.responseData;
      }, error => {
        console.log(error);
      }
    );
  }

updateEmployee() {
  this.employeeService.updateEmployee(this.employeeId, this.employee).subscribe(
    data => {
console.log(data);
    },error => {
console.log(error);
    }
  );
  this.employee = new Employee();
  this.redirectToEmployeeList();
}  

redirectToEmployeeList() {
  this.router.navigate(['/employees']);
}

onSubmit(){
  this.updateEmployee();
}
}
