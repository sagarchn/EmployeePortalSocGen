import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { server_url } from './url-constant';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  server_url = server_url;

  constructor(private http: HttpClient) { }

  getHeaders() {
    const headers = new HttpHeaders().set('content-type', 'application/json');
    return headers;
  }

  /**
   * method to make POST request
   * 
   * @param url 
   * @param body 
   */
  addObject(url: string, body: any, params?: HttpParams): Observable<Object> {
    if (!!url) {

      let options = { headers: this.getHeaders(), params: params };
      return this.http.post<Object>(this.server_url + url, JSON.stringify(body), options)
        .pipe(catchError(this.handleError));
    } else throwError('url cannot be empty!');
  }

  /**
   * method to make GET request and receive object array
   * 
   * @param url 
   * @param params 
   */
  getObjects(url: string, params?: HttpParams): Observable<Object[]> {
    if (!!url) {

      let oprions = { headers: this.getHeaders(), params: params };
      return this.http.get<Object[]>(this.server_url + url)
        .pipe(catchError(this.handleError));
    } else throw throwError('url cannot be empty!');

  }


  /**
   * extract http error message
   * @param e 
   */
  handleError(e: HttpErrorResponse) {
    try {

      return throwError(e.error.message);
    } catch (error) {
      return throwError('unable to extract server error : ' + error);
    }
  }
}
