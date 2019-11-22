import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
 success=false;
 failure=false;
 message='';
 setSuccess(message:string){
 this.message=message;
  this.success=true;
  setTimeout(() => {
    this.success=false;
  }, 3000);
}

 setFailure(message:string){
  this.message=message;
   this.failure=true;
   setTimeout(() => {
     this.failure=false;
   }, 3000);
 }

}
