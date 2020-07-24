import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule ,ReactiveFormsModule} from '@angular/forms';
import { APP_BASE_HREF } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
//import { AddNewVideoModule } from './add-new-video/add-new-video.module';

import { AppComponent } from './app.component';
import { HelloComponent } from './hello.component';
import { PlayerComponent } from './player/player.component';
import { ControlsComponent } from './controls/controls.component';
import { PlaylistComponent } from './playlist/playlist.component';
import { AddNewVideoComponent } from './add-new-video/add-new-video.component';
import { VideoPlayerComponent } from './video-player/video-player.component';
import { FormsComponent } from './add-new-video/forms/forms.component';
import { RouterModule, Routes } from '@angular/router';
//import { SharedModule } from './shared.module';

import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { VideoService } from './videoservice';

const appRoutes: Routes = [
  { path: '', component: VideoPlayerComponent },
  { path: 'add', component: AddNewVideoComponent }
];

@NgModule({
  imports:      [ BrowserAnimationsModule,MatDialogModule,BrowserModule, FormsModule, HttpClientModule ,ReactiveFormsModule,
    RouterModule.forRoot(appRoutes)
],
  declarations: [ FormsComponent, AppComponent, HelloComponent, PlayerComponent, ControlsComponent, PlaylistComponent, AddNewVideoComponent, VideoPlayerComponent ],
  bootstrap:    [ AppComponent ],
  providers: [VideoService, { provide: APP_BASE_HREF, useValue: '/' }  ]
})
export class AppModule { }
