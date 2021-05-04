import { Component, OnInit } from '@angular/core';
import { StudentService } from 'src/app/services/student/student.service';
import { Student } from './student';

@Component({
  selector: 'student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students:Student[]=[];

  constructor(private _studentService:StudentService) { }

  ngOnInit(): void {

    this._studentService.get().subscribe(
      response =>{
        this.students = response.Data as Student[];
      },
      error=>{
        alert("Error fetching data");
      }
    )
  }

  deleteStudent(index:number){

    this._studentService.delete(index).subscribe(
      response =>{
        alert("Deleted student with index " + index);
      },
      error=>{

      }
    );
  }

}
