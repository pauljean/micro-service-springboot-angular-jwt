package com.pauljean.microservicebackend;

import com.pauljean.microservicebackend.dao.ProduitRepository;
import com.pauljean.microservicebackend.entity.Produit;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;
@EnableEurekaClient
@SpringBootApplication
public class MicroserviceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(RepositoryRestConfiguration restConfiguration, ProduitRepository produitRepository)
	{
		return Args-> {
			restConfiguration.exposeIdsFor(Produit.class);
			/*List<Produit> produits=new ArrayList<>();
			produits.add(new Produit(1,"Jeu de dame","apprentissage",4.5,true,false));
			produits.add(new Produit(2,"Chasse au tresor","Aventure",9.5,true,true));
			produits.add(new Produit(3,"Femme de fer","Romance",5.2,true,true));
			produits.add(new Produit(4,"De zero a hero","Action",4.5,true,false));
			produitRepository.saveAll(produits);*/

		};
	}

}
