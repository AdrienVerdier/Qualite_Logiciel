package testRunners;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import controler.ChefMagasinDAO;
import controler.Connexion;
import controler.RayonDAO;
import controler.gestionUtilisateur;
import controler.gestionRayon;
import cucumber.api.PendingException;  
import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import model.ChefMagasin;
import model.Rayon;

import static org.junit.Assert.*;

public class TestRunner_GestionRayonAdministrateur {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connexion.test();
		ChefMagasin ChefMagasin1 = new ChefMagasin(1,"nom","prenom","password",null,null);
		Rayon Rayon1 = new Rayon(1,"Rayon1",null,null,ChefMagasin1);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon1);
		RayonDAO.ajouterRayon(Rayon1);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin1);
		Rayon rayon1 = RayonDAO.rechercheRayonById(1);
		RayonDAO.supprimerRayon(rayon1);
	}
	
	@Given("un chef de magasin connecte a l'application pour le premier test de GestionRayonAdministrateur")
    public void un_chef_de_magasin_connecte_a_l_application_pour_le_premier_test() {
        
		int retour = gestionUtilisateur.authentification(1, "password", true);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
	 
    @When("Il ajoute un rayon a la base de donnee pour le premier test de GestionRayonAdministrateur")
    public void il_ajoute_un_rayon_a_la_base_de_donnee() {

    	gestionRayon.ajouterRayon("scie", 1);
    	assertEquals("Le rayon ne s'est pas ajouté", "scie", RayonDAO.rechercheRayonById(2).getNom());
    	
        throw new PendingException();
    }
    
    @Then("Le rayon se trouve dans l'application pour le premier test de GestionRayonAdministrateur")
    public void le_rayon_se_trouve_dans_l_application() {

    	assertEquals("Le rayon ne s'est pas ajouté", "scie", RayonDAO.rechercheRayonById(2).getNom());
    	
        throw new PendingException();
    }
    
    @Given("un chef de magasin connecte à l'application pour le second test de GestionRayonAdministrateur")
    public void un_chef_de_magasin_connecte_a_l_application_pour_le_second_test() {
        
		int retour = gestionUtilisateur.authentification(1, "password", true);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
    
    @When("Il modifie les information d'un rayon pour le second test de GestionRayonAdministrateur")
    public void il_modifie_les_information_d_un_rayon() {
        
    	gestionRayon.modifierRayon(1, "hache");
    	assertEquals("Le rayon n'est pas modifié", "hache", RayonDAO.rechercheRayonById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Then("Le rayon est modifie dans l'application pour le second test de GestionRayonAdministrateur")
    public void le_rayon_est_modifie_dans_l_application() {

    	assertEquals("Le rayon n'est pas modifié", "hache", RayonDAO.rechercheRayonById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Given("un chef de magasin connecte à l'application pour le troisieme test de GestionRayonAdministrateur")
    public void un_chef_de_magasin_connecte_a_l_application_pour_le_troisieme_test() {
        
		int retour = gestionUtilisateur.authentification(1, "password", true);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
    
    @When("il supprime un rayon pour le troisieme test de GestionRayonAdministrateur")
    public void il_supprime_un_rayon() {

    	gestionRayon.supprimerRayon(2);
    	assertEquals("le rayon n'est pas supprimé", null, RayonDAO.rechercheRayonById(2));
    	
        throw new PendingException();
    }
    
    @Then("Le rayon ne se trouve plus dans l'application pour le troisieme test de GestionRayonAdministrateur")
    public void le_rayon_ne_se_trouve_plus_dans_l_application() {

    	assertEquals("le rayon n'est pas supprimé", null, RayonDAO.rechercheRayonById(2));
    	
        throw new PendingException();
    }

}
