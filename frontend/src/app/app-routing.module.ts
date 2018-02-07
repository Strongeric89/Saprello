import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent }      from './user/user.component';

const routes: Routes = [
  { path: 'users', component: UserComponent }
];

@NgModule({
exports: [RouterModule],
imports: [ RouterModule.forRoot(routes) ],
  declarations: []
})
export class AppRoutingModule { }
