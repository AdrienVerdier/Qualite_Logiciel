#Author: Pierre Savary & Adrien Verdier
#Keywords Summary : test de la classe GestionProduit du point de vue d'un chef de magasin
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
@tag
Feature: Test classe GestionProduit Administrateur
  On va ici d�crire des sc�narios pour tester la classe GestionProduit en partant du point de vue d'un chef de magasin

  @tag1
  Scenario: Ajout d'un produit par un chef de magasin
    Given un chef de magasin connect� � l'application
    When Il ajoute un produit � la base de donn�e
    Then Le produit se trouve dans l'application

  @tag2
  Scenario Outline: Modification d'un produit par un chef de magasin
    Given un chef de magasin connect� � l'application
    When Il modifie les information d'un produit
    Then Le produit est modifi� dans l'application
    
	@tag3
	Scenario Outline: Suppression d'un produit par un chef de magasin
		Given un chef de magasin connect� � l'application
		When il supprime un produit 
		Then Le produit ne se trouve plus dans l'application