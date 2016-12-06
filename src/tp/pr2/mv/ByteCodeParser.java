package tp.pr2.mv;

import tp.pr2.mv.bytecodes.ByteCode;
import tp.pr2.mv.bytecodes.arithmetics.Add;
import tp.pr2.mv.bytecodes.arithmetics.Div;
import tp.pr2.mv.bytecodes.arithmetics.Sub;
import tp.pr2.mv.bytecodes.arithmetics.Mul;
import tp.pr2.mv.bytecodes.ConditionalJumps;
import tp.pr2.mv.bytecodes.conditionaljumps.IfEq;
import tp.pr2.mv.bytecodes.conditionaljumps.IfLe;
import tp.pr2.mv.bytecodes.conditionaljumps.IfLeq;
import tp.pr2.mv.bytecodes.conditionaljumps.IfNeq;
import tp.pr2.mv.bytecodes.stackuse.Load;
import tp.pr2.mv.bytecodes.stackuse.Push;
import tp.pr2.mv.bytecodes.stackuse.Store;


/**
 * Esta clase nos permite a partir de una cadena, sacar un objeto de tipo ByteCode
 * @authors Pablo Martín Huertas y Jose Mª López
 *
 */
public class ByteCodeParser {
	private final static ByteCode[] instrucciones = {
		new Add(), new Div(), new Sub(), new Mul(), new IfEq(), new IfLe(), 
		new IfLeq(), new IfNeq(), new Push(), new Load(), new Store()
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
