/**
 * 
 */
package prettyCompilation.generator;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author sievi
 *
 */
public abstract class SymbolTable {
	
	/**
	 * @param functionName
	 * @param out
	 */

	public void addFunction(String functionName, int input, int out) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param functionName
	 * @param instr
	 */
	public void addThreeAddrInstruction(String functionName, Code3Adresse instr) {
		
	}

	/**
	 * @param functionName
	 * @param whileName
	 */
	public void addVariable(String functionName, String whileName) {
		
	}

	/**
	 * @param functionName
	 * @param whileName
	 */
	public void addInput(String functionName, String whileName) {
		
	}


}
