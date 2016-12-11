package tp.pr2.mv;

import tp.pr2.mv.commands.AddByteCodeProgram;
import tp.pr2.mv.commands.Help;
import tp.pr2.mv.commands.Quit;
import tp.pr2.mv.commands.Replace;
import tp.pr2.mv.commands.Reset;
import tp.pr2.mv.commands.Run;


/**
 * Este objeto contiene un método que, a partir de una cadena nos permite obtener un comando
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 */
public class CommandParser {
/**
 * Es un array con todos los comando implementados.
 */
	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(), new Run(), new AddByteCodeProgram() 
		};
	/**
	 * Recorre el atributo Command para apartir de linea obtener un comando.
	 * @param linea El String que se va a parsear.
	 * @return Devuelve un objeto command que se ha parseado de linea o 
	 * null si no se reconoce nada.
	 */
	public static Command parse(String linea){
		String[] words=linea.split(" ");
		Command c = null;
		for(int ctrl=0;ctrl<commands.length;ctrl++){
			c=commands[ctrl].Parse(words);
			if(c!=null)return c;
		}
		return null;
	}
	
	/**
	 * Recorre Commands para acceder a la ayuda de cada comando y mostrar por 
	 * pantalla el uso de cada uno.
	 */
	public static void showHelp(){
		for (int ctrl=0;ctrl<commands.length;ctrl++)
			System.out.println(commands[ctrl].textHelp());
	}
}
