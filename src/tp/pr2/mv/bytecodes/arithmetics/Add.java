package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Add extends Arithmetics{
	

	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("ADD")) return new Add();
		else return null;
	}

	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}
	public String toString(){
		return "ADD";
	}

	@Override
	public Integer execute(int op1, int op2) {
		return op1 + op2;
	}


}
