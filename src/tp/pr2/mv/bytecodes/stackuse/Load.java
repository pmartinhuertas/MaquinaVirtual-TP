package tp.pr2.mv.bytecodes.stackuse;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ByteCode;
import tp.pr2.mv.bytecodes.StackUse;

public class Load extends StackUse{
	
	public Load(){	}
	public Load(int par){
		super(par);
	}
	@Override
	public boolean execute(CPU cpu) {
		return cpu.exeload(this.parametro);
	}
	@Override
	public ByteCode parseAux(String word, int par) {
		if(word.equalsIgnoreCase("LOAD"))return new Load(par);
		return null;
	}
}
