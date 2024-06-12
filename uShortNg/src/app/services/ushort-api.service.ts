import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ConfigService } from './config.service'
import { HttpHeadersUtils } from './static/http-headers-utils';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UshortApiService {
  private apiEndpoint: string = '/v1/ushort'; 

  constructor(private http: HttpClient, private config: ConfigService) {} 
  
  createShortUrl(data :any){
    const headers = HttpHeadersUtils.getHeaders();
    let address = this.config.getConfig().gateway.url;
    return this.http.post<any>(`${address}${this.apiEndpoint}/create`, data, {headers: headers});
  }

  getOriginal(code: string | null) { 
    const headers = HttpHeadersUtils.getHeaders();
    let address = this.config.getConfig().gateway.url;
    return this.http.get<any>(`${address}${this.apiEndpoint}/${code}`, {headers: headers}, );
  }
} 
