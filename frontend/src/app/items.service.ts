import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Items } from './items';

@Injectable({
  providedIn: 'root'
})
export class ItemsService {

  private apiServerUrl = environment.apiBaseUrl;
  
  constructor(private http: HttpClient) { }

  public getItems(): Observable<Items[]> {
    return this.http.get<Items[]>(`${this.apiServerUrl}item-service/getallitem`);
  }

  public addItems(items: Items): Observable<Items> {
    return this.http.post<Items>(`${this.apiServerUrl}item-service/saveitem`, items);
  }

  public updateItems(items: Items): Observable<Items> {
    return this.http.put<Items>(`${this.apiServerUrl}item-service/updateitem`, items);
  }

  public deleteItems(itemID: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}item-service/delete/${itemID}`);
  }
}
