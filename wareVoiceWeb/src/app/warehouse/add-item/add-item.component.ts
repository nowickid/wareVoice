import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css'],
})

export class AddItemComponent {
  dataForm = new FormGroup({
    model: new FormControl(''),
  })

  onSubmit() {
    console.log(this.dataForm.value);
  }
}