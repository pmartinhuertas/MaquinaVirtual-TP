package tp.pr2.mv.bytecodes.conditionaljumps;

import tp.pr2.mv.CPU;
import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.ByteCode;

public class IfNeq extends ConditionalJumps{

	public IfNeq(int num){
		super(num);
	}
	public IfNeq(){
	}
	@Override
	public boolean execute(CPU cpu) {
		int aux2=0; Integer aux = null;
		aux = cpu.pop_back();
		if(aux==null)return false;
		aux2 = aux;
		aux = cpu.pop_back();
		if(aux==null) return false;
		if (aux != aux2) cpu.SaltoPC(this.salto);
		return true;
	}

	@Override
	public ByteCode parseAux(String word, int salto) {
		if (word.equalsIgnoreCase("IFNEQ")) return new IfNeq(salto);
		else return null;
	}

}
