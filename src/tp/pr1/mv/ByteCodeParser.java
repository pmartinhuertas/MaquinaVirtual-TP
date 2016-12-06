package tp.pr1.mv;


/**
 * Esta clase nos permite a partir de una cadena, sacar un objeto de tipo ByteCode
 * @authors Pablo Martín Huertas y Jose Mª López
 *
 */
public class ByteCodeParser {
	
	/**
	 * 
	 * @param subcads Es un array de String que contiene en la segunda y tercera posicion respectivamente
	 * a la operación y el parámetro del ByteCode
	 * @return Nos devuelve el objeto creado a partir de la cadena
	 */
	public static ByteCode parse(String subcads[]){

		switch (subcads[1]){
		case "PUSH":{
			if(subcads.length!=3)return new ByteCode (ENUM_BYTECODE.PUSH, null);
			return new ByteCode (ENUM_BYTECODE.PUSH, Integer.parseInt(subcads[2]));
			}
		case "LOAD":
			if(subcads.length!=3)return new ByteCode (ENUM_BYTECODE.LOAD, null);
			return new ByteCode (ENUM_BYTECODE.LOAD, Integer.parseInt(subcads[2]));
		case "STORE":
			if(subcads.length!=3)return new ByteCode (ENUM_BYTECODE.STORE, null);
			return new ByteCode (ENUM_BYTECODE.STORE, Integer.parseInt(subcads[2]));
		case "ADD":
			return new ByteCode (ENUM_BYTECODE.ADD);
		case "SUB":
			return new ByteCode (ENUM_BYTECODE.SUB);
		case "MUL":
			return new ByteCode (ENUM_BYTECODE.MUL);
		case "DIV":
			return new ByteCode (ENUM_BYTECODE.DIV);
		case "OUT":
			return new ByteCode (ENUM_BYTECODE.OUT);
		case "HALT":
			return new ByteCode (ENUM_BYTECODE.HALT);
		}
		
		return null;
	}
}
