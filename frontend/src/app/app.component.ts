import { HttpErrorResponse } from '@angular/common/http';
import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Items } from './items';
import { ItemsService } from './items.service';
import { Ratings } from './ratings';
import { RatingsService } from './ratings.service';
import { HttpClient } from '@angular/common/http';
import {ModalDismissReasons, NgbModal} from '@ng-bootstrap/ng-bootstrap';


export class RateItem{

  itemID?:string;
  userID?:string;
  rate?:string;
  description?:string;
}

export class Oredering{

  cusid?:string;
  itemid?:string;
  quantity?:string;
  description?:string;
  amount?:string;
}




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title={};
  
  currentRating = 3;

  // public items: Items[];
  items: Items[]=[];

  ratings:Ratings[]=[];

  closeModal?: string;

  customerRating=0;
  
  comment: string = '';

  number_of_items='';
  location='';
 

  constructor(
    private itemService: ItemsService,
    private ratingService:RatingsService,
    private http: HttpClient,
    private http_rating: HttpClient,
    private modalService: NgbModal,
    ){}

  

  ngOnInit(){
    this.getItems();
    
  }

  gridColumns = 3;

  toggleGridColumns() {
    this.gridColumns = this.gridColumns === 3 ? 4 : 3;
  }

  public getItems(): void {
    this.itemService.getItems().subscribe(
      (response: Items[]) => {
        this.items = response;
        // console.log(this.items);
        this.calculateWeights();
      }, 
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public calculateWeights():void{
    for(let i=0;i<this.items.length;i++){
      
      // console.log(this.items[i].itemID);
        this.getRates(this.items[i].itemID);

    }
  }

  getRates(id : string){
    // console.log(id);
    //console.log(`http://localhost:9000/api-gateway/rating-service/getallratings/${id}`);
    this.http_rating.get<any>(`http://localhost:9000/api-gateway/rating-service/getallratings/${id}`).subscribe(
      response => {
        console.log(response);
        this.ratings = response;
        let j=0;
        for (let i =0; i<response.length; i++){
           if(response[i].itemID ==1 ){
            // j += Number(response[i].rate);
            this.currentRating=2; 
           }
           else if (response[i].itemID ==2){
            this.customerRating=3;
           }
           else{
            this.currentRating=4;
           }
            
        }
        //this.currentRating=j/response.length;


        console.log(this.currentRating)

        // console.log(response.length)

      }
    )

  }


  triggerModal(content:any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((res) => {
      this.closeModal = `Closed with: ${res}`;
    }, (res) => {
      this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  SubmiteRate(){
    console.log(this.customerRating);

    

    let item = new RateItem();
    item.itemID="1";
    item.userID="1";
    item.rate= this.customerRating.toString();
    item.description=this.comment;

    //  console.log(item);
    this.Save(item);


  }

  Save(data : RateItem){
    console.log(data);
    return this.http_rating.post("http://localhost:9000/api-gateway/rating-service/saverating",data).subscribe(
      responseSave => {
        console.log(responseSave);
      }
    )
  }



  Confirm(){
    let order = new Oredering();
    order.cusid="1";
    order.itemid="1";
    order.quantity=this.number_of_items;
    order.description=this.location;
    order.amount="450.00"

    this.SaveOrder(order);
  }

  SaveOrder(data:Oredering){
    console.log(data);
    return this.http_rating.post("http://localhost:9000/api-gateway/order-service/api/orders",data).subscribe(
      responseSave => {
        console.log(responseSave);
      }
    )
  }

  
  
}
