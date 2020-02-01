package testDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.*;

import controler.ChefMagasinDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.RayonDAO;
import model.*;

public class TestChefMagasinDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connexion.test();
	}

	@Before
	public void setUp() throws Exception {
		ChefMagasin ChefMagasin1 = new ChefMagasin(1, "nom", "prenom", "password", null, null);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);
	}

	@After
	public void tearDown() throws Exception {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin1);
	}

	@Test
	public void test_ajouterChefMagasin_et_rechercheChefMagasinById_et_supprimerChefMagasin() {
		ChefMagasin ChefMagasin2 = new ChefMagasin(2, "nom", "prenom", "password", null, null);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin2);
		ChefMagasin ChefMagasin3 = ChefMagasinDAO.rechercheChefMagasinById(2);
		assertEquals("ChefMagasin2 et 3 n'ont pas le même id", ChefMagasin2.getIDChefMagasin(),
				ChefMagasin2.getIDChefMagasin());
		assertEquals("ChefMagasin2 et 3 n'ont pas le même nom", ChefMagasin2.getNom(), ChefMagasin3.getNom());
		assertEquals("ChefMagasin2 et 3 n'ont pas le même prenom", ChefMagasin2.getPrenom(), ChefMagasin3.getPrenom());
		assertEquals("ChefMagasin2 et 3 n'ont pas le même password", ChefMagasin2.getMotDePasse(),
				ChefMagasin3.getMotDePasse());
		assertEquals("ChefMagasin2 et 3 n'ont pas la même liste de rayon", ChefMagasin2.getListRayon(),
				ChefMagasin3.getListRayon());
		assertEquals("ChefMagasin2 et 3 n'ont pas la même liste de chef de rayon", ChefMagasin2.getListChefRayon(),
				ChefMagasin3.getListChefRayon());
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin3);
		ChefMagasin ChefMagasin4 = ChefMagasinDAO.rechercheChefMagasinById(2);
		assertEquals("Le chef magasin n'a pas été supprimé",ChefMagasin4,null);
	}

	@Test
	public void test_ajouterChefMagasinRayon() {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		Rayon Rayon1 = new Rayon(1, "Rayon1", null, null, ChefMagasin1);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon1);
		RayonDAO.ajouterRayon(Rayon1);
		assertEquals("Rayon1 et le rayon du chef magasin n'ont pas le même id", ChefMagasin1.getListRayon().get(0).getIDRayon(),
				Rayon1.getIDRayon());
		assertEquals("Rayon1 et le rayon du chef magasin n'ont pas le même nom",  ChefMagasin1.getListRayon().get(0).getNom(), Rayon1.getNom());
		assertEquals("Rayon1 et le rayon du chef magasin n'ont pas la même liste de produit",  ChefMagasin1.getListRayon().get(0).getListProduit(),
				Rayon1.getListProduit());
		assertEquals("Rayon1 et le rayon du chef magasin n'ont pas la même liste de chef de rayon",  ChefMagasin1.getListRayon().get(0).getListChefRayon(),
				Rayon1.getListChefRayon());
		assertEquals("Rayon1 et le rayon du chef magasin n'ont pas le même chef de magasin",  ChefMagasin1.getListRayon().get(0).getIDChefMagasin(),
				Rayon1.getIDChefMagasin());
		RayonDAO.supprimerRayon(Rayon1);
	}

	@Test
	public void test_ajouterChefMagasinChefRayon() {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);
		ChefRayon ChefRayon1 = new ChefRayon(1, "nom1", "prenom1", "password1", ChefMagasin1, null);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon1);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
		assertEquals("Les 2 ChefRayons ne sont pas égaux", ChefMagasin1.getListChefRayon().get(0), ChefRayon1);
		ChefRayonDAO.supprimerChefRayon(ChefRayon1);
	}

	@Test
	public void test_modifierChefMagasin() {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ChefMagasin ChefMagasin2 = new ChefMagasin(1, "Verdier", "Adrien", "newpassword", null, null);
		ChefMagasinDAO.modifierChefMagasin(1, ChefMagasin2);
		assertEquals("ChefMagasin1 et 2 n'ont pas le même nom", ChefMagasin1.getNom(), ChefMagasin2.getNom());
		assertEquals("ChefMagasin1 et 2 n'ont pas le même prenom", ChefMagasin1.getPrenom(), ChefMagasin2.getPrenom());
		assertEquals("ChefMagasin1 et 2 n'ont pas le même password", ChefMagasin1.getMotDePasse(),
				ChefMagasin2.getMotDePasse());
	}

	@Test
	public void test_returnAllChefMagasin() {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ArrayList<ChefMagasin> ListChefMagasin = ChefMagasinDAO.returnAllChefMagasin();
		assertEquals("La liste n'a pas la bonne taille",1, ListChefMagasin.size());
		assertEquals("ChefMagasin1 et le chef magasin de la liste n'ont pas le même nom", ChefMagasin1.getNom(), ListChefMagasin.get(0).getNom());
		assertEquals("ChefMagasin1 et le chef magasin de la liste n'ont pas le même prenom", ChefMagasin1.getPrenom(), ListChefMagasin.get(0).getPrenom());
		assertEquals("ChefMagasin1 et le chef magasin de la liste n'ont pas le même password", ChefMagasin1.getMotDePasse(),
				ListChefMagasin.get(0).getMotDePasse());
		
		ChefMagasin ChefMagasin2 = new ChefMagasin(2, "nom", "prenom", "password", null, null);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin2);
		ListChefMagasin = ChefMagasinDAO.returnAllChefMagasin();
		assertEquals("La liste n'a pas la bonne taille",2, ListChefMagasin.size());

		ChefMagasin ChefMagasin3 = new ChefMagasin(3, "nom", "prenom", "password", null, null);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin3);
		ListChefMagasin = ChefMagasinDAO.returnAllChefMagasin();
		assertEquals("La liste n'a pas la bonne taille",3, ListChefMagasin.size());
		
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin2);
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin3);
	}

	@Test
	public void test_returnMaxIDChefMagasin() {
		int MaxIDChefMagasin = ChefMagasinDAO.returnMaxIDChefMagasin();
		assertEquals("L'id renvoyé n'est pas bon",2,MaxIDChefMagasin);
		
		ChefMagasin ChefMagasin2 = new ChefMagasin(2, "nom", "prenom", "password", null, null);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin2);
		MaxIDChefMagasin = ChefMagasinDAO.returnMaxIDChefMagasin();
		assertEquals("L'id renvoyé n'est pas bon",3,MaxIDChefMagasin);

		ChefMagasin ChefMagasin3 = new ChefMagasin(3, "nom", "prenom", "password", null, null);
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin3);
		MaxIDChefMagasin = ChefMagasinDAO.returnMaxIDChefMagasin();
		assertEquals("L'id renvoyé n'est pas bon",4,MaxIDChefMagasin);
		
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin2);
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin3);
	}
}
