import {
  type HttpEvent,
  type HttpHandler,
  type HttpInterceptor,
  type HttpRequest
} from '@angular/common/http'
import { Injectable } from '@angular/core'
import { type Observable } from 'rxjs'

@Injectable()
export class XhrInterceptor implements HttpInterceptor {
  intercept (req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    })
    return next.handle(xhr)
  }
}
