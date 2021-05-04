import { Component, OnInit } from '@angular/core';
import { Task } from './../models/task';
import { HttpClient } from '@angular/common/http';
import { ApiResponse } from '../models/api-response';
import { TaskService } from '../services/task.service';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  name:string="Mohamed Ali";

  tasks:Task[]=[];
  constructor(private _httpClient:HttpClient,private _taskService:TaskService) { }

  ngOnInit(): void {
    this._httpClient.get<ApiResponse>("http://api.mohamed-sadek.com/Task/Get").subscribe(
      response=>{
        //this.tasks=response['Data'] as Task[];
        this.tasks=response.Data as Task[];

      },
      error=>{
        //if false
        alert("Error");
      }
      );
    //alert("Finished");
    
  }
  showTasksCount(){
   this._taskService.get().subscribe(
      response=>{
        alert((response.Data as Task[]).length);
      },
      error=>{
        //if false
        alert("Error");
      }
      );
  }
addTask(title:string){

let task=new Task();
task.Title=title;

task.IsDone=false;
this._httpClient.post("http://api.mohamed-sadek.com/Task/Post",task).subscribe(
  response=>{
    task.ID=response['Data'] as number;
    this.tasks.push(task);
    alert(response['Message']);
  },
  error=>{}
);

}

delete(index:number)
{
  let task=this.tasks[index];
  this._httpClient.delete<ApiResponse>('http://api.mohamed-sadek.com/Task/Delete?id='+task.ID).subscribe(
response=>{
  alert(response.Message);
  this.tasks.splice(index,1);
},
error=>{}


  );
}

deleteFromService(index:number)
{
  let task=this.tasks[index];
  this._taskService.delete(task.ID).subscribe(
response=>{
  alert(response.Message);
  this.tasks.splice(index,1);
},
error=>{}


  );
}
  getPendingTasks():number{
    return this.tasks.filter(x=>!x.IsDone).length;
  }

}
