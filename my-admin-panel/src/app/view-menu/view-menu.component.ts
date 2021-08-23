import { Component, OnInit } from '@angular/core';
import {Items} from '../itemservices.service'
import {ItemservicesService} from '../itemservices.service'


@Component({
  selector: 'app-view-menu',
  templateUrl: './view-menu.component.html',
  styleUrls: ['./view-menu.component.css']
})
export class ViewMenuComponent implements OnInit {
 


  items?: Items[];
  currentItems: Items = {};
  currentIndex = -1;
  title = '';

  constructor(private itemService: ItemservicesService) { }

  ngOnInit(): void {
  }
  retrieveTutorials(): void {
    this.itemService.getAll()
      .subscribe(
        data => {
          this.items = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  
}