package prettyCompilation.generator;

import java.util.Stack;
/*
 * Une liste FIFO qui permet de g�n�rer des variables selon un pr�fixe donn�e
 */
public class RegisterStack {
	Stack<String> registres = new Stack<String>();
	private int counter = 0;
	private String prefixe;
	public RegisterStack(String prefixe) {
		this.prefixe = prefixe;
	}
	
	public String push() {
		registres.add(prefixe+counter);//parti droite de expr et args
		return prefixe+(counter++);//parti gauche de expr et args
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