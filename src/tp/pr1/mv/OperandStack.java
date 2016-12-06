package tp.pr1.mv;


/**
 * Esta clase representa la pila de operandos.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class OperandStack {
	/**
	 * Tamaño máximo de la pila del objeto.
	 */
	private final int max = 100;
	/**
	 * Array que contiene los operandos.
	 */
	private int[]stack;
	/**
	 * Numero de posiciones que tiene ocupadas stack.
	 */
	private int numInt;
	
	
	/**
	 * Constructor que nos permite crear un objeto de tipo OperandStack inicializando stack a un array
	 * de ceros de tamaño máximo y con numInt=0.
	 */
	public OperandStack(){
		stack = new int[max];
		numInt = 0;
	}
	/**
	 * Nos permite acceder al operando almacenado en la cima de la pila.
	 * @return Devuelve el operando almacenado en la cima de la pila.
	 */
	public int getValor(){
		return stack[numInt-1];
	}
	
	/**
	 * Nos permite saber cuantos operandos teneos almacenados.
	 * @return Devuelve cuantos operandos tenemos almacenados.
	 */
	public int getNumInt(){
		return numInt;
	}
	
	/**
	 * Nos permite añadir un operando en la cima de la pila.
	 * @param n El entero que queremos añadir.
	 * @return 	Devolverá cierto si se ha podido añadir y falso en otro caso.
	 */
	public boolean push_back(int n){
		if(numInt>=max)return false;
		stack[numInt] = n;
		++numInt;
		return true;
	}
	/**
	 * Saca de la pila el valor de su cima.
	 * @return Devuelve la cima de la pila.
	 */
	public Integer pop_back(){
		--numInt;
		if(numInt<0){
			numInt=0;
			return null;
		}
		return stack[numInt];
	}
	/**
	 * Reddefinimos el toString de OperandStack para que nos muestre información sobre la pila de operandos.
	 */
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("Pila:");
		for (int i = 0; i < numInt; ++i){
			cadena.append(' ');
			cadena.append(stack[i]);
		}
		if (numInt == 0) cadena.append(" <vacia>");
		return cadena.toString();
	}
}
