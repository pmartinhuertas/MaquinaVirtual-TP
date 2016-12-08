package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfLe extends ConditionalJumps{

	public IfLe(int num){
		super(num);
	}
	public IfLe(){
		
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFLE")) return new IfLe(salto);
		else return null;
	}
	public String toString(){
		return "IFLE "+this.salto;
	}
	@Override
	public boolean execute(int op1, int op2) {
		return op1 < op2;
	}
}
