/* eslint-disable @typescript-eslint/consistent-type-imports */
import { Component } from '@angular/core'
import { HttpClient } from '@angular/common/http'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'OAuth2 Client Application'
  authenticated = false
  counter = 0

  constructor (private readonly httpClient: HttpClient) {
  }

  getHello (): void {
    this.httpClient.get<{ get_text: string }>('/resource/hello').subscribe({
      next: value => {
        console.log(value)
        alert(JSON.stringify(value, undefined, 4))
      },
      error: err => {
        console.error(err)
      },
      complete: () => {
        console.log('Completed.')
      }
    })
  }

  postHello (): void {
    // eslint-disable-next-line @typescript-eslint/restrict-plus-operands
    const textToSend = 'Hello ' + this.counter
    this.httpClient.post('/resource/hello', { text: textToSend }).subscribe({
      next: value => {
        console.log(value)
        alert(JSON.stringify(value, undefined, 4))
      },
      error: err => {
        console.error(err)
      },
      complete: () => {
        console.log('Completed.')
      }
    })
  }

  getDemo (): void {
    this.httpClient.get<{ message: string }>('/demo').subscribe({
      next: value => {
        console.log(value)
        alert(JSON.stringify(value, undefined, 4))
      },
      error: err => {
        console.error(err)
      },
      complete: () => {
        console.log('Completed.')
      }
    })
  }
}
