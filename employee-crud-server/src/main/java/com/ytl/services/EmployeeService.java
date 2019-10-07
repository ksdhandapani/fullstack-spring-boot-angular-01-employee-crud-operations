package com.ytl.services;

import com.ytl.model.Employee;

public interface EmployeeService {

	public RestApiResponse getEmployees();

	public RestApiResponse getEmployeeByEmploeeId(Integer employeeId);

	public RestApiResponse saveEmployee(Employee employee);

	public RestApiResponse updateEmployee(Employee employee, Integer employeeId);

	public RestApiResponse deleteEmployeeById(Integer employeeId);
}
