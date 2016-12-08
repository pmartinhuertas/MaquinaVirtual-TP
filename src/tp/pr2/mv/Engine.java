package tp.pr2.mv;


//grupo8

import java.util.Scanner;

import tp.pr2.mv.bytecodes.ByteCode;
/**
 * Esta clase manipula el bucle de control de la aplicación.
 * @authors Pablo Martin Huertas y Jose Mª Lopez
 *
 */
public class Engine {
	/**
	 * Representa la lista de instrucciones que tenemos almacenadas.
	 */
	private ByteCodeProgram program;
	/**
	 * Valor booleano que será cierto si se ejecuta el comando QUIT y falso en otro caso.
	 */
	private boolean end;
	/**
	 * Este atributo nos permite leer datos que introduce el usuario de la máquina.
	 */
	private static Scanner in = new Scanner(System.in);
	

	/**
	 * Constructor que nos permite crear un objeto de tipo Engine invocando al constructor de la clase
	 * ByteCodeProgram e inicializando el valor de end a falso.
	 */
	public Engine(){
		this.program = new ByteCodeProgram();
		this.end=false;
	}

	
	/**
	 * Nos permite añadir una instrucción a program.
	 * @param inst La instrucción que se va a añadir.
	 * @return Devuelve cierto si se ha podido añadir la instrucción y falso en otro caso.
	 */
	public boolean pushback(ByteCode inst){
		if(this.program.push_back(inst)) return true;
		else return false;
	}
	
	/**
	 * Nos permite sustituir una instrucción almacenada en cierta posición de program por otra.
	 * @param inst El ByteCode que queremos añadir.
	 * @param pos La posición en la que se va a realizar el reemplazamiento.
	 * @return Devuelve cierto si se ha podido reemplazar y falso en otro caso.
	 */
	public boolean reemplazar(int pos){
		//Falta!!!
		String texto="";
		System.out.println("Introduzca la nueva instruccion");
		texto=in.nextLine().toUpperCase();
		ByteCode inst = ByteCodeParser.parse(texto);//esto se hace aqui?
		if(this.program.replace(inst,pos)) return true;
		else return false;
	}
	/*
	public boolean replace(Command comando){
		System.out.println("Comienza la ejecución de REPLACE");
		if(comando.getReplace()==null)return false;
		System.out.println("Introduzca una instruccion");
		Scanner cin = new Scanner(System.in);
		String linea="NEWINST ";
		linea+=cin.nextLine().toUpperCase();
		String subcads[]= linea.split(" ");
		ByteCode inst = ByteCodeParser.parse(subcads);
		cin.close();
		if(!reemplazar(inst, comando.getReplace())) {
			System.out.println("No se ha podido realizar el reemplazamiento.");
			return false;
			}
		return true;
	}*/
	public boolean quit(){
		System.out.println("Comienza la ejecución de QUIT");
		end=true;
		return true;
	}
	
	public boolean help(){
		CommandParser.showHelp();
		return true;
	}
	
	public boolean readByteCodeProgram(){
		String linea = "";
		ByteCode inst;
		while (!linea.equals("END")){
			linea=this.in.nextLine().toUpperCase();
			inst=ByteCodeParser.parse(linea);
			if(inst==null && !linea.equals("END"))System.out.println("No se reconoce la instruccion");
			else if(!linea.equals("END"))this.program.push_back(inst);
		}
		return true;
	}
	
	public boolean resetProgram(){
		System.out.println("Comienza la ejecución de RESET");
		this.program = new ByteCodeProgram();
		return true;
	}
	
	public boolean run(){
		System.out.println("Comienza la ejecucion de run");
		CPU cpu=new CPU(this.program);
		if(cpu.run()){
			System.out.println(cpu.toString());
			return true;
		}
		else {
			System.out.println("Error de ejecucion");
			return false;
		}
	}
	/**
	 * Método que controla el bucle principal de la aplicación.
	 */
	public void start(){
		String linea = "";
		System.out.print("> ");
		linea = in.nextLine();
		linea=linea.toUpperCase();
		Command com= CommandParser.parse(linea);
		if(com!=null){
			if(com.execute(this)){
			/*if(	com.getCommand() == ENUM_COMMAND.REPLACE ||
				com.getCommand() == ENUM_COMMAND.RESET ||
				com.getCommand()==ENUM_COMMAND.QUIT)*/
				System.out.println(program.toString());}
			else System.out.println("Error: Ejecucion incorrecta del comando");
		}
		else System.out.println("Error: El comando introducido no es valido");
		while (!end){
			System.out.print("> ");
			linea = in.nextLine();
			linea=linea.toUpperCase();
			com= CommandParser.parse(linea);
			if(com!=null){
			if(com.execute(this))
			/*{if(com.getCommand() == ENUM_COMMAND.NEWINST || 
					com.getCommand() == ENUM_COMMAND.REPLACE ||
					com.getCommand() == ENUM_COMMAND.RESET ||
					com.getCommand()==ENUM_COMMAND.QUIT)}
			else*/
			 System.out.println(program.toString());
			else System.out.println("Error: Ejecucion incorrecta del comando");
			}
			else System.out.println("Error: El comando introducido no es valido");
			}
		System.out.println("Fin de la ejecución...");
		in.close();
	}
	

	


}
