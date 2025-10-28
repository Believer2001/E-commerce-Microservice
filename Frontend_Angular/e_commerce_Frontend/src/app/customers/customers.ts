import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommonModule} from '@angular/common';




// 1. Définir la structure exacte de la réponse HATEOAS
interface Customer {
  id: number;
  name: string;
  email: string;
  _links: any;
}

interface CustomerApiResponse {
  _embedded: {
    customers: Customer[]; // Le tableau des clients est sous cette clé
  };
  page?: any;
  _links?: any;
}

@Component({
  selector: 'app-customers',
  imports: [CommonModule],
  templateUrl: './customers.html',
  styleUrl: './customers.css'
})
export class Customers implements  OnInit{
   customer :Customer[] =[];
  constructor(private http :HttpClient) {
  }

  ngOnInit() {
    // ⬅️ Indiquer que le retour est CustomerApiResponse
    this.http.get<CustomerApiResponse>("http://localhost:8092/customer-service/customers").subscribe(
      (res: CustomerApiResponse) => { // ⬅️ Utiliser un nom court 'res' et typer explicitement le paramètre

        // 2. EXTRACTION CLÉ : Cibler le chemin '_embedded.customers'
        if (res && res._embedded && res._embedded.customers) {
          this.customer = res._embedded.customers;
        } else {
          // Fallback : au cas où l'API changerait et renverrait le tableau directement
          console.warn("Réponse de l'API inattendue, assignation directe.");
          this.customer = res as any;
        }

        console.log("Liste des clients chargée:", this.customer);
      },
      (err) => {
        console.error("Erreur lors du chargement des données ", err);
      });
  }

}
