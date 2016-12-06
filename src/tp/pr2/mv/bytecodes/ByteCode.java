package tp.pr2.mv.bytecodes;

import tp.pr2.mv.CPU;


/**
 * Clase que representa una instruccion del programa
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 */
public abstract class ByteCode {
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] words);
}
