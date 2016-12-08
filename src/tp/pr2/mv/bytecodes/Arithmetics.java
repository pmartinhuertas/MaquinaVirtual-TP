package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public abstract class Arithmetics extends ByteCode{
	
	abstract public Integer execute(int op1, int op2);
	
	public boolean execute(CPU cpu){
		int op1 = 0; int op2 = 0; Integer aux = null;
		aux = cpu.pop_back();
		if(aux==null) return false;
		op2 = aux;
		aux = cpu.pop_back();
		if(aux==null) return false;
		op1 = aux;
		Integer sol = execute(op1, op2);
		if (sol == null) return false;
		cpu.push_back(sol);
		cpu.sigPC();
		return true;
	}

	abstract public ByteCode parseAux (String word);

	public ByteCode Parse(String[] words){
		if(words.length !=1) return null;
		else return this.parseAux(words[0]);
	}
}
