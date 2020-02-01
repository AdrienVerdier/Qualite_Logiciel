package controler;

import java.util.*;

import javax.persistence.Query;

import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

public class ChefMagasinDAO {
	/**
	 * Cette méthode ajoute un chef magasin à la base de données
	 * 
	 * @param ChefMagasin le chef magasin que l'on veut ajouter
	 */
	public static void ajouterChefMagasin(ChefMagasin ChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(ChefMagasin);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode ajoute un chef de rayon à un chef magasin
	 * 
	 * @param ChefMagasin le chef magasin auquel on veut ajouter le chef de rayon
	 * @param ChefRayon   le chef de rayon que l'on veut ajouter
	 */
	public static void ajouterChefMagasinChefRayon(ChefMagasin ChefMagasin, ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		List<ChefRayon> listChefRayon;
		listChefRayon = ChefMagasin.getListChefRayon();
		if (listChefRayon == null) {
			listChefRayon = new ArrayList<ChefRayon>();
		}
		listChefRayon.add(ChefRayon);
		ChefMagasin.setListChefRayon(listChefRayon);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode ajoute un rayon à un chef magasin
	 * 
	 * @param ChefMagasin le chef magasin auquel on veut ajouter le chef de rayon
	 * @param Rayon       le rayon que l'on veut ajouter
	 */
	public static void ajouterChefMagasinRayon(ChefMagasin ChefMagasin, Rayon Rayon) {
		Connexion.getEM().getTransaction().begin();
		List<Rayon> listRayon;
		listRayon = ChefMagasin.getListRayon();
		if (listRayon == null) {
			listRayon = new ArrayList<Rayon>();
		}
		listRayon.add(Rayon);
		ChefMagasin.setListRayon(listRayon);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode supprime un chef magasin de la base de données
	 * 
	 * @param ChefMagasin le chef magasin que l'on veut supprimer
	 */
	public static void supprimerChefMagasin(ChefMagasin ChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		ChefMagasin ChefMagasin2 = Connexion.getEM().find(ChefMagasin.class, ChefMagasin.getIDChefMagasin());
		Connexion.getEM().remove(ChefMagasin2);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode recherche un chef magasin dans la base de données
	 * 
	 * @param IDChefMagasin l'id du chef magasin que l'on recherche
	 * @return le chef de magasin recherché
	 */
	public static ChefMagasin rechercheChefMagasinById(int IDChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		ChefMagasin ChefMagasin = Connexion.getEM().find(ChefMagasin.class, IDChefMagasin);
		Connexion.getEM().getTransaction().commit();
		return ChefMagasin;
	}

	/**
	 * Cette méthode modifie un chef magasin, son nom, son prenom et son mot de
	 * passe
	 * 
	 * @param IDChefMagasin l'id du chef magasin que l'on veut modifié
	 * @param ChefMagasin   un objet chef magasin qui contient les nouvelles données
	 *                      du chef magasin que l'on veut modifier
	 */
	public static void modifierChefMagasin(int IDChefMagasin, ChefMagasin ChefMagasin) {
		Connexion.getEM().getTransaction().begin();
		ChefMagasin NouveauChefMagasin = Connexion.getEM().find(ChefMagasin.class, IDChefMagasin);
		NouveauChefMagasin.setMotDePasse(ChefMagasin.getMotDePasse());
		NouveauChefMagasin.setNom(ChefMagasin.getNom());
		NouveauChefMagasin.setPrenom(ChefMagasin.getPrenom());
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode renvoie une liste de tous les chefs magasins de la base de
	 * données
	 * 
	 * @return la liste de chefs magasins
	 */
	public static ArrayList<ChefMagasin> returnAllChefMagasin() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<ChefMagasin> resultat = new ArrayList<ChefMagasin>();
		String queryString = "select c from ChefMagasin c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			ChefMagasin ChefMagasin = (ChefMagasin) results.get(i);
			resultat.add(ChefMagasin);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};

	/**
	 * Cette méthode renvoie le nouvel id du prochain chef magasin que l'on va
	 * ajouter à la base de données
	 * 
	 * @return un int, l'id du nouveau chef magasin
	 */
	public static int returnMaxIDChefMagasin() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select c from ChefMagasin c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 1;
		for (int i = 0; i < results.size(); i++) {
			ChefMagasin ChefMagasin = (ChefMagasin) results.get(i);
			if (ChefMagasin.getIDChefMagasin() >= max) {
				max = ChefMagasin.getIDChefMagasin() + 1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};
}
