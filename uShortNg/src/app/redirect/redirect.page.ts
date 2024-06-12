import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA, Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { IonicModule } from '@ionic/angular';
import { UshortApiService } from '../services/ushort-api.service';

@Component({
  selector: 'app-redirect',
  templateUrl: './redirect.page.html',
  styleUrls: ['./redirect.page.scss'],
  standalone: true,
  imports: [CommonModule, IonicModule, HttpClientModule],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class RedirectPage implements OnInit {
  code: string | null = '';

  constructor(
    private route: ActivatedRoute,
    private ushortApiService: UshortApiService
  ) {}

  ngOnInit() {
    this.route.paramMap.subscribe((params) => {
      this.code = params.get('code');
    });

    this.redirectUser();
  }

  redirectUser() {
    this.ushortApiService.getOriginal(this.code).subscribe(
      (response) => {
        window.location.href =response.originalUrl;
      },
      (error) => {
        console.log(error);
      }
    );
  }
}
