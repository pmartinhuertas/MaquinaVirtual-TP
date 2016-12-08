package tp.pr2.mv.bytecodes.stackuse;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ByteCode;
import tp.pr2.mv.bytecodes.StackUse;

public class Push extends StackUse{

	public Push(int par){
		super(par);
	}
	public Push(){}
	public boolean execute(CPU cpu) {
		return cpu.exepush(this.parametro);
	}
	public ByteCode parseAux(String word, int par) {
		if(word.equalsIgnoreCase("PUSH"))return new Push(par);
		return null;
	}
	public String toString(){
		return "PUSH "+this.parametro;
	}
}
