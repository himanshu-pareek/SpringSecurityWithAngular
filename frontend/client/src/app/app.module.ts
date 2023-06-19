import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppComponent } from './app.component'
import { RouterModule, Routes } from '@angular/router'
import { BankComponent } from 'src/bank/bank.component'
import { HttpClientModule } from '@angular/common/http'

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'bank' },
  { path: 'bank', component: BankComponent },
  { path: 'login', component: 'LoginComponent' }
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
