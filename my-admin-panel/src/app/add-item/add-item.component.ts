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
  selector: 'app-add-item',
  templateUrl: './add-item.component.html',
  styleUrls: ['./add-item.component.css']
})
export class AddItemComponent implements OnInit {
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
