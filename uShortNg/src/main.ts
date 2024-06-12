import { enableProdMode, importProvidersFrom } from '@angular/core';
import { routes } from './app/app-routing';
import { AppComponent } from './app/app.component';
import { IonicRouteStrategy } from '@ionic/angular';
import { environment } from './environments/environment';
import { IonicModule } from '@ionic/angular';
import { RouteReuseStrategy, provideRouter } from '@angular/router';
import { bootstrapApplication } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

if (environment.production) {
  enableProdMode();
}

bootstrapApplication(AppComponent, {
  providers: [
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    importProvidersFrom(IonicModule.forRoot({})),
    importProvidersFrom(HttpClientModule),
    provideRouter(routes),
  ],
});
