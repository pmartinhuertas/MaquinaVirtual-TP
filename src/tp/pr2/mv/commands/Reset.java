package tp.pr2.mv.commands;

import tp.pr2.mv.Command;
import tp.pr2.mv.Engine;

public class Reset extends Command{

	@Override
	public boolean execute(Engine aplicacion) {
		return aplicacion.resetProgram();
	}

	public Command Parse(String[] linea) {
		if(linea.length==1&&linea[0].equalsIgnoreCase("RESET"))
			return new Reset();
		else return null;
	}

	@Override
	public String textHelp() {
		return "RESET: Vacia el programa actual\n";
	}

}
