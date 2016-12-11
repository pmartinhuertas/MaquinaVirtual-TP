package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public class Halt extends ByteCode{

	@Override
	public boolean execute(CPU cpu) {
		cpu.setHalt(true);
		return true;
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length==1&&words[0].equals("HALT"))return new Halt();
		return null;
	}
	public String toString(){
		return "HALT";
	}

}
