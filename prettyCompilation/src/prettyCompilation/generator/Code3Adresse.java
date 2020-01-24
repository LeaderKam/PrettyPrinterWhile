package prettyCompilation.generator;

import java.util.LinkedList;
import java.util.List;

public class Code3Adresse {
	String op;
	String addr1;
	String addr2;
	String addr3;
	private int count=0;

	List<Code3Adresse> alors, sinon;

	//Code 3@
	public Code3Adresse(String op, String addr1, String addr2, String addr3) {
		super();
		this.op = op;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.addr3 = addr3;
		
		this.alors = null;
		this.sinon = null;
		
		switch(this.op) {
		case "while" : 
		case "foreach" :
		case "for" :
			alors = new LinkedList<Code3Adresse>();
			break;
		case "if":
			alors = new LinkedList<Code3Adresse>();
			sinon = new LinkedList<Code3Adresse>();
			break;
		default :
			break;
		}
	}

	@Override
	public String toString() {
		//return "<" + op + ", " + addr1 + ", " + addr2 + ", " + addr3+ ">";
		return "<" + op+" " +((alors!=null)?alors.toString():"")+((sinon!=null)?" ELSE "+sinon.toString():"")+", " + addr1 + ", " + addr2 + ", " + addr3+ ">";
	}
	public String compile() {
		String res = "";
		switch(this.op) {
		case "nop" :
			return "libwh.nop();";
		case "ret" :
			return "return "+addr1+";";
		case "push":
			return addr1+".add("+addr2+");";
		case "array":
			return "List<BinTree> "+addr1+" = new ArrayList<BinTree>();";
		case "subarray":
			return "List<BinTree> "+ addr1+" = new ArrayList<BinTree>();";
		case "aff":
			return "BinTree "+ addr1+" = "+addr2+";";
		case "affVariable":
			return addr1+" = "+addr2+";";
		case "affWhile":
			return addr1+" = "+addr2+";";
		case "nil":
			return "BinTree "+addr1+" = libwh.nil();";
		case "cons":
			return addr1+" = libwh.cons("+addr2+", "+addr3+");"; // return concaténation de addr2(gauche) et addr3(droite) 
			// Attention à bien différentier si addr3 est un bintree ou pas. Si oui, merger, sinon, retourner addr2 sans concaténation (ca veut dire que c'est l'init)!
		case "hd":
			return "BinTree "+addr1+" = libwh.hd("+addr2+");";
		case "tl":
			return "BinTree "+addr1+" = libwh.tl("+addr2+");";
		case "not":
			return "BinTree "+addr1+" = libwh.not("+addr2+");";
		case "and":
			return "BinTree "+addr1+" = libwh.and("+addr2+","+addr3+");";
		case "or":
			return "BinTree "+addr1+" = libwh.or("+addr2+","+addr3+");";
		case "=?":
			return "BinTree "+addr1+" = libwh.eq("+addr2+","+addr3+");";
		case "symb":
			return "BinTree "+addr1+" = libwh.symb(\'"+addr2+"\');";
		case "btoi":
			return "BinTree "+addr1+" = libwh.intFromBintree("+addr2+");";
		case "call":
			return "LinkedList<BinTree> "+ addr3+" = new LinkedList<BinTree>();\n"+
					addr3+".addAll("+addr1+"("+addr2+"));";
		case "pop" :
			return "BinTree "+addr1+" = "+addr2+".pop();";
		case "while":
			for(Code3Adresse Code3Adresse : alors)
				res += Code3Adresse.compile()+"\n";
			return "while(libwh.isTrue("+addr2+")){\n"+res+"}";
		case "foreach":
			res+=addr3+" = libwh.hd("+addr1+")\n";
			for(Code3Adresse Code3Adresse : alors)
				res += Code3Adresse.compile()+"\n";
			res+=addr1+" = libwh.tl("+addr1+")\n";
			return addr1+" = "+addr2+";\nwhile(libwh.isTrue("+addr1+")){\n"+res+"}";
		case "for":
			for(Code3Adresse Code3Adresse : alors)
				res += Code3Adresse.compile()+"\n";
			return "int "+addr1+" = libwh.intFromBintree("+addr2+");\nfor (int "+addr3+" = 0; "+addr3+" < "+addr1+"; "+addr3+"++){\n"+res+"}";
		case "if":
			for(Code3Adresse Code3Adresse : alors)
				res += Code3Adresse.compile()+"\n";
			res = "if (libwh.isTrue("+addr2+")){\n"+res+"}";
			if(!sinon.isEmpty()) {
				res+="\nelse{\n";
				for(Code3Adresse Code3Adresse : sinon)
					res += Code3Adresse.compile()+"\n";
				res+="}";
			}
			return res;
		default :
			return "libwh.nonImpl();";
		}
	}

	public List<Code3Adresse> getAlors() {
		return alors;
	}

	public List<Code3Adresse> getSinon() {
		return sinon;
	}

}