package compilation;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

import compilation.Libwh;
import compilation.BinTree;
import java.util.function.Function;




public class Test {
	public static Libwh libwh = new Libwh();
	
	
		
  	public static List<BinTree> f0(BinTree A2, BinTree B3){

			List<BinTree> out = new ArrayList<BinTree>();
			List<BinTree> args0 = new ArrayList<BinTree>();
			args0.add(A2);
			args0.add(B3);
			LinkedList<BinTree> expr2 = new LinkedList<BinTree>();
			expr2.addAll(f1(args0));
			BinTree expr3 = expr2.pop();
			BinTree expr4 = expr2.pop();
			BinTree aff2 = expr4;
			BinTree aff1 = expr3;
			A2 = aff1;
			B3 = aff2;
			List<BinTree> args1 = new ArrayList<BinTree>();
			args1.add(B3);
			args1.add(A2);
			LinkedList<BinTree> expr5 = new LinkedList<BinTree>();
			expr5.addAll(f1(args1));
			BinTree expr6 = expr5.pop();
			BinTree expr7 = expr5.pop();
			BinTree aff4 = expr7;
			BinTree aff3 = expr6;
			B3 = aff3;
			A2 = aff4;
			out.add(B3);
			return out;
			
  	}
  	public static List<BinTree> f1(List<BinTree> params){
			BinTree X0, Y1;
				
			X0=params.get(0); Y1=params.get(1);
			List<BinTree> out = new ArrayList<BinTree>();
			int loop0 = libwh.intFromBintree(X0);
			for (int i0 = 0; i0 < loop0; i0++){
			BinTree expr0 = X0;
			BinTree expr1 = libwh.nil();
			expr0 = libwh.cons(expr1, expr0);
			BinTree aff0 = expr0;
			X0 = aff0;
			}
			out.add(X0);
			out.add(Y1);
			return out;
			
  	}
	public static void main(String[] args){
	
		if((args.length!=3)||(args.length<=0)){	
			System.out.println("La fonction prend 2 parametres\n mais vous avez donnez "+args.length);
		}else{	
			for(int i=0;i<args.length ;i++){
				System.out.println("Params:  "+args[i]);
			}
			List<BinTree> mainWhile=f0(libwh.bintreeFromString(args[1]), libwh.bintreeFromString(args[2]));
			for(BinTree valeur:mainWhile){
				System.out.println("Value of BinTree : "+libwh.intFromBintree(valeur));	
			}		
		}
	}
}
