import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { DragulaModule } from 'ng2-dragula';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



import { AppComponent } from './app.component';
import { PostService } from "./shared/post/post.service";
import { UserService } from './shared/user/user.service';
import { UserComponent } from './user/user.component';
import { AppRoutingModule } from './app-routing.module';

const appRoutes: Routes = [
  { path: 'users', component: UserComponent }
];



@NgModule({
  declarations: [
    AppComponent,
    UserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    DragulaModule,
<<<<<<< HEAD
    NgbModule.forRoot()
=======
    AppRoutingModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true } // <-- debugging purposes only
    )
>>>>>>> branches/ben
  ],
  providers: [PostService, UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
