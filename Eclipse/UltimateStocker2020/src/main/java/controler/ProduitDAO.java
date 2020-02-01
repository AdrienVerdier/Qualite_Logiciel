package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.Produit;

public class ProduitDAO {

	/**
	 * Cette méthode ajoute un produit à la base de données
	 * 
	 * @param ChefRayon le chef de rayon que l'on veut ajouter
	 */
	public static void ajouterProduit(Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(Produit);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode supprime un produit de la base de données
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
	 * Cette méthode recherche un produit dans la base de données
	 * 
	 * @param IDProduit l'id du produit que l'on recherche
	 * @return le produit recherché
	 */
	public static Produit rechercheProduitById(int IDProduit) {
		Connexion.getEM().getTransaction().begin();
		Produit Produit = Connexion.getEM().find(Produit.class, IDProduit);
		Connexion.getEM().getTransaction().commit();
		return Produit;
	}

	/**
	 * Cette méthode modifie un produit, sa description, son prix et sa quantité
	 * 
	 * @param IDProduit l'id du produit que l'on veut modifié
	 * @param Produit   un objet produit qui contient les nouvelles données du
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
	 * Cette méthode renvoie une liste de tous les produits de la base de données
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
	 * Cette méthode renvoie le nouvel id du prochain produit que l'on va ajouter à
	 * la base de données
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
