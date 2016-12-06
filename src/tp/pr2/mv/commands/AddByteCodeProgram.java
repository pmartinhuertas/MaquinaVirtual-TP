package tp.pr2.mv.commands;

import tp.pr2.mv.Command;
import tp.pr2.mv.Engine;

public class AddByteCodeProgram extends Command{

	public boolean execute(Engine aplicacion) {
		return aplicacion.readByteCodeProgram();
	}

	public Command Parse(String[] linea) {
		if(linea.length==1 && linea[0].equalsIgnoreCase("BYTECODE"))
			return new AddByteCodeProgram();
		else return null;
	}

	public String textHelp() {
		return "BYTECODE: Añade instrucciones al programa";
	}

}
