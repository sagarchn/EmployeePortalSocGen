import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Employee } from '../entity/employee';
import { AppComponent } from '../app.component';
import { DataService } from '../data.service';

@Component({
  selector: 'app-employee-registration',
  templateUrl: './employee-registration.component.html',
  styleUrls: ['./employee-registration.component.css']
})
export class EmployeeRegistrationComponent implements OnInit {


  employee: Employee;

  employeeForm;

  constructor(private appComponent:AppComponent,private dataService: DataService) { }

  ngOnInit() {
    this.employee = new Employee();
    this.employeeForm = new FormGroup({
      firstName: new FormControl(this.employee.firstName, [Validators.required])
      , lastName: new FormControl(this.employee.lastName, [Validators.required]),
      gender: new FormControl(this.employee.gender, [Validators.required]),
      dateOfBirth: new FormControl(this.employee.dateOfBirth, [Validators.required])
      , department: new FormControl(this.employee.department, [Validators.required])
    });

  }

  validateEmployee() {
    if (!this.employee.firstName)
      throw 'First name is invalid!';
    if (!this.employee.lastName)
      throw 'Last name is invalid!';
    if (!this.employee.dateOfBirth)
      throw 'Date of Birth name is invalid!';
    if (!this.employee.gender)
      throw 'Gender is invalid!';
    if (!this.employee.department)
      throw 'Department is invalid!';

  }


  setEmployee() {
    this.employee.firstName = this.employeeForm.value['firstName'];
    this.employee.lastName = this.employeeForm.value['lastName'];
    this.employee.gender = this.employeeForm.value['gender'];
    this.employee.dateOfBirth = this.employeeForm.value['dateOfBirth'];
    this.employee.department = this.employeeForm.value['department'];


  }
  onSubmit() {
    this.setEmployee();
    try {

      this.validateEmployee();
    } catch (e) {
      this.appComponent.setFailure(e);
      return;
    }

    this.dataService.addObject('employee/add', this.employee).subscribe(data => {
      this.appComponent.setSuccess('Employee Added to Portal');
      this.employeeForm.reset();
    }, error => { alert(error);this.appComponent.setFailure(error); })


  }
}
