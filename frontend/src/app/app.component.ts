import { Component } from '@angular/core';
import {PostService} from "./shared/post/post.service";
import { DragulaService } from 'ng2-dragula/ng2-dragula';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Project Management Saprello';
  card = 'Card Name';
  posts: Array<any>;

  options: any={
    removeOnSpill: true
  }

  constructor(private postService: PostService, private dragulaService: DragulaService ){}

  ngOnInit(){
    this.postService.getAll().subscribe(
      data => {
        this.posts = data;
      },
      error => console.log(error)
    )
  }


}
