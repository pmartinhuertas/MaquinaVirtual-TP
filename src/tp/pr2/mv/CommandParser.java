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

	private final static Command[] commands = {
		new Help(), new Quit(), new Reset(),
		new Replace(), new Run(), new AddByteCodeProgram() 
		};
	
	public static Command parse(String linea){
		String[] words=linea.split(" ");
		Command c = null;
		for(int ctrl=0;ctrl<commands.length;ctrl++){
			c=commands[ctrl].Parse(words);
			if(c!=null)return c;
		}
		return null;
	}
	
	public static void showHelp(){
		for (int ctrl=0;ctrl<commands.length;ctrl++)
			System.out.println(commands[ctrl].textHelp());
	}
}
