import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TextService {

  constructor(){
    alert("constructor TextService");
  }
    isValidText(text:string):boolean
    {
      return true;
    }
}
