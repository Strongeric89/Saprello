import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { DragulaModule } from 'ng2-dragula';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



import { AppComponent } from './app.component';
import {PostService} from "./shared/post/post.service";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    DragulaModule,
    NgbModule.forRoot()
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
