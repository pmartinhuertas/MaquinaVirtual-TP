package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public abstract class Arithmetics extends ByteCode{
	
	abstract public boolean execute(CPU cpu);

	abstract public ByteCode parseAux (String word);

	public ByteCode Parse(String[] words){
		if(words.length !=1) return null;
		else return this.parseAux(words[0]);
	}
}
