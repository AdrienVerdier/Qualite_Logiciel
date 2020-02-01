package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.Produit;

public class ProduitDAO {

	/**
	 * Cette m�thode ajoute un produit � la base de donn�es
	 * 
	 * @param ChefRayon le chef de rayon que l'on veut ajouter
	 */
	public static void ajouterProduit(Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(Produit);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode supprime un produit de la base de donn�es
	 * 
	 * @param Produit le produit que l'on veut supprimer
	 */
	public static void supprimerProduit(Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Produit Produit2 = Connexion.getEM().find(Produit.class, Produit.getIDProduit());
		Connexion.getEM().remove(Produit2);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode recherche un produit dans la base de donn�es
	 * 
	 * @param IDProduit l'id du produit que l'on recherche
	 * @return le produit recherch�
	 */
	public static Produit rechercheProduitById(int IDProduit) {
		Connexion.getEM().getTransaction().begin();
		Produit Produit = Connexion.getEM().find(Produit.class, IDProduit);
		Connexion.getEM().getTransaction().commit();
		return Produit;
	}

	/**
	 * Cette m�thode modifie un produit, sa description, son prix et sa quantit�
	 * 
	 * @param IDProduit l'id du produit que l'on veut modifi�
	 * @param Produit   un objet produit qui contient les nouvelles donn�es du
	 *                  produit que l'on veut modifier
	 */
	public static void modifierProduit(int IDProduit, Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Produit NouveauProduit = Connexion.getEM().find(Produit.class, IDProduit);
		NouveauProduit.setNom(Produit.getNom());
		NouveauProduit.setDescription(Produit.getDescription());
		NouveauProduit.setPrix(Produit.getPrix());
		NouveauProduit.setQuantite(Produit.getQuantite());
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode renvoie une liste de tous les produits de la base de donn�es
	 * 
	 * @return la liste des produits
	 */
	public static ArrayList<Produit> returnAllProduit() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<Produit> resultat = new ArrayList<Produit>();
		String queryString = "select c from Produit c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			Produit Produit = (Produit) results.get(i);
			resultat.add(Produit);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};

	/**
	 * Cette m�thode renvoie le nouvel id du prochain produit que l'on va ajouter �
	 * la base de donn�es
	 * 
	 * @return un int, l'id du nouveau produit
	 */
	public static int returnMaxIDProduit() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select p from Produit p";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 1;
		for (int i = 0; i < results.size(); i++) {
			Produit Produit = (Produit) results.get(i);
			if (Produit.getIDProduit() >= max) {
				max = Produit.getIDProduit() + 1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};
}
