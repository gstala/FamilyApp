import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainLayoutComponent} from './core/components/main-layout/main-layout.component';
import {WelcomeComponent} from './core/components/welcome/welcome.component';

const routes: Routes = [
  {
    path: '', component: MainLayoutComponent, children: [
      {
        path: '', component: WelcomeComponent
      },
      {
        path: 'family', loadChildren: '../app/features/family/family.module#FamilyModule',
      }
    ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
