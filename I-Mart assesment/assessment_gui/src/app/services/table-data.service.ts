import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


export interface productData{
  id : number;
}

@Injectable({
  providedIn: 'root'
})

export class TableDataService {

  private apiUrl = 'http://localHost:8081/api/v1/product';

  constructor(private http: HttpClient) {
  }

  getAllProductData(){
    return this.http.get(this.apiUrl+'/get-all-products');
  }

  getProductById(productId : number){
    return this.http.get(this.apiUrl+'/get-product-by-id?id='+productId);
  }

  getTotalPrice(productId : number, cartonQt: number, uniteQt: number){
    return this.http.get(this.apiUrl+'/get-total-price?id='+productId+'&cartons='+cartonQt+'&unites='+uniteQt);
  }
}
