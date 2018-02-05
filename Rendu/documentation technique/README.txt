=== PROJET COMPILATEUR WHILE VERS JAVASCRIPT ===
=== Compilation, ESIR2, 2017-2018 ===
=== GODBILLOT Faustine, GAUTRAIN Antoine, CHIQUET Basile, ROCHAT Nicolas, DIIARA Mame, LABRUE Gwendal, JEGO Emmanuel ===


=== CODE SOURCE ===
La grammaire est d�finie dans le fichier "Projet.xtext"
La classe "Launcher.java" permet de lancer le compilateur directement plut�t que via le serveur
Le fichier test.wh est le fichier contenant le programme WHILE lu par Launcher.java
Un r�pertoire gen/ est cr�� � la compilation lanc�e via Luncher.java et contient les diff�rents fichiers cr��s

Les classes utiles � la compilation sont d�finies dans le package "generator"
	- les classes correspondant aux instructions possibles en code 3@
	- les classes utiles � la g�n�ration de code 3@ : funcEntry, funcTab, symTab
	- ProjectGenerator.xtend est la classe permettant de g�n�rer le fichier pretty-print�
	- CodeGenerator.java est la classe permettant de g�n�rer le code 3@
	- JsGenerator.java est la classe permettant de g�n�rer le code JavaScript
	- le fichier executable compilator.jar permet d'ex�cuter le compilateur sans interface (am�lioration du jar du premier sprint)
Le package "server" contient la classe "SimpleHttpServer.java" qui d�fini notre serveur java pour l'interface web


=== MODE D'EMPLOI COMPILATEUR SANS INTERFACE ===
1. Ouvrir une invite de commande
2. Se rendre dans le r�pertoire "code source"
3. Lancer le compilateur via la commande
	java -jar compaltor.jar --src=test.wh
4. Le fichier pretty-print� est cr�� dans le repertoire "gen"
5. Le fichier JavaScript est cr�� dans le repertoire "code source"