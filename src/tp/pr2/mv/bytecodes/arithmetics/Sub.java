package tp.pr2.mv.bytecodes.arithmetics;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.Arithmetics;
import tp.pr2.mv.bytecodes.ByteCode;

public class Sub extends Arithmetics{

	@Override
	public boolean execute(CPU cpu) {
		int sol=0; Integer aux = null;
		aux = cpu.pop_back();
		if(aux==null)return false;
		sol-=aux;
		aux = cpu.pop_back();
		if(aux==null) return false;
		sol+=aux;
		cpu.push_back(sol);
		return true;
	}

	public ByteCode parseAux(String word){
		if (word.equalsIgnoreCase("SUB")) return new Sub();
		else return null;
	}
	
	@Override
	public ByteCode parse(String[] words) {
		return super.Parse(words);
	}

}
