/**
 * 
 */
package compilation;

import java.util.ArrayList;
import java.util.List;
import compilation.BinTree;
import java.util.function.Function;
import javax.script.*;

/**
 * @author sievi
 *
 */
public class Libwh {

	/**
	 * 
	 */
	public Libwh() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public void nop() {
	}

	public BinTree nil() {
		return new BinTree("nil", null, null);
	}

	public BinTree cons(BinTree addr2, BinTree addr3) {
		BinTree bt = new BinTree("cons", addr2, addr3);
		List<BinTree> args = new ArrayList<BinTree>();
		args.add(addr2); // clone the addr2
		if (addr3 != null) {
			args.add(addr3); // clone the addr3
		}
		return bt.cons(args); // return the new bintree
	}

	public BinTree list(BinTree addr2, BinTree addr3) {
		BinTree bt = new BinTree("nill", addr2, addr3);
		List<BinTree> args = new ArrayList<BinTree>();
		args.add(addr2); // clone the addr2
		args.add(addr3); // clone the addr3
		return bt.list(args); // return the new bintree
	}

	public BinTree hd(BinTree addr2) {
		BinTree bt = new BinTree("nill", null, null);
		return bt.head(addr2);
	}

	public BinTree tl(BinTree addr2) {
		BinTree bt = new BinTree("nill", null, null);
		return bt.tail(addr2);
	}

	public BinTree not(BinTree addr2) {
		BinTree bt = new BinTree("nill", null, null);
		if (bt.isTrue(addr2)) {
			return bt;
		} else {
			return new BinTree("cons", new BinTree("nil", null, null), new BinTree("nil", null, null));
		}
	}

	public boolean isTrue(BinTree tree) {

		if (tree.getData() != "nil")
			return true;
		return false;

	}

	public BinTree and(BinTree addr2, BinTree addr3) {
		BinTree bt = new BinTree("AND", null, null);
		return bt.evaluate("AND", addr2, addr3);
	}

	public BinTree or(BinTree addr2, BinTree addr3) {
		BinTree bt = new BinTree("OR", null, null);
		return bt.evaluate("OR", addr2, addr3);
	}

	public BinTree eq(BinTree addr2, BinTree addr3) {
		BinTree bt = new BinTree("EQ", null, null);
		return bt.evaluate("EQ", addr2, addr3);
	}

	public BinTree symb(String addr2) { // here, a symbol is given so we need to return a bintree with the symbol as
										// data
		return bintreeFromString(addr2);
	}

	/**
	 * @params : BinTree
	 * 
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
	 * @param {*} str : String representing a BinTree.
	 */
	public BinTree bintreeFromString(String val) {

		/* if the parameter is an int, launch public BinTree bintreeFromInt. */
		String subVal = "";
		int h = 0;
		BinTree res = bintreeFromInt(0);
		try {
			res = bintreeFromInt(Integer.parseInt(val));
			return res;

		} catch (Exception e) {
			// System.out.println("Ce n'est pas un entier");
		}

		/*
		 * if it's a string and correctly written, we start parsing to create an
		 * adequate BinTree.
		 */

		if (val.charAt(0) == '(') {

			int a = StringBinTree(val, h);

			res = bintreeFromInt(a);

			return res;

		} else // we create a symbol
		{
			res = new BinTree(val.toString(), null, null);
		}
		return res;
	}

	public Integer StringBinTree(String val, int k) {
		int i = 0;
		// System.out.println(val.substring(6, 9));
		if (val.substring(i + 1, i + 5).equals("cons")/* || "list" == val.substring(i + 1, i + 5) */) {
			if ((val.substring(i + 6, i + 9).equals("nil")) && (!val.substring(10, val.length() - 1).equals("nil"))) {
				//System.out.println(k);
				val = val.substring(10, val.length() - 1);
				k++;
				k = StringBinTree(val, k);
			} else if ((val.substring(i + 6, i + 9).equals("nil"))
					&& (val.substring(10, val.length() - 1).equals("nil"))) {
				k++;
			} else {
				// System.out.println("bintree mal format�");
				return null;
			}

		} else {
			System.out.println("symbole");
			return null;
		}
		return k;
	}

	/**
	 * Parsing : Finding the position of the next '(' parenthesis of a char sequence
	 * representing a BinTree.
	 * 
	 * @param {*} str : Char Sequence representing a BinTree object.
	 * @param {*} position : Integer representing our position in str.
	 * @returns position of the next '('.
	 */
	public Integer getOpenParenthesis(CharSequence str, Integer position) {
		while (str.charAt(position) != '(' && position <= str.length()) {
			position++;
		}
		if (position > str.length()) {
			return -1;
		}
		return position;
	};

	public void nonImpl(){
		
	}
	/**
	 * Parsing : Finding the position of the next ')' parenthesis of a string, from
	 * a '(' parenthesis.
	 * 
	 * @param {*} str : Char Sequence representing a BinTree object.
	 * @param {*} position : Integer representing the position of the previous
	 *            opening parenthesis.
	 * @returns position of the closing parenthesis, if there was an opening
	 *          parenthesis found previously.
	 */
	public Integer getCloseParenthesis(CharSequence str, Integer position) {
		if (str.charAt(position) != '(') {
			return -1;
		}
		int nbOpenParenthesis = 1;
		boolean found = false;
		while (!found) {
			position++;
			if (str.charAt(position) == ')') {
				if (nbOpenParenthesis == 1) {
					found = true;
				} else {
					nbOpenParenthesis--;
				}
			} else if (str.charAt(position) == '(') {
				nbOpenParenthesis++;
			}
		}
		return position;
	};

	/**
	 * Converts a given BinTree object to an Integer.
	 * 
	 * @param {*} tree : BinTree object.
	 * @returns Integer representing param tree.
	 */
	public Integer intFromBintree(BinTree tree) {
		int res = 0;
		if (tree != null) {
			if (tree.getData() == "cons" || tree.getData() == "list") {
				res++;
				res += intFromBintree(tree.getRight());
			}
			;
		}
		;
		return res;
	}

	/**
	 * Constructs a bintree from a given Integer.
	 * 
	 * @param {*} int : Integer to convert.
	 * @returns BinTree.
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
