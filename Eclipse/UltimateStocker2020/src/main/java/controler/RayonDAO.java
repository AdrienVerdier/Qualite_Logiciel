package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.ChefRayon;
import model.Produit;
import model.Rayon;

public class RayonDAO {
	/**
	 * Cette m�thode ajoute un rayon � la base de donn�es
	 * 
	 * @param Rayon le rayon que l'on veut ajouter
	 */
	public static void ajouterRayon(Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(Rayon);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode ajoute un chef de rayon � un rayon
	 * 
	 * @param Rayon     le rayon auquel on veut ajouter le chef de rayon
	 * @param ChefRayon le chef de rayon que l'on veut ajouter
	 */
	public static void ajouterRayonChefRayon(Rayon Rayon, ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		List<ChefRayon> listChefRayon;
		listChefRayon = Rayon.getListChefRayon();
		if (listChefRayon == null) {
			listChefRayon = new ArrayList<ChefRayon>();
		}
		listChefRayon.add(ChefRayon);
		Rayon.setListChefRayon(listChefRayon);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode ajoute un produit � un rayon
	 * 
	 * @param Rayon   le rayon auquel on veut ajouter le produit
	 * @param Produit le produit que l'on veut ajouter
	 */
	public static void ajouterRayonProduit(Rayon Rayon, Produit Produit) {
		Connexion.getEM().getTransaction().begin();
		List<Produit> listProduit;
		listProduit = Rayon.getListProduit();
		if (listProduit == null) {
			listProduit = new ArrayList<Produit>();
		}
		listProduit.add(Produit);
		Rayon.setListProduit(listProduit);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode supprime un rayon dans la base de donn�es
	 * 
	 * @param Rayon le rayon que l'on veut supprimer
	 */
	public static void supprimerRayon(Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		Rayon Rayon2 = Connexion.getEM().find(Rayon.class, Rayon.getIDRayon());
		Connexion.getEM().remove(Rayon2);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode recherche un rayon dans la base de donn�es
	 * 
	 * @param IDRayon l'id du rayon que l'on recherche
	 * @return le rayon recherch�
	 */
	public static Rayon rechercheRayonById(int IDRayon) {
		Connexion.getEM().getTransaction().begin();
		Rayon Rayon = Connexion.getEM().find(Rayon.class, IDRayon);
		Connexion.getEM().getTransaction().commit();
		return Rayon;
	}

	/**
	 * Cette m�thode modifie un rayon, son nom
	 * 
	 * @param IDRayon l'id du rayon que l'on veut modifi�
	 * @param Rayon   un objet rayon qui contient les nouvelles donn�es du rayon que
	 *                l'on veut modifier
	 */
	public static void modifierRayon(int IDRayon, Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		Rayon NouveauRayon = Connexion.getEM().find(Rayon.class, IDRayon);
		NouveauRayon.setNom(Rayon.getNom());
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette m�thode renvoie une liste de tous les rayons de la base de donn�es
	 * 
	 * @return la liste des rayons
	 */
	public static ArrayList<Rayon> returnAllRayon() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<Rayon> resultat = new ArrayList<Rayon>();
		String queryString = "select c from Rayon c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			Rayon Rayon = (Rayon) results.get(i);
			resultat.add(Rayon);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};

	/**
	 * Cette m�thode renvoie le nouvel id du prochain rayon que l'on va ajouter � la
	 * base de donn�es
	 * 
	 * @return un int, l'id du nouveau rayon
	 */
	public static int returnMaxIDRayon() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select r from Rayon r";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 0;
		for (int i = 0; i < results.size(); i++) {
			Rayon Rayon = (Rayon) results.get(i);
			if (Rayon.getIDRayon() >= max) {
				max = Rayon.getIDRayon() + 1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};

}
