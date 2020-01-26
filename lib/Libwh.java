/**
 * 
 */
package compilation;

import java.util.ArrayList;
import java.util.List;
import compilation.BinTree;
import java.util.function.Function;
import javax.script.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author sievi
 *
 */
public class Libwh {

	/**
	 * 
	 */
	public static BinTree bintree ;

	public Libwh() {
		//super()
	}

	public void nop() {
	}

	public BinTree nil() {
		return new BinTree("nil", null, null);
	}

	public BinTree cons(BinTree adr2, BinTree adr3) {
		
		bintree = new BinTree("cons", adr2, adr3);
		LinkedList<BinTree> args = new LinkedList<BinTree>();
		args.add(adr2); // clone the adr2
		if (adr3 != null) {
			args.add(adr3); // clone the adr3
		}
		return bintree.cons(args); // return the new bintree
	}

	public BinTree list(BinTree adr2, BinTree adr3) {
		bintree = new BinTree("nill", adr2, adr3);
		LinkedList<BinTree> args = new LinkedList<BinTree>();
		args.add(adr2); // clone the adr2
		args.add(adr3); // clone the adr3
		return bintree.list(args); // return the new bintree
	}

	public BinTree hd(BinTree adr) {
		return adr.head(adr);
	}

	public BinTree tl(BinTree adr) {
		return adr.tail(adr);
	}

	public BinTree not(BinTree adr2) {
		bintree = new BinTree("nill", null, null);
		if (isTrue(adr2)) {
			return bintree;
		} else {
			return new BinTree("cons", bintree, bintree);
		}
	}

	public boolean isTrue(BinTree tree) {
		return tree.isTrue(tree);
	}

	public BinTree and(BinTree adr2, BinTree adr3) {
		bintree = new BinTree("AND", null, null);
		return bintree.evaluate("AND", adr2, adr3);
	}

	public BinTree or(BinTree adr2, BinTree adr3) {
		bintree = new BinTree("OR", null, null);
		return bintree.evaluate("OR", adr2, adr3);
	}

	public BinTree eq(BinTree adr2, BinTree adr3) {
		bintree = new BinTree("EQ", null, null);
		return bintree.evaluate("EQ", adr2, adr3);
	}

	public BinTree symb(String adr2) { // here, a symbol is given so we need to return a bintree with the symbol as
										// data
		return bintreeFromString(adr2);
	}

	/**
	 * @param : BinTree
	 * @return String
	 */
	public String bintreeToString(BinTree X) {
		String sortie = "";
		if ((X.getRight() == null)) {
			sortie = sortie + "nil";
		} else {
			sortie = "(" + X.getData() + " " + ((X.getLeft() == null) ? "" : "nil ")
					+ ((X.getRight() == null) ? "" : bintreeToString(X.getRight())) + ")";
		}
		return sortie;
	}

	/**
	 * Converts a char sequence representing a BinTree to an actual BinTree object.
	 * !! : The char sequence should be written as "(cons X Y)" or "(list X Y)" or
	 * "(nil)" where X and Y are arguments in the same form.
	 * 
	 * @param str : String representing a BinTree.
	 * @return BinTree
	 */
	public BinTree bintreeFromString(String val) {

		BinTree res = bintreeFromInt(0);
		try {
			res = bintreeFromInt(Integer.parseInt(val));
			return res;

		} catch (Exception e) {
		}

		/*
		 * if it's a string and correctly written, we start parsing to create an
		 * adequate BinTree.
		 */

		int j = 0;
		int k = 0;

		// le bintree
		Pattern p1 = Pattern.compile("([(]cons nil )+nil([)])+");
		Matcher m1 = p1.matcher(val);

		// Nombre parenthèse ouvrantes
		Pattern p2 = Pattern.compile("[(]");
		Matcher m2 = p2.matcher(val);

		// Nombre parenthèse fermantes
		Pattern p3 = Pattern.compile("[)]");
		Matcher m3 = p3.matcher(val);

		if (m1.matches()) {

			j = 0;
			k = 0;
			while (m2.find()) {
				j = j + 1;
			}
			while (m3.find()) {
				k = k + 1;
			}
			if (j == k) {
				res= bintreeFromInt(j);
			}
		}else{
			System.out.println("bintree mal formate donne nil(0)");
			res= new BinTree(val.toString(), null, null);
		}
		
		return res;
	}

	public void nonImpl(){
		
	}


	/**
	 * Converts a given BinTree object to an Integer.
	 * 
	 * @param tree : BinTree object.
	 * @return Integer representing param tree.
	 */
	public Integer bintreeToInt(BinTree tree) {
		int res = 0;
		if (tree != null) {
			if (tree.getData() == "cons" || tree.getData() == "list") {
				res++;
				res += bintreeToInt(tree.getRight());
			}
			;
		}
		;
		return res;
	}

	/**
	 * Constructs a bintree from a given Integer.
	 * 
	 * @param int : Integer to convert.
	 * @return BinTree.
	 */
	public BinTree bintreeFromInt(int a) {
		BinTree res = new BinTree("nil", null, null);
		if (a != 0) {
			for (int i = 0; i < a; i++) {
				BinTree tmp = new BinTree("nil", null, null);
				res = new BinTree("cons", tmp, res);
			}
		}
		return res;
	}
	
	public static void setupWH() {
		
	}

	/**
	 * @param argc
	 * @param args permettant
	 */
	public static void main(Integer argc, String[] args) {
		setupWH();// installation de l'environnement while
//		in=inWH(argc,argv);// utilisation des parametre
//		out=f0(in);
//		outWH(out);
	}

	
}
