package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public abstract class ConditionalJumps extends ByteCode{

	protected int salto;
	
	
	public ConditionalJumps(){};
	public ConditionalJumps(int num){
		salto = num;
	}
	
	
	abstract public boolean execute(int op1, int op2);
	
	@Override
	public boolean execute(CPU cpu){
		int op1 = 0; int op2 = 0; Integer aux = null;
		aux= cpu.pop_back();
		if(aux==null)return false;
		op2 = aux;
		aux = cpu.pop_back();
		if(aux==null)return false;
		op1 = aux;
		if (execute(op1, op2)) {
			cpu.sigPC();
			return true;
		}
		else return cpu.SaltoPC(this.salto);
	}
	
	
	abstract public ByteCode parseAux(String word, int salto);

	@Override
	public ByteCode parse(String[] words) {
		if(words.length !=2) return null;
		else return this.parseAux(words[0], Integer.parseInt(words[1]));
		
	}

}
