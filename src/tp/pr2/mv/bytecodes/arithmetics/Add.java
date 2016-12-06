package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Add extends Arithmetics{
	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}

	@Override
	public boolean execute(CPU cpu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ByteCode parse(String[] words) {
		return null;
		
	}
}
