import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { DataPost } from './DataPost';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
   
  })
};
@Injectable({
  providedIn: 'root'
})

export class UserServiceService {
  private dataPostUrl: string;
  
  constructor(private http: HttpClient) {  this.dataPostUrl = 'http://localhost:9090/ExtractionInfo';}  
/*
  getuser(): Observable<User[]> {
    console.log('getuser '+this.dataPostUrl  )
    return this.http.get<User[]>(this.dataPostUrl)
  }*/
  public save(data: DataPost) :  Observable<any>{
    const headers = { 'content-type': 'application/json'}  
    const body=JSON.stringify(data);
    console.log(body)
   
    //window.location.reload();
    return this.http.post(this.dataPostUrl  , body,{'headers':headers})
  }
   
  }


  


