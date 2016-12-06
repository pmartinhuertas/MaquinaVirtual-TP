package tp.pr2.mv.bytecodes.stackuse;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ByteCode;
import tp.pr2.mv.bytecodes.StackUse;

public class Store extends StackUse{
	public Store(int par) {
		super(par);
	}	
	public Store(){}
	public boolean execute(CPU cpu) {
		
		
		return true;
	}
	public ByteCode parseAux(String word, int par) {
		if(word.equalsIgnoreCase("STORE"))return new Store(par);
		return null;
	}
}
