import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaisesComponent } from './components/paises/paises.component';

const routes: Routes = [
  {
    path:'',
    redirectTo:'Paises',
    pathMatch:'full'
  },
  {
    path:'Paises',
    component:PaisesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
