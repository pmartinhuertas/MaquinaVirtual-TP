package tp.pr2.mv;


/**
 * El programa empieza a ejecutarse desde Main.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class Main {
	/**
	 * Crea un objeto de tipo Engine y llama al método start de Engine que controla el bucle 
	 * principal de la aplicación.
	 * @param args
	 */
	public static void main(String[] args) {
		Engine aplicacion=new Engine();
		aplicacion.start();
	}
}
