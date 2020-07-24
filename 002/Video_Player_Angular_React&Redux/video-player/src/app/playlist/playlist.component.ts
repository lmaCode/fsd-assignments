import { Component, OnInit, Input, ElementRef, Output, EventEmitter } from '@angular/core';
import { Video } from '../video';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.css']
})
export class PlaylistComponent implements OnInit {

  @Output() newItemEvent = new EventEmitter();

  videoList:Video[];

  constructor(private http: HttpClient) { }

  getVideoData() {
    this.http.get('http://localhost:3004/videos')
    .subscribe(res => this.videoList =
    res as Video[]);}

  ngOnInit() {
    this.getVideoData();
  }

  select(movie) {
    this.newItemEvent.emit(movie);
}

}
