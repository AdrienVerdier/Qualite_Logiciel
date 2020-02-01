package testRunners;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import controler.ChefMagasinDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.ProduitDAO;
import controler.RayonDAO;
import controler.gestionUtilisateur;
import controler.gestionProduit;
import cucumber.api.PendingException;  
import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;  
import static org.junit.Assert.*;

public class TestRunner_GestionProduitUtilisateur {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connexion.test();
		ChefMagasin ChefMagasin1 = new ChefMagasin(1,"nom","prenom","password",null,null);
		Rayon Rayon1 = new Rayon(1,"Rayon1",null,null,ChefMagasin1);
		ChefRayon ChefRayon1 = new ChefRayon(1,"nom1","prenom1","password1",ChefMagasin1,Rayon1);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon1);
		RayonDAO.ajouterRayon(Rayon1);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon1);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon1);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin1);
		Rayon rayon1 = RayonDAO.rechercheRayonById(1);
		RayonDAO.supprimerRayon(rayon1);
		ChefRayon chefRayon1 = ChefRayonDAO.rechercheChefRayonById(1);
		ChefRayonDAO.supprimerChefRayon(chefRayon1);
	}
	
	@Given("un chef de rayon connecte a l'application pour le premier test de GestionProduitUtilisateur")
    public void un_chef_de_rayon_connecte_a_l_application_pour_le_premier_test() {

		int retour = gestionUtilisateur.authentification(1, "password1", false);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
	 
    @When("Il ajoute un produit a la base de donnee pour le premier test de GestionProduitUtilisateur")
    public void il_ajoute_un_produit_a_la_base_de_donnee() {

    	gestionProduit.ajouterProduit("vis", "vis crusciforme", 12, 123, 1);
    	assertEquals("Le produit n'a pas été ajouté", "vis", ProduitDAO.rechercheProduitById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Then("Le produit se trouve dans l'application pour le premier test de GestionProduitUtilisateur")
    public void le_produit_se_trouve_dans_l_application() {

    	assertEquals("Le produit n'a pas été ajouté", "vis", ProduitDAO.rechercheProduitById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Given("un chef de rayon connecte à l'application pour le second test de GestionProduitUtilisateur")
    public void un_chef_de_rayon_connecte_a_l_application_pour_le_second_test() {

		int retour = gestionUtilisateur.authentification(1, "password1", false);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
    
    @When("Il modifie les information d'un produit pour le second test de GestionProduitUtilisateur")
    public void il_modifie_les_information_d_un_produit() {
    	
    	gestionProduit.modifierProduit(1, "clou", "clou pointu", 7, 56, 1);
    	assertEquals("Le produit n'a pas été modifié", "clou", ProduitDAO.rechercheProduitById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Then("Le produit est modifie dans l'application pour le second test de GestionProduitUtilisateur")
    public void le_produit_est_modifie_dans_l_application() {

    	assertEquals("Le produit n'a pas été modifié", "clou", ProduitDAO.rechercheProduitById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Given("un chef de rayon connecte a l'application pour le troisieme test de GestionProduitUtilisateur")
    public void un_chef_de_rayon_connecte_a_l_application_pour_le_troisieme_test() {

		int retour = gestionUtilisateur.authentification(1, "password1", false);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
    
    @When("il supprime un produit pour le troisieme test de GestionProduitUtilisateur")
    public void il_supprime_un_produit() {
    	
    	gestionProduit.supprimerProduit(1);
    	assertEquals("Le produit n'a pas été effacé", null, ProduitDAO.rechercheProduitById(1));
    	
        throw new PendingException();
    }
    
    @Then("Le produit ne se trouve plus dans l'application pour le troisieme test de GestionProduitUtilisateur")
    public void le_produit_ne_se_trouve_plus_dans_l_application() {

    	assertEquals("Le produit n'a pas été effacé", null, ProduitDAO.rechercheProduitById(1));
    	
        throw new PendingException();
    }

}
