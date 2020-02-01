package controler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

/**
 * Cette classe représente l'ensemble des méthodes permettant la gestion des utilisateurs
 * @author Pierre Savary & Adrien Verdier
 *
 */
public class gestionUtilisateur {
	
	private gestionUtilisateur() {
		
	}

	/**
	 * Cette méthode permet d'ajouter un chef de rayon
	 * @param nom le nom du chef de rayon à ajouter
	 * @param prenom le prénom du chef de rayon à ajouter
	 * @param motDePasse mot de passe du chef de rayon à ajouter
	 * @param IDChefMagasin identifiant du chef de magasin associé
	 * @param nomRayon le nom du rayon ou il travaille
	 */
	public static void ajouterChefRayon(String nom, String prenom, String motDePasse, int IDChefMagasin, String nomRayon) {		
		Iterator<Rayon> iter = RayonDAO.returnAllRayon().iterator();
		Rayon tmp;
		Rayon rayon = new Rayon();
		while(iter.hasNext()) {
			tmp = iter.next();
			if(tmp.getNom().equals(nomRayon)) {
				rayon = tmp;
			}
		}
		ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin);
		ChefRayon chefRayon = new ChefRayon(ChefRayonDAO.returnMaxIDChefRayon(), nom, prenom, motDePasse, chefMagasin, rayon);
		RayonDAO.ajouterRayonChefRayon(rayon, chefRayon);
		ChefRayonDAO.ajouterChefRayon(chefRayon);
	}
	
	/**
	 * Cette méthode permet de modifier un chef de rayon
	 * @param idChefRayon identifiant du chef de rayon à modifier
	 * @param nom nouveau nom du chef de rayon
	 * @param prenom nouveau prénom du chef de rayon
	 * @param motDePasse nouveau mot de passe du chef de rayon
	 * @param IDChefMagasin identifiant du chef de magasin
	 * @param nomRayon nom du rayon ou il travaille
	 */
	public static void modifierChefRayon(int idChefRayon, String nom, String prenom, String motDePasse, int IDChefMagasin, String nomRayon) {
		Iterator<Rayon> iter = RayonDAO.returnAllRayon().iterator();
		Rayon tmp;
		Rayon rayon = new Rayon();
		while(iter.hasNext()) {
			tmp = iter.next();
			if(tmp.getNom().equals(nomRayon)) {
				rayon = tmp;
			}
		}
		ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(idChefRayon);
		chefRayon.setIDChefMagasin(ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin));
		chefRayon.setIDRayon(rayon);
		chefRayon.setMotDePasse(motDePasse);
		chefRayon.setNom(nom);
		chefRayon.setPrenom(prenom);
		ChefRayonDAO.modifierChefRayon(idChefRayon, chefRayon);
	}
	
	public static int nombreChefRayon() {
		return getChefRayon().size();
	}
	
	public static void supprimerChefRayon(int IDChefRayon) {
		ChefRayonDAO.supprimerChefRayon(ChefRayonDAO.rechercheChefRayonById(IDChefRayon));
	}
	
	public static ArrayList<ChefRayon> getChefRayon(){
		return ChefRayonDAO.returnAllChefRayon();			
	}
	
	/**
	 * Cette méthode permet de changer le mot de passe de l'utilisateur
	 * @param IDChefRayon identifiant de l'utilisateur 
	 * @param isChefMagasin booleen présentant si c'est un chef de magasin ou non
	 * @param motDePasse nouveau mot de passe de l'utilisateur
	 */
	public static void changerMDP (int IDChefRayon, boolean isChefMagasin, String motDePasse) {
		if(isChefMagasin) {
			ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefRayon);
			chefMagasin.setMotDePasse(motDePasse);
			ChefMagasinDAO.modifierChefMagasin(IDChefRayon, chefMagasin);
		}
		else {
			ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(IDChefRayon);
			chefRayon.setMotDePasse(motDePasse);
			ChefRayonDAO.modifierChefRayon(IDChefRayon, chefRayon);
		}
	}
	
	/**
	 * Cette classe permet d'authentifier un utilisateur
	 * @param idUser identifiant de l'utilisateur
	 * @param password mot de passe de l'utilisateur
	 * @param isChefMagasin booleen qui précise si c'est un chef de magasin
	 * @return l'id si ok, -1 si pas bon
	 */
	public static int authentification (int idUser, String password, boolean isChefMagasin) {
		if(isChefMagasin) {
			ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(idUser);
			if(password.equals(chefMagasin.getMotDePasse())) {
				return idUser;
			}
		}
		else {
			ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(idUser);
			if(password.equals(chefRayon.getMotDePasse())) {
				return idUser;
			}
		}
		
		return -1;
	}
	
	public static int getRayonChefRayon(int idUser) {
		ChefRayon chefRayon = ChefRayonDAO.rechercheChefRayonById(idUser);
		return chefRayon.getIDRayon().getIDRayon();
	}
	
	public static ChefRayon getUtilisateur (int idUser) {
		return ChefRayonDAO.rechercheChefRayonById(idUser);
	}
}
