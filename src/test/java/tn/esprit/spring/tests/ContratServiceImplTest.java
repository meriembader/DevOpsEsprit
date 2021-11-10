package tn.esprit.spring.tests;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
    @Autowired
	public EntrepriseServiceImpl entrepriseServiceImpl;
	
	@Autowired
	public IEmployeService Emps;

    private static final Logger l= LogManager.getLogger(ContratServiceImplTest.class);

	@SuppressWarnings("squid:S2699")
    @Test
	public void testAddContrat(){
        
        Date current = new Date();
        l.info(" Create the Current Date");
        Employe emp = new Employe("CHRAIEF", "Nihel", "nihel.chraief@esprit.tn", true, Role.INGENIEUR);
        Contrat contrat= new Contrat(current,"travail Administratif",1000);
        l.info("Contrat ajouté");
        Emps.ajouterEmploye(emp);
        l.info("Employe ajoutéé");
	
		entrepriseServiceImpl.ajouterContrat(contrat);
        Emps.affecterContratAEmploye(contrat.getReference(),emp.getId());
        l.info("Contrat affecté à employé");
	}

    @After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name= joinPoint.getSignature().getName();
		String msg="Out of method : " +name;
		l.info(msg);
	}
    
	
	@Before("execution(* tn.esprit.spring.service.*.*(..))")
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
