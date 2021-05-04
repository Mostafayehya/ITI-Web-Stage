import { Component } from "@angular/core";


// this is a decorator method 
@Component({

    selector:'demo', // this is the name that used by html, but in ts files we use the name of the class  <demo></demo>
    templateUrl: './demo.component.html', // AppModule will call app component 

    styleUrls:['./demo.component.css']
    }
)
export class DemoComponent{

}