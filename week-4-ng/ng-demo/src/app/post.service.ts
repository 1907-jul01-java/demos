import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { Post } from './Post';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient:HttpClient) { }

  getPosts(): Observable<Post[]> {
    return this.httpClient.get<Post[]>('https://jsonplaceholder.typicode.com/posts')
  }
}
