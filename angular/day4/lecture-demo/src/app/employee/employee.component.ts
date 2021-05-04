import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/employee';
import { TextHelper } from '../TextHelper';
import { TextService } from './../text.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  //string name="ddd";
 employee:Employee=new Employee();
 employees:Employee[]=[];
 names:string[]=["Mohamed","Ahmed"];
 textHelper:TextHelper=new TextHelper();
 textHelper2:TextHelper=new TextHelper();

  constructor(
    private _httpClient:HttpClient,
    private _textService:TextService,private _text2Service:TextService) {


   }

  ngOnInit(): void {
    this._httpClient.get("http://api.mohamed-sadek.com/Task/Get").subscribe();
    alert("rtytr");
  }

  getFullName():string{
    return this.employee.firstName+" "+this.employee.lastName;

  }
  setFirstName(){
    this._textService.isValidText("ss");
    this.employee.firstName="Ahmed";
  }
  setLastName(lastName:string){
    this.employee.lastName=lastName;
  }

  showAge(age:number):string{
    return "";
  }

 

}
