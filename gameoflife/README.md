# Game of life
> [Wikipedia](https://en.wikipedia.org/wiki/Conway's_Game_of_Life), [PlayGameOfLife](https://playgameoflife.com/) 👍

## Présentation

Votre objectif est d'implémenter une version finie du **Jeu de la vie** de Conway. Pour cet exercice, n'hésitez pas
à vous munir d'une feuille et d'un stylo afin de pouvoir dessiner.

### Concepts de base

* Le Jeu de la vie se déroule sur une grille à *deux dimensions*, qui seront fixes dans le cadre de cet exercice (par
exemple : 3\*3, 5\*5, 7\*9, etc.).
* Chaque case de cette grille est appelée *cellule*.
* Une cellule ne possède que deux états : *vivante*, ou *morte*.
* Chaque cellule possède des *voisins* : il s'agit des cellules directement adjacentes **et** en diagonale, pour un total 
de 8 voisins pour chaque cellule. Pour le besoin du calcul de voisinage, l'extérieur de la grille est considéré comme
n'étant composé *que de cellules mortes*.
* À chaque *tour de jeu*, l'état de chaque cellule de la grille sera mis à jour en suivant les règles du Jeu de la vie. 

### Contrat d'interface

Cet exercice sera partiellement corrigé de manière automatique, il est donc indispensable que vous respectiez le
contrat d'interface suivant :

```java
package fr.esgi.gameoflife.core;

public class GameOfLife {
    public GameOfLife(final boolean[][] grid);
    public boolean[][] tick();
}
```

L'objet `GameOfLife` doit pouvoir être initialisé avec un tableau à deux dimensions de booléens représentant chacun une
cellule dans un état soit vivante (`true`) soit morte (`false`). Bien entendu, rien ne vous empêche de transformer ce 
tableau de types primitifs en objet(s) à manipuler à l'intérieur de votre logique métier...
 
Chaque appel à la méthode `tick` exécute le calcul d'un nouveau tour de jeu, et renvoie en retour le nouvel état du jeu
à la fin du tour. Ici aussi, une transformation inverse d'objet(s) vers un tableau de primitifs est à envisager.

Et surtout... respectez bien le package !

Vous avez la possibilité de partir d'un squelette de projet respectant ce contrat d'interface. Lancez la commande
`mvn test` pour valider le bon fonctionnement de votre installation : tant que cette commande s'exécute avec succès,
vous avez l'assurance que la correction automatique s'exécutera sans problème !

Si la correction automatisée ne s'exécute pas car ce contrat d'interface n'est pas respecté, qu'une erreur survient lors 
de la compilation ou qu'une exception est levée au runtime quel que soit l'input donné à votre programme : la note sera 
de 0.

## Règles

L'implémentation de chacun de ces règles vous rapportera 4 points, pour un total de 16/20. Les 4 points restants seront 
attribués subjectivement pour valoriser la qualité de votre projet en termes de choix d'architecture et de respect des 
principes de la programmation orientée objet.

### Sous-population
> 4 points

*Chaque cellule vivante ayant moins de 2 voisins vivants meurt au prochain tour.*

Exemples :
```
| | | |        | |x| |        | | | |        | | | |
| |x| |   ou   | |x| |   ou   | |x| |   =>   | | | |  
| | | |        | | | |        | | |x|        | | | |
```

### Survie
> 4 points

*Chaque cellule vivante ayant 2 ou 3 voisins vivants reste en vie au prochain tour.*

Exemples :
```
| | | | |        | | | | |
| |x|x| |   =>   | |x|x| |
| |x|x| |        | |x|x| |
| | | | |        | | | | |
```

```
| | | | | | |        | | | | | | |
| | |x|x| | |        | | |x|x| | |
| |x| | |x| |   =>   | |x| | |x| |
| | |x|x| | |        | | |x|x| | |
| | | | | | |        | | | | | | |
```

### Sur-population
> 4 points

*Chaque cellule vivante ayant plus de 3 voisins vivants meurt au prochain tour.*

Exemple :
```
| | | | | | |        | | | | | | |
| |x|x| | | |        | |x|x| | | |
| |x|x| | | |   =>   | |x| | | | |
| | | |x|x| |        | | | | |x| |
| | | |x|x| |        | | | |x|x| |
| | | | | | |        | | | | | | |
```


### Reproduction
> 4 points

*Chaque cellule morte ayant exactement 3 voisins devient vivante.*

Exemples :
```
| | | | | | |        | | | | | | |
| |x|x| | | |        | |x|x| | | |
| |x| | | | |   =>   | |x|x| | | |
| | | | |x| |        | | | |x|x| |
| | | |x|x| |        | | | |x|x| |
| | | | | | |        | | | | | | |
```

Exemple simple de combinaison des règles de sous-population et de reproduction :
```
| |x| |        | | | |
| |x| |   =>   |x|x|x|  
| |x| |        | | | |
```

Bien évidemment, une cellule ne peut pas devenir vivante en dehors des limites de la grille telle que définie à 
l'intialisation du jeu :
```
|x| | |        | | | |
|x| | |   =>   |x|x| |  
|x| | |        | | | |
```