
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from '../app.component';
import { LoginComponent } from './login.component';
import { RegisterComponent } from './register.component';

export const LoginRoutes: Routes= [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full',
},

{
  path: '',
  component: AppComponent,
  children: [
 
  {
      path: 'login',
      component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
}
]

}

];