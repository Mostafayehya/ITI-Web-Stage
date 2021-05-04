import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../services/task.service';
import { Task } from '../models/task';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  task:Task=new Task();
  constructor(private _activatedRoute:ActivatedRoute,private _taskService:TaskService) { 
    alert("constructor");

  }

  ngOnInit(): void {
    alert("ngOnInit");

    this._activatedRoute.paramMap.subscribe(params=>{
      let id:number=+params.get('id');

     this._taskService.getDetails(id).subscribe(response=>{
       this.task=response.Data;
       alert("getDetails");
     });

     alert("paramMap");
    });
    
  }

}
