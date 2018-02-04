=== PROJET COMPILATEUR WHILE VERS JAVASCRIPT ===
=== Compilation, ESIR2, 2017-2018 ===
=== GODBILLOT Faustine, GAUTRAIN Antoine, CHIQUET Basile, ROCHAT Nicolas, DIIARA Mame, LABRUE Gwendal, JEGO Emmanuel ===


=== MODE D'EMPLOI ===
1. Ouvrir une invite de commande
2. Se rendre dans le r�pertoire o� se trouve ce fichier README.txt
3. Lancer le serveur via la commande
	java -jar ./server.jar
4. Ouvrir l'interface d'utilisation (index.html)
5. Modifier le code WHILE en cliquant sur "MODIFIER" (un programme simple est saisi par d�faut)
6. Cliquer sur "VALIDER" pour confirmer les modifications apport�es au programme
7. Cliquer sur "COMPILER" : le code JavaScript est affich� apr�s le chargement
8. Cliquer sur le bouton dans la fen�tre de test ("fX") pour tester le programme
	-> les param�tres � saisir doivent correspondre au langage JavaScript
		-> (cons nil nil) : cons(nil,nil)
		-> (list nil nil) : list(nil,nil)
		-> (hd X) : hd(X)
		-> (tl X) : tl(X)
		-> nil : nil
	-> les r�sultats renvoy�s sont affich�s en langage JavaScript	
		-> "left" correspond au sous-arbre gauche
		-> "right" correspond au sous-arbre droit
		-> {"left":null,"rigth":null} correspond � nil
	-> la fonction appel�e est la derni�re d�clar�e dans le programme WHILE

Le bouton "? Aide" donne certaines indications suppl�mentaires sur l'interface.
Des indications concernant la compilation sont affich�es dans l'invite de commande.


=== FONCTIONNALITES ===
Le compilateur WHILE ver JavaScript permet de traduire du code �crit en langage WHILE vers le langage JavaScript.
L'interface d'utilisation permet d'ex�cuter le compilateur et de tester le code JavaScript cr��.
Le compilateur offre 3 principales fonctionnalit�s :
	- pretty-printer le code WHILE saisi
	- g�n�r� et visualiser du code JavaScript correspondant au code WHILE saisi
	- ex�cuter le code de mani�re int�ractive et visualiser le r�sultat
L'interface comprend une gestion des erreurs. Un message d'erreur s'affiche si :
	- le code WHILE ne respecte pas la grammaire
	- la g�n�ration du code JavaScript a �chou�
	- l'ex�cution du code JavaScript a �chou�
