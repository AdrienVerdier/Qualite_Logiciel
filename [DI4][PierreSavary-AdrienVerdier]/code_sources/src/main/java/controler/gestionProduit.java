package controler;

import java.util.ArrayList;
import java.util.Iterator;

import model.Produit;
import model.Rayon;

/**
 * Cette classe repr�sente l'ensemble des m�thodes permettant la gestion des produits
 * @author Pierre Savary & Adrien Verdier
 *
 */
public class gestionProduit {
	
	private gestionProduit() {
		
	}
	
	/**
	 * Cette m�thode permet d'ajouter un produit
	 * @param nom Nom du produit � ajouter
	 * @param description description du produit
	 * @param prix prix du produit
	 * @param quantite quantit� de produit disponible
	 * @param codeRayon code du rayon ou se trouve le produit
	 * @return trus si tout est ok
	 */
	public static boolean ajouterProduit(String nom, String description, int prix, int quantite, int codeRayon) {
		if(RayonDAO.rechercheRayonById(codeRayon) != null) {
			Rayon rayon = RayonDAO.rechercheRayonById(codeRayon);
			Produit produit = new Produit(ProduitDAO.returnMaxIDProduit(), nom, prix, quantite, description, rayon);		
			RayonDAO.ajouterRayonProduit(rayon, produit);
			ProduitDAO.ajouterProduit(produit);
		}
		
		return true;
	}
	
	/**
	 * Cette m�thode permet de modifier les infos d'un produit
	 * @param idProduit identifiant du produit � modifier
	 * @param nom nouveau nom du produit
	 * @param description nouvel description du produit
	 * @param prix nouveau prix du produit
	 * @param quantite nouvel quantit� de produit
	 * @param codeRayon identifiant du rayon associ� au produit
	 */
	public static void modifierProduit(int idProduit, String nom, String description, int prix, int quantite, int codeRayon) {
		Produit produit = ProduitDAO.rechercheProduitById(idProduit);
		produit.setNom(nom);
		produit.setDescription(description);
		produit.setIDRayon(RayonDAO.rechercheRayonById(codeRayon));
		produit.setPrix(prix);
		produit.setQuantite(quantite);
		ProduitDAO.modifierProduit(idProduit, produit);
	}
	
	public static int nombreProduit(int codeRayon) {
		return getProduit(codeRayon).size();
	}
	
	public static void supprimerProduit(int codeProduit) {
		ProduitDAO.supprimerProduit(ProduitDAO.rechercheProduitById(codeProduit));
	}
	
	public static ArrayList<Produit> getProduit(){
		return ProduitDAO.returnAllProduit();		
	}
	
	/**
	 * Permet de r�cup�rer tous les produits associ� � un rayon
	 * @param codeRayon l'identifiant du rayon ou on cherche
	 * @return la liste des produits associ�s
	 */
	public static ArrayList<Produit> getProduit(int codeRayon){
		Iterator<Produit> iter = ProduitDAO.returnAllProduit().iterator();
		ArrayList<Produit> retour = new ArrayList<Produit>();
		
		while(iter.hasNext()) {
			Produit prod = iter.next();
			
			if(prod.getIDRayon().getIDRayon() == codeRayon) {
				retour.add(prod);
			}
		}
		
		return retour;
	}
	
	public static String getDescription(int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getDescription();
	}
	
	public static int getQuantite(int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getQuantite();
	}
	
	public static int getPrix(int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getPrix();
	}
	
	public static String getNom (int IDProduit) {
		Produit produit = ProduitDAO.rechercheProduitById(IDProduit);
		return produit.getNom();
	}

}
