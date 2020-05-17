import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

import { Video } from './video';

@Injectable()
export class VideoService {
    loading = true;
    videoURL = 'http://localhost:3004/videos';
    constructor(
        private router: Router,
        public http: HttpClient
    ) { }

    headers = new HttpHeaders({
        'Authorization': 'JWT ' + localStorage.getItem('token')
    });

    getList(sortActive: string, order: string, pageSize: number, page: number, search: string) {
        let params = new HttpParams();
        params = params.append('active', sortActive);
        params = params.append('order', order);
        params = params.append('search', search);
        params = params.append('pageSize', pageSize.toString());
        params = params.append('page', page.toString());

        return this.http.get<VideoApi>(
            this.videoURL,
            { headers: this.headers, params: params }
        );
    }

    delete(id: Number) {
        return this.http.delete(
          this.videoURL+'/'+id,
            { headers: this.headers }
        );
    }

    getOne(id: number) {
        return this.http.get(
          this.videoURL+'/'+id,
            { headers: this.headers }
        );
    }

    save(video: Video) {
        return this.http.post(
          this.videoURL,
            {
              title:video.title,
              url:video.url,
              id:video.id
            },
            { headers: this.headers }
        );
    }

    update(video: Video) {
      return this.http.put(
        this.videoURL+'/'+video.id,
         video,
          { headers: this.headers }
      );
  }
}

export interface VideoApi {
    success: boolean;
    data: Video[];
    total: number;
    pageSize: number;
    page: number;
}
