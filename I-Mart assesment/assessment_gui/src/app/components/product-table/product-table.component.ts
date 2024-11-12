import { Component } from '@angular/core';
import {TableDataService} from "../../services/table-data.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-table',
  templateUrl: './product-table.component.html',
  styleUrl: './product-table.component.scss'
})
export class ProductTableComponent {

  products = null;

  constructor(
    private tableDataService : TableDataService,
    private router: Router) {
    this.getTableData();
  }

  getTableData(){
    this.tableDataService.getAllProductData().subscribe(
      (resp : any) => {
        console.log(resp);
        this.products = resp.data;
      },
      (error => {
        console.log(error);
      })
    );
  }

  priceCalculate(productId : number) {
    this.router.navigate(['/calcPrice',productId])
  }
}
