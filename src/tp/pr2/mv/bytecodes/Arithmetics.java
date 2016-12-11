package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;
/**
 * Clase abstracta de la que herdarán los bytecodes que
 * representen operaciones aritméticas.
 * @authors Pablo Martín Huertas y Jose Mª López.
 *
 */
public abstract class Arithmetics extends ByteCode{
	/**
	 * Método que ejecuta la operación en cuestión.
	 * @param op1 Operando1.
	 * @param op2 Operando2.
	 * @return Devuelve op1 operado con op2.
	 */
	abstract public Integer execute(int op1, int op2);
	
	/**
	 * Manipula la pila para extraer los operandos, y pone el resultado
	 * enella.
	 */
	public boolean execute(CPU cpu){
		int op1 = 0; int op2 = 0; Integer aux = null;
		aux = cpu.pop_back();
		if(aux==null) return false;
		op2 = aux;
		aux = cpu.pop_back();
		if(aux==null) return false;
		op1 = aux;
		Integer sol = execute(op1, op2);
		if (sol == null) return false;
		cpu.push_back(sol);
		cpu.sigPC();
		return true;
	}
/**
 * Nos permite identificar el tipo de Bytecode que se ha introducido,
 * @param word El String que representa el código del Bytecode.
 * @return Devuelve el Bytecode que se ha reconocio o null si 
 * no e reconoce ninguno.
 */
	abstract public ByteCode parseAux (String word);
/**
 * Obtiene un Bytecode a partir de una cadena.
 * @param words El array que se va a parsear.
 * @return Devuelve el Bytecode que se ha parseado o null si no se ha
 *  reconocido ninguno.
 */
	public ByteCode Parse(String[] words){
		if(words.length !=1) return null;
		else return this.parseAux(words[0]);
	}
}
