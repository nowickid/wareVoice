import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { AddItemComponent } from './add-item/add-item.component';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.css'],
})

export class WarehouseComponent {
  displayedColumns: string[] = ['lp', 'model', 'count', 'details'];
  dataSource = ELEMENT_DATA;

  constructor(public dialog: MatDialog) {}

  showDetails() {
    this.dialog.open(ItemDetailsComponent);
  }
  add() {
    this.dialog.open(AddItemComponent)
  }
}


export interface PeriodicElement {
  model: string;
  lp: number;
  count: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {lp: 1, model: 'Hydrogen', count: 1.0079},
  {lp: 2, model: 'Helium', count: 4.0026},
  {lp: 3, model: 'Lithium', count: 6.941},
  {lp: 4, model: 'Beryllium', count: 9.0122},
  {lp: 5, model: 'Boron', count: 10.811},
  {lp: 6, model: 'Carbon', count: 12.0107},
  {lp: 7, model: 'Nitrogen', count: 14.0067},
  {lp: 8, model: 'Oxygen', count: 15.9994},
  {lp: 9, model: 'Fluorine', count: 18.9984},
  {lp: 10, model: 'Neon', count: 20.1797},
];
