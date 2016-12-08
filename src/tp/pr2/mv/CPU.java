package tp.pr2.mv;

import tp.pr2.mv.bytecodes.ByteCode;


/**
 * Representa la unidad de procesamiento de la máquina virtual.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class CPU {
	ByteCodeProgram programa;
	private int PC;
	/**
	 * boolean que indica si indica si se ha ejecutado la instrucción HALT.
	 */
	private boolean halt;
	/**
	 * Representa la pila de operandos(una pila de enteros).
	 */
	private OperandStack pilaop;
	/**
	 * Representa la memoria de la máquina virtual.
	 */
	private Memory memoria;
	
	/**
	 * Constructor que nos permite crear un objeto de tipo CPU, inicializando halt a false e invocando
	 * a los constructores de las clases OperandStack y Memory.
	 */
	public CPU(ByteCodeProgram program){
		halt=false;
		pilaop=new OperandStack();
		memoria=new Memory();
		programa=program;
	}
	
	/**
	 * Permite la extraccion de halt para saber cuando parar la maquina.
	 */
	
	public boolean getHalt(){
		return halt;
	}
	
	public boolean exeload(int par){
		if(this.memoria.read(par)==null)this.memoria.write(par, 0);
		this.pilaop.push_back(this.memoria.read(par));
		this.PC++;
		return true;
	}
	public boolean exepush(int par){
		if(this.pilaop.push_back(par)){
			this.PC++;	
			return true;
		}
		else return false;
	}
	public boolean exestore(int par){
		this.memoria.write(par, this.pilaop.pop_back());
		this.PC++;
		return true;
	}
	public boolean exehalt(){
		this.halt=true;
		return true;
	}
	
	public boolean run(){
		boolean fallo=false;
		while(this.halt==false&&!fallo){
			if(!this.programa.getInstr(this.PC).execute(this))return false;
		}
		//for(int ctrl=0;ctrl<this.programa.getnumInst();ctrl++){
		//	if(!this.programa.getInstr(ctrl).execute(this))return false;
		//}
		return true;
	}
	
	public boolean exeAdd(){
		int sol=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		sol+=aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		sol+=aux;
		pilaop.push_back(sol);
		this.PC++;
		return true;
	}
	
	public boolean exeDiv(){
		int sol=0;int extra = 0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		else if (aux == 0) return false;
		extra = aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		sol = aux / extra;
		pilaop.push_back(sol);
		this.PC++;
		return true;
	}
	
	public boolean exeMul(){
		int sol=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		sol = aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		sol*=aux;
		pilaop.push_back(sol);
		return true;
	}
	
	public boolean exeSub(){
		int sol=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		sol-=aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		sol+=aux;
		pilaop.push_back(sol);
		return true;
	}
	
	public boolean exeIfeq(int num){
		int aux2=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		aux2 = aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		if (aux == aux2) this.SaltoPC(num);
		this.PC++;
		return true;
	}
	
	public boolean exeIfle (int num){
		int aux2=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		aux2 = aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		if (aux < aux2) this.SaltoPC(num);
		return true;
	}
	
	public boolean exeIfleq(int num){
		int aux2=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		aux2 = aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		if (aux <= aux2) this.SaltoPC(num);
		return true;

	}
	
	public boolean exeIfneq(int num){
		int aux2=0; Integer aux = null;
		aux = pilaop.pop_back();
		if(aux==null)return false;
		aux2 = aux;
		aux = pilaop.pop_back();
		if(aux==null) return false;
		if (aux != aux2) this.SaltoPC(num);
		return true;
	}

	private boolean SaltoPC(int num){
		if (num <0) return false;
		else PC = num;
		return true;
	}
	
	/**
	 * Este método nos permite ejecutar instrucciones de tipo ByteCode.
	 * @param instr El ByteCode que se ejecutará.
	 * @return Devolverá cierto si se se ha podido ejecutar la instrucción y falso en otro caso.
	 */
	
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("Estado de la CPU:\n  ");
		cadena.append(memoria.toString());
		cadena.append("\n  ");
		cadena.append(pilaop.toString());
		cadena.append('\n');
		return cadena.toString();
	}
	
	
}
