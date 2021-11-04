package tests;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.EntrepriseServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class EntrepriseServiceTest {

	@Mock
	EntrepriseRepository entrepriseRepoistory=Mockito.mock(EntrepriseRepository.class);
	@InjectMocks
	private EntrepriseServiceImpl entrService;
	private static final Logger l =
	LogManager.getLogger(EntrepriseServiceTest.class);
	
    MockMvc mockMvc;
	
	@Test
	public void saveEntreprise(){
      Entreprise entreprise=new Entreprise();
	  entreprise.setName("e1");
	  entreprise.setId(1);
	  when(entrService.ajouterEntreprise(entreprise)).thenReturn(new Entreprise());	
	  Entreprise created=entrService.ajouterEntreprise(entreprise);
  assertThat(created.getId()).isGreaterThan(0);
  l.info("entreprise : "+ created);

	}
	
	@Test 
	public void updateEntreprise(){
		List<Entreprise> list = new ArrayList<Entreprise>();
        Entreprise entOne = new Entreprise(1, "ent1");
        Entreprise entTwo = new Entreprise(2, "ent2");
        Entreprise entThree = new Entreprise(3, "ent2");
         
        list.add(entOne);
        list.add(entTwo);
        list.add(entThree);
         
        when(entrepriseRepoistory.findAll()).thenReturn(list);
         
        //test
        Iterable<Entreprise> entlist = entrepriseRepoistory.findAll();
        assertThat(entlist).isNotEmpty();
        
	}
	/*
	@Test
    public void getEntrepriseByIdTest()
    {
		Entreprise entreprise=new Entreprise();
	  entreprise.setName("e1");
	  entreprise.setId(1);
	  when(entrService.getEntrepriseById(entreprise.getId())).thenReturn(new Entreprise(1,"e1"));
         
        Entreprise ent = entrService.getEntrepriseById(entreprise.getId());
         
        assertThat(ent).isNotNull();
        
    }
	*/


	
}
