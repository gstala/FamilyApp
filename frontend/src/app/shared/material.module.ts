import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';


import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatCardModule} from '@angular/material/card';
import {MatStepperModule} from '@angular/material/stepper';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material';
import {MatSelectModule} from '@angular/material/select';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';


const materialModules =
  [
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatCardModule,
    MatStepperModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatSnackBarModule,
    MatIconModule,
    MatTableModule
  ];

@NgModule({
  imports: [
    CommonModule,
    FlexLayoutModule,
    materialModules
  ],
  declarations: [],
  exports: [materialModules, FlexLayoutModule]

})
export class MaterialModule {
}
