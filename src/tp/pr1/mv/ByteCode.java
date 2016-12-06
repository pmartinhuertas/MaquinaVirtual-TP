package tp.pr1.mv;


/**
 * Clase que representa una instruccion del programa
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 */
public class ByteCode {
	/**
	 * Enumerado que representa el tipo de operacion
	 */
	private ENUM_BYTECODE operacion;
	/**
	 *Parametro usado en las operaciones de push, store y load
	 */
	private Integer parametro;
	
	/**
	 * Constructor por defecto de ByteCode
	 */
	public ByteCode(){}

	/**
	 * Constructor de ByteCode, que nos permite crear un ByteCode con su operacion
	 */
	public ByteCode(ENUM_BYTECODE op){
		operacion = op;
	}

	/**
	 * Constructor de ByteCode, que nos permite crear un ByteCode con su operacion y parametro
	 */
	public ByteCode(ENUM_BYTECODE op, Integer n){
		operacion = op;
		parametro =n;
	}
	
	/**
	 * Nos permite saber cual es el campo parametro del objeto ByteCode
	 * @return atributo paramtro del objeto ByteCode
	 */
	public Integer getPar(){
		return this.parametro;
	}

	/**
	 * Nos permite saber cual es el campo operacio del objeto ByteCode
	 * @return atributo operacion del objeto ByteCode
	 */
	public ENUM_BYTECODE getOp(){
		return this.operacion;
	}

	
	
	
	
	/**
	 * Nos permite modificar la operacion del ByteCode
	 * @param inst La nueva operacion que tendra el objeto
	 */
	public void setByteCode(ENUM_BYTECODE inst){
		operacion = inst;
	}

	/**
	 * Nos permite modificar el parametro del ByteCode
	 * @param n El nuevo parametro que tendra el objeto
	 */
	public void setParametro(int n){
		parametro=n;
	}
	
	/**
	 * Redefinimos el toString de ByteCode para que cree una cadena con la operacion y 
	 * el parametro si es necesario
	 */
	public String toString(){
		StringBuilder cadena =  new StringBuilder();
		switch(operacion){
		case PUSH:{
			cadena.append("PUSH ");
			cadena.append(parametro);	break;
		}
		case LOAD:{
			cadena.append("LOAD ");
			cadena.append(parametro);	break;
		}
			
		case STORE:{
			cadena.append("STORE ");
			cadena.append(parametro);	break;
		}
		case ADD:{
			cadena.append("ADD");	break;
		}
		case SUB:{
			cadena.append("SUB");	break;
		}
		case MUL:{
			cadena.append("MUL");	break;
		}
		case DIV:{
			cadena.append("DIV");	break;
		}
		case OUT:{
			cadena.append("OUT");	break;
		}
		case HALT:{ 
			cadena.append("HALT");	break;
		}
		
		}
		return cadena.toString();
	}
}
