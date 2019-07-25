import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { PostService } from '../post.service';
import { Post } from '../Post';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  posts:Observable<Post[]>
  constructor(private postService: PostService) { }

  ngOnInit() {
    this.posts = this.postService.getPosts();
  }

}
