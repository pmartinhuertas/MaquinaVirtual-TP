package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Div extends Arithmetics{

	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("DIV")) return new Div();
		else return null;
	}
	
	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}
	public String toString(){
		return "DIV";
	}
	
	public Integer execute(int op1,int op2) {
		if(op2 == 0) return null;
		return op1/op2;
	}
}
