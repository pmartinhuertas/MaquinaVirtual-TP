package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Div extends Arithmetics{

	@Override
	public boolean execute(CPU cpu) {
		return cpu.exeDiv();
	}

	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("DIV")) return new Div();
		else return null;
	}
	
	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}

}
