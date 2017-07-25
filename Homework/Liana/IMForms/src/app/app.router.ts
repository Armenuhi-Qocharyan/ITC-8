import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginRegisterComponent } from './components/login-register/login-register.component';
import { HomeComponent } from './components/home/home.component';
import { CreateFormComponent } from './components/create-form/create-form.component';
import { MyFormsComponent } from './components/my-forms/my-forms.component';

export const router: Routes = [
  { path: '', redirectTo: 'login-register', pathMatch: 'full'},
  { path: 'login-register', component: LoginRegisterComponent },
  { path: 'home', component: HomeComponent },
  { path: 'create-form', component: CreateFormComponent },
  { path: 'my-forms', component: MyFormsComponent }
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);

