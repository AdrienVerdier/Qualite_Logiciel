# qualite_logiciel
 projet de qualité logiciel

Pour ce projet, nous avons utilisé hibernate afin de gérer la base de données sur wampserver (possibilité d'utiliser devserver ou tout autre logiciel équivalent).
Pour cela vous devez créer la base de données projetqualitelogiciel en amount sur wampserver. 
Pour faire fonctionner les tests, vous devez créer la base de données test_projetqualitelogiciel.

Pour créer la base de données, lancer wamp, clique gauche sur son icône, onglet phpmyadmin.
Puis connecter vous avec l'utilisateur root sans mot de passe.
Cliquer sur le bouton créer Nouvelle base de données et rentrer : projetqualitelogiciel.
(Voir pour manipulation équivalent sur tout autre logiciel)

Si wampserver n'est pas lancé alors lancer le.

Puis vous pourrez lancer l'application (penser à activer le serveur de base de données en amont):
 - Tout d'abord vous devez lancer le .jar CreationBDD qui va créer la base de données et placer quelques données pour commencer son utilisation.
 - Puis vous pouver lancer UtilisationBDD qui va lancer l'interface pour accéder à la base de données et vous permettre 
d'effectuer des modifications. Ces modifications sont enregistrées dans la base de données et pourront être récupérer au 
prochain lancement de l'application.

L'application est configuré pour accéder à une base de données se trouvant en localhost (127.0.0.1) avec les noms explicité plus tôt. 
Si vous voulez modifier ces informations, il faut modifier le fichier persistence.xml se trouvant au chemin : 
[DI4][PierreSavary-AdrienVerdier]/code_sources/src/main/java/META-INF/persistence.xml
