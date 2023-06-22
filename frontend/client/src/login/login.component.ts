/* eslint-disable @typescript-eslint/consistent-type-imports */
import { Component } from '@angular/core'
import { Router } from '@angular/router'
import { AppService } from 'src/app/app.service'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: [
    './login.component.css'
  ]
})
export class LoginComponent {
  credentials = {
    username: '',
    password: ''
  }

  error = ''

  constructor (
    private readonly appService: AppService,
    private readonly router: Router
  ) {
  }

  async signIn (): Promise<boolean> {
    this.error = ''
    try {
      const user = await this.appService.authenticate(this.credentials)
      console.log(user)
      await this.router.navigateByUrl('/')
    } catch (error) {
      this.error = 'Invalid username / password'
      console.error(error)
    }
    return false
  }
}
