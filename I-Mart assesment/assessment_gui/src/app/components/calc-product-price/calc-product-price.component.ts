import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TableDataService} from "../../services/table-data.service";

@Component({
  selector: 'app-calc-product-price',
  templateUrl: './calc-product-price.component.html',
  styleUrl: './calc-product-price.component.scss'
})
export class CalcProductPriceComponent implements OnInit{
  productId: number | null = null;
  product : { productId: number, productName: string, availableCartons: number, availableSingleUnits: number, unitsPerCarton: number, pricePerCarton: number} | undefined;
  chgProductId=0;
  cartonQuantity=0;
  uniteQuantity=0;
  TotalPrice = 0 ;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private tableDataService : TableDataService) {
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params =>{
      this.productId = Number(params.get('id'));
      this.tableDataService.getProductById(this.productId).subscribe(
        (resp : any) => {
         console.log(resp);
          this.product = resp.data;
          this.chgProductId = resp.data.productId;
          console.log(this.product)
        },
        (error => {
          console.log(error);
        })
      );
    })
  }

  cancel() {
    this.router.navigate([''])
  }

  totalPrice() {
    this.tableDataService.getTotalPrice(this.chgProductId,this.cartonQuantity,this.uniteQuantity).subscribe(
      (resp : any) => {
        console.log(resp);
        this.TotalPrice = resp.data;
      }, error => {
        console.log(error);
      }
    )
  }
}
