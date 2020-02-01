package testDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controler.RayonDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.ProduitDAO;
import model.Rayon;
import model.ChefRayon;
import model.Produit;

public class TestRayonDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connexion.test();
	}

	@Before
	public void setUp() throws Exception {
		Rayon Rayon1 = new Rayon(1, "Rayon1", null, null, null);
		RayonDAO.ajouterRayon(Rayon1);
	}

	@After
	public void tearDown() throws Exception {
		Rayon Rayon1 = RayonDAO.rechercheRayonById(1);
		RayonDAO.supprimerRayon(Rayon1);
	}

	@Test
	public void test_ajouterRayon_et_rechercheRayonById_et_supprimerRayon() {
		Rayon Rayon2 = new Rayon(2, "Rayon2", null, null, null);
		RayonDAO.ajouterRayon(Rayon2);
		Rayon Rayon3 = RayonDAO.rechercheRayonById(2);
		assertEquals("Rayon2 et 3 n'ont pas le même id", Rayon2.getIDRayon(), Rayon3.getIDRayon());
		assertEquals("Rayon2 et 3 n'ont pas le même nom", Rayon2.getNom(), Rayon3.getNom());
		assertEquals("Rayon2 et 3 n'ont pas la même liste de produit", Rayon2.getListProduit(),
				Rayon3.getListProduit());
		assertEquals("Rayon2 et 3 n'ont pas la même liste de chef de rayon", Rayon2.getListChefRayon(),
				Rayon3.getListChefRayon());
		assertEquals("Rayon2 et 3 n'ont pas le même chef de magasin", Rayon2.getIDChefMagasin(),
				Rayon3.getIDChefMagasin());
		RayonDAO.supprimerRayon(Rayon2);
		Rayon Rayon4 = RayonDAO.rechercheRayonById(2);
		assertEquals("Le rayon n'a pas été supprimé", Rayon4, null);
	}

	@Test
	public void test_ajouterRayonProduit() {
		Rayon Rayon1 = RayonDAO.rechercheRayonById(1);
		Produit Produit1 = new Produit(1, "Produit1", 10, 10, "descriptionProduit1", Rayon1);
		RayonDAO.ajouterRayonProduit(Rayon1, Produit1);
		ProduitDAO.ajouterProduit(Produit1);
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même id", Produit1.getIDProduit(),
				Rayon1.getListProduit().get(0).getIDProduit());
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même nom", Produit1.getNom(),
				Rayon1.getListProduit().get(0).getNom());
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même prix", Produit1.getPrix(),
				Rayon1.getListProduit().get(0).getPrix());
		assertEquals("Produit1 et le Produit de la liste n'ont pas la même quantité", Produit1.getQuantite(),
				Rayon1.getListProduit().get(0).getQuantite());
		assertEquals("Produit1 et le Produit de la liste n'ont pas la même description", Produit1.getDescription(),
				Rayon1.getListProduit().get(0).getDescription());
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même rayon", Produit1.getIDRayon(),
				Rayon1.getListProduit().get(0).getIDRayon());
		ProduitDAO.supprimerProduit(Produit1);
	}

	@Test
	public void test_ajouterRayonChefRayon() {
		Rayon Rayon1 = RayonDAO.rechercheRayonById(1);
		RayonDAO.ajouterRayon(Rayon1);
		ChefRayon ChefRayon1 = new ChefRayon(1, "nom1", "prenom1", "password1", null, Rayon1);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon1);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
		assertEquals("Le chef de rayon de la liste des rayon et ChefRayon1 n'ont pas le même id",
				Rayon1.getListChefRayon().get(0).getIDChefRayon(), ChefRayon1.getIDChefRayon());
		assertEquals("Le chef de rayon de la liste des rayon et ChefRayon1 n'ont pas le même nom",
				Rayon1.getListChefRayon().get(0).getNom(), ChefRayon1.getNom());
		assertEquals("Le chef de rayon de la liste des rayon et ChefRayon1 n'ont pas le même prenom",
				Rayon1.getListChefRayon().get(0).getPrenom(), ChefRayon1.getPrenom());
		assertEquals("Le chef de rayon de la liste des rayon et ChefRayon1 n'ont pas le même mot de passe",
				Rayon1.getListChefRayon().get(0).getMotDePasse(), ChefRayon1.getMotDePasse());
		assertEquals("Le chef de rayon de la liste des rayon et ChefRayon1 n'ont pas le même rayon",
				Rayon1.getListChefRayon().get(0).getIDRayon(), ChefRayon1.getIDRayon());
		assertEquals("Le chef de rayon de la liste des rayon et ChefRayon1 n'ont pas le même chef de magasin",
				Rayon1.getListChefRayon().get(0).getIDChefMagasin(), ChefRayon1.getIDChefMagasin());
		ChefRayonDAO.supprimerChefRayon(ChefRayon1);
	}

	@Test
	public void test_modifierRayon() {
		Rayon Rayon1 = RayonDAO.rechercheRayonById(1);
		Rayon Rayon2 = new Rayon(1, "Rayon2", null, null, null);
		RayonDAO.modifierRayon(1, Rayon2);
		assertEquals("Rayon1 et 2 n'ont pas le même nom", Rayon1.getNom(), Rayon2.getNom());
	}

	@Test
	public void test_returnAllRayon() {
		Rayon Rayon1 = RayonDAO.rechercheRayonById(1);
		ArrayList<Rayon> ListRayon = RayonDAO.returnAllRayon();
		assertEquals("La liste n'a pas la bonne taille", 1, ListRayon.size());
		assertEquals("Rayon1 et le rayon de la liste n'ont pas le même id", Rayon1.getIDRayon(),
				ListRayon.get(0).getIDRayon());
		assertEquals("Rayon1 et le rayon de la liste  n'ont pas le même nom", Rayon1.getNom(),
				ListRayon.get(0).getNom());
		assertEquals("Rayon1 et le rayon de la liste  n'ont pas la même liste de produit", Rayon1.getListProduit(),
				ListRayon.get(0).getListProduit());
		assertEquals("Rayon1 et le rayon de la liste  n'ont pas la même liste de chef de rayon",
				Rayon1.getListChefRayon(), ListRayon.get(0).getListChefRayon());
		assertEquals("Rayon1 et le rayon de la liste  n'ont pas le même chef de magasin", Rayon1.getIDChefMagasin(),
				ListRayon.get(0).getIDChefMagasin());

		Rayon Rayon2 = new Rayon(2, "Rayon2", null, null, null);
		RayonDAO.ajouterRayon(Rayon2);
		ListRayon = RayonDAO.returnAllRayon();
		assertEquals("La liste n'a pas la bonne taille", 2, ListRayon.size());

		Rayon Rayon3 = new Rayon(3, "Rayon3", null, null, null);
		RayonDAO.ajouterRayon(Rayon3);
		ListRayon = RayonDAO.returnAllRayon();
		assertEquals("La liste n'a pas la bonne taille", 3, ListRayon.size());

		RayonDAO.supprimerRayon(Rayon2);
		RayonDAO.supprimerRayon(Rayon3);
	}

	@Test
	public void test_returnMaxIDRayon() {
		int MaxIDRayon = RayonDAO.returnMaxIDRayon();
		assertEquals("L'id renvoyé n'est pas bon", 2, MaxIDRayon);

		Rayon Rayon2 = new Rayon(2, "Rayon2", null, null, null);
		RayonDAO.ajouterRayon(Rayon2);
		MaxIDRayon = RayonDAO.returnMaxIDRayon();
		assertEquals("L'id renvoyé n'est pas bon", 3, MaxIDRayon);

		Rayon Rayon3 = new Rayon(3, "Rayon3", null, null, null);
		RayonDAO.ajouterRayon(Rayon3);
		MaxIDRayon = RayonDAO.returnMaxIDRayon();
		assertEquals("L'id renvoyé n'est pas bon", 4, MaxIDRayon);

		RayonDAO.supprimerRayon(Rayon2);
		RayonDAO.supprimerRayon(Rayon3);
	}

}
