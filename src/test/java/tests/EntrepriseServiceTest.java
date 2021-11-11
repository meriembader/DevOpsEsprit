package tests;
/*
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;

@SpringBootTest
public class EntrepriseServiceTest {

	EntrepriseServiceImpl entrService;

	@Test
	@Rollback(value = false)
	public void saveEmployeeTest() {

		Entreprise entreprise = new Entreprise("1", "entreprise 1");

		Entreprise savedentreprise = entrService.ajouterEntreprise(entreprise);

		assertThat(savedentreprise.getId()).isGreaterThan(0);

	}

	@Test
	@Rollback(value = false)
	public void updateEntrepriseTest() {

		Entreprise entreprise = entrService.getEntrepriseById(1);

		entreprise.setName("esprit");

		Entreprise entrepriseUpdated = entrService.ajouterEntreprise(entreprise);

		assertThat(entrepriseUpdated.getName()).isEqualTo("esprit");
	}

	@Test
	@Rollback(value = false)
	public void deleteEntrepriseTest() {

		Entreprise entreprise = entrService.getEntrepriseById(1);

		entrService.deleteEntrepriseById(entreprise.getId());

		Entreprise entreprise1 = null;

		Optional<Entreprise> optionalentreprise = entrService.getEntrepriseByName("esprit");

		if (optionalentreprise.isPresent()) {
			entreprise1 = optionalentreprise.get();
		}

		assertThat(entreprise1).isNull();
	}

}
*/