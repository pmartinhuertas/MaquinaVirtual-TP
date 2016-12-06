package tp.pr2.mv;


/**
 * Esta clase permite representar los comandos que ejecuta engine.
 * @authors Pablo Martín Huertas y Jose Mª López
 *
 */
public abstract class Command {



	public Command (){}
	
	abstract public boolean execute(Engine aplicacion);
	abstract public Command Parse(String[]linea);
	abstract public String textHelp();



}
