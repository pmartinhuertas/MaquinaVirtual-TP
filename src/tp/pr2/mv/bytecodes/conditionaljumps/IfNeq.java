package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfNeq extends ConditionalJumps{

	public IfNeq(int num){
		super(num);
	}
	public IfNeq(){
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFNEQ")) return new IfNeq(salto);
		else return null;
	}
	public String toString(){
		return "IFNEQ "+this.salto;
	}
	@Override
	public boolean execute(int op1, int op2) {
		return op1 != op2;
	}

}
