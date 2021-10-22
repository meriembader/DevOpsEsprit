package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseRepository extends CrudRepository<Entreprise, Integer>  {
    @Query("SELECT * FROM Entreprise e where e.name=name ")
    public Optional <Entreprise> findByName(@Param("name")String name);
	
}
