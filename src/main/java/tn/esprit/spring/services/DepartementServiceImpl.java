package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;

public class DepartementServiceImpl implements IDepartementService {

	@Autowired
	EmployeRepository employeRepository;
	@Autowired
	DepartementRepository deptRepoistory;

	@Override
	public List<Departement> affecterDepartementEmploye(int employeId, int depId) {
		Optional<Departement> d = deptRepoistory.findById(depId);
		Optional<Employe> e = employeRepository.findById(employeId);
		Employe employeManagedEntity = new Employe();
		Departement depManagedEntity = new Departement();
		if (d.isPresent() && e.isPresent()) {
			depManagedEntity = d.get();
			employeManagedEntity = e.get();
		}

		if (employeManagedEntity.getDepartements() == null) {

			List<Departement> departements = new ArrayList<>();
			departements.add(depManagedEntity);
			employeManagedEntity.setDepartements(departements);
		} else {

			employeManagedEntity.getDepartements().add(depManagedEntity);

		}

		return employeManagedEntity.getDepartements();
	}

}
