import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RouterModule } from '@angular/router';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { NavbarComponent } from './common/navbar/navbar.component';
import { MatButtonModule } from '@angular/material/button';

import { MatTableModule } from '@angular/material/table';
import { ItemDetailsComponent } from './warehouse/item-details/item-details.component';

import { MatDialogModule } from '@angular/material/dialog';
import { AddItemComponent } from './warehouse/add-item/add-item.component';

import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';

import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';

import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { MAT_DATE_LOCALE } from '@angular/material/core';

import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { MainComponent } from './main/main.component';
import { HttpClientModule } from  '@angular/common/http';
import { DatePipe } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    WarehouseComponent,
    NavbarComponent,
    ItemDetailsComponent,
    AddItemComponent,
    MainComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: 'warehouse', component: WarehouseComponent},
      {path: '', component: MainComponent}
    ]),
    BrowserAnimationsModule,
    MatButtonModule,
    MatTableModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatDividerModule,
    MatListModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule,
    MatIconModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'pl-PL'}, DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
