import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RestApiResponse } from '../models/RestApiResponse.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = "http://localhost:8080/employeeApi/employee"

  constructor(private httpClient: HttpClient) { }

  getEmployeeById(id: number): Observable<any> {
    return this.httpClient.get<RestApiResponse>(`${this.baseUrl}/${id}`);
  }

  createEmployee(employee: Object): Observable<any> {
    return this.httpClient.post<RestApiResponse>(`${this.baseUrl}`, employee);
  }

  updateEmployee(id: number, employee: Object): Observable<any> {
    return this.httpClient.put<RestApiResponse>(`${this.baseUrl}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete<RestApiResponse>(`${this.baseUrl}/${id}`);
  }

  getEmployeesList(): Observable<any> {
    return this.httpClient.get<RestApiResponse>(`${this.baseUrl}/all`);
  }
}
