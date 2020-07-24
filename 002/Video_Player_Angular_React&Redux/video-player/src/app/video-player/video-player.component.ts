import { Component, OnInit, ViewChild, ElementRef,AfterViewInit, ViewChildren } from '@angular/core';
import { PlayerComponent } from '../player/player.component';
import { ControlsComponent } from '../controls/controls.component';
import { RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrls: ['./video-player.component.css']
})
export class VideoPlayerComponent implements  AfterViewInit {
  @ViewChild (PlayerComponent)
  private  playerComponet :PlayerComponent;

  @ViewChild (ControlsComponent)
  private  controlsComponent :ControlsComponent;

  myVideo:ElementRef;
  constructor() { }

  seconds() { return 0; }

  select(movie){
    this.playerComponet.myVideo.nativeElement.setAttribute("src", movie);
    this.playerComponet.myVideo.nativeElement.setAttribute('autoplay', 'autoplay');
    document.getElementById("play").setAttribute("disabled", "true");
    document.getElementById("pause").removeAttribute("disabled");
    this.controlsComponent.getProgress();
    this.controlsComponent.progressFlag = setInterval(()=>this.controlsComponent.getProgress(), 60);
  }

  ngAfterViewInit() {
    this.myVideo = this.playerComponet.myVideo;
    setTimeout(() => this.seconds(), 0);
  }

}
