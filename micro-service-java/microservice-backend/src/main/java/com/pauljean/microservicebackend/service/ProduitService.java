package com.pauljean.microservicebackend.service;

import com.pauljean.microservicebackend.dao.IProduitDao;
import com.pauljean.microservicebackend.entity.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProduitService implements ProduitServiceInt{

    @Autowired
    private IProduitDao iProduitDao;

    @Override
    public List<Produit> livresDisponible() {

        return iProduitDao.findByDisponible(true);
    }

    @Override
    public Produit emprunterLivre(String nom) {

            Produit produit=iProduitDao.findByNom(nom);
            if (produit==null) throw new RuntimeException("Ce livre n'existe pas");
            produit.setDisponible(false);
            iProduitDao.save(produit);
        return produit;
    }

    @Override
    public Produit restituerLivre(String nom) {

        Produit produit=iProduitDao.findByNom(nom);
        produit.setDisponible(true);
        iProduitDao.save(produit);
        return produit;
    }


    @Override
    public Produit ajouterLivre(Produit p) {
           Produit produit=iProduitDao.findByNom(p.getNom());
           if (produit !=null) throw new RuntimeException("Ce livre existe deja");

        return iProduitDao.save(p);
    }

    @Override
    public List<Produit> livresEmprunter() {
        return  iProduitDao.findByDisponible(false);

    }




}
