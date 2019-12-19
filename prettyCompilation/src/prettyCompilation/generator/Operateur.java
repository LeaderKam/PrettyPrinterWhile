/**
 * 
 */
package prettyCompilation.generator;

import java.util.List;

/**
 * @author sievi
 *
 */
public class Operateur {
	String op;
	String adr1;
	String adr2;
	String adr3;

	List<Code3Adresse> alors, sinon;
	
	public String compile(String op) {
		String res = "";
		switch (this.op) {
		case "nop":
			return "libwh.nop();";
		case "ret":
			return "return " + adr1 + ";";
		case "push":
			return adr1+".push("+adr2+");";
		case "array":
			return "var "+adr1+" = [];";
		case "subarray":
			return adr1+" = [];";
		case "aff":
			return adr1 + " = " + adr2 + ";";
		case "nil":
			return adr1 + " = libwh.nil();";
		case "cons":
			return adr1 + " = libwh.cons(" + adr2 + ", " + adr3 + ");"; // return concaténation de adr2(gauche) et
																			// adr3(droite)
		// Attention à bien différentier si adr3 est un bintree ou pas. Si oui, merger,
		// sinon, retourner adr2 sans concaténation (ca veut dire que c'est l'init)!
		case "hd":
			return adr1 + " = libwh.hd(" + adr2 + ");";
		case "tl":
			return adr1 + " = libwh.tl(" + adr2 + ");";
		case "not":
			return adr1 + " = libwh.not(" + adr2 + ");";
		case "and":
			return adr1 + " = libwh.and(" + adr2 + "," + adr3 + ");";
		case "or":
			return adr1 + " = libwh.or(" + adr2 + "," + adr3 + ");";
		case "=?":
			return adr1 + " = libwh.eq(" + adr2 + "," + adr3 + ");";
		case "symb":
			return adr1 + " = libwh.symb(\'" + adr2 + "\');";
		case "btoi":
			return adr1 + " = libwh.intFromBintree(" + adr2 + ");";
		case "call":
			return adr3 + " = " + adr1 + ".apply(null, " + adr2 + ");";
		case "pop":
			return adr1 + " = " + adr2 + ".shift();";
		case "while":
			for (Code3Adresse code3Adresse : alors)
				res += code3Adresse.compile() + "\n";
			return "while(libwh.isTrue(" + adr2 + ")){\n" + res + "}";
		case "foreach":
			res += adr3 + " = libwh.hd(" + adr1 + ")\n";
			for (Code3Adresse code3Adresse : alors)
				res += code3Adresse.compile() + "\n";
			res += adr1 + " = libwh.tl(" + adr1 + ")\n";
			return adr1 + " = " + adr2 + ";\nwhile(libwh.isTrue(" + adr1 + ")){\n" + res + "}";
		case "for":
			for (Code3Adresse code3Adresse : alors)
				res += code3Adresse.compile() + "\n";
			return adr1 + " = libwh.intFromBintree(" + adr2 + ");\nfor (" + adr3 + " = 0; " + adr3 + " < " + adr1
					+ "; " + adr3 + "++){\n" + res + "}";
		case "if":
			for (Code3Adresse code3Adresse : alors)
				res += code3Adresse.compile() + "\n";
			res = "if (libwh.isTrue(" + adr2 + ")){\n" + res + "}";
			if (!sinon.isEmpty()) {
				res += "\nelse{\n";
				for (Code3Adresse code3Adresse : sinon)
					res += code3Adresse.compile() + "\n";
				res += "}";
			}
			return res;
		default:
			return "libwh.nonImpl();";
		}
	}
}
