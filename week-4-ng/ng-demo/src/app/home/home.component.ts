import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  name: string = "world"
  count: number = 0

  increment() {
    this.count+=1;
  }

  constructor() { }

  ngOnInit() {
  }

}
