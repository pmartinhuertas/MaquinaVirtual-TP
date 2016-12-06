package tp.pr2.mv.commands;

import tp.pr2.mv.Command;
import tp.pr2.mv.Engine;

public class Help extends Command{

	public boolean execute(Engine aplicacion) {
		return aplicacion.help();
	}

	public Command Parse(String[] linea){
		if(linea.length==1&&linea[0].equalsIgnoreCase("HELP"))
			return new Help();
		else return null;
	}

	public String textHelp() {
		return "HELP: Muestra esta ayuda";
	}
	
}
