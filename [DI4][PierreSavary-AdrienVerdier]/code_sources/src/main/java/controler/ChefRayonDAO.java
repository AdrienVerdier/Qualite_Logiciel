package controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import model.ChefRayon;

public class ChefRayonDAO {
	
	private ChefRayonDAO() {
		
	}

	/**
	 * Cette méthode ajoute un chef de rayon à la base de données
	 * 
	 * @param ChefRayon le chef de rayon que l'on veut ajouter
	 */
	public static void ajouterChefRayon(ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		Connexion.getEM().persist(ChefRayon);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode supprime un chef de rayon de la base de données
	 * 
	 * @param ChefRayon le chef de rayon que l'on veut supprimer
	 */
	public static void supprimerChefRayon(ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		ChefRayon ChefRayon2 = Connexion.getEM().find(ChefRayon.class, ChefRayon.getIDChefRayon());
		Connexion.getEM().remove(ChefRayon2);
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode recherche un chef de rayon dans la base de données
	 * 
	 * @param IDChefRayon l'id du chef de rayon que l'on recherche
	 * @return le chef de rayon recherché
	 */
	public static ChefRayon rechercheChefRayonById(int IDChefRayon) {
		Connexion.getEM().getTransaction().begin();
		ChefRayon ChefRayon = Connexion.getEM().find(ChefRayon.class, IDChefRayon);
		Connexion.getEM().getTransaction().commit();
		return ChefRayon;
	}

	/**
	 * Cette méthode modifie un chef de rayon, son nom, son prenom et son mot de
	 * passe
	 * 
	 * @param IDChefRayon l'id du chef de rayon que l'on veut modifié
	 * @param ChefRayon   un objet chef de rayon qui contient les nouvelles données
	 *                    du chef de rayon que l'on veut modifier
	 */
	public static void modifierChefRayon(int IDChefRayon, ChefRayon ChefRayon) {
		Connexion.getEM().getTransaction().begin();
		ChefRayon NouveauChefRayon = Connexion.getEM().find(ChefRayon.class, IDChefRayon);
		NouveauChefRayon.setMotDePasse(ChefRayon.getMotDePasse());
		NouveauChefRayon.setNom(ChefRayon.getNom());
		NouveauChefRayon.setPrenom(ChefRayon.getPrenom());
		Connexion.getEM().getTransaction().commit();
	}

	/**
	 * Cette méthode renvoie une liste de tous les chefs de rayon de la base de
	 * données
	 * 
	 * @return la liste des chefs de rayon
	 */
	public static ArrayList<ChefRayon> returnAllChefRayon() {
		Connexion.getEM().getTransaction().begin();
		ArrayList<ChefRayon> resultat = new ArrayList<ChefRayon>();
		String queryString = "select c from ChefRayon c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		for (int i = 0; i < results.size(); i++) {
			ChefRayon ChefRayon = (ChefRayon) results.get(i);
			resultat.add(ChefRayon);
		}
		Connexion.getEM().getTransaction().commit();
		return resultat;
	};

	/**
	 * Cette méthode renvoie le nouvel id du prochain chef de rayon que l'on va
	 * ajouter à la base de données
	 * 
	 * @return un int, l'id du nouveau chef de rayon
	 */
	public static int returnMaxIDChefRayon() {
		Connexion.getEM().getTransaction().begin();
		String queryString = "select c from ChefRayon c";
		Query query = Connexion.getEM().createQuery(queryString);
		List results = query.getResultList();
		int max = 1;
		for (int i = 0; i < results.size(); i++) {
			ChefRayon ChefRayon = (ChefRayon) results.get(i);
			if (ChefRayon.getIDChefRayon() >= max) {
				max = ChefRayon.getIDChefRayon() + 1;
			}
		}
		Connexion.getEM().getTransaction().commit();
		return max;
	};
}
