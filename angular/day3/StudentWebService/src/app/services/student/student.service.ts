import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private _httpClient:HttpClient) { }

  get():Observable<any>{
    return this._httpClient.get("http://api.mohamed-sadek.com/Student/Get");
  }

  delete(id:number):Observable<any>{
    return this._httpClient.delete("http://api.mohamed-sadek.com/Student/Delete?id="+id);
  }
}
