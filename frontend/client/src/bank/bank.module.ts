import { NgModule } from '@angular/core'
import { HttpClientModule } from '@angular/common/http'
import { BankComponent } from './bank.component'

@NgModule({
  imports: [
    HttpClientModule
  ],
  declarations: [
    BankComponent
  ],
  exports: []
})
export class BankModule {

}
