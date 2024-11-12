import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CalcProductPriceComponent} from "./components/calc-product-price/calc-product-price.component";
import {ProductTableComponent} from "./components/product-table/product-table.component";

const routes: Routes = [
  {
    path: '',
    component: ProductTableComponent },
  {
    path: 'calcPrice/:id',
    component: CalcProductPriceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
