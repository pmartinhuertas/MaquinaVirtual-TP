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
		if (cpu.readMem(parametro) == null) cpu.writeMem(parametro, 0);
		cpu.push_back(cpu.readMem(parametro));
		cpu.sigPC();
		return true;
	}
	@Override
	public ByteCode parseAux(String word, int par) {
		if(word.equalsIgnoreCase("LOAD"))return new Load(par);
		return null;
	}
	public String toString(){
		return "LOAD "+this.parametro;
	}
}
