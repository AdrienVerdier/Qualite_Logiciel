package testDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controler.ChefRayonDAO;
import controler.Connexion;
import model.ChefRayon;

public class TestChefRayonDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connexion.init();
	}

	@Before
	public void setUp() throws Exception {
		ChefRayon ChefRayon1 = new ChefRayon(1, "nom1", "prenom1", "password1", null, null);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
	}

	@After
	public void tearDown() throws Exception {
		ChefRayon ChefRayon1 = ChefRayonDAO.rechercheChefRayonById(1);
		ChefRayonDAO.supprimerChefRayon(ChefRayon1);
	}

	@Test
	public void test_ajouterChefRayon_et_rechercheChefRayonById_et_supprimerChefRayon() {
		ChefRayon ChefRayon2 = new ChefRayon(2, "nom2", "prenom2", "password2", null, null);
		ChefRayonDAO.ajouterChefRayon(ChefRayon2);
		ChefRayon ChefRayon3 = ChefRayonDAO.rechercheChefRayonById(2);
		assertEquals("ChefRayon2 et 3 n'ont pas le même id", ChefRayon2.getIDChefRayon(), ChefRayon3.getIDChefRayon());
		assertEquals("ChefRayon2 et 3 n'ont pas le même nom", ChefRayon2.getNom(), ChefRayon3.getNom());
		assertEquals("ChefRayon2 et 3 n'ont pas le même prenom", ChefRayon2.getPrenom(), ChefRayon3.getPrenom());
		assertEquals("ChefRayon2 et 3 n'ont pas le même mot de passe", ChefRayon2.getMotDePasse(), ChefRayon3.getMotDePasse());
		assertEquals("ChefRayon2 et 3 n'ont pas le même rayon", ChefRayon2.getIDRayon(), ChefRayon3.getIDRayon());
		assertEquals("ChefRayon2 et 3 n'ont pas le même chef de magasin", ChefRayon2.getIDChefMagasin(),
				ChefRayon3.getIDChefMagasin());
		ChefRayonDAO.supprimerChefRayon(ChefRayon2);
	}

	@Test
	public void test_modifierChefRayon() {
		ChefRayon ChefRayon1 = ChefRayonDAO.rechercheChefRayonById(1);
		ChefRayon ChefRayon2 = new ChefRayon(1, "nom2", "prenom2", "password2", null, null);
		ChefRayonDAO.modifierChefRayon(1, ChefRayon2);
		assertEquals("ChefRayon1 et 2 n'ont pas le même nom", ChefRayon1.getNom(), ChefRayon2.getNom());
		assertEquals("ChefRayon1 et 2 n'ont pas le même prenom", ChefRayon1.getPrenom(), ChefRayon2.getPrenom());
		assertEquals("ChefRayon1 et 2 n'ont pas le même mot de passe", ChefRayon1.getMotDePasse(), ChefRayon2.getMotDePasse());
	}

	@Test
	public void test_returnAllChefRayon() {
		ChefRayon ChefRayon1 = ChefRayonDAO.rechercheChefRayonById(1);
		ArrayList<ChefRayon> ListChefRayon = ChefRayonDAO.returnAllChefRayon();
		assertEquals("La liste n'a pas la bonne taille", 1, ListChefRayon.size());
		assertEquals("ChefRayon1 et le ChefRayon de la liste n'ont pas le même id", ChefRayon1.getIDChefRayon(),
				ListChefRayon.get(0).getIDChefRayon());
		assertEquals("ChefRayon1 et le ChefRayon de la liste  n'ont pas le même nom", ChefRayon1.getNom(),
				ListChefRayon.get(0).getNom());
		assertEquals("ChefRayon1 et le ChefRayon de la liste  n'ont pas le même prenom", ChefRayon1.getPrenom(),
				ListChefRayon.get(0).getPrenom());
		assertEquals("ChefRayon1 et le ChefRayon de la liste  n'ont pas le même mot de passe", ChefRayon1.getMotDePasse(),
				ListChefRayon.get(0).getMotDePasse());
		assertEquals("ChefRayon1 et le ChefRayon de la liste  n'ont pas le même rayon", ChefRayon1.getIDRayon(),
				ListChefRayon.get(0).getIDRayon());
		assertEquals("ChefRayon1 et le ChefRayon de la liste  n'ont pas le même chef de magasin",
				ChefRayon1.getIDChefMagasin(), ListChefRayon.get(0).getIDChefMagasin());

		ChefRayon ChefRayon2 = new ChefRayon(2, "nom2", "prenom2", "password2", null, null);
		ChefRayonDAO.ajouterChefRayon(ChefRayon2);
		ListChefRayon = ChefRayonDAO.returnAllChefRayon();
		assertEquals("La liste n'a pas la bonne taille", 2, ListChefRayon.size());

		ChefRayon ChefRayon3 = new ChefRayon(3, "nom3", "prenom3", "password3", null, null);
		ChefRayonDAO.ajouterChefRayon(ChefRayon3);
		ListChefRayon = ChefRayonDAO.returnAllChefRayon();
		assertEquals("La liste n'a pas la bonne taille", 3, ListChefRayon.size());

		ChefRayonDAO.supprimerChefRayon(ChefRayon2);
		ChefRayonDAO.supprimerChefRayon(ChefRayon3);
	}

	@Test
	public void test_returnMaxIDChefRayon() {
		int MaxIDChefRayon = ChefRayonDAO.returnMaxIDChefRayon();
		assertEquals("L'id renvoyé n'est pas bon", 2, MaxIDChefRayon);

		ChefRayon ChefRayon2 = new ChefRayon(2, "nom2", "prenom2", "password2", null, null);
		ChefRayonDAO.ajouterChefRayon(ChefRayon2);
		MaxIDChefRayon = ChefRayonDAO.returnMaxIDChefRayon();
		assertEquals("L'id renvoyé n'est pas bon", 3, MaxIDChefRayon);

		ChefRayon ChefRayon3 = new ChefRayon(3, "nom3", "prenom3", "password3", null, null);
		ChefRayonDAO.ajouterChefRayon(ChefRayon3);
		MaxIDChefRayon = ChefRayonDAO.returnMaxIDChefRayon();
		assertEquals("L'id renvoyé n'est pas bon", 4, MaxIDChefRayon);

		ChefRayonDAO.supprimerChefRayon(ChefRayon2);
		ChefRayonDAO.supprimerChefRayon(ChefRayon3);
	}

}
