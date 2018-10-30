import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CreateFamilyComponent} from './components/create-family/create-family.component';
import {FamilyDetailsComponent} from './components/family-details/family-details.component';
import {SearchFamilyComponent} from './components/search-family/search-family.component';

const routes: Routes = [
  {path: 'create', component: CreateFamilyComponent},
  {path: 'search', component: SearchFamilyComponent},
  {path: ':id/details', component: FamilyDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FamilyRoutingModule {
}
