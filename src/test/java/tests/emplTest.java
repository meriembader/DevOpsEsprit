package tests;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.stereotype.Component;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;

import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.DepartementServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;


@Component
@Aspect
public class emplTest {
	EmployeServiceImpl empService;
	DepartementRepository depRepo;
	DepartementServiceImpl depService;
	private static final Logger l = LogManager.getLogger(emplTest.class);
/*
	@Test
	public void AffecterEmpDeptest() {

		Employe employe = new Employe("bekir", "ali", "ali@esprit.tn");

		Employe savedemp = empService.ajouterEmploye(employe);

		assertThat(savedemp.getId()).isGreaterThan(0);

		Departement departement = new Departement("dep1");

		Departement savedDep = depRepo.save(departement);

		assertThat(savedDep.getId()).isGreaterThan(0);

		List<Employe> Lemp = empService.affecterEmployeADepartement(savedemp.getId(), savedDep.getId());

		assertThat(Lemp.contains(savedemp)).isTrue();



		assertThat(Lemp.contains(savedemp)).isTrue();

		empService.deleteEmployeById(savedemp.getId());

		depRepo.deleteById(savedDep.getId());
	}

	@Around("execution(* tn.esprit.spring.services.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		l.info("Method execution time: " + elapsedTime + " milliseconds.");
		String name = pjp.getSignature().getName();

		if(elapsedTime>3000){
		l.warn("methode:"+name+ "execution time more than 3 seconds");
		
		}
		return obj;

	}
*/
}
