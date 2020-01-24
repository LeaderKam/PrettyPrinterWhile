/**
 * Liste de structure de chaque focntion du repertoire de fonction
 */
package prettyCompilation.generator;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * @author
 *
 */
public class CodeDependant {
	private List<String> inputs;
	private List<String> inputsWhile;
	private int nbOutput;
	private int nbInput;
	private List<Code3Adresse> instructions;
	private Map<String, String> variables;
	private Stack<List<Code3Adresse>> instructionList; 

	/**
	 * constructeur de la structure de fonction
	 * Liste de params entrée
	 * Liste de params sortie
	 * instructions code 3 adresse
	 * variables
	 * liste de liste de code 3 adresse
	 * output 
	 */
	public CodeDependant(int nbInput, int nbOut) {
		this.inputs = new ArrayList<String>();
		this.nbOutput = nbOut;
		this.nbInput=nbInput;
		// Les instruction peuvent peut-être etre triée ? (déclaration d'abord...)
		this.instructions = new LinkedList<Code3Adresse>();
		this.variables = new HashMap<String, String>();
		this.instructionList= new Stack<List<Code3Adresse>>();
	}

	public void addInstruction(Code3Adresse instruction) {
		if (instructionList.isEmpty()) {
			this.instructions.add(instruction);
		}
		else {
			this.instructionList.peek().add(instruction);
		}
		if (instruction.getSinon() != null)
			this.instructionList.push(instruction.getSinon());
		if (instruction.getAlors() != null)
			this.instructionList.push(instruction.getAlors());
	}

	public Stack<List<Code3Adresse>> getInstructionList() {
		return instructionList;
	}

	public void addVariable(String whileName, String javaName) {
		this.variables.put(whileName, javaName);
	}

	public void addInputs(String whileName) {
		this.inputs.add(whileName);
	}

	public List<String> getInputs() {
		return inputs;
	}

	public int getNbOutput() {
		return nbOutput;
	}

	public int getNbInput() {
		return nbInput;
	}
	public List<Code3Adresse> getInstructions() {
		return instructions;
	}

	public Map<String, String> getVariables() {
		return variables;
	}
}