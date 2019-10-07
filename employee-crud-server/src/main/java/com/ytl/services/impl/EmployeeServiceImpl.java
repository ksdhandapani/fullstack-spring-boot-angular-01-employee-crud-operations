package com.ytl.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ytl.model.Employee;
import com.ytl.repository.EmployeeRepository;
import com.ytl.services.EmployeeService;
import com.ytl.services.RestApiResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	RestApiResponse response = new RestApiResponse();

	@Override
	public RestApiResponse getEmployees() {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			List<Employee> employees = this.employeeRepository.findAll();
			if (!employees.isEmpty()) {
				response.setResponseData(employees);
				response.setIsSuccess(true);
				response.setMessage("Employees found");
			} else {
				response.setMessage("Employees not found");
			}
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
		}
		return response;
	}

	@Override
	public RestApiResponse getEmployeeByEmploeeId(Integer employeeId) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			Employee employee = this.employeeRepository.findById(employeeId).get();
			if (employee != null) {
				response.setResponseData(employee);
				response.setIsSuccess(true);
				response.setMessage("Employee with id " + employeeId + " found");
			} else {
				response.setMessage("Employee with id " + employeeId + " not found");
			}
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
		}
		return response;
	}

	@Override
	public RestApiResponse saveEmployee(Employee employee) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			Employee savedEmployee = this.employeeRepository.save(employee);
			if (savedEmployee != null) {
				response.setResponseData(savedEmployee);
				response.setIsSuccess(true);
				response.setMessage("Employee save successful");
			} else {
				response.setMessage("Employee save unsuccessful");
			}
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
		}
		return response;
	}

	@Override
	public RestApiResponse updateEmployee(Employee employee, Integer employeeId) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			Employee foundEmployee = this.employeeRepository.findById(employeeId).get();
			if (foundEmployee != null) {
				Employee savedEmployee = this.employeeRepository.save(employee);
				if (savedEmployee != null) {
					response.setResponseData(savedEmployee);
					response.setIsSuccess(true);
					response.setMessage("Employee with id " + employeeId + "update successful");
				} else {
					response.setMessage("Employee with id " + employeeId + " found but unable to update the employee");
				}
			} else {
				response.setMessage("Employee with id " + employeeId + " not found");
			}
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
		}
		return response;
	}

	@Override
	public RestApiResponse deleteEmployeeById(Integer employeeId) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			Employee foundEmployee = this.employeeRepository.findById(employeeId).get();
			if (foundEmployee != null) {
				this.employeeRepository.deleteById(employeeId);
				response.setIsSuccess(true);
				response.setResponseData(true);
			} else {
				response.setMessage("Employee with id " + employeeId + " not found");
			}
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
		}
		return response;
	}

}
