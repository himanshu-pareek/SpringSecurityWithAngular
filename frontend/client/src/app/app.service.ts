// eslint-disable-next-line @typescript-eslint/consistent-type-imports
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Injectable } from '@angular/core'

@Injectable()
export class AppService {
  authenticated = false

  constructor (private readonly http: HttpClient) {
  }

  async fetchAuthenticationState (): Promise<boolean> {
    return await new Promise((resolve, reject) => {
      this.http.get<{ name: string }>('/user')
        .subscribe({
          next: value => {
            this.authenticated = true
            resolve(true)
          },
          error: error => {
            this.authenticated = false
            reject(error)
          }
        })
    })
  }

  async authenticate (credentials: {
    username: string
    password: string
  }): Promise<{ name: string }> {
    const headers = new HttpHeaders(
      {
        authorization: 'Basic ' + btoa(
          `${credentials.username}:${credentials.password}`
        )
      }
    )

    return await new Promise((resolve, reject) => {
      this.http.get<{ name: string }>('/user', {
        headers
      }).subscribe({
        next: (response) => {
          this.authenticated = response.name != null
          resolve(response)
        },
        error: (error) => {
          reject(error)
        }
      })
    })
  }
}
