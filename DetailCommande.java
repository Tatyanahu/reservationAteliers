package com.cegepgg.demoreservationAteliers.models;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "details_commandes")
public class DetailCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_details_commande")
    private Integer idDetailCommande;

    // Clé étrangère vers la table Commandes
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commande")
    private Commande commande;

    // Clé étrangère vers la table Ateliers
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_atelier")
    private Atelier atelier;
    
    // Clé étrangère vers la table Ateliers
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_creneau")
    private List<Creneau> creneaux;

    
    
	public DetailCommande() {
	}

	public DetailCommande(Commande commande, Atelier atelier, List<Creneau> creneaux) {
		this.commande = commande;
		this.atelier = atelier;
		this.creneaux = creneaux;
	}

	public Integer getIdDetailCommande() {
		return idDetailCommande;
	}

	public void setIdDetailCommande(Integer idDetailCommande) {
		this.idDetailCommande = idDetailCommande;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Atelier getAtelier() {
		return atelier;
	}

	public void setAtelier(Atelier atelier) {
		this.atelier = atelier;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}


    
    

}
