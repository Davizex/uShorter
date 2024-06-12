import { Component, OnInit } from '@angular/core';
import { UshortApiService } from '../services/ushort-api.service';
import { HttpClient } from '@angular/common/http';
import { IonicModule } from '@ionic/angular';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  standalone: true,
  imports:[IonicModule, CommonModule, FormsModule]
})
export class HomePage implements OnInit {

  shortedUrl: string | null = null;
  originalUrl: string = '';
  domain: string ='';
  cleanButton: boolean = false;
  constructor(private ushortApiService: UshortApiService, private http: HttpClient) {}

  ngOnInit() {}
  
  onClick(){
    let body = { originalURL: this.originalUrl}; 
    this.ushortApiService.createShortUrl(body).subscribe(
      (response) =>{
        let hostname = window.location.hostname;
        let port = window.location.port;
        
        if (port) {
          this.domain = `${hostname}:${port}`;
        } else {
          this.domain = hostname;
        }
        this.shortedUrl= (this.domain+'/'+response.code);
        this.cleanButton=true;
      },
      (error) =>{
        console.log(error);
      },
    );
  }

  onInput(ev:any){
    const value = ev.target!.value;
    this.originalUrl = value;
  }

  onClearTiny(){
    this.cleanButton=false;
    this.shortedUrl=null;
  }
}
