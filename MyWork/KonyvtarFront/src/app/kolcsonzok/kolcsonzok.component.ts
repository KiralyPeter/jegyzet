import { Component, OnInit } from '@angular/core';
import { BaseService } from '../base.service';
import { Kolcsonzok } from '../kolcsonzok';

@Component({
  selector: 'app-kolcsonzok',
  templateUrl: './kolcsonzok.component.html',
  styleUrls: ['./kolcsonzok.component.css']
})
export class KolcsonzokComponent implements OnInit{

  kolcsonzokListaja: Kolcsonzok[] = [];

  constructor(private base:BaseService){}

  ngOnInit(): void {
      // this.base.getKolcsonzok().subscribe(res=> {
      //   this.kolcsonzokListaja = res;
      // }) 
        
      
  }


}
