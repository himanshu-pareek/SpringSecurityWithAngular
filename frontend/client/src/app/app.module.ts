import { NgModule } from '@angular/core'
import { BrowserModule } from '@angular/platform-browser'

import { AppComponent } from './app.component'
import { RouterModule, type Routes } from '@angular/router'
import { BankComponent } from 'src/bank/bank.component'
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { AppService } from './app.service'
import { FormsModule } from '@angular/forms'
import { LoginComponent } from 'src/login/login.component'
import { XhrInterceptor } from './xhr-interceptor.service'

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'bank' },
  { path: 'bank', component: BankComponent },
  { path: 'login', component: LoginComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    BankComponent,
    LoginComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    AppService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: XhrInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
