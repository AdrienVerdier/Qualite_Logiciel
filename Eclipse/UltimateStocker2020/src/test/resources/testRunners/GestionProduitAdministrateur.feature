#Author: Pierre Savary & Adrien Verdier
#Keywords Summary : test de la classe GestionProduit du point de vue d'un chef de magasin

@tag
Feature: Test classe GestionProduit Administrateur
  On va ici décrire des scénarios pour tester la classe GestionProduit en partant du point de vue d'un chef de magasin

  @tag1
  Scenario: Ajout d'un produit par un chef de magasin
    Given un chef de magasin connecte a l'application pour le premier test de GestionProduitAdministrateur
    When Il ajoute un produit a la base de donnee pour le premier test de GestionProduitAdministrateur
    Then Le produit se trouve dans l'application pour le premier test de GestionProduitAdministrateur

  @tag2
  Scenario: Modification d'un produit par un chef de magasin
    Given un chef de magasin connecte a l'application pour le second test de GestionProduitAdministrateur
    When Il modifie les information d'un produit pour le second test de GestionProduitAdministrateur
    Then Le produit est modifie dans l'application pour le second test de GestionProduitAdministrateur