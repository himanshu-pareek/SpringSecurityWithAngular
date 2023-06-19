// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Injectable } from '@angular/core'

@Injectable()
export class AppService {
  authenticated = false

  constructor (private readonly http: HttpClient) { }

  async authenticate (credentials?: {
    username: string
    password: string
  }, callback = null): Promise<{ name: string | null }> {
    const headers = new HttpHeaders(
      (credentials != null)
        ? {
            authorization: 'Basic ' + btoa(
            `${credentials.username}:${credentials.password}`
            )
          }
        : {}
    )

    return await new Promise((resolve, reject) => {
      this.http.get<{ name: string | null }>('user', {
        headers
      }).subscribe({
        next: (response) => {
          if (response.name != null) {
            this.authenticated = true
          } else {
            this.authenticated = false
          }
          resolve(response)
        },
        error: (error) => {
          reject(error)
        }
      })
    })
  }
}
