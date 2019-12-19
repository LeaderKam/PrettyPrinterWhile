package prettyCompilation.generator;

import java.util.Stack;

/*
 * Class register
 */
public class RegisterStack {
	Stack<String> registres = new Stack<String>();
	private int counter = 0;
	private String prefixe;
	public RegisterStack(String prefixe) {
		this.prefixe = prefixe;
	}
	
	public String push() {
		registres.add(prefixe+"["+counter+"]");
		return prefixe+"["+(counter++)+"]";
	}
	
	public String pop() {
		return registres.pop();
	}
	public String getNextReg() {
		return prefixe+".get("+counter+")";
	}
	public String getPrefixe() {
		return prefixe;
	}
	public boolean isEmpty() {
		return this.registres.isEmpty();
	}
}