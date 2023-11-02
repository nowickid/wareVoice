import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent {
  displayedColumns: string[] = ['lp', 'count', 'price', 'date'];
  dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA); 

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
    console.log(this.deliveryForm.value);
  }
}

export interface PeriodicElement {
  price: number;
  lp: number;
  count: number;
  date: string;
  editable: boolean;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {lp: 1, price: 429.99, count: 30, date: '01.11.2023', editable: false},
  {lp: 2, price: 129.99, count: 20, date: '02.11.2023', editable: false},
  {lp: 3, price: 229.99, count: 10, date: '03.11.2023', editable: false},
];