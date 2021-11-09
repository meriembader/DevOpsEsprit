package tn.esprit.spring.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;
import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {
	
	@Autowired
	DepartementRepository depRepo;
	
	private static final Logger l= LogManager.getLogger(EmployeTest.class);
	
	@Autowired
	IEmployeService emplS;

   @Test
	public void testAddEmploye() {
		int emp = emplS.ajouterEmploye(new Employe("rafaa", "lakhdhar", "rafaa.lakhdhar@esprit.tn", true, Role.CHEF_DEPARTEMENT));
		l.debug("employee added");
		emplS.deleteEmployeById(emp);
		l.info(emp);
	}
	
	@Test
	public void testGetEmployePrenomById() {
		int emp = emplS.ajouterEmploye(new Employe("lakhdhar", "rafaa", "rafaa.lakhdhar@esprit.tn", true, Role.CHEF_DEPARTEMENT));
		assertEquals("rafaa", emplS.getEmployePrenomById(emp));
		l.info("get emploue prenom");
		
	}
	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name= joinPoint.getSignature().getName();
		String msg="Out of method : " +name;
		l.info(msg);
	}
	
	@Around("execution(* tn.esprit.spring.service.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	if (elapsedTime > 3000) {
		l.fatal("This process takes more than 3sec to execute");
	}
	
	String msg="Method execution time: " + elapsedTime + " milliseconds.";
	l.info(msg);
		return obj;
	}
	
}
