package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public abstract class StackUse extends ByteCode{
	protected int parametro;
	
	public StackUse(){	}
	public StackUse(int par){
		this.parametro=par;
	}
	
	
	abstract public boolean execute(CPU cpu);
	
	abstract public ByteCode parseAux(String word, int par);
	@Override
	public ByteCode parse(String[] words) {
		if(words.length!=2)return null;
		else return this.parseAux(words[0], Integer.parseInt(words[1]));
	}

}
