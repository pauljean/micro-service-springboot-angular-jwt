import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './login/register.component';
import { AuthGuard } from './security/auth.guard';

const routes: Routes = [
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
  }, {
    path: 'register',
    component: RegisterComponent 
  } , {
    path: 'home',
    canActivate: [AuthGuard],
    component: HomeComponent
  }   
]

},

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
