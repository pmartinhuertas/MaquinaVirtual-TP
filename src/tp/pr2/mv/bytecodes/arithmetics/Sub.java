package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Sub extends Arithmetics{


	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}
	
	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}
	public String toString(){
		return "SUB";
	}

	@Override
	public Integer execute(int op1, int op2) {
		return op1 - op2;
	}
}
