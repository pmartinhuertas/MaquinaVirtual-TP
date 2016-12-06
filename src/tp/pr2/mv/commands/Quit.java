package tp.pr2.mv.commands;

import tp.pr2.mv.Command;
import tp.pr2.mv.Engine;

public class Quit extends Command{

	@Override
	public boolean execute(Engine aplicacion) {
		return aplicacion.quit();
	}

	@Override
	public Command Parse(String[] linea){
		if(linea.length==1 && linea[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else return null;

	}

	@Override
	public String textHelp() {
		return "QUIT: Cierra la aplicacion\n";
	}

}
