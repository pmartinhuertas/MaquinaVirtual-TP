package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Add extends Arithmetics{
	
	@Override
	public boolean execute(CPU cpu) {
		return cpu.exeAdd();
	}
	
	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}

	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}



}
