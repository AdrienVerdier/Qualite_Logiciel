package main;

import controler.ChefMagasinDAO;
import controler.ChefRayonDAO;
import controler.Connexion;
import controler.ProduitDAO;
import controler.RayonDAO;
import model.*;

public class MainCreation {

	public static void main(String[] args) {
		Connexion.init();
		
		ChefMagasin ChefMagasin1 = new ChefMagasin(1,"nom","prenom","password",null,null);
		
		Rayon Rayon1 = new Rayon(1,"Rayon1",null,null,ChefMagasin1);
		Rayon Rayon2 = new Rayon(2,"Rayon2",null,null,ChefMagasin1);
		Rayon Rayon3 = new Rayon(3,"Rayon3",null,null,ChefMagasin1);
		
		ChefRayon ChefRayon1 = new ChefRayon(1,"nom1","prenom1","password1",ChefMagasin1,Rayon1);
		ChefRayon ChefRayon2 = new ChefRayon(2,"nom2","prenom2","password2",ChefMagasin1,Rayon2);
		ChefRayon ChefRayon3 = new ChefRayon(3,"nom3","prenom3","password3",ChefMagasin1,Rayon3);
		ChefRayon ChefRayon4 = new ChefRayon(4,"nom4","prenom4","password4",ChefMagasin1,Rayon3);
		
		Produit Produit1 = new Produit(1,"Produit1",10,10,"descriptionProduit1",Rayon1);
		Produit Produit2 = new Produit(2,"Produit2",100,0,"descriptionProduit2",Rayon1);
		Produit Produit3 = new Produit(3,"Produit3",50,5,"descriptionProduit3",Rayon2);
		Produit Produit4 = new Produit(4,"Produit4",3,150,"descriptionProduit4",Rayon2);
		Produit Produit5 = new Produit(5,"Produit5",5,7,"descriptionProduit5",Rayon2);
		Produit Produit6 = new Produit(6,"Produit6",11,60,"descriptionProduit6",Rayon2);
		Produit Produit7 = new Produit(7,"Produit7",13,30,"descriptionProduit7",Rayon3);
		Produit Produit8 = new Produit(8,"Produit8",47,23,"descriptionProduit8",Rayon3);
		Produit Produit9 = new Produit(9,"Produit9",33,12,"descriptionProduit9",Rayon3);
		
		ChefMagasinDAO.ajouterChefMagasin(ChefMagasin1);

		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon1);
		RayonDAO.ajouterRayon(Rayon1);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon2);
		RayonDAO.ajouterRayon(Rayon2);
		ChefMagasinDAO.ajouterChefMagasinRayon(ChefMagasin1, Rayon3);
		RayonDAO.ajouterRayon(Rayon3);
		
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon1);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon1);
		ChefRayonDAO.ajouterChefRayon(ChefRayon1);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon2);
		RayonDAO.ajouterRayonChefRayon(Rayon1, ChefRayon2);
		ChefRayonDAO.ajouterChefRayon(ChefRayon2);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon3);
		RayonDAO.ajouterRayonChefRayon(Rayon2, ChefRayon3);
		ChefRayonDAO.ajouterChefRayon(ChefRayon3);
		ChefMagasinDAO.ajouterChefMagasinChefRayon(ChefMagasin1, ChefRayon4);
		RayonDAO.ajouterRayonChefRayon(Rayon3, ChefRayon4);
		ChefRayonDAO.ajouterChefRayon(ChefRayon4);
		
		RayonDAO.ajouterRayonProduit(Rayon1, Produit1);
		RayonDAO.ajouterRayonProduit(Rayon1, Produit2);
		RayonDAO.ajouterRayonProduit(Rayon2, Produit3);
		RayonDAO.ajouterRayonProduit(Rayon2, Produit4);
		RayonDAO.ajouterRayonProduit(Rayon2, Produit5);
		RayonDAO.ajouterRayonProduit(Rayon2, Produit6);
		RayonDAO.ajouterRayonProduit(Rayon3, Produit7);
		RayonDAO.ajouterRayonProduit(Rayon3, Produit8);
		RayonDAO.ajouterRayonProduit(Rayon3, Produit9);
		ProduitDAO.ajouterProduit(Produit1);
		ProduitDAO.ajouterProduit(Produit2);
		ProduitDAO.ajouterProduit(Produit3);
		ProduitDAO.ajouterProduit(Produit4);
		ProduitDAO.ajouterProduit(Produit5);
		ProduitDAO.ajouterProduit(Produit6);
		ProduitDAO.ajouterProduit(Produit7);
		ProduitDAO.ajouterProduit(Produit8);
		ProduitDAO.ajouterProduit(Produit9);

		ChefMagasin ChefMagasin2 = new ChefMagasin(1,"Verdier","Adrien","password",null,null);
		ChefMagasinDAO.modifierChefMagasin(1,ChefMagasin2);
	}

}
