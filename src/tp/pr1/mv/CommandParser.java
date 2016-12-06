package tp.pr1.mv;


/**
 * Este objeto contiene un método que, a partir de una cadena nos permite obtener un comando
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 */
public class CommandParser {

	/**
	 * 
	 * @param linea Es la cadena que se parseará.
	 * @return Devolverá el comando que se haya creado o null si no se ha reconocido el comando
	 * en linea.
	 */
	public static Command parse(String linea){
		String subcads[]= linea.split(" ");
		
		switch (subcads[0]){
		case "HELP":
			if (subcads.length==1)return new Command(ENUM_COMMAND.HELP);
		case "QUIT":
			if (subcads.length==1)return new Command(ENUM_COMMAND.QUIT);
		case "NEWINST":
			if(subcads.length<2)return new Command(ENUM_COMMAND.NEWINST,null);
			else return new Command (ENUM_COMMAND.NEWINST, ByteCodeParser.parse(subcads));
		case "RESET":
			if (subcads.length==1)return new Command(ENUM_COMMAND.RESET);
		case "REPLACE":
			if(subcads.length!=2)return new Command(ENUM_COMMAND.REPLACE, null);
			return new Command (ENUM_COMMAND.REPLACE, Integer.parseInt(subcads[1]));
		case "RUN":
			if (subcads.length==1)return new Command(ENUM_COMMAND.RUN);
		}

		return null;
	}
}
