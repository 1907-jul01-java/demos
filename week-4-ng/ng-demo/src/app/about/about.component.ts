import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  parentStyle = {
    color: 'red'
  }

  changeColor() {
    this.parentStyle.color = 'blue'
  }
  constructor() { }

  ngOnInit() {
  }

}
