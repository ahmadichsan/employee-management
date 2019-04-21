// Lib
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

// Component
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { EmployeeComponent } from './components/employee/employee.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ProjectComponent } from './components/project/project.component';

// Service
import { AuthGuard } from '../app/services/guard/auth.guard';

const routes: Routes = [
  { path: '', pathMatch: 'full' , component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'project', component: ProjectComponent, canActivate: [AuthGuard]  },
  { path: 'employee', component: EmployeeComponent, canActivate: [AuthGuard]  },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
