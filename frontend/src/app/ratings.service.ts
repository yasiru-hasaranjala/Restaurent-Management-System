import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { Ratings } from './ratings';


@Injectable({
  providedIn: 'root'
})
export class RatingsService {

  private apiServerUrl = environment.apiBaseUrl;

  


  
}
