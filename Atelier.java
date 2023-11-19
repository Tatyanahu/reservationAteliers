package com.cegepgg.demoreservationAteliers.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ateliers")
public class Atelier {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_atelier")
	    private Integer id;
	  
	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_artisan")
	    private Artisan artisan;
	    
	    @Column(nullable = false, length = 255)
	    private String nom;

	    @Column(columnDefinition = "TEXT")
	    private String description;

	    
	    @ManyToMany(mappedBy = "ateliers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Creneau> creneaux;

	    
	    
		public Atelier(Artisan artisan, String nom, String description, List<Creneau> creneaux) {
			this.artisan = artisan;
			this.nom = nom;
			this.description = description;
			this.creneaux = creneaux;
		}


		public Atelier() {}

	
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Artisan getArtisan() {
			return artisan;
		}

		public void setArtisan(Artisan artisan) {
			this.artisan = artisan;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	
	    
	    
}
