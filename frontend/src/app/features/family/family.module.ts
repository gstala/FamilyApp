import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FamilyRoutingModule} from './family-routing.module';
import {MaterialModule} from '../../shared/material.module';
import {CreateFamilyComponent} from './components/create-family/create-family.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {FamilyService} from './services/family.service';
import {HttpClientModule} from '@angular/common/http';
import { FamilyDetailsComponent } from './components/family-details/family-details.component';
import { SearchFamilyComponent } from './components/search-family/search-family.component';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    FamilyRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  declarations: [CreateFamilyComponent, FamilyDetailsComponent, SearchFamilyComponent],
  providers: [FamilyService]
})
export class FamilyModule {
}
