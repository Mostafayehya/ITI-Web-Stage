import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form:FormGroup;

  constructor(private _formBuilder:FormBuilder) { }

  ngOnInit(): void {

    this.form = this._formBuilder.group({

      // each control is an array 
      // first element is the default 
      // second element is array of validators
      Email:['',[Validators.required,Validators.maxLength(30)]],
      Password:['',[Validators.required,Validators.min(8),Validators.max(20)]]
    })
  }

}
