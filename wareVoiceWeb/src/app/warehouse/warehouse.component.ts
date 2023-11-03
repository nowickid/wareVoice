import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ItemDetailsComponent } from './item-details/item-details.component';
import { AddItemComponent } from './add-item/add-item.component';
import { RestService } from "../rest.service";

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.css'],
})

export class WarehouseComponent {
  displayedColumns: string[] = ['id', 'model', 'count', 'details'];
  dataSource: any;

  constructor(public dialog: MatDialog, private restService: RestService) {

    this.restService.getItems().subscribe(
      (response) => {                           //next() callback
        console.log('response received')
        this.dataSource = response;
      });
  }

  showDetails(id: number) {
    this.dialog.open(ItemDetailsComponent, {
      data: { id: id }
    })
  }

  add() {
    this.dialog.open(AddItemComponent)
  }
}


export interface PeriodicElement {
  model: string;
  id: number;
  count: number;
}
