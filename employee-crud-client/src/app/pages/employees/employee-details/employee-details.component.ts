import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/models/Employee.model';
import { EmployeeService } from 'src/app/services/employee.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

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

  redirectToEmployeesList(){
    this.router.navigate['employees'];
  }

}
