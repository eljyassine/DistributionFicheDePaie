import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PdfComponent } from './pdf/pdf.component';
import { FormsModule }   from '@angular/forms';
import { UploadFileComponent } from './upload-file/upload-file.component';
@NgModule({
  declarations: [
    AppComponent,
    PdfComponent,
    UploadFileComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
