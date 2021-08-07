# spring-boot-test

[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)

Bonjouuur, Je vais vous montrer comment créer un service RESTful simple à l'aide de Spring Boot tout en suivant TDD et en utilisant Junit 5.3.1. 

<img src="todoproject\src\main\resources\static\run.PNG" width="30%"  />

Vous aller trouver sur cette repository un projet complet avec des commentaires qui vous expliquent tous les étapes de test et les resultats d'execution, et les raisons de differents choix
## Pour commencer
TDD est un paradigme dans lequel vous écrivez un cas de test et apportez des modifications minimalistes au code pour le faire passer avec les cas de test existants. 
TDD c'est faire les étapes suivantes de manière répétitive:
 - Ajouter rapidement un test
 - Exécutez tous les tests et voyez le nouveau échouer 
 - Apporter des modifications minimalistes au code 
 - Exécutez tous les tests et voyez-les tous réussir 
 - Refactoriser pour supprimer la duplication
#REST

<img src="todoproject\src\main\resources\static\architecture.PNG" width="70%"  />

=>Architecture en couches
### Pré-requis 
 - Java 
 - Des notions de base de MVC, REST APIs et Unit tests

### Tech Stack:
 - JDK 11
 - Spring Boot (2.1.4)
 - Gradle
 - JPA
 - JUnit (5.3.1)
 - Mockito
 - Hamcrest

### Outils:
 - IntelliJ IDEA 
 - Spring tool suite (personellement je l'ai utilisé pour ce projet)

## Démarrage
  En utilisant l'outil facile de https://start.spring.io/ 
  on a choisie le projet gradle. On a ajouter Web, JPA, H2. 
  JPA est une API tout comme JDBC pour permettre à Java d'interagir avec la base de données.
  La base de données que nous utiliserons est H2 qui est une base de données en mémoire.
  
  <img src="todoproject\src\main\resources\static\spring.PNG" width="80%"  />
  
## Structure de cas de test
En Parlant de la structure de ce cas de test. Il suit le modèle AAA (organiser, agir, affirmer).
Organiser : C'est la première étape d'un test unitaire. Ici, nous allons organiser le test, en d'autres termes, nous allons faire la configuration nécessaire du test. Par exemple, pour effectuer le test, nous devons créer un objet de la classe ciblée, si nécessaire, nous devons ensuite créer des objets fictifs et d'autres variables d'initialisation, quelque chose comme ceux-ci.
Agir : Dans cette étape, nous allons exécuter le test. En d'autres termes, nous effectuerons les tests unitaires réels et le résultat sera obtenu à partir de l'application de test. Fondamentalement, nous appellerons la fonction ciblée dans cette étape en utilisant l'objet que nous avons créé à l'étape précédente.
Assert : C'est la dernière étape d'un test unitaire. Dans cette étape, nous allons vérifier le résultat renvoyé avec les résultats attendus.

## Test API avec POSTMAN
Spring boot est livré avec un serveur Tomcat. Maintenant, démarrons le serveur et accédons à notre API via un outil appelé POSTMAN

Tout d'abord, lancer le serveur. Accédez au fichier ToDoApplication.java et exécutez-le. Voir le port sur lequel il est démarré. Généralement, ce serait 8080 mais je l'ai modifié au niveau de page application.properties à 9092

<img src="todoproject\src\main\resources\static\run_junit.png" width="80%"  />

Avoir tous les ToDo’s
GET Request → http://localhost:9092/todos/

<img src="todoproject\src\main\resources\static\postman_todos1.PNG" width="80%"  />

=> Réponse de la demande GET
Nous obtenons une liste vide car nous n'avons ajouté aucune donnée à la base de données et nous n'avons encore implémenté aucune API pour stocker les données. Ajoutons donc quelques données dans l'application elle-même.

Nous devons maintenant initialiser notre base de données (H2) avec des exemples de données à l'aide de l'interface CommandLineRunner. Il est utilisé pour exécuter des morceaux de code spécifiques lorsqu'une application est complètement démarrée.

<img src="todoproject\src\main\resources\static\charger_bdd.png" width="80%"  />

Avoir tous les ToDo’s inserés dans la BDD
GET Request → http://localhost:9092/todos/

<img src="todoproject\src\main\resources\static\postman2.PNG" width="80%"  />

=> Réponse de la demande GET

Maintenant, nous pouvons supprimer cette configuration CommandLineRunner d'Application.java, c'était juste pour obtenir quelques tâches en utilisant l'API que nous avons construite car cela entraînera l'échec des tests de service car la méthode de configuration ne peut pas obtenir une instance ToDoRepository lorsque nous exécutons un test suite annotée avec SpringBootTest.

=>Donc, maintenant les étapes à suivre pour implémenter une API seront clairs. Écrivez un test de contrôleur où nous simulons le service, implémentons-le. Ecrivez un test de service où nous utilisons directement l'instance de référentiel, implémentez-le.

