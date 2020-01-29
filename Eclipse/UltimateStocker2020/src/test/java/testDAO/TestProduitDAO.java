package testDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controler.Connexion;
import controler.ProduitDAO;
import model.Produit;

public class TestProduitDAO {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Connexion.test();
	}

	@Before
	public void setUp() throws Exception {
		Produit Produit1 = new Produit(1, 10, 10, "descriptionProduit1", null);
		ProduitDAO.ajouterProduit(Produit1);
	}

	@After
	public void tearDown() throws Exception {
		Produit Produit1 = ProduitDAO.rechercheProduitById(1);
		ProduitDAO.supprimerProduit(Produit1);
	}

	@Test
	public void test_ajouterProduit_et_rechercheProduitById_et_supprimerProduit() {
		Produit Produit2 = new Produit(2, 100, 100, "descriptionProduit2", null);
		ProduitDAO.ajouterProduit(Produit2);
		Produit Produit3 = ProduitDAO.rechercheProduitById(2);
		assertEquals("Produit2 et 3 n'ont pas le même id", Produit2.getIDProduit(), Produit3.getIDProduit());
		assertEquals("Produit2 et 3 n'ont pas le même prix", Produit2.getPrix(), Produit3.getPrix());
		assertEquals("Produit2 et 3 n'ont pas la même quantité", Produit2.getQuantite(), Produit3.getQuantite());
		assertEquals("Produit2 et 3 n'ont pas la même description", Produit2.getDescription(),
				Produit3.getDescription());
		assertEquals("Produit2 et 3 n'ont pas le même rayon", Produit2.getIDRayon(), Produit3.getIDRayon());
		ProduitDAO.supprimerProduit(Produit2);
		Produit Produit4 = ProduitDAO.rechercheProduitById(2);
		assertEquals("Le produit n'a pas été supprimé",Produit4,null);
	}

	@Test
	public void test_modifierProduit() {
		Produit Produit1 = ProduitDAO.rechercheProduitById(1);
		Produit Produit2 = new Produit(1, 100, 100, "descriptionProduit2", null);
		ProduitDAO.modifierProduit(1, Produit2);
		assertEquals("Produit1 et 2 n'ont pas le même prix", Produit1.getPrix(), Produit2.getPrix());
		assertEquals("Produit1 et 2 n'ont pas la même quantité", Produit1.getQuantite(), Produit2.getQuantite());
		assertEquals("Produit1 et 2 n'ont pas la même description", Produit1.getDescription(),
				Produit2.getDescription());
	}

	@Test
	public void test_returnAllProduit() {
		Produit Produit1 = ProduitDAO.rechercheProduitById(1);
		ArrayList<Produit> ListProduit = ProduitDAO.returnAllProduit();
		assertEquals("La liste n'a pas la bonne taille", 1, ListProduit.size());
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même id", Produit1.getIDProduit(),
				ListProduit.get(0).getIDProduit());
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même prix", Produit1.getPrix(),
				ListProduit.get(0).getPrix());
		assertEquals("Produit1 et le Produit de la liste n'ont pas la même quantité", Produit1.getQuantite(),
				ListProduit.get(0).getQuantite());
		assertEquals("Produit1 et le Produit de la liste n'ont pas la même description", Produit1.getDescription(),
				ListProduit.get(0).getDescription());
		assertEquals("Produit1 et le Produit de la liste n'ont pas le même rayon", Produit1.getIDRayon(),
				ListProduit.get(0).getIDRayon());
		
		Produit Produit2 = new Produit(2, 100, 100, "descriptionProduit2", null);
		ProduitDAO.ajouterProduit(Produit2);
		ListProduit = ProduitDAO.returnAllProduit();
		assertEquals("La liste n'a pas la bonne taille", 2, ListProduit.size());

		Produit Produit3 = new Produit(3, 50, 30, "descriptionProduit3", null);
		ProduitDAO.ajouterProduit(Produit3);
		ListProduit = ProduitDAO.returnAllProduit();
		assertEquals("La liste n'a pas la bonne taille", 3, ListProduit.size());

		ProduitDAO.supprimerProduit(Produit2);
		ProduitDAO.supprimerProduit(Produit3);
	}

	@Test
	public void test_returnMaxIDProduit() {
		int MaxIDProduit = ProduitDAO.returnMaxIDProduit();
		assertEquals("L'id renvoyé n'est pas bon", 2, MaxIDProduit);

		Produit Produit2 = new Produit(2, 100, 100, "descriptionProduit2", null);
		ProduitDAO.ajouterProduit(Produit2);
		MaxIDProduit = ProduitDAO.returnMaxIDProduit();
		assertEquals("L'id renvoyé n'est pas bon", 3, MaxIDProduit);

		Produit Produit3 = new Produit(3, 50, 30, "descriptionProduit3", null);
		ProduitDAO.ajouterProduit(Produit3);
		MaxIDProduit = ProduitDAO.returnMaxIDProduit();
		assertEquals("L'id renvoyé n'est pas bon", 4, MaxIDProduit);

		ProduitDAO.supprimerProduit(Produit2);
		ProduitDAO.supprimerProduit(Produit3);
	}

}
