package com.cegepgg.demoreservationAteliers.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "artisans")
public class Artisan {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_client")
	    private Long id;
	  
	  @Column(nullable = false, length = 50)
	    private String nom;
	  
	   @Column(nullable = false, unique = true, length = 100)
	    private String email;

	    @Column(name = "mot_de_passe", nullable = false, length = 255)
	    private String motDePasse;

	  @OneToOne(mappedBy = "artisan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Atelier atelier;
	  
	  
	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}



	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	  

}
