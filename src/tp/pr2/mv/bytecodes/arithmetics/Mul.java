package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Mul extends Arithmetics {
	@Override
	public boolean execute(CPU cpu) {
		return cpu.exeMul();
	}
	
	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("Mul")) return new Mul();
		else return null;
	}

	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}
	public String toString(){
		return "MUL";
	}
}
