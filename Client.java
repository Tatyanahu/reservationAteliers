package com.cegepgg.demoreservationAteliers.models;

import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_client")
	    private Long id;
	  
	  @Column(nullable = false, length = 50)
	    private String nom;
	  
	  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Creneau> creneaux;
	  
	   @Column(nullable = false, unique = true, length = 100)
	    private String email;

	    @Column(name = "mot_de_passe", nullable = false, length = 255)
	    private String motDePasse;
	  
	  public String getEmail() {
			return email;
		}
	  
	  public Client() {}

		public Client(String nom, Set<Creneau> creneaux, String email, String motDePasse, Set<Commande> commandes) {
		super();
		this.nom = nom;
		this.creneaux = creneaux;
		this.email = email;
		this.motDePasse = motDePasse;
		this.commandes = commandes;
	}

		public Set<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(Set<Creneau> creneaux) {
		this.creneaux = creneaux;
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

		public Set<Commande> getCommandes() {
			return commandes;
		}

		public void setCommandes(Set<Commande> commandes) {
			this.commandes = commandes;
		}

		// Relation avec les commandes
	    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<Commande> commandes;

	public Long getId() {
		return id;
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
