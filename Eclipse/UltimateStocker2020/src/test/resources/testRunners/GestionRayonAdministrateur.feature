#Author: Pierre Savary & Adrien Verdier
#Keywords Summary : test de la classe GestionRayon du point de vue d'un chef de magasin

@tag
Feature: Test classe GestionRayon Administrateur
  On va ici décrire des scénarios pour tester la classe GestionRayon en partant du point de vue d'un chef de magasin

  @tag1
  Scenario: Ajout d'un rayon par un chef de magasin
    Given un chef de magasin connecte a l'application pour le premier test de GestionRayonAdministrateur
    When Il ajoute un rayon a la base de donnee pour le premier test de GestionRayonAdministrateur
    Then Le rayon se trouve dans l'application pour le premier test de GestionRayonAdministrateur

  @tag2
  Scenario Outline: Modification d'un rayon par un chef de magasin
    Given un chef de magasin connecte a l'application pour le second test de GestionRayonAdministrateur
    When Il modifie les information d'un rayon pour le second test de GestionRayonAdministrateur
    Then Le rayon est modifie dans l'application pour le second test de GestionRayonAdministrateur
    
	@tag3
	Scenario Outline: Suppression d'un rayon par un chef de magasin
		Given un chef de magasin connecte a l'application pour le troisieme test de GestionRayonAdministrateur
		When il supprime un rayon pour le troisieme test de GestionRayonAdministrateur
		Then Le rayon ne se trouve plus dans l'application pour le troisieme test de GestionRayonAdministrateur