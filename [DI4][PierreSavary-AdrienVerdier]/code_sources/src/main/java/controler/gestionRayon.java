package controler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;

import model.Rayon;
import model.ChefMagasin;
import model.ChefRayon;

/**
 * Cette classe repr�sente l'ensemble des m�thodes permettant la gestion des rayons
 * @author Pierre Savary & Adrien Verdier
 *
 */
public class gestionRayon {
	
	private gestionRayon() {
		
	}
	
	/**
	 * Cette m�thode permet d'ajouter un rayon
	 * @param nom nom du rayon
	 * @param IDChefMagasin identifiant du chef de magasin associ�
	 */
	public static void ajouterRayon(String nom, int IDChefMagasin) {		
		ChefMagasin chefMagasin = ChefMagasinDAO.rechercheChefMagasinById(IDChefMagasin);
		Rayon rayon = new Rayon(RayonDAO.returnMaxIDRayon(), nom, null, null, chefMagasin);
		ChefMagasinDAO.ajouterChefMagasinRayon(chefMagasin, rayon);
		RayonDAO.ajouterRayon(rayon);
	}
	
	/**
	 * Cette m�thode permet de modifier un rayon
	 * @param idRayon identifiant du rayon � modifier
	 * @param nouveauNom nouveau nom du rayon
	 */
	public static void modifierRayon(int idRayon, String nouveauNom) {
		Rayon rayon = RayonDAO.rechercheRayonById(idRayon);
		rayon.setNom(nouveauNom);
		RayonDAO.modifierRayon(idRayon, rayon);
	}
	
	public static int nombreRayon(int IDChefRayon, boolean isChefMagasin) {
		if(isChefMagasin) {
			return getRayon().size();
		}
		else {
			return getRayon(IDChefRayon).size();
		}
	}
	
	public static int nombreRayon() {
		return getRayon().size();
	}
	
	public static void supprimerRayon(int codeRayon) {
		RayonDAO.supprimerRayon(RayonDAO.rechercheRayonById(codeRayon));
	}
	
	public static ArrayList<Rayon> getRayon(){
		return RayonDAO.returnAllRayon();			
	}
	
	/**
	 * Cette m�thode permet de r�cup�rer la liste des rayon associ� � un chef de rayon
	 * @param IDChefRayon identifiant du chef de rayon
	 * @return la liste des rayons
	 */
	public static ArrayList<Rayon> getRayon(int IDChefRayon){
		Iterator<Rayon> iter = RayonDAO.returnAllRayon().iterator();
		ArrayList<Rayon> retour = new ArrayList<Rayon>();
		
		while(iter.hasNext()) {
			Rayon rayon = iter.next();
			
			if(rayon.getListChefRayon().contains(ChefRayonDAO.rechercheChefRayonById(IDChefRayon))) {
				retour.add(rayon);
			}
		}
		
		return retour;
	}
	
	/**
	 * Cette m�thode permet de remplis une liste d�roulante avec les rayons
	 * @param dropDownList la liste � remplir
	 * @return la liste rempli
	 */
	public static JComboBox<String> RemplirListeRayon (JComboBox<String> dropDownList){
		Iterator<Rayon> rayon = RayonDAO.returnAllRayon().iterator();
		Rayon tmp;
		
		while(rayon.hasNext()){
			tmp = rayon.next();
			
			dropDownList.addItem(tmp.getNom());
		}
		
		return dropDownList;
	}

}
