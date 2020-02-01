package model;

import javax.persistence.*;

/**
 * Cette classe représente un produit
 * @author Pierre Savary & Adrien Verdier
 *
 */
@Entity
public class Produit {
	@Id
	private int IDProduit;
	private String nom;
	private int Prix;
	private int Quantite;
	private String Description;
	@ManyToOne(fetch = FetchType.LAZY)
	private Rayon IDRayon;

	public int getIDProduit() {
		return IDProduit;
	}

	public void setIDProduit(int iDProduit) {
		IDProduit = iDProduit;
	}

	public int getPrix() {
		return Prix;
	}

	public void setPrix(int prix) {
		Prix = prix;
	}

	public int getQuantite() {
		return Quantite;
	}

	public void setQuantite(int quantite) {
		Quantite = quantite;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Rayon getIDRayon() {
		return IDRayon;
	}

	public void setIDRayon(Rayon iDRayon) {
		IDRayon = iDRayon;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Produit(int iDProduit, String nom, int prix, int quantite, String description, Rayon iDRayon) {
		super();
		IDProduit = iDProduit;
		this.nom = nom;
		Prix = prix;
		Quantite = quantite;
		Description = description;
		IDRayon = iDRayon;
	}

	public Produit() {
		super();
	}
}
