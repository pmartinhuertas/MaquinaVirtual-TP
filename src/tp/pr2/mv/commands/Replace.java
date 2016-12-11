package tp.pr2.mv.commands;

import tp.pr2.mv.Command;
import tp.pr2.mv.Engine;

public class Replace extends Command{
	
	private int desp;
	
	public Replace(int desp){
		this.desp=desp;
	}
	public Replace(){
		desp=0;
	}
	public boolean execute(Engine aplicacion) {
		return aplicacion.reemplazar(desp);
	}

	public Command Parse(String[] linea) {
		if(linea.length==2 && linea[0].equalsIgnoreCase("REPLACE") )
			return new Replace(Integer.parseInt(linea[1]));
		else return null;
	}

	public String textHelp() {
		return "REPLACE: sustituye una instrucción";
	}
	public String toString(){
		return "REPLACE";
		}
}
