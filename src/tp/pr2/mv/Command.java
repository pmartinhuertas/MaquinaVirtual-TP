package tp.pr2.mv;


/**
 * Esta clase abstracta será de la que hereden las clases que representen
 * los distintos comandos.
 * @authors Pablo Martín Huertas y Jose Mª López
 *
 */
public abstract class Command {


	
	public Command (){}
	/**
	 * Ejecuta el comando.
	 * @param aplicacion El objeto engine en el que se ejecutara el comando.
	 * @return Devuelve cierto si se ejecuta con éxito y falso en otro caso.
	 */
	abstract public boolean execute(Engine aplicacion);
	/**
	 * Nos permite obtener un objeto comando de un String.
	 * @param linea Es un array de Strings que contiene en la posición 0 el
	 * codigo del comando y en la segunda el parámetro si debería haberlo.
	 * @return Devuelve el comando que se obtiene de linea.
	 */
	abstract public Command Parse(String[]linea);
	/**
	 * Sirve para que cada comando muestre para que sirve.
	 * @return Devuelve para que sirve el comando en cuestion.
	 */
	abstract public String textHelp();



}
