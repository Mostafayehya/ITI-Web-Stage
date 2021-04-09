import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TextService {

  constructor() {
    alert("constrcutor TextService");

   }

   isValidText(text:string):boolean{
     return true;
   }
}
