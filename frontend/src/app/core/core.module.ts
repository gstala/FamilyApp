import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {MainLayoutComponent} from './components/main-layout/main-layout.component';
import {MaterialModule} from '../shared/material.module';
import {RouterModule} from '@angular/router';
import { WelcomeComponent } from './components/welcome/welcome.component';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule
  ],
  declarations: [MainLayoutComponent, WelcomeComponent]
})
export class CoreModule {
}
