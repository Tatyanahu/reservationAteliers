package com.cegepgg.demoreservationAteliers.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_commande")
	    private Long id;

	    // Relation avec la table 'clients'
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_client") // Cette colonne doit correspondre à la clé étrangère dans la table des commandes
	    private Client client;

	    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Creneau> creneaux;
	    
	    @Column(name = "date_commande")
	    @Temporal(TemporalType.TIMESTAMP) // Utilisez TemporalType.DATE si vous avez seulement besoin de la date sans l'heure
	    private Date dateCommande;
	    
	    private List<Long> selectedCreneaux;

	    public List<Long> getSelectedCreneaux() {
	        return selectedCreneaux;
	    }

	    public void setSelectedCreneaux(List<Long> selectedCreneaux) {
	        this.selectedCreneaux = selectedCreneaux;
	    }
	    

		public Commande() {
		}

		public List<Creneau> getCreneaux() {
			return creneaux;
		}

		public void setCreneaux(List<Creneau> creneaux) {
			this.creneaux = creneaux;
		}

		public Commande(Client client, Date dateCommande) {
			this.client = client;
			this.dateCommande = dateCommande;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

		public Date getDateCommande() {
			return dateCommande;
		}

		public void setDateCommande(Date dateCommande) {
			this.dateCommande = dateCommande;
		}
		
		
	    
	    

}
