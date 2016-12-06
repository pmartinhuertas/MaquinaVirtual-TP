package tp.pr2.mv;


/**
 * Representa la memoria de la máquina.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class Memory {
	/**
	 * Tamaño inicial de la memoria.
	 */
	private final int MAX = 100;
	/**
	 * Atributo que contiene los datos almacenados en la memoria. 
	 */
	private Integer[]memory;
	
	/**
	 * Redefinimos el constructor del objeto para que cree un objeto Memory con 
	 * su atributo memoria inicializado a un vector vacío del tamaño máximo indicado.
	 */
	public Memory(){
		this.memory=new Integer[MAX];
	}

	/**
	 * Nos permite cambiar el tamaño de memory
	 * @param n Valor que se tendrá en cuenta a la hora de cambiar el tamaño (será el valor 
	 * que hay que pasar si no estamos seguros de que una posición se va a salir del rango de la
	 * memoria).
	 */
	public void redimensionar(int n){
		Integer []aux=new Integer[n+1];
		for(int ctrl=0;ctrl<this.memory.length;ctrl++){
			aux[ctrl]=memory[ctrl];
		}
		memory=aux;
		
	}
	
	/**
	 * Nos permite escribir en cierta posición de memory.
	 * @param pos La posición en la que queremos escribir.
	 * @param valor El entero que queremos escribir en memory.
	 * @return Devuelve falso si la posición introducida no es válida y cierto en otro caso.
	 */
	public boolean write(int pos, int valor){
		if(pos<0)return false;
		if(pos>=this.memory.length){
			redimensionar(pos);
			}
		memory[pos]=valor;
		return true;
	}
	
	/**
	 * Nos permite acceder al valor almacenado en cierta posición de memory.
	 * @param pos La posición de memory a la que queremos aceceder.
	 * @return Devuelve el valor almacenado en esa posición, y  si no hay nada.
	 */
	public Integer read(int pos){
		if(pos<0)return null;
		if(memory[pos] != null) return memory[pos];
		else return null;
	}
	
	/**
	 * Redefinimos el método toString de Memory, para que nos muestre información sobre el estado de la memoria.
	 */
	public String toString(){
		StringBuilder cadena = new StringBuilder();
		cadena.append("Memoria: ");
		boolean vacia = true;
		for (int i = 0; i < memory.length; ++i){
			if(memory[i] != null){ 
			cadena.append('[');
			cadena.append(i);
			cadena.append("]:");
			cadena.append(memory[i]);
			cadena.append(' ');
			vacia = false;
			}
		}
		if(vacia) cadena.append("<vacia>");
		
		return cadena.toString();
	}
}
