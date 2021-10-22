import { Component, OnInit } from '@angular/core';
import { DataPost} from '../DataPost';

import { HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UploadFileService } from '../upload-file.service';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-pdf',
  templateUrl: './pdf.component.html',
  styleUrls: ['./pdf.component.css']
})
export class PdfComponent{
  selectedFiles?: FileList;
  currentFile?: File;
  progress = 0;
  message = '';
  fileInfos?: Observable<any>;

  users :DataPost[];
  data: DataPost ;

  typeid="matricule";
  typeSearch="chaineApres";
  currentDate = new Date();
  typeidd:boolean=true;
  constructor( private userService:  UserServiceService ,private uploadService: UploadFileService) {
     this.data = new DataPost();

    }
    
    
 
/*

  ngOnInit(): void {
    this.refreshPeople()
  }

  refreshPeople() {
    this.userService.getuser()
      .subscribe(data => {
        console.log(" refrechéééé")
        console.log(data)
        this.users=data;
      })      
 }
*/


  onSubmit(forminfo){
    
    this.data.typeIdent=forminfo.typeIdent; 
    this.data.isRouleau=forminfo.isRouleau; 
    this.data.ligne=forminfo.ligne; 
    this.data.colonne=forminfo.colonne;
    this.data.date=forminfo.date;  
    this.data.largeur=forminfo.largeur;
    this.data.chaineApres=forminfo.chaineApres; 
    /*
   this.data.lienFichier=forminfo.lienFichier; */
   
    this.data.typeSearch=forminfo.typeSearch
    
    console.log("date:"+typeof(this.currentDate));
    this.userService.save(this.data).subscribe(data => {
      
      console.log(data);
     // this.refreshPeople();
    }) ;
  
   
  }


  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
  }
  upload(): void {
    this.progress = 0;
  
    if (this.selectedFiles) {
      const file: File | null = this.selectedFiles.item(0);
  
      if (file) {
        this.currentFile = file;
  
        this.uploadService.upload(this.currentFile).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progress = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              this.message = event.body.message;             
            }
          },
          (err: any) => {
            console.log(err);
            this.progress = 0;
  
            if (err.error && err.error.message) {
              this.message = err.error.message;
            } else {
           //   this.message = 'Could not upload the file!';
            }
  
            this.currentFile = undefined;
          });
      }
  
      this.selectedFiles = undefined;
    }
  }
}
