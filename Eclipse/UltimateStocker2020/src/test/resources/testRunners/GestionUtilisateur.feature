#Author: Pierre Savary & Adrien Verdier
#Keywords Summary : test de la classe GestionUtilisateur du point de vue d'un chef de magasin

@tag
Feature: Test classe GestionUtilisateur 
  On va ici décrire des scénarios pour tester la classe GestionUtilisateur en partant du point de vue d'un chef de magasin

  @tag1
  Scenario: Ajout d'un utilisateur par un chef de magasin
    Given un chef de magasin connecte a l'application pour le premier test de GestionUtilisateur
    When Il ajoute un utilisateur a la base de donnee pour le premier test de GestionUtilisateur
    Then L'utilisateur se trouve dans l'application pour le premier test de GestionUtilisateur

  @tag2
  Scenario Outline: Modification d'un utilisateur par un chef de magasin
    Given un chef de magasin connecte a l'application pour le second test de GestionUtilisateur
    When Il modifie les information d'un utilisateur pour le second test de GestionUtilisateur
    Then L'utilisateur est modifie dans l'application pour le second test de GestionUtilisateur
    
	@tag3
	Scenario Outline: Suppression d'un utilisateur par un chef de magasin
		Given un chef de magasin connecte a l'application pour le troisieme test de GestionUtilisateur
		When il supprime un utilisateur pour le troisieme test de GestionUtilisateur
		Then L'utilisateur ne se trouve plus dans l'application pour le troisieme test de GestionUtilisateur