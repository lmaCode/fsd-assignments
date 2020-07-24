import { Component, OnInit, ElementRef } from '@angular/core';
import { Input } from "@angular/core";
import { ViewChild } from '@angular/core';



@Component({
  selector: 'app-controls',
  templateUrl: './controls.component.html',
  styleUrls: ['./controls.component.css']
})
export class ControlsComponent implements OnInit {
  @Input() myVideo :ElementRef;
  //@ViewChild('video1') myVideo :ElementRef;
  @ViewChild('prograssBar') prograssBar:ElementRef;
  progressFlag;

  constructor() { }

  ngOnInit() {
    if (typeof localStorage.getItem('likecount') == 'undefined' || localStorage.getItem('likecount') == null) {
        localStorage.likecount = 0;
    }

    if (typeof localStorage.getItem('unlikecount') == 'undefined' || localStorage.getItem('unlikecount') == null) {
        localStorage.unlikecount = 0;
    }

    document.getElementById("thumbsUp").innerHTML = " " + localStorage.likecount;
    document.getElementById("thumbsDown").innerHTML = " " + localStorage.unlikecount;
  }

  getProgress() {
    var percent = this.myVideo.nativeElement.currentTime / this.myVideo.nativeElement.duration;
    this.prograssBar.nativeElement.style = "width: " + Number(percent * 100) + "%;";
    this.prograssBar.nativeElement.innerHTML = (percent * 100).toFixed(1) + "%";
  }

  playAndPause() {
    if (this.myVideo.nativeElement.paused) {
      document.getElementById("play").setAttribute("disabled", "true");
      document.getElementById("pause").removeAttribute("disabled");
      this.myVideo.nativeElement.play();
      this.getProgress();
      this.progressFlag = setInterval(()=>this.getProgress(), 60);

  } else {
      document.getElementById("pause").setAttribute("disabled", "true");
      document.getElementById("play").removeAttribute("disabled");
      this.myVideo.nativeElement.pause();
      clearInterval(this.progressFlag);
  }
  }

volumeUp() {
    if (this.myVideo.nativeElement.volume < 1) {
      this.myVideo.nativeElement.volume = this.myVideo.nativeElement.volume + 0.1;
    }
}

volumeDown() {
    if (this.myVideo.nativeElement.volume > 0) {
      this.myVideo.nativeElement.volume = this.myVideo.nativeElement.volume - 0.1;
    }
}

 volumeOff() {
    if (this.myVideo.nativeElement.muted) {
      this.myVideo.nativeElement.muted = false;
    } else {
      this.myVideo.nativeElement.muted = true;
    }
}

rePlay() {
  this.myVideo.nativeElement.load();
    this.myVideo.nativeElement.setAttribute("autoplay", "autoplay");
    document.getElementById("play").setAttribute("disabled", "true");
    document.getElementById("pause").removeAttribute("disabled");
    this.getProgress();
    this.progressFlag = setInterval(()=>this.getProgress(), 60);

}

 fullScreen() {
  this.myVideo.nativeElement.requestFullscreen();
}

like() { //IP地址，cookie 本地存储，一增一减少？；
  if (localStorage.likecount) {
      localStorage.likecount = Number(localStorage.likecount) + 1;
  } else {
      localStorage.likecount = 1;
  }
  document.getElementById("thumbsUp").innerHTML = " " + localStorage.likecount;
}

unlike() {
  if (localStorage.unlikecount) {
      localStorage.unlikecount = Number(localStorage.unlikecount) + 1;
  } else {
      localStorage.unlikecount = 1;
  }
  document.getElementById("thumbsDown").innerHTML = " " + localStorage.unlikecount;
}


}
