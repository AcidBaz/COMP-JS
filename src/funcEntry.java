package org.xtext.example.generator;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe d'entr�e d'une fonction pour la table des fonctions
 * @author groupe JS
 *
 */
public class funcEntry {
	//nb de param�tres et de valeurs retourn�es
	int in,out;
	//liste des instructions en code 3@
	ArrayList<code3A> code;
	//table des valeurs de la fonction
	HashMap<String,String> tabVal;
	
	funcEntry(int in, int out){
		this.in = in;
		this.out = out;
		this.code = new ArrayList<code3A>();
		this.tabVal = new HashMap<String,String>();
	}
	
	void addCode(code3A instruction){
		this.code.add(instruction);
	}
	
	void addVal(String id, String val){
		this.tabVal.put(id, val);
	}
}
