package tp.pr2.mv;


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
	
	public Integer readMem(int n){
		return memoria.read(n);
	}
	public void writeMem(int par, int n){
		memoria.write(par, n);
	}
	
	public int pop_back(){
		return pilaop.pop_back();
	}
	
	public boolean push_back(int n){
		return pilaop.push_back(n);
	}
	
	public void sigPC(){
		++this.PC;
	}

	public boolean SaltoPC(int num){
		if (num <0) return false;
		else PC = num;
		return true;
	}
	
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
