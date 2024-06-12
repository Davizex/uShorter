import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
 
  private config: any = environment.ionicConfig;
 
  constructor() {
    this.config = environment.ionicConfig;
  }

  getConfig(): any{
    return this.config;
  }
}
