Partie 2 : Groupe 3 par DAVID Zoé,NGUEMA Levy, VOIRIN Raphaël, BEN ARBIYA Siham

!!! ATTENTION !!! Les collisions entre Véhicules ne sont pas gérées. La classe ParkingController a été codée par un autre membre du groupe. J'ai eu le temps de corriger et d'adapter checkOutBounds() mais j'avoue que je n'ai pas eu le courage de m'atteler aux collisions entre Véhicules..DESOLE POUR LE GROUPE SUIVANT :-(

JAVADOC : doc/index.html

Vehicule :

J'ai ajouté un constructeur qui permet de créer un Véhicule avec seulement son nom, sa taille et sa couleur.
Et cela dans le but de pouvoir créer des Véhicules avec uniquement les données vehicles.dat
Il faut par contre initialiser les autres attributs à l'aide des modificateurs avant d'afficher le Véhicule.

J'ai modifié la méthode deplacer(). En effet dans la version originale les positions X et Y n'était pas mises à jour
après un déplacement. C'est maintenant le cas.

J'ai ajouté plusieurs accesseurs et modificateurs.

J'ai ajouté une méthode makeVisible() puisque le nouveau constructeur ne fait que créer un Véhicule sans l'afficher.

Parking :

J'ai surchargé la méthode add() avec une version qui permet d'ajouter un Véhicule précédemment créer.

J'ai ajouté la méthode move() qui remplace la méthode deplacement().
La méthode deplacement() prend en paramètre une chaîne de caratère qui contient plusieurs ordres de déplacement.
Pas très pratique...(voir RushHour1).

ParkingController :

Je n'ai pas codé personnellement cette classe.
La méthode checkRectangleOverlap() est une ébauche et n'est pas utilisée. Les collisions entre les Véhicules ne sont donc pas gérées...DESOLE :-(

RWFile :

Classe qui permet la lecture et l'écriture d'ArrayList<String> et d'HashMap<String,String> depuis et vers un fichier texte.

Console :

Classe qui permet la lecture des saisies clavier sur un terminal.


ParkingFactory :

J'ai choisi de créer et de conserver tous les Véhicules de vehicles.dat dans une HashMap. Ainsi pour créer un Parking on puise directement dedans pour ajouter des Véhicules.
Il faut bien sûr avant cela initialiser la direction et la position du Véhicule. Puis le rendre visible.

Pour chaque niveau de difficulté, une ArrayList est initialisée avec toutes les configurations possibles.
Ensuite en fonction du niveau de difficulté et du numéro de configuration sélectionnés, on remplit le Parking en allant chercher dans l'ArrayList adéquate.
