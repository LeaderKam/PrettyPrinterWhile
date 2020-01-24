package prettyCompilation.generator;

import java.util.LinkedList;
/*
 * Une liste FIFO qui permet de générer des variables selon un préfixe donnée
 */
public class RegisterList {
	LinkedList<String> registres = new LinkedList<String>();
	private int counter = 0;
	private String prefixe;
	public RegisterList(String prefixe) {
		this.prefixe = prefixe;
	}
	
	public String push() {
		registres.add(prefixe+""+counter+"");//expression de droite pour aff
		return prefixe+(counter++);//expression de gauche
	}
	
	public String pop() {
		return registres.pop();
	}
	public String getNextReg() {
		return prefixe+"["+counter+"]";
	}
	public String getPrefixe() {
		return prefixe;
	}
	public boolean isEmpty() {
		return this.registres.isEmpty();
	}
}