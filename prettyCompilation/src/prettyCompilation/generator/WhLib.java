/**
 * 
 */
package prettyCompilation.generator;

import java.util.ArrayList;
import java.util.List;

import prettyCompilation.generator.BinTree;

/**
 * @author sievi
 *
 */
public class WhLib {

	
	/**
	 * 
	 */
	public WhLib() {
		//super();
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

	public BinTree symb(BinTree addr2) { // here, a symbol is given so we need to return a bintree with the symbol as
											// data
		return bintreeFromString((CharSequence) addr2);
	}

	/**
	 * Converts a char sequence representing a BinTree to an actual BinTree object.
	 * !! : The char sequence should be written as "(cons X Y)" or "(list X Y)" or
	 * "(nil)" where X and Y are arguments in the same form.
	 * 
	 * @param {*} str : Char Sequence representing a BinTree.
	 */
	public BinTree bintreeFromString(CharSequence addr2) {
		
		/* if the parameter is an int, launch public BinTree bintreeFromInt. */
		
		BinTree res;
		try {
			Integer bb=Integer.decode(addr2.toString());
			res = bintreeFromInt(Integer.parseInt(addr2.toString()));
		}catch (Exception e) {
			System.out.println("Pas integer");
		}
		/*
		 * if it's a string and correctly written, we start parsing to create an
		 * adequate BinTree.
		 */
		if (addr2.charAt(0) == '(') {
			int i = 0;
			if (addr2.subSequence(i + 1, i + 5) == "cons" || addr2.subSequence(i + 1, i + 5) == "list") {
				if (addr2.charAt(addr2.length() - 1) != ')') {
					System.out.println("Erreur, pas de parenthse fermante englobant l'expression entiere.");
				
				} else if (addr2.charAt(5) == ')') {
					return new BinTree("nil", null, null);
				}

				if (addr2.charAt(i + 5) != ' ') {
					System.out.println("Il faut un espace apres un cons/list. Veuillez reformuler votre BinTree.");
					return null;
				}

				CharSequence cmd;
				if ("cons" == addr2.subSequence(i + 1, i + 5) || "list" == addr2.subSequence(i + 1, i + 5)) {
					cmd = addr2.subSequence(i + 1, i + 5);
				} else {
					System.out.println("Opening Parenthesis found but not followed by a cons nor a list.");
					return null;
				}
				List<BinTree> args = new ArrayList<BinTree>();
				String newNode = "";
				int whitespaces = 0;
				i = 6;
				while (i < addr2.length()) {
					if (addr2.charAt(i) == ' ' || addr2.charAt(i) == ')') {
						if (addr2.charAt(i) == ' ') {
							if (whitespaces > 1) {
								System.out.println("Erreur, plus d'un espace entre chaque terme.");
								return null;
							}
							whitespaces++;
						}
						if (newNode != "") {
							args.add(new BinTree(newNode, null, null));
							whitespaces = 0;
							newNode = "";
						}
						i++;
						continue;
					}
					if (addr2.charAt(i) == '(') /* Case : one or multiple cons expressions in str */
					{
						Integer closeParenthesis = getCloseParenthesis(addr2, i);
						args.add(bintreeFromString(addr2.subSequence(i, closeParenthesis + 1)));
						i += addr2.subSequence(i, closeParenthesis + 1).length();
					} else /* no cons expression - only nil or symbols in str */
					{
						newNode = newNode + addr2.charAt(i);
					}
					i++;
				}
				if (addr2.charAt(i - 2) == ' ') {
					System.out.println("Erreur, un ou plusieurs espace(s) en trop avant la parenthese fermante.");
					return null;
				}

				BinTree bt;
				if (cmd == "cons") {
					bt=new BinTree("cons", null, null);
					res = bt.cons(args);
				}
				if (cmd == "list") {
					bt=new BinTree("list", null, null);
					res = bt.list(args);
				}
			}
		} else // we create a symbol
		{
			res = new BinTree(addr2.toString(), null, null);
		}
		res = new BinTree(addr2.toString(), null, null);
		return res;
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

//			module.exports = {
//			    bt: bt,
//			    nop: nop,
//			    nil: nil,
//			    cons: cons,
//			    list: list,
//			    hd: hd,
//			    tl: tl,
//			    not: not,
//			    and:  and,
//			    or: or,
//			    eq: eq,
//			    isTrue: isTrue,
//			    symb: symb,
//			    bintreeFromString: bintreeFromString,
//			    intFromBintree: intFromBintree,
//			    bintreeFromInt: bintreeFromInt,
//			    getCloseParenthesis: getCloseParenthesis,
//			    getOpenParenthesis: getOpenParenthesis
//			};

}
