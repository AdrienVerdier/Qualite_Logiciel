package testRunners;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import controler.ChefMagasinDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.RayonDAO;
import controler.gestionUtilisateur;
import cucumber.api.PendingException;  
import cucumber.api.java.en.Given;  
import cucumber.api.java.en.Then;  
import cucumber.api.java.en.When;
import model.ChefMagasin;
import model.ChefRayon;
import model.Rayon;

import static org.junit.Assert.*;

public class TestRunner_GestionUtilisateur {
	
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
	
	@Given("un chef de magasin connecté à l'application")
    public void un_chef_de_magasin_connecte_a_l_application() {
        
		int retour = gestionUtilisateur.authentification(1, "password", true);
		assertEquals("L'utilisateur n'est pas identifié", retour,1);
		
        throw new PendingException();
    }
	 
    @When("Il ajoute un utilisateur à la base de donnée")
    public void il_ajoute_un_utilisateur_a_la_base_de_donnee() {
        
    	gestionUtilisateur.ajouterChefRayon("pierre", "savary", "oui", 1, "Rayon1");
    	assertEquals("L'utilisateur ne s'est pas ajouté", "pierre", ChefRayonDAO.rechercheChefRayonById(2).getNom());
    	
        throw new PendingException();
    }
    
    @Then("L'utilisateur se trouve dans l'application")
    public void l_utilisateur_se_trouve_dans_l_application() {

    	assertEquals("L'utilisateur ne s'est pas ajouté", "pierre", ChefRayonDAO.rechercheChefRayonById(2).getNom());
    	
        throw new PendingException();
    }
    
    @When("Il modifie les information d'un utilisateur")
    public void il_modifie_les_information_d_un_utilisateur() {
        
    	gestionUtilisateur.modifierChefRayon(1, "bidule", "prenom1", "password1", 1, "Rayon1");
    	assertEquals("L'utilisateur n'est pas modifié", "bidule", ChefRayonDAO.rechercheChefRayonById(1).getNom());
    	
        throw new PendingException();
    }
    
    @Then("L'utilisateur est modifié dans l'application")
    public void l_utilisateur_est_modifie_dans_l_application() {

    	assertEquals("L'utilisateur n'est pas modifié", "bidule", ChefRayonDAO.rechercheChefRayonById(1).getNom());
    	
        throw new PendingException();
    }
    
    @When("il supprime un utilisateur")
    public void il_supprime_un_utilisateur() {

    	gestionUtilisateur.supprimerChefRayon(2);
    	assertEquals("L'utilisateur n'a pas été supprimé", null, ChefRayonDAO.rechercheChefRayonById(2));
    	
        throw new PendingException();
    }
    
    @Then("L'utilisateur ne se trouve plus dans l'application")
    public void l_utilisateur_ne_se_trouve_plus_dans_l_application() {

    	assertEquals("L'utilisateur n'a pas été supprimé", null, ChefRayonDAO.rechercheChefRayonById(2));
    	
        throw new PendingException();
    }

}
