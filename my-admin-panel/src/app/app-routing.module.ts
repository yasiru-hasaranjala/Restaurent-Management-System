import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemComponent } from './add-item/add-item.component';
import { UpdateItemComponent } from './update-item/update-item.component';
import { DeleteItemComponent } from './delete-item/delete-item.component';
import { ViewMenuComponent } from './view-menu/view-menu.component';
import { ViewOrdersComponent } from './view-orders/view-orders.component';
import { ViewUsersComponent } from './view-users/view-users.component';

const appRoutes: Routes=[
  {path: 'add-item',component:AddItemComponent},
  {path: 'delete-item',component:DeleteItemComponent},
  {path: 'update-item',component:UpdateItemComponent},
  {path: 'view-menu',component:ViewMenuComponent},
  {path: 'view-orders',component:ViewOrdersComponent},
  {path: 'view-users',component:ViewUsersComponent},
  {path: '',redirectTo:'/add-item',pathMatch:'full'}
];


@NgModule({
  imports: [RouterModule.forRoot(
    appRoutes,
            {enableTracing:true}          
    )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
