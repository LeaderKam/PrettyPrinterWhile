package compilation;

import java.util.ArrayList;
import java.util.List;

import compilation.Libwh;
import compilation.BinTree;
import java.util.function.Function;
import javax.script.*;
import java.util.HashMap;
import java.util.Map;


public class FichierSource {
	public static Libwh libwh = new Libwh();
	public static Map<String,Integer> paramsFunctions= new HashMap<String,Integer>();


  	public static List<BinTree> f1(BinTree paramX, BinTree paramY){
		List<BinTree> aff=new ArrayList<BinTree>() ;
		List<BinTree> expr=new ArrayList<BinTree>() ;
		List<BinTree> i=new ArrayList<BinTree>() ;
		List<BinTree> loop=new ArrayList<BinTree>() ;
		List<BinTree> args=new ArrayList<BinTree>() ;
		List<BinTree> whileVar=new ArrayList<BinTree>() ;
		List<BinTree> out=new ArrayList<BinTree>() ;
		
		libwh.nop();
		out.add(paramX);
		return out;
  	}
	public static void main(String[] args){
		if(args.length>0){	
			if(args.length==1){
				BinTree paramX= libwh.bintreeFromString(args[0]);
				System.out.println("ToString binTree : "+libwh.bintreeToString(paramX));
			}else{	
				for(int i=0;i<args.length ;i++){
					System.out.println("Params:  "+args[i]);
				//for(int i=0;i<args.length -1<i++){
				//	BinTree "param"+(i+1)= libwh.bintreeFromString(args[1]);
				}
				BinTree paramX= libwh.bintreeFromString(args[1]);
				BinTree paramY= libwh.bintreeFromString(args[2]);
				System.out.println("ToString binTree : "+libwh.bintreeToString(paramX));
		
				List<BinTree> a=f1(paramX, paramY);
				System.out.println("Int of BinTree : "+libwh.intFromBintree(a.get(0)));	
			}			
		}else{
			System.out.println("pas*********");
				
		}
	}
}
