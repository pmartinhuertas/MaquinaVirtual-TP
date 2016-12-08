package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public class Halt extends ByteCode{

	@Override
	public boolean execute(CPU cpu) {
		return cpu.exehalt();
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length==1&&words[1]=="HALT")return new Halt();
		return null;
	}
	public String toString(){
		return "HALT";
	}

}
