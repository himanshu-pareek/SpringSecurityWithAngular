/* eslint-disable @typescript-eslint/consistent-type-imports */
import { Component, OnInit } from '@angular/core'
import { AppService } from './app.service'
import {HttpClient, HttpHeaders} from '@angular/common/http'
import { Router } from '@angular/router'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Spring Security with Angular'

  constructor (
    private readonly appService: AppService,
    private readonly http: HttpClient,
    private readonly router: Router
  ) {
  }

  ngOnInit (): void {
    this.appService.fetchAuthenticationState()
      .then(value => {
        if (!value) {
          void this.router.navigateByUrl('/login')
        }
      })
      .catch(error => {
        console.error(error)
        void this.router.navigateByUrl('/login')
      })
  }

  logout (): void {
    this.http.post('/logout', {}).subscribe(() => {
      this.appService.authenticated = false
      void this.router.navigateByUrl('/login')
    })
  }

  async sayHello (): Promise<void> {
    this.http.get< { text: string }>(
      '/resource/demo/hello'
    )
      .subscribe({
        next: value => {
          alert(value.text)
        },
        error: err => {
          console.error(err)
        }
      }
      )
  }
}
