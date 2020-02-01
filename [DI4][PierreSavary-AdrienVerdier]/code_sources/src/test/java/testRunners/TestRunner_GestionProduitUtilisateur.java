package testRunners;

import static org.junit.Assert.assertEquals;

import controler.ChefMagasinDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.ProduitDAO;
import controler.RayonDAO;
import controler.gestionProduit;
import controler.gestionUtilisateur;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.ChefMagasin;
import model.ChefRayon;
import model.Produit;
import model.Rayon;

public class TestRunner_GestionProduitUtilisateur {

	@Before
	public void setUp() {
		Connexion.test();
		ChefMagasin ChefMagasin1 = new ChefMagasin(1, "nom", "prenom", "password", null, null);
		Rayon Rayon1 = new Rayon(1, "Rayon1", null, null, ChefMagasin1);
		ChefRayon ChefRayon1 = new ChefRayon(1, "nom1", "prenom1", "password1", ChefMagasin1, Rayon1);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon1);
		RayonDAO.ajouterRayon(Rayon1);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon1);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon1);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
		Produit Produit1 = new Produit(1,"Produit1",10,10,"descriptionProduit1",Rayon1);
		RayonDAO.ajouterRayonProduit(Rayon1, Produit1);
		ProduitDAO.ajouterProduit(Produit1);
	}

	@Given("un chef de rayon connecte a l'application pour le premier test de GestionProduitUtilisateur")
	public void un_chef_de_rayon_connecte_a_l_application_pour_le_premier_test() {

		int retour = gestionUtilisateur.authentification(1, "password1", false);
		assertEquals("L'utilisateur n'est pas identifi�", retour, 1);

		
	}

	@When("Il ajoute un produit a la base de donnee pour le premier test de GestionProduitUtilisateur")
	public void il_ajoute_un_produit_a_la_base_de_donnee() {

		gestionProduit.ajouterProduit("vis", "vis crusciforme", 12, 123, 1);
		assertEquals("Le produit n'a pas �t� ajout�", "vis", ProduitDAO.rechercheProduitById(2).getNom());

		
	}

	@Then("Le produit se trouve dans l'application pour le premier test de GestionProduitUtilisateur")
	public void le_produit_se_trouve_dans_l_application() {

		assertEquals("Le produit n'a pas �t� ajout�", "vis", ProduitDAO.rechercheProduitById(2).getNom());

		
	}

	@Given("un chef de rayon connecte a l'application pour le second test de GestionProduitUtilisateur")
	public void un_chef_de_rayon_connecte_a_l_application_pour_le_second_test() {

		int retour = gestionUtilisateur.authentification(1, "password1", false);
		assertEquals("L'utilisateur n'est pas identifi�", retour, 1);

		
	}

	@When("Il modifie les information d'un produit pour le second test de GestionProduitUtilisateur")
	public void il_modifie_les_information_d_un_produit() {

		gestionProduit.modifierProduit(1, "clou", "clou pointu", 7, 56, 1);
		assertEquals("Le produit n'a pas �t� modifi�", "clou", ProduitDAO.rechercheProduitById(1).getNom());

		
	}

	@Then("Le produit est modifie dans l'application pour le second test de GestionProduitUtilisateur")
	public void le_produit_est_modifie_dans_l_application() {

		assertEquals("Le produit n'a pas �t� modifi�", "clou", ProduitDAO.rechercheProduitById(1).getNom());

		
	}

}
