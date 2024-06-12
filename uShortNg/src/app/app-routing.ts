import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadComponent: () => import('./home/home.page').then( m => m.HomePage),
  },
  {
    path: ':code',
    loadComponent: () => import('./redirect/redirect.page').then( m => m.RedirectPage)
  },
 
];
