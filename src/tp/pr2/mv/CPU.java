package tp.pr2.mv;


/**
 * Representa la unidad de procesamiento de la máquina virtual.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class CPU {
	ByteCodeProgram programa;
	/**
	 * Indica la instruccion del programa que se debera ejecutar.
	 */
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
	 * a los constructores de las clases OperandStack y Memory. Habrá que pasarle el programa
	 * desde fuera.
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
	/**
	 * Nos permite cambiar el valor de halt desde fuera.
	 * @param El valor que tomará halt.
	 */
	public void setHalt(boolean valor){
		this.halt=valor;
	}
	/**
	 * Es el método encargado de ejecutar el programa.
	 * @return Devuelve true si se han realizado todas las operaciones con éxito 
	 * o false si hay algún fallo.
	 */
	public boolean run(){
		boolean fallo=false;
		while(this.halt==false&&!fallo){
			if(!this.programa.getInstr(this.PC).execute(this))fallo =true;
		}
		return !fallo;
	}
	
	/**
	 * Nos permite ver lo que hay en cierta posición de la memoria.
	 * @param n Posición que se va a leer.
	 * @return Devuelve lo que hay en esa posición.
	 */
	public Integer readMem(int n){
		return memoria.read(n);
	}
	/**
	 * Nos permite escribir en la memoria un valor.
	 * @param par Lo que se vaa escribir.
	 * @param n La posición en la que se va escribir.
	 */
	public void writeMem(int par, int n){
		memoria.write(par, n);
	}
	/**
	 * Extrae un operando de la pila.
	 * @return Devuelve el operando extraido.
	 */
	public Integer pop_back(){
		return pilaop.pop_back();
	}
	/**
	 * Inserta un entero en la pila de operandos.
	 * @param n
	 * @return Devuelve true si se ha podido realizar la inserción y
	 * false en otro caso.
	 */
	public boolean push_back(int n){
		return pilaop.push_back(n);
	}
	/**
	 * Incrementa en 1 el valor del atributo PC.
	 */
	public void sigPC(){
		++this.PC;
	}
	/**
	 * Permite cambiar el valor de PC.
	 * @param num El nuevo valor de PC.
	 * @return Devuelve true si la operación es posible y false en otro caso.
	 */
	public boolean SaltoPC(int num){
		if (num <0 || num>=this.programa.getnumInst()) return false;
		else PC = num;
		return true;
	}
	
	/**
	 * Redefinimos el toString para este objeto para que muestre la CPU como nos 
	 * interesa.
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
