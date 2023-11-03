import {Component} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {RestService} from "../../rest.service";

@Component({
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css'],
})

export class AddItemComponent {
  constructor(private restService: RestService) {
  }

  dataForm = new FormGroup({
    model: new FormControl(''),
  })

  onSubmit() {
    this.restService.addItem(<string>this.dataForm.value.model)
  }
}
