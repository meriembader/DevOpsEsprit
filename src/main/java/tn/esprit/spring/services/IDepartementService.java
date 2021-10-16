package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;

public interface IDepartementService {

	public List<Departement> affecterDepartementEmploye(int employeId, int depId);

}
