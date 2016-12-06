package tp.pr2.mv.commands;

import tp.pr2.mv.Command;
import tp.pr2.mv.Engine;

public class Run extends Command{

	@Override
	public boolean execute(Engine aplicacion) {
		return aplicacion.run();
	}

	@Override
	public Command Parse(String[] linea) {
		if(linea.length == 1 && linea[0].equalsIgnoreCase("RUN"))
			return new Run();
		else return null;
	}

	@Override
	public String textHelp() {
		return "RUN: ejecuta el programa almacenado";
	}

}
