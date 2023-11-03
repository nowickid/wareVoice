import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RestService {

  baseURL: string = "http://localhost:8080/";

  constructor(private http: HttpClient) {
  }

  getItems(): Observable<any> {
    return this.http.get(this.baseURL + 'items')
  }

  getDeliveries(id: number):  Observable<any> {
    return this.http.get(this.baseURL + 'deliveries/'+id)
  }

  addItem(model: string) {
    this.http.post(this.baseURL + 'create-item',
      {
        "model": model
      }).subscribe()
  }

  addDetails(count: number, price: number, date: string) {
    this.http.post(this.baseURL + 'add-delivery',
      {
        "count": count,
        "price": price,
        "date": date
      }).subscribe()
  }
}


