import { Component, OnInit } from "@angular/core";
import { first } from "rxjs/operators";
import { User } from "../modele/user";
import { Produit } from "../modele/produit";
import { UserService } from "../service/user.service";
import { ProduitService } from "../service/produit.service";



@Component({
    templateUrl: './home.Component.html',
  })
  export class HomeComponent implements OnInit {
  
    public headerRow: string[];



    loading = false;
    users: User[];
    produits: Produit[];

    constructor(private userService: UserService, private produitService: ProduitService) { }

    ngOnInit() {
        this.loading = true;
        this.produitService.getAll().pipe(first()).subscribe(produits => {
            this.loading = false;
            this.produits = produits;
        });


        this.headerRow= [ '#', 'Name', 'Catégorie', 'Prix', 'Actions'];

    }
  }