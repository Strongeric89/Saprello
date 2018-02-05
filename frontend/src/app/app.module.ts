import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { DragulaModule } from 'ng2-dragula';



import { AppComponent } from './app.component';
import {PostService} from "./shared/post/post.service";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    DragulaModule
  ],
  providers: [PostService],
  bootstrap: [AppComponent]
})
export class AppModule { }
