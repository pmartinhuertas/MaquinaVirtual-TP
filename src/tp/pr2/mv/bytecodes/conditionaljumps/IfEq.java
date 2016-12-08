package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfEq extends ConditionalJumps{
	
	public IfEq(int num){
		super(num);
	}
	
	public IfEq(){
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFEQ")) return new IfEq(salto);
		else return null;
	}
	public String toString(){
		return "IFEQ "+this.salto;
	}

	@Override
	public boolean execute(int op1, int op2) {
		return op1 == op2;
	}
}
