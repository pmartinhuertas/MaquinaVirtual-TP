package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Div extends Arithmetics{

	@Override
	public boolean execute(CPU cpu) {
		int sol=0;int extra = 0; Integer aux = null;
		aux = cpu.pop_back();
		if(aux==null)return false;
		else if (aux == 0) return false;
		extra = aux;
		aux = cpu.pop_back();
		if(aux==null) return false;
		sol = aux / extra;
		cpu.push_back(sol);
		return true;
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
