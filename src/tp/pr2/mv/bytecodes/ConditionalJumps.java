package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public abstract class ConditionalJumps extends ByteCode{

	protected int salto;
	
	
	public ConditionalJumps(){};
	public ConditionalJumps(int num){
		salto = num;
	}
	
	@Override
	abstract public boolean execute(CPU cpu);
	
	
	abstract public ByteCode parseAux(String word, int salto);

	@Override
	public ByteCode parse(String[] words) {
		if(words.length !=2) return null;
		else return this.parseAux(words[0], Integer.parseInt(words[1]));
		
	}

}
