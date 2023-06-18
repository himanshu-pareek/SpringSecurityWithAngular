// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { HttpClient } from '@angular/common/http'
import { Component } from '@angular/core'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client'
  transfer = {
    to: '',
    amount: 0
  }

  constructor (private readonly http: HttpClient) {}

  handleAccountChange (event: any): void {
    this.transfer.to = event.target.value
  }

  handleAmountChange (event: any): void {
    this.transfer.amount = parseInt(event.target.value)
  }

  transferMoney (): void {
    this.http.get('/banking/transfer', {
      params: {
        account: this.transfer.to,
        amount: this.transfer.amount
      }
    }).subscribe(console.log)
  }

  transferMoneyPost (): void {
    this.http.post('/banking/transfer', {
      account: this.transfer.to,
      amount: this.transfer.amount
    }).subscribe(console.log)
  }
}
