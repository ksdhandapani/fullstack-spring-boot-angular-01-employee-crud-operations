import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

export class HttpErrorInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(retry(1), catchError((error: HttpErrorResponse) => {
            let errorMessage = '';
            if (error.error instanceof ErrorEvent) {
                // Client side error
                errorMessage = `Error : ${error.error.message}`
            } else {
                // Server side error
                errorMessage = `Error Code : ${error.status}\n Message : ${error.message}`
            }
            window.alert(errorMessage);
            return throwError(errorMessage);
        }))
    }
}