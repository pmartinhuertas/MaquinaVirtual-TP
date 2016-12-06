package tp.pr2.mv.bytecodes;


public abstract class Arithmetics extends ByteCode{

	public ByteCode Parse(String[] words){
		if(words.length !=1) return null;
		else return this.parseAux(words[0]);
	}
	
	public boolean execute() {
		return true;
	}
}
