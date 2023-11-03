import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Inject } from '@angular/core';
import { RestService } from "../../rest.service";

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent {
  displayedColumns: string[] = ['id', 'count', 'price', 'date'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA); 

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private restService: RestService) { 
    console.log(this.data.id)

    this.restService.getDeliveries(this.data.id).subscribe(
      (response) => {                           
        console.log('response received')
        this.dataSource = response;
      });
  }

  toggleEdit(element: PeriodicElement): void {
    element.editable = !element.editable;
  }

  saveEdit(element: PeriodicElement): void {
    // Tutaj możesz zapisać zmiany w elemencie, na przykład do serwera.
    element.editable = false;
  }

  deliveryForm = new FormGroup({
    count: new FormControl(''),
    price: new FormControl(''),
    date: new FormControl('')
  })

  deliverySubmit() {
    this.restService.addDetails(this.data.id, 
                                <number><unknown>this.deliveryForm.value.count, 
                                <number><unknown>this.deliveryForm.value.price,
                                <string>this.deliveryForm.value.date)
    console.log(this.deliveryForm.value);
  }
}

export interface PeriodicElement {
  price: number;
  id: number;
  count: number;
  date: string;
  editable: boolean;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {id: 1, price: 429.99, count: 30, date: '01.11.2023', editable: false},
  {id: 2, price: 129.99, count: 20, date: '02.11.2023', editable: false},
  {id: 3, price: 229.99, count: 10, date: '03.11.2023', editable: false},
];