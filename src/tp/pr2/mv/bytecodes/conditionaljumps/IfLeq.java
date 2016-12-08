package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfLeq extends ConditionalJumps{

	public IfLeq(int num){
		super(num);
	}
	public IfLeq(){
	}
	
	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFLEQ")) return new IfLeq(salto);
		else return null;
	}
	public String toString(){
		return "IFLEQ "+this.salto;
	}
	@Override
	public boolean execute(int op1, int op2) {
		return op1 <= op2;
	}

}
