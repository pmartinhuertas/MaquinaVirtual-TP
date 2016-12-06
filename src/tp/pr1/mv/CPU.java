package tp.pr1.mv;


/**
 * Representa la unidad de procesamiento de la máquina virtual.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class CPU {
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
	public CPU(){
		halt=false;
		pilaop=new OperandStack();
		memoria=new Memory();
	}
	
	/**
	 * Permite la extraccion de halt para saber cuando parar la maquina.
	 */
	
	public boolean getHalt(){
		return halt;
	}
	
	/**
	 * Este método nos permite ejecutar instrucciones de tipo ByteCode.
	 * @param instr El ByteCode que se ejecutará.
	 * @return Devolverá cierto si se se ha podido ejecutar la instrucción y falso en otro caso.
	 */
	public boolean execute(ByteCode instr){
		switch(instr.getOp()){
		case PUSH:{ 
			if(!this.pilaop.push_back(instr.getPar()))return false;
			break;
		}
		case STORE: {
			if(pilaop.getNumInt()==0)return false;
			memoria.write(instr.getPar(), pilaop.pop_back());
			break;
		}
		case LOAD:{
			if(memoria.read(instr.getPar())==null){
				memoria.write(instr.getPar(), 0);
			}
			pilaop.push_back(memoria.read(instr.getPar()));
			break;
		}
		case ADD:{
			int sol=0; Integer aux = null;
			aux = pilaop.pop_back();
			if(aux==null)return false;
			sol+=aux;
			aux = pilaop.pop_back();
			if(aux==null) return false;
			sol+=aux;
			pilaop.push_back(sol);
			
			break;
		}
		case SUB:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			sol-=pilaop.pop_back();
			sol+=pilaop.pop_back();
			pilaop.push_back(sol);
			break;
		}
		case MUL:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			sol=pilaop.pop_back();
			sol*=pilaop.pop_back();
			pilaop.push_back(sol);
			break;
		}
		case DIV:{
			if(pilaop.getNumInt()<2)return false;
			int sol=0;
			int aux=pilaop.pop_back();
			if(aux==0)return false;
			sol=(pilaop.pop_back()/aux);
			pilaop.push_back(sol);
			break;
		}
		case OUT:{
			System.out.println(pilaop.getValor());
			break;
		}
		case HALT:{
			halt=true;
			break;
		}
		}
	
	
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
