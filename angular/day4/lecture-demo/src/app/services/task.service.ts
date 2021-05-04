import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from '../models/task';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/api-response';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private _httpClient:HttpClient) { }

  get():Observable<any>{
   return this._httpClient.get("http://api.mohamed-sadek.com/Task/Get");
  }
  getDetails(id:number):Observable<ApiResponse>{
    return this._httpClient.get<ApiResponse>("http://api.mohamed-sadek.com/Task/GetByID?id="+id);
   }

  delete(id:number):Observable<any>{
    return this._httpClient.delete("http://api.mohamed-sadek.com/Task/delete?id="+id);
   }
   
  post(task:Task):Observable<any>{
    return this._httpClient.post("http://api.mohamed-sadek.com/Task/post",task);
   }


}
