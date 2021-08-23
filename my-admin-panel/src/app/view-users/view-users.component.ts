import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
export class Item{
  constructor(
    public id:number,
    public name:string,
    public description:string,
    public price:number
  ){}
}
@Component({
  selector: 'app-view-users',
  templateUrl: './view-users.component.html',
  styleUrls: ['./view-users.component.css']
})
export class ViewUsersComponent implements OnInit {

  Items :Item[]=[];
  constructor(private httpClient:HttpClient) { 
    this.Items=[];
  }

  ngOnInit(): void {
  }
  getFriend(){
    let url = " ";
    this.httpClient.get<any>(url).subscribe(
      response =>{
        this.Items = response;
      }
    );
  }

}
