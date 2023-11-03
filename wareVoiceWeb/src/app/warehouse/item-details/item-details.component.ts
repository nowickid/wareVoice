import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Inject } from '@angular/core';
import { RestService } from "../../rest.service";
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent {
  displayedColumns: string[] = ['id', 'count', 'price', 'date'];
  dataSource: any;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any, private restService: RestService, private datePipe: DatePipe) {
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
  formatPurchaseDate(dateString: string): string {
    const date = new Date(dateString);
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    const formattedDate = this.datePipe.transform(date, 'fullDate', 'pl-PL');
  
    return formattedDate || ''; // Obsługuje wartość null
  }
}

export interface PeriodicElement {
  price: number;
  id: number;
  count: number;
  purchaseDate: string;
  editable: boolean;
}
