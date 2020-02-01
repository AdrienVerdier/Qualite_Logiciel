#Author: Pierre Savary & Adrien Verdier
#Keywords Summary : test de la classe GestionRayon du point de vue d'un chef de magasin
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
@tag
Feature: Test classe GestionRayon Administrateur
  On va ici d�crire des sc�narios pour tester la classe GestionRayon en partant du point de vue d'un chef de magasin

  @tag1
  Scenario: Ajout d'un rayon par un chef de magasin
    Given un chef de magasin connect� � l'application
    When Il ajoute un rayon � la base de donn�e
    Then Le rayon se trouve dans l'application

  @tag2
  Scenario Outline: Modification d'un rayon par un chef de magasin
    Given un chef de magasin connect� � l'application
    When Il modifie les information d'un rayon
    Then Le rayon est modifi� dans l'application
    
	@tag3
	Scenario Outline: Suppression d'un rayon par un chef de magasin
		Given un chef de magasin connect� � l'application
		When il supprime un rayon 
		Then Le rayon ne se trouve plus dans l'application