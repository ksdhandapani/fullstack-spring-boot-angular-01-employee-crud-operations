package com.ytl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ytl.model.Employee;
import com.ytl.services.EmployeeService;
import com.ytl.services.RestApiResponse;

@RestController
@CrossOrigin(value = {"*"})
@RequestMapping(value = "/employeeApi")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employee/all", method = RequestMethod.GET)
	public ResponseEntity<RestApiResponse> getEmployees() {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			response = this.employeeService.getEmployees();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<RestApiResponse> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			response = this.employeeService.getEmployeeByEmploeeId(employeeId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ResponseEntity<RestApiResponse> saveEmployee(@RequestBody Employee employee) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			response = this.employeeService.saveEmployee(employee);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "employee/{employeeId}", method = RequestMethod.PUT)
	public ResponseEntity<RestApiResponse> updateEmployee(@RequestBody Employee employee,
			@PathVariable("employeeId") Integer employeeId) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			response = this.employeeService.updateEmployee(employee, employeeId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}

	}

	@RequestMapping(value = "/employee/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<RestApiResponse> saveEmployee(@PathVariable("employeeId") Integer employeeId) {
		RestApiResponse response = new RestApiResponse();
		response.setIsAuthenticationException(false);
		response.setIsException(false);
		response.setIsSuccess(false);
		try {
			response = this.employeeService.deleteEmployeeById(employeeId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.setIsException(true);
			response.setMessage("Exception Occured - " + ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}

	}

}
