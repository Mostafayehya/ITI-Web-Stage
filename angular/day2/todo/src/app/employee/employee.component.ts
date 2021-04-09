import { Component, OnInit } from '@angular/core';
import { Employee } from '../models/Employee';
import { TextService } from '../text.service';
import { TextHelper } from './TextHelper';

@Component({
  selector: 'employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employee = new Employee ("mostafa","yehya,",27);


   employee1 = new Employee("Ahmed","Galal",26);
   employee2 = new Employee("Ahmed","Asem",16);
   employee3 = new Employee("Azama","ya Maser",26);

  // Employee list
  employees:Employee[] = [this.employee1,this.employee2,this.employee3];

  names:string[]=["ahemd","salah","fawzy"];

  textHelper:TextHelper = new TextHelper();
  textHelper2:TextHelper = new TextHelper();


  // it will be injected one 
  constructor(private _textService:TextService, private _textService2:TextService) {


  }

  ngOnInit(): void {
  }

  getFullName():string{
    return this.employee.firstName + this.employee.lastName;
  }

  getAge(age:number):string{
    return"";
  }

  setFirstName(){
    this.employee.firstName="new Name";
  }

  changeName(name:string){

    this.employee.firstName=name;
  }

  deleteEmployee(index:number){
    this.employees.splice(index,1);
  }

  addEmployee(data){

    this.employees.push(new Employee(data.firstName,data.lastName,data.age));
  }

}
