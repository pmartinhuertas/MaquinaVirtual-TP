package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfLeq extends ConditionalJumps{

	public IfLeq(int num){
		super(num);
	}
	public IfLeq(){
	}
	@Override
	public boolean execute(CPU cpu) {
		return	cpu.exeIfleq(this.salto);
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFLEQ")) return new IfLeq(salto);
		else return null;
	}
	public String toString(){
		return "IFLEQ "+this.salto;
	}

}
