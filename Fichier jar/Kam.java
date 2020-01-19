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

			List<BinTree> aff = new ArrayList<BinTree>();
			List<BinTree> expr = new ArrayList<BinTree>();
			List<BinTree> i = new ArrayList<BinTree>();
			List<BinTree> loop = new ArrayList<BinTree>();
			List<BinTree> args = new ArrayList<BinTree>();
			List<BinTree> out = new ArrayList<BinTree>();
			//addr1 = [];
			args.add(B3);
			args.add(C4);
			expr.addAll(f1(args));
			args.clear();
			//addr1  = null.shift();
			aff=expr;
			A2=aff.get(0);
			//addr1 = [];
			args.add(B3);
			args.add(C4);
			expr.addAll(f1(args));
			args.clear();
			//addr1  = null.shift();
			aff=expr;
			B3=aff.get(1);
			out.add(A2);
			out.add(B3);
			return out;
			
  	}
  	public static List<BinTree> f1(List<BinTree> params){
			BinTree X0, Y1;
				
			X0=params.get(0); Y1=params.get(1);
			List<BinTree> aff = new ArrayList<BinTree>();
			List<BinTree> expr = new ArrayList<BinTree>();
			List<BinTree> i = new ArrayList<BinTree>();
			List<BinTree> loop = new ArrayList<BinTree>();
			List<BinTree> args = new ArrayList<BinTree>();
			List<BinTree> out = new ArrayList<BinTree>();
			libwh.nop();
			out.add(X0);
			return out;
			
  	}
	public static void main(String[] args){
	
		if((args.length!=4)||(args.length<=0)){	
			System.out.println("La fonction prend 3 parametres\n mais vous avez donnez "+args.length);
		}else{	
			for(int i=0;i<args.length ;i++){
				System.out.println("Params:  "+args[i]);
			}
			List<BinTree> mainWhile=f0(libwh.bintreeFromString(args[1]), libwh.bintreeFromString(args[2]), libwh.bintreeFromString(args[3]));
			for(BinTree valeur:mainWhile){
				System.out.println("Value of BinTree : "+libwh.intFromBintree(valeur));	
			}		
		}
	}
}
