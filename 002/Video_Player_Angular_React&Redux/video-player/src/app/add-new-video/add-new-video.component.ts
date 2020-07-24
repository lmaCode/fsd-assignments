import { Component, AfterViewInit, ViewChild, ChangeDetectorRef, OnInit ,ElementRef} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Video } from '../video';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VideoService } from '../videoservice';

import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';

import { merge, of as observableOf } from 'rxjs';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';



//import { ConfirmComponent } from '~components/confirm/confirm.component';
import { FormsComponent } from './forms/forms.component';
//import { SnackbarComponent } from '~components/snackbar/snackbar.component';

@Component({
  selector: 'app-add-new-video',
  templateUrl: './add-new-video.component.html',
  styleUrls: ['./add-new-video.component.css'],
  providers: [VideoService]
})


export class AddNewVideoComponent implements OnInit {

  videoList:Video[];
  itemId;
  checkoutForm;
  temp:Video;
  @ViewChild('myTable') myTable :ElementRef;
  @ViewChild(MatPaginator, { static: false }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: false }) sort: MatSort;

  headerOption = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private route: ActivatedRoute,private formBuilder: FormBuilder, public dialog: MatDialog,private videoService: VideoService,private http: HttpClient)
  {

    this.checkoutForm = this.formBuilder.group({
      title: '',
      url: ''
    });
  }
  ngOnInit() {
    this.http.get('http://localhost:3004/videos')
    .subscribe(res => this.videoList =
    res as Video[]);
  }

  // onSubmit(customerData:Video) {
  //   // Process checkout data here
  //   console.warn('Your order has been submitted', customerData);
  //   this.temp = new Video(customerData.title,customerData.url);
  //   //this.http.post<Video>('http://localhost:3004/videos',customerData,this.headerOption);//Content-Type: application/json
  //   console.log(this.http.post<Video>('http://localhost:3004/videos',this.temp,this.headerOption));//Content-Type: application/json
  //   //this.videoList = this.cartService.clearCart();
  //   this.checkoutForm.reset();
  // }
  onSubmit(customerData:Video){
    this.videoService.save(customerData).subscribe(
      ()=>this.ngOnInit()
    );
  }

  deleteVideo(videoId: Number){
    this.videoService.delete(videoId).subscribe(()=>this.ngOnInit());

  }

  edit(row: Video): void {
    // Getting data from back
    this.videoService.getOne(row.id).subscribe((data: Video) => {
        //if (data.success) {
            const dialogRef = this.dialog.open(FormsComponent, {
                // height: '450px',
                width: '400px',
                data: { title: 'Update video', action: 'edit', data: data }
            });

            dialogRef.afterClosed().subscribe(
              ()=>this.ngOnInit()
            );
      //  }
    });
}

}
