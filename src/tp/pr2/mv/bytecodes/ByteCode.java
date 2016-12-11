package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;


/**
 * Clase abstracta que representa una instruccion del programa de la que heredan
 * todas las demás clases que van a representar algún ByteCode.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 */
public abstract class ByteCode {
	/**
	 * Permite ejecutar un Bytecode.
	 * @param cpu El objeto CPU en el que se realizará la operación.
	 * @return Devuelve cierto si se ha podido realizar la operación
	 * o falso en otro caso.
	 */
	abstract public boolean execute(CPU cpu);
	/**
	 * 
	 * @param words El array de Strings que se va a parsear, en posición 0
	 * el código del Bytecode y en la 1 el parámetro si es necesario.
	 * @return Devuelve el Bytecode parseado o null si no se reconoce ninguno.
	 */
	abstract public ByteCode parse(String[] words);
	//abstract public String toString();
}
