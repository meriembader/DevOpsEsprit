package tn.esprit.spring.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Employes {

	
	private String prenom;
	
	private String nom;

	//@Column(unique=true)
		private String email;

		private boolean isActif;
		@Enumerated(EnumType.STRING)
		//@NotNull
		private Role role;
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return isActif;
	}

	public void setActif(boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
