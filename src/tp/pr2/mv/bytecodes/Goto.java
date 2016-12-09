package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;

public class Goto extends ByteCode {
	protected int salto;
	public Goto(){}
	public Goto(int salto){
		this.salto=salto;
	}
	public boolean execute(CPU cpu) {
		return cpu.SaltoPC(this.salto);
	}

	@Override
	public ByteCode parse(String[] words) {
		if(words.length==2 && words[0].equals("GOTO")){
			int aux=Integer.parseInt(words[1]);
			if(aux<0)return null;
			else return new Goto(aux);
		}
		return null;
	}
	public String toString(){
		return "GOTO "+this.salto;
	}
}
