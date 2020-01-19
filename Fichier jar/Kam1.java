package compilation;

import java.util.ArrayList;
import java.util.List;

import compilation.Libwh;
import compilation.BinTree;
import java.util.function.Function;
import javax.script.*;
import java.util.HashMap;
import java.util.Map;


public class Kam {
	public static Libwh libwh = new Libwh();
	public static Map<String,Integer> paramsFunctions= new HashMap<String,Integer>();
	
	
  	public static List<BinTree> f0(BinTree A2, BinTree B3, BinTree C4){
		Map<Integer,List<BinTree>> aff = new HashMap<Integer,List<BinTree>>();
		
		//utilisé pour mettre les valeurs des arguments
		Map<Integer,List<BinTree>> args = new HashMap<Integer,List<BinTree>>();
		
		//utilisé pour mettre les valeurs des expressions
		Map<Integer,List<BinTree>> expr = new HashMap<Integer,List<BinTree>>();
		
		args.put(0,new ArrayList<BinTree>());
		aff.put(0,new ArrayList<BinTree>());
		
		List<BinTree> out = new List<BinTree>();
		
		//utilisé pour mettre les arguments
		args.get(0);
		args.get(0).add(B3);
		args.get(0).add(C4);
		//expr.get(0).add(f1(args.get(0).get(0), args.get(0).get(1)));
		//expr.get(1).add(expr.get(0)); 
		expr.put(0,f1(args.get(0).get(0), args.get(0).get(1)));
		expr.put(1,expr.get(0)); 
		
		for (BinTree a:expr.get(1)){
			aff.get(0).add(a);
		}
		A2 = aff.get(0);
		
		
		args.get(1);
		args.get(1).add(B3);
		args.get(1).add(C4);
		//expr.get(2).add(f1(null, args.get(1).get(0)));
		//expr.get(3).add(expr.get(2)); 
		//expr.get(2).remove();

		expr.put(2,f1(null, args.get(1).get(0)));
		expr.put(3,expr.get(2)); 

		for(BinTree a: expr.get(3)){
			aff.get(1).add(a);
		}
		B3 = aff.get(1).get(0);
		
		
		out.add(A2);
		return out;
		
  	}
  	public static List<BinTree> f1(BinTree X0, BinTree Y1){
		Map<Integer,List<BinTree>> whileVar = new HashMap<Integer,List<BinTree>>();
		whileVar.put(0,new ArrayList<BinTree>());
		List<BinTree> out = new List<BinTree>();
		libwh.nop();
		out.add(X0);
		return out;
		
  	}
	public static void main(String[] args){
		
		if((args.length!=3)||(args.length<=0)){	
			System.out.println("La fonction prend 3 parametres\n mais vous avez donnez "+args.length);
		}else{	
			for(int i=0;i<args.length ;i++){
				System.out.println("Params:  "+args[i+1]);
			}
			List<BinTree> mainWhile=f0(libwh.binTreeFromString(args[1], libwh.binTreeFromString(args[2], libwh.binTreeFromString(args[3]));
			for(BinTree valeur:mainWhile){
				System.out.println("Value of BinTree : "+libwh.intFromBintree(valeur));	
			}		
		}
	}
}
