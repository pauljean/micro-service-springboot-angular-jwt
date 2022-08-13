package com.pauljean.microservicebackend.service;

import com.pauljean.microservicebackend.dao.ProduitRepository;
import com.pauljean.microservicebackend.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> livresDisponible() {

        return produitRepository.findByDisponible(true);
    }

    @Override
    public Produit emprunterLivre(String nom) {

            Produit produit= produitRepository.findByNom(nom);
            if (produit==null) throw new RuntimeException("Ce livre n'existe pas");
            produit.setDisponible(false);
            produitRepository.save(produit);
        return produit;
    }

    @Override
    public Produit restituerLivre(String nom) {

        Produit produit= produitRepository.findByNom(nom);
        produit.setDisponible(true);
        produitRepository.save(produit);
        return produit;
    }


    @Override
    public Produit ajouterLivre(Produit p) {
           Produit produit= produitRepository.findByNom(p.getNom());
           if (produit !=null) throw new RuntimeException("Ce livre existe deja");

        return produitRepository.save(p);
    }

    @Override
    public List<Produit> livresEmprunter() {
        return  produitRepository.findByDisponible(false);

    }




}
