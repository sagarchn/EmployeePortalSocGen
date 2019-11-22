import { NgModule } from '@angular/core';
import { Routes, RouterModule } from "@angular/router";
import { EmployeeRegistrationComponent } from './employee-registration/employee-registration.component';
import { EmployeeViewComponent } from './employee-view/employee-view.component';
const routes: Routes = [
    { path: 'register', component: EmployeeRegistrationComponent }
    , { path: 'view', component: EmployeeViewComponent },
     { path: '**', redirectTo: 'register', pathMatch: 'full' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {

}