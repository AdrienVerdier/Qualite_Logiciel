# qualite_logiciel
 projet de qualité logiciel

Pour ce projet, nous avons utilisé hibernate afin de gérer la base de données sur wampserver.
Pour cela vous devez créer la base de données projetqualitelogiciel en amount sur wampserver. 
Pour faire fonctionner les tests, vous devez créer la base de données test_projetqualitelogiciel

Pour créer la base de données, lancer wamp, clique gauche sur son icône, onglet phpmyadmin.
Puis connecter vous avec l'utilisateur root sans mot de passe.
Cliquer sur le bouton créer Nouvelle base de données et rentrer : projetqualitelogiciel.

Puis vous pouvez lancer l'application :
 - Tout d'abord vous devez lancer le .jar CreationBDD qui va créer la base de données et placer quelques données pour commencer son utilisation.
 - Puis vous pouver lancer UtilisationBDD qui va lancer l'interface pour accéder à la base de données et vous permettre 
d'effectuer des modifications. Ces modificationssont enregistrées dans la base de données et pourront être récupérer au 
prochain lancement de l'application.