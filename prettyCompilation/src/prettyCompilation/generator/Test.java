/**
 * 
 */
package prettyCompilation.generator;
import java.util.ArrayList;
import java.util.List;

import prettyCompilation.generator.WhLib;
import prettyCompilation.generator.BinTree;
import org.eclipse.xtext.xtext.generator.junit.Junit4Fragment2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
/**
 * @author sievi
 *
 */
public class Test {

	public static WhLib wh;

//bt =wh.bt;
//binTree = new BinTree();


//describe('BinTree Test Session', function() {
//  describe('#binTreeFromInt()', function() {
//    it('Converts the value 0 to BinTree, should return the following BinTree : nil.', function() {
//      assert.isTrue(bt.evaluateEQ(wh.bintreeFromInt(0), new BinTree("nil", null, null)));
//    });
//    it('Converts the value 1 to BinTree, should return the following BinTree : (cons nil nil).', function(){
//       t = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       args = [];
//      args.push(t); args.push(t2);
//      assert.isTrue(bt.evaluateEQ(wh.bintreeFromInt(1), bt.cons(args)));
//    });
//    it('Converts the value 2 to BinTree, should return the following BinTree : (cons nil (cons nil nil).', function(){
//       t = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       args = [];
//       args2 = [];
//      args.push(t); args.push(t2); 
//      args2.push(t3); args2.push(bt.cons(args));
//
//      assert.isTrue(bt.evaluateEQ(wh.bintreeFromInt(2), bt.cons(args2)));
//    });
//  });
//  describe('#intFromBinTree()', function(){
//    it(('Converting nil to int should return the value 0.'), function(){ 
//       tree = new BinTree("nil", null, null);
//      assert.equal(wh.intFromBintree(tree), 0);
//    });
//    it(('Converting (cons) to int should return the value 0.'), function(){
//       args = [];
//      assert.equal(wh.intFromBintree(bt.cons(args)), 0);
//    });
//    it(('Converting (list) to int should return the value 0.'), function(){
//       args = [];
//      assert.equal(wh.intFromBintree(bt.list(args)), 0);
//    });
//
//    it(('Converting (cons (nil)) to int should return the value 0.'), function(){
//       t = new BinTree("nil", null, null);
//       args = [];
//      args.push(t); 
//      assert.equal(wh.intFromBintree(bt.cons(args)), 0);
//    });
//
//    it(('Converting (cons(nil)(nil)) to int should return the value 1.'), function(){
//       t = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       args = [];
//      args.push(t); args.push(t2); 
//      assert.equal(wh.intFromBintree(bt.cons(args)), 1);
//    });
//    
//    it(('Converting (list(nil)(nil)) to int should return the value 2.'), function(){ 
//       t = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       args = [];
//      args.push(t); args.push(t2); 
//      assert.equal(wh.intFromBintree(bt.list(args)), 2);
//    });
//  });
//
//  describe(('#bintreeFromInt and #intFromBintree'), function(){
//    it(('Converting int to Bintree and deconverting it, should return the same int'), function(){
//        assert.equal(5, wh.intFromBintree(wh.bintreeFromInt(5)));
//    });
//    it(('Deconverting and converting BinTree (cons(nil)(cons(nil)(nil))), should return the same BinTree'), function(){
//         t = wh.bintreeFromString("(cons nil nil nil)");
//        assert.isTrue(bt.evaluateEQ(t, wh.bintreeFromInt(wh.intFromBintree(t))));
//    });
//  });
//  
//  describe(('#bintreeFromString()'), function(){
//    it(('Should convert a stringified int to a BinTree.'), function(){
//       t = wh.bintreeFromInt(5);
//      assert.isTrue(bt.evaluateEQ(wh.bintreeFromString("5"), t));
//    });
//    it(('Converting nil to a BinTree.'), function(){
//       t = new BinTree("nil", null, null);
//      assert.isTrue(bt.evaluateEQ(wh.bintreeFromString("nil"), t))
//    });
//    it(('Should convert a symbol to BinTree with symbol as the only node inside the BinTree.'), function(){
//       t = new BinTree("symbol", null, null);
//      assert.isTrue(bt.evaluateEQ(wh.bintreeFromString("symbol"), t));
//    });
//    it(('Should convert the following char sequence : (cons) to a BinTree.'), function(){
//       t = new bt.BinTree("nil", null, null);
//      assert.isTrue(bt.evaluateEQ(t, wh.bintreeFromString("(cons)"))); 
//    });
//    it(('Should convert the following char sequence : (list) to a BinTree.'), function(){
//       args = [];
//      assert.isTrue(bt.evaluateEQ(bt.list(args), wh.bintreeFromString("(list)"))); 
//    });
//    it(('Should convert the following char sequence : (list) to a BinTree : (cons).'), function(){
//       args = [];
//      assert.isTrue(bt.evaluateEQ(bt.list(args), wh.bintreeFromString("(cons)"))); 
//    });
//    it(('Should convert the following char sequence : (cons) to a BinTree : (list).'), function(){
//       args = [];
//      assert.isTrue(bt.evaluateEQ(bt.cons(args), wh.bintreeFromString("(list)"))); 
//    });
//    it(('Should convert the following char sequence : (cons nil) to a BinTree.'), function(){
//       t = new BinTree("nil", null, null);
//       args = [];
//      args.push(t);
//      assert.isTrue(bt.evaluateEQ(bt.cons(args), wh.bintreeFromString("(cons nil)"))); 
//    });
//    it(('Should convert the following char sequence : (list nil) to a BinTree.'), function(){
//       t = new BinTree("nil", null, null);
//       args = [];
//      args.push(t);
//    
//      assert.isTrue(bt.evaluateEQ(bt.list(args), wh.bintreeFromString("(list nil)"))); 
//    });
//    it(('Should convert the following char sequence : (list nil nil) to a BinTree.'), function(){
//       args = [];
//      args.push(new BinTree("nil", null, null));
//      args.push(new BinTree("nil", null, null));    
//      assert.isTrue(bt.evaluateEQ(bt.list(args), wh.bintreeFromString("(list nil nil)"))); 
//    });
//    it(('Should convert the following char sequence : (cons nil nil nil bonjour) to a BinTree.'), function(){
//       args = [];
//      args.push(new BinTree("nil", null, null));
//      args.push(new BinTree("nil", null, null));
//      args.push(new BinTree("nil", null, null));
//      args.push(new BinTree("bonjour", null, null));
//      assert.isTrue(bt.evaluateEQ(bt.cons(args), wh.bintreeFromString("(cons nil nil nil bonjour)"))); 
//    });
//    it(('Should convert the following char sequence : (list nil nil nil) to a BinTree.'), function(){
//       args = [];
//      args.push(new BinTree("nil", null, null));
//      args.push(new BinTree("nil", null, null));
//      args.push(new BinTree("nil", null, null));    
//      assert.isTrue(bt.evaluateEQ(bt.list(args), wh.bintreeFromString("(list nil nil nil)"))); 
//    });
//    it(('Should convert the following char sequence : (cons nil (cons nil nil)) to a BinTree.'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       args = [];
//       args2 = [];
//      args.push(t2); args.push(t3); 
//      args2.push(t1); args2.push(bt.cons(args));
//      assert.isTrue(bt.evaluateEQ(bt.cons(args2), wh.bintreeFromString("(cons nil (cons nil nil))")));
//    });
//    it(('Should convert the following char sequence : (cons un (cons deux trois)) to a BinTree.'), function(){
//       t1 = new BinTree("un", null, null);
//       t2 = new BinTree("deux", null, null);
//       t3 = new BinTree("trois", null, null);
//       args = [];
//       args2 = [];
//      args.push(t2); args.push(t3); 
//      args2.push(t1); args2.push(bt.cons(args));
//      assert.isTrue(bt.evaluateEQ(bt.cons(args2), wh.bintreeFromString("(cons un (cons deux trois))")));
//    });
//    it(('Should convert the following char sequence : (cons nil (cons nil nil) nil) to a BinTree.'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       t4 = new BinTree("nil", null, null);
//
//       args = [];
//       args2 = [];
//      args.push(t2); args.push(t3); 
//      args2.push(t1); args2.push(bt.cons(args)); args2.push(t4);
//      assert.isTrue(bt.evaluateEQ(bt.cons(args2), wh.bintreeFromString("(cons nil (cons nil nil) nil)")));
//    });
//    describe(('EXPRESSIONS THAT SHOULD NOT BE CONVERTED'), function() {
//      it(('(cons nil nil )     : Additionnal space(s) before the closing parenthesis.'), function(){
//         args = [];
//        args.push(new BinTree("nil", null, null));
//        args.push(new BinTree("nil", null, null));
//        assert.isFalse(bt.evaluateEQ(bt.cons(args), wh.bintreeFromString("(cons nil nil )"))); 
//      });
//      it(('(cons nil nil       : Missing closing parenthesis.'), function(){
//         args = [];
//        args.push(new BinTree("nil", null, null));
//        args.push(new BinTree("nil", null, null));
//        assert.isFalse(bt.evaluateEQ(bt.cons(args), wh.bintreeFromString("(cons nil nil"))); 
//      });
//      it(('(cons   nil  nil)   : Additionnal whitespaces between two terms.'), function(){
//         args = [];
//        args.push(new BinTree("nil", null, null));
//        args.push(new BinTree("nil", null, null));
//        assert.isFalse(bt.evaluateEQ(bt.cons(args), wh.bintreeFromString("(cons  nil  nil"))); 
//      });
//    });
//      
//    
//  });
//
//  describe(('#BinTree.ToString()'), function(){
//    it(('Should print the literal expression of the BinTree : nil'), function(){
//       t = new BinTree("nil", null, null);
//
//      assert.equal(t.toString(), "nil");
//    });
//    it(('Should print the literal expression of the BinTree : (cons)'), function(){
//       args = []; 
//
//      assert.equal(bt.list(args).toString(), "nil");
//    });
//    it(('Should print the literal expression of the BinTree : (list)'), function(){
//       args = []; 
//
//      assert.equal(bt.list(args).toString(), "nil");
//    });
//    it(('Should print the literal expression of the BinTree : (cons nil nil)'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       args = []; 
//      args.push(t1); args.push(t2);
//
//      assert.equal(bt.cons(args).toString(), "(cons nil nil)");
//    });
//    it(('Should print the literal expression of the BinTree : (cons nil (cons nil nil))'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       args = []; 
//      args.push(t1); args.push(t2); args.push(t3);
//
//      assert.equal(bt.cons(args).toString(), "(cons nil (cons nil nil))");
//    });
//    it(('Should print the literal expression of the BinTree : (cons nil (cons nil nil))'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       t4 = new BinTree("nil", null, null);
//       t5 = new BinTree("nil", null, null);
//       args = []; 
//      args.push(t1); args.push(t2); args.push(t3);
//
//      assert.equal(bt.cons(args).toString(), "(cons nil (cons nil nil))");
//    });
//    
//    it(('Should print the literal expression of the BinTree : (cons nil (cons nil (cons nil (cons nil nil))))'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       t4 = new BinTree("nil", null, null);
//       t5 = new BinTree("nil", null, null);
//       args = []; 
//      args.push(t1); args.push(t2); args.push(t3); args.push(t4); args.push(t5);
//
//      assert.equal(bt.cons(args).toString(), "(cons nil (cons nil (cons nil (cons nil nil))))");
//    });
//    it(('Should print the literal expression of the BinTree : (cons nil (cons nil nil))'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       args = []; 
//      args.push(t1); args.push(t2); args.push(t3);
//      assert.equal(wh.bintreeFromString(bt.cons(args).toString()).toString(), "(cons nil (cons nil nil))");
//    });
//  });
//
//  describe(('#head(BinTree)'), function(){
//    it(('Should return the head of nil : nil'), function(){
//       t = new BinTree("nil", null, null);
//      assert.isTrue(bt.evaluateEQ(bt.head(t), t))
//    });
//    it(('Should return the head of (cons nil nil) : nil'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//      List<BinTree> args = new ArrayList<BinTree>(); 
//      args.push(t1); args.push(t2);
//      assert.isTrue(bt.evaluateEQ(bt.tail(bt.cons(args)), new BinTree("nil", null, null)))
//    });
//    it(('Should return the head of (cons (cons nil nil) nil ) : (cons nil nil)'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//      List<BinTree> args = new ArrayList<BinTree>(); 
//      args.push(t1); args.push(t2);
//       cons = new BinTree("cons", bt.cons(args), t3);
//      assert.isTrue(bt.evaluateEQ(bt.head(bt.cons(args)), bt.cons(args)))
//    });
//  });
//  describe(('#tail(BinTree)'), function(){
//    it(('Should return the head of nil : nil'), function(){
//       t = new BinTree("nil", null, null);
//      assert.isTrue(bt.evaluateEQ(bt.tail(t), t))
//    });
//    it(('Should return the tail of (cons nil nil) : nil'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       args = []; 
//      args.push(t1); args.push(t2);
//
//      assert.isTrue(bt.evaluateEQ(bt.tail(bt.cons(args)), new BinTree("nil", null, null)))
//    });
//    it(('Should return the tail of (cons nil (cons nil nil)) : (cons nil nil)'), function(){
//       t1 = new BinTree("nil", null, null);
//       t2 = new BinTree("nil", null, null);
//       t3 = new BinTree("nil", null, null);
//       t4 = new BinTree("nil", null, null);
//       t5 = new BinTree("nil", null, null);
//      List<BinTree> args,args = new ArrayList<BinTree>; //List<Integer> args2 = new ArrayList<Integer>(); 
//      args.add(t1); args.add(t2); args.add(t3);
//      args2.add(t4); args2.add(t5)
//
//      assert.isTrue(bt.evaluateEQ(bt.tail(bt.cons(args)), bt.cons(args2)))
//    });
//
//  });
//
//});
}