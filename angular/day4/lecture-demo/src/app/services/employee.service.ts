import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/api-response';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private _httpClient:HttpClient) { }

  get():Observable<any>{
   return this._httpClient.get("http://api.mohamed-sadek.com/Employee/Get");
  }
  getDetails(id:number):Observable<ApiResponse>{
    return this._httpClient.get<ApiResponse>("http://api.mohamed-sadek.com/Employee/GetByID?id="+id);
   }

  delete(id:number):Observable<any>{
    return this._httpClient.delete("http://api.mohamed-sadek.com/Employee/delete?id="+id);
   }
   
  post(Employee:any):Observable<any>{
    return this._httpClient.post("http://api.mohamed-sadek.com/Employee/post",Employee);
   }
   
  put(Employee:any):Observable<any>{
    return this._httpClient.put("http://api.mohamed-sadek.com/Employee/put",Employee);
   }
}
