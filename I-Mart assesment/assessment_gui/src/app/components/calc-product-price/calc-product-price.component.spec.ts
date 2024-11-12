import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CalcProductPriceComponent } from './calc-product-price.component';

describe('CalcProductPriceComponent', () => {
  let component: CalcProductPriceComponent;
  let fixture: ComponentFixture<CalcProductPriceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CalcProductPriceComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CalcProductPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
