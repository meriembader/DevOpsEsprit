package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;

public class DepartementServiceImpl implements IDepartementService{

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	
	@Override
	public List<Departement> affecterDepartementEmploye(int employeId, int depId) {
		Departement depManagedEntity = deptRepoistory.findById(depId).get();
		Employe employeManagedEntity = employeRepository.findById(employeId).get();

		if(employeManagedEntity.getDepartements() == null){

			List<Departement> departements = new ArrayList<>();
			 departements.add(depManagedEntity);
			employeManagedEntity.setDepartements(departements);
		}else{

			employeManagedEntity.getDepartements().add(depManagedEntity);

		}
		
		return employeManagedEntity.getDepartements();
	}
	
	

}
