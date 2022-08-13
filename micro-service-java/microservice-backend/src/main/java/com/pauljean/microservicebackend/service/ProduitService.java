package com.pauljean.microservicebackend.service;

import com.pauljean.microservicebackend.entity.Produit;

import java.util.List;

public interface ProduitService {

    // Liste des livres disponible
    public List<Produit> livresDisponible();

    // emprunter un livre
    public Produit emprunterLivre(String nom);

    //Restituer un livre
    public Produit restituerLivre(String nom);

    // ajouter un livre
    public Produit ajouterLivre(Produit p);

    // Liste des livres empruntes
    public List<Produit> livresEmprunter();

}
