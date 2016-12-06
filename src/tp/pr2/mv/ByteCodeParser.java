package tp.pr2.mv;

import tp.pr2.mv.bytecodes.ByteCode;
import tp.pr2.mv.bytecodes.arithmetics.Add;
import tp.pr2.mv.bytecodes.arithmetics.Div;
import tp.pr2.mv.bytecodes.arithmetics.Sub;


/**
 * Esta clase nos permite a partir de una cadena, sacar un objeto de tipo ByteCode
 * @authors Pablo Martín Huertas y Jose Mª López
 *
 */
public class ByteCodeParser {
	private final static ByteCode[] instrucciones = {
		new Add(), new Div(), new Sub()
		};
	
	public static ByteCode parse(String linea){
		String[] words=linea.split(" ");
		ByteCode instruccion = null;
		for(int ctrl=0;ctrl<instrucciones.length;ctrl++){
			instruccion = instrucciones[ctrl].parse(words);
			if(instruccion!=null)return instruccion;
		}
		return null;
	}
	
	
}
