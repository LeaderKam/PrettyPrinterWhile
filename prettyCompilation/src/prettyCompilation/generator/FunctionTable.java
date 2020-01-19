package prettyCompilation.generator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import prettyCompilation.generator.FunctionTable;

public class FunctionTable extends SymbolTable {
//	/** Instance unique pré-initialisée */
//	private static FunctionTable INSTANCE = new FunctionTable();

	/**
	 * Repertoire de fonctions representee par une liste de structures
	 * CodeDependant
	 */
	private Map<String, CodeDependant> functionDirectory;	
	public static int compt=0;
	/** Constructeur privé sans paramètre 
	 * Repertoire de fonction 
	 * Params: String :Nomfonction; Codedependant: Description des instruction interne(liste de structure)
	 * */
	public FunctionTable() {
		this.functionDirectory = new HashMap<String, CodeDependant>();
	}

//	/** Point d'accès pour l'instance unique du singleton */
//	public static FunctionTable getInstance() {
//		return INSTANCE;
//	}

	/**
	 * @param functionName
	 * @param out
	 */
	@Override
	public void addFunction(String functionName,int nbInput, int nbOutput) {
		CodeDependant fd = new CodeDependant(nbInput, nbOutput);
		this.functionDirectory.put(functionName, fd);
	}

	/**
	 * @param functionName
	 * @param instr
	 */
	@Override
	public void addThreeAddrInstruction(String functionName, Code3Adresse instr) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			currentFd.addInstruction(instr);
		}
		// TODO gestion des erreurs ?
	}

	/**
	 * @param functionName
	 * @param whileName
	 */
	@Override
	public void addVariable(String functionName, String whileName) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			currentFd.addVariable(whileName, "whileVar['"+whileName+"']");
		}
		// TODO gestion des erreurs ?
	}

	@Override
	public void addInputs(String functionName, String whileName) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			currentFd.addInputs(whileName);
			currentFd.addVariable(whileName, whileName+compt);
			compt++;
		}
		// TODO gestion des erreurs ?
	}

	private Map<String, CodeDependant> getFunctionDirectory() {
		return this.functionDirectory;
	}

	/**
	 * @return liste of inputs
	 * @param function name
	 */
	public List<String> getInputs(String functionName) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			return currentFd.getInputs();
		}
		return null;
		// TODO gestion des erreurs ?
	}

	/**
	 * @param functionName
	 * @return number of output
	 */
	public int getOutput(String functionName) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			return currentFd.getNbOutput();
		}
		return -1;
		// TODO gestion des erreurs ?
	}

	public List<Code3Adresse> getInstructions(String functionName) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			return currentFd.getInstructions();
		}
		return null;
		// TODO gestion des erreurs ?
	}

	public Set<String> getFunctions() {
		return this.getFunctionDirectory().keySet();
	}

	public String getVariable(String functionName, String variable) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			return currentFd.getVariables().get(variable);
		}
		return null;
		// TODO gestion des erreurs ?
	}
	public boolean varExists(String functionName, String variable) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			return currentFd.getVariables().containsKey(variable);
		}
		return false;
	}

	public void popFromInstructionList(String functionName) {
		CodeDependant currentFd = this.functionDirectory.get(functionName);
		if (currentFd != null) {
			currentFd.getInstructionList().pop();
		}
	}
	public boolean functionExists(String functionName) {
		return functionDirectory.containsKey(functionName);
	}

	public static FunctionTable getInstance() {
	  throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}
}