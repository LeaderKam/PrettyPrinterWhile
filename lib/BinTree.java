/**
 * 
 */
package compilation;

import java.util.List;
import java.util.LinkedList;

/**
 * @author sievi
 *
 */
public class BinTree {

	private String data;
	private BinTree left;
	private BinTree right;

	/**
	 * Constructor of the BinTree class.
	 * 
	 * @param data : Value of the node.
	 * @param leftTree : data's left BinTree.
	 * @param rightTree : data's right BinTree.
	 */
	public BinTree(String data, BinTree leftTree, BinTree rightTree) {
		this.data = data;
		if (this.data != "nil") {
			this.left = leftTree;
			this.right = rightTree;
		} else {
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * @return data
	 */
	public String getData() {
		return data;	
	}

	/**
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;	
	}

	/**
	 * @return left BinTree
	 */
	public BinTree getLeft() {
		return left;	
	}

	/**
	 * @param leftTree
	 */
	public void setLeft(BinTree leftTree) {
		if (leftTree.getData() != "nil") {
			this.left = leftTree;
		}	
	}

	/**
	 * @return right BinTree
	 */
	public BinTree getRight() {
		return right;	
	}

	public void setRight(BinTree rightTree) {
		if (rightTree.getData() != "nil") {
			this.right = rightTree;
		}
	}

	

	/**
	 * @param tree : BinTree object.
	 * @returns the head of tree. If its left son equals to null, will return null.
	 */
	public BinTree head(BinTree tree) {
		if (tree.getLeft() != null) {
			return tree.getLeft();
		}
		return new BinTree("nil", null, null);
	};

	/**
	 * @param tree : BinTree object.
	 * @return Bintree: the tail of tree. If its right son equals to null, will return null.
	 */
	public BinTree tail(BinTree tree) {
		if (tree.getRight() != null) {
			return tree.getRight();
		}
		return new BinTree("nil", null, null);
	};

	/**
	 * @param args : LinkedList<BinTree>
	 * @return BinTree object
	 */
	public BinTree cons(LinkedList<BinTree> args) {
		if (args != null) {
			if (args.size() == 0) {
				return new BinTree("nil", null, null);
			}

			BinTree tree = args.pop(); // return the first element of the linkedlist
			if (args.size() <= 0) {
				return tree;
			} else {
				return new BinTree("cons", tree, cons(args));
			}
		}
		return null;
	};

	/**
	 * Same as cons function but we have lists instead of cons, and we have an
	 * additional (nil) at the end of the BinTree.
	 * 
	 * @param args : LinkedList<BinTree>
	 * @return List of BinTrees from a given array of BinTrees. (nil) if it has
	 *          less than 2 elements.
	 */
	// public BinTree list(LinkedList<BinTree> args) {
	// 	if (args != null) {
	// 		if (args.size() == 0) {
	// 			return new BinTree("nil", null, null);
	// 		}

	// 		BinTree tree = args.pop();
	// 		if (args.size() <= 0) {
	// 			return new BinTree("list", tree, new BinTree("nil", null, null));
	// 		} else {
	// 			return new BinTree("list", tree, list(args));
	// 		}
	// 	}
	// 	return null;
	// };

	/**
	 * Apply the given operand to the trees.
	 * @param operand : Given operand, can be either AND, OR or EQ
	 * @param tree1 : BinTree object (left side).
	 * @param tree2 : BinTree object (right side).
	 * @return case AND : (nil) if one of the elements equals to (nil), (cons nil nil) else.
	 *          case OR : (nil) if both of the elements are equal to (nil), (cons nil nil) else.
	 *          case EQ : (nil) if the elements are not equal, (cons nil nil) else.
	 */
	public BinTree evaluate(String operand,BinTree tree1,BinTree tree2) {
	   if (operand == "AND")
	    { 
	        if(tree1.getData() == "nil" || tree2.getData() == "nil")
	        {
	            return new BinTree("nil", null, null);
	        } 
	        else
	        {
	            return new BinTree("cons", new BinTree("nil", null, null), new BinTree("nil", null, null));
	        } 
	    }else if(operand == "OR")
	    {
	        if(tree1.getData() == "nil" && tree2.getData() == "nil")
	        {
	           return new BinTree("nil", null, null); 
	        } 
	        else
	        {
	            return new BinTree("cons", new BinTree("nil", null, null), new BinTree("nil", null, null));
	        }
	    }
	    else if(operand == "EQ"){
	        if( !evaluateEQ(tree1,tree2))
	        {
	            return new BinTree("nil", null, null);
	        }else{
	            return new BinTree("cons", new BinTree("nil", null, null), new BinTree("nil", null, null));
	        }
	    }return null;

	}

	/**
	 * Evaluates tree1 and tree2 and tells if they are equal or not. This function
	 * stringifies tree1 and tree2's params and compares tree1's params with tree2's
	 * params.
	 * 
	 * @param tree1 : BinTree object.
	 * @param tree2 : BinTree object.
	 */
	public boolean evaluateEQ(BinTree tree1, BinTree tree2) {
		if (tree1.equals(tree2))
			return true;
		return false;
	}

	/**
	 * Checks if a given tree is not equal to nil.
	 * 
	 * @param tree : BinTree object.
	 */
	public Boolean isTrue(BinTree tree) {
		if (tree.getData() != "nil")
			return true;
		return false;
	}


}