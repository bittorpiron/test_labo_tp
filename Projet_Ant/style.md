# Normes de codification
v1.6

## 1. Introduction
Les normes suivantes seront les règles à suivre tout au long du projet afin d'uniformiser le rendu final.
Chacun est tenu de les appliquer sur le code qu'ils mettent en place.


## 2. Cohésion
Les méthodes doivent être découpées de manière à respecter le "Principe de responsabilité unique".

 

## 3. Commentaires
Les commentaires peuvent être rédigés dans les langues communes entre les gens de l'équipe, soit le français et l'anglais.
### 3.1 Classes
Seuls les commentaires de droits d'auteur sont nécessaires.

### 3.2 Méthodes
 * Une méthode bien nommée ne devrait pas nécessiter de commentaire.
 * Les commentaires sont permis seulement si ceux-ci ont une valeur ajoutée.
 * JavaDoc seulement requis pour les librairies.

### 3.3 Code
Les commentaires dans le code doivent décrire le code qui ne peut s'expliquer de lui-même malgré l'utilisation adéquate de nom de variable et de méthode.

Par exemple :

  * Un algorithme.
  * Une expression régulière.
  * Décrire nos intentions dans le bloc de code à suivre.
  * Avertir des conséquences.
  * Code relié à une fonctionnalité externe.



## 4. Nommage
 * Le nommage se fait dans les langues communes entre les gens de l'équipe, soit le français et l'anglais. Il faudrait toutefois se limiter à n'utiliser que les caractères alphanumériques.
 * Il est important de choisir des noms justes qui décrivent bien leur rôle.
 * Il n'y a pas de limitation au niveau de la longueur. Tant qu'il n'inclut pas de "Et", ce qui indiquerait une multiresponsabilité (cohésion).

### 4.1 Classes
 * Le nom des classes est en [PascalCase](http://c2.com/cgi/wiki?PascalCase).

### 4.2 Méthodes
 * Le nom des méthodes est en [camelCase](http://fr.wikipedia.org/wiki/CamelCase).

### 4.3 Variables
 * Le nom des variables est en [camelCase](http://fr.wikipedia.org/wiki/CamelCase).

### 4.4 Constantes
 * Le nom des constantes est entièrement en majuscules de format [SNAKE_CASE](http://fr.wikipedia.org/wiki/Snake_case).



## 5. Aération
Les fichiers doivent avoir un contenu qui doit pouvoir être affiché sur une largeur d'écran. 
###5.1 Hors classe

 * La ligne de déclaration du package est précédée et suivie d'un saut de ligne.
 * Le bloc de déclaration englobant les imports utilisés est précédé et suivi d'un saut de ligne.

### 5.2 Classe
 * Le bloc de déclaration de variable doit être groupé. Ce bloc doit être précédé d'un saut de ligne.

### 5.3 Méthodes
 * Chaque méthode doit être précédée de 2 sauts de ligne.
 * Les méthodes ne doivent pas excéder 10 lignes.
 * Le nombre de paramètres ne devrait pas excéder 3.

### 5.4 Code
 * L'utilisation de parenthèses se fait ainsi :
 ```

 if (condition) {
     code;
 }

 if (condition) {
     code;
 } else {
     code;
 }

 if (condition) {
     code;
 } else if (condition) {
     code;
 } else {
     code;
 }

 ```
 ```

 for (initialisation; condition; miseAJour);

 for (initialisation; condition; miseAJour) {
     code;
 }
 ...

 while (condition);

 while (condition) {
     code;
 }
 ...

 do {
     code;
 } while (condition);
 ...

 switch (condition) {
 case A:
     code;
 case B:
     code;
     break;
 case C:
     code;
     break;
 default:
     code;
     break;
 ...

 try {
     code;
 } catch (classeException e) {
     code;
 } finally {
     code;
 }
 ...

 if ((a == b) && (c == d)) {
 }

 ```
 * L'indentation du code se fait à l'aide d'une tabulation par niveau (ou quatre espaces):
 ```

    if (condition) {
        throw new ErreurValeurFichierEntreeException("Le fichier d'entrée comporte une erreur.");
    }

 ```
 * Les retours doivent se faire ainsi :
 ...

 return expressionBooleen;

 return (condition ? x : y);
 

## 6. Tests unitaires
 * La personne ayant codé une fonctionnalité est entièrement responsable de mettre en place ses tests unitaires initiaux.
 * Chaque méthode ne devrait comprendre idéalement qu'une seule vérification (assert).
 * Au besoin, lors de la révision du projet avant remise, chacun est tenu d'ajouter des tests supplémentaires aux endroits qu'il juge bons afin de renforcir la couverture de test.



## 7. Format de fichier
### 7.1 Encodage des fichiers
Les fichiers doivent être enregistrés en suivant le format UTF-8. Celui-ci peut-être définit dans NetBeans dans le menu "Project properties" -> "Sources".

### 7.2 Retour à la ligne
Le type de retour à la ligne utilisé est celui Windows.

## 8. Respect des normes communes Java
Veuillez bien vous assurer de bien respecter nos normes de programmation, basé sur "Code Conventions for the Java Programming Language" publié par Sun. 
Il est disponible en ligne, http://java.sun.com/docs/codeconv/html/CodeConvTOC.doc.html. Netbeans peut aider en étant bien configuré.
