package com.cegepgg.demoreservationAteliers.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "creneaux")
public class Creneau {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_creneau")
	    private Long id;
	  
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_atelier", nullable = false)
	    private List<Atelier> ateliers;
	    
	 

	


	

		 public Commande getCommande() {
			return commande;
		}



		public void setCommande(Commande commande) {
			this.commande = commande;
		}

		@ManyToOne(fetch = FetchType.LAZY)
		    @JoinColumn(name = "id_commande") // Cette colonne doit correspondre à la clé étrangère dans la table des commandes
		    private Commande commande;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_client") // Cette colonne doit correspondre à la clé étrangère dans la table des commandes
	    private Client client;
	    
	    @Column(name = "start_time", nullable = false)
	    private String startTime;

	    @Column(name = "end_time", nullable = false)
	    private String endTime;
	    
	    public Creneau(List<Atelier> ateliers, Commande commande, Client client, String startTime, String endTime,
				boolean available) {
			super();
			this.ateliers = ateliers;
			this.commande = commande;
			this.client = client;
			this.startTime = startTime;
			this.endTime = endTime;
			this.available = available;
		}



		public Creneau(List<Atelier> ateliers, Client client,
				String startTime, String endTime, boolean available) {
			this.ateliers = ateliers;
			this.client = client;
			this.startTime = startTime;
			this.endTime = endTime;
			this.available = available;
		}



		public Client getClient() {
			return client;
		}



		public void setClient(Client client) {
			this.client = client;
		}

		@Column(name = "available", nullable = false)
	    private boolean available;
	    
	    public Creneau() {}



		public boolean isAvailable() {
			return available;
		}







		public void setAvailable(boolean available) {
			this.available = available;
		}







		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}


		public List<Atelier> getAteliers() {
			return ateliers;
		}



		public void setAteliers(List<Atelier> ateliers) {
			this.ateliers = ateliers;
		}



		public String getStartTime() {
			return startTime;
		}

		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}

		public String getEndTime() {
			return endTime;
		}

		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
	    
}
