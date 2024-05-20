import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BaseService {

  private kolcsonzesekUrl = 'http://localhost:8000/Kolcsonzesek/';
  private kolcsonzokUrl = 'http://localhost:8000/Kolcsonzok/';
  private kolcsonzesekSub = new BehaviorSubject(null);
  private kolcsonzokSub = new BehaviorSubject(null);

  constructor(private http: HttpClient) { }

  private loadKolcsonzok(){
    this.http.get(this.kolcsonzokUrl).subscribe(
      (res:any) => this.kolcsonzokSub.next(res)
    )
  }

  getKolcsonzok(){
    return this.kolcsonzokSub;
  }
}
