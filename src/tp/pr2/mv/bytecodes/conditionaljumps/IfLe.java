package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfLe extends ConditionalJumps{

	public IfLe(int num){
		super(num);
	}
	public IfLe(){
		
	}
	@Override
	public boolean execute(CPU cpu) {
		return cpu.exeIfle(this.salto);
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFLE")) return new IfLe(salto);
		else return null;
	}
}
