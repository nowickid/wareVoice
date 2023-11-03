import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { AddItemComponent } from './add-item/add-item.component';
import {RestService} from "../rest.service";

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.css'],
})

export class WarehouseComponent {
  displayedColumns: string[] = ['lp', 'model', 'count', 'details'];
  dataSource: any;

  constructor(public dialog: MatDialog, private restService: RestService) {

    this.restService.getItems().subscribe(
      (response) => {                           //next() callback
        console.log('response received')
        this.dataSource = response;
      });
  }

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
