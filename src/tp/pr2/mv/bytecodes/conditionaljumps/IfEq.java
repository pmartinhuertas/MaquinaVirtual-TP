package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.arithmetics.Add;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfEq extends ConditionalJumps{
	
	public IfEq(int num){
		super(num);
	}
	
	public IfEq(){
	}
	@Override
	public boolean execute(CPU cpu) {
		return cpu.exeIfeq(this.salto);
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFEQ")) return new IfEq(salto);
		else return null;
	}

}
