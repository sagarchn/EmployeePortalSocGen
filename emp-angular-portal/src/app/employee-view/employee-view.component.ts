import { Component, OnInit } from '@angular/core';
import { Employee } from '../entity/employee';
import { DataService } from '../data.service';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {

  employees: Employee[] = [];

  constructor(private appComponent: AppComponent, private dataService: DataService) { }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.dataService.getObjects('employee/all').subscribe(data => {
      this.employees = <Employee[]>data;
    }, error => {
      this.appComponent.setFailure(error)
    });
  }

}
