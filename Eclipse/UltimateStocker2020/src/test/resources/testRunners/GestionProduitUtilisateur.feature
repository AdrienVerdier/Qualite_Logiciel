#Author: Pierre Savary & Adrien Verdier
#Keywords Summary : test de la classe GestionProduit du point de vue d'un chef de rayon

@tag
Feature: Test classe GestionProduit Utilisateur
  On va ici décrire des scénarios pour tester la classe GestionProduit en partant du point de vue d'un chef de rayon

  @tag1
  Scenario: Ajout d'un produit par un chef de rayon
    Given un chef de rayon connectéa l'application pour le premier test de GestionProduitUtilisateur
    When Il ajoute un produit a la base de donnee pour le premier test de GestionProduitUtilisateur
    Then Le produit se trouve dans l'application pour le premier test de GestionProduitUtilisateur

  @tag2
  Scenario Outline: Modification d'un produit par un chef de rayon
    Given un chef de rayon connecte a l'application pour le second test de GestionProduitUtilisateur
    When Il modifie les information d'un produit pour le second test de GestionProduitUtilisateur
    Then Le produit est modifie dans l'application pour le second test de GestionProduitUtilisateur
    
	@tag3
	Scenario Outline: Suppression d'un produit par un chef de rayon
		Given un chef de rayon connecte a l'application pour le troisieme test de GestionProduitUtilisateur
		When il supprime un produit pour le troisieme test de GestionProduitUtilisateur
		Then Le produit ne se trouve plus dans l'application pour le troisieme test de GestionProduitUtilisateur
