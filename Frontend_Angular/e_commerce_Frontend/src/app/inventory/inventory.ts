import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonModule} from '@angular/common';


interface  Product
{
  id: string;
  name: string;
  price: number;
  quantity: number;
  _links: any;


}

interface InventoryApiResponse {
  _embedded: {
    products: Product[]; // Le tableau des clients est sous cette clé
  };
  page?: any;
  _links?: any;
}






@Component({
  selector: 'app-inventory',
  imports: [CommonModule],
  templateUrl: './inventory.html',
  styleUrl: './inventory.css'
})
export class Inventory implements OnInit{


  products: any;

  constructor(private  http:HttpClient) {

  }

  ngOnInit() {

    this.http.get<InventoryApiResponse>("http://localhost:8092/inventory-service/products").subscribe(
      (responses: InventoryApiResponse)=>{

        if (responses && responses._embedded && responses._embedded.products)
        {
          this.products =responses._embedded.products
        }

        else
        {
          // Fallback : au cas où l'API changerait et renverrait le tableau directement
          console.warn("Réponse de l'API inattendue, assignation directe.");
          this.products= responses as any;
        }



      },
      (error)=>{

        console.error("Erreur lors du chargement des données ", error);

      }
    );

  }


}
