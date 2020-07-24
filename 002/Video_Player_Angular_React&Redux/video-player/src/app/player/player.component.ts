import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent implements OnInit {
  src;
  poster;
  onended;
  @ViewChild('video1') myVideo :ElementRef;
  constructor() { }
  seconds() { return 0; }

  ngOnInit() {
    this.src="http://www.w3school.com.cn/example/html5/mov_bbb.mp4";
    //this.src="https://www.youtube.com/watch?v=YQHsXMglC9A";
    this.poster="assets/cover.jpg";
    this.onended="afterend()";
   }

   afterend(){

   }

}
