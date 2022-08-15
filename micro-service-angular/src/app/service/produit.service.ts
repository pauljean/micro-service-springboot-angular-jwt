import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { Produit } from '../modele/produit';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class ProduitService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<Produit[]>(`${environment.apiUrl}/backend/produits`);
    }
}