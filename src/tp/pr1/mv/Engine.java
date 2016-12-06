package tp.pr1.mv;


//grupo8

import java.util.Scanner;
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
	public boolean reemplazar(ByteCode inst, int pos){
		if(this.program.replace(inst,pos)) return true;
		else return false;
	}
	
	public void quit(){
		System.out.println("Comienza la ejecución de QUIT");
		end=true;
	}
	
	public void help(){
		System.out.println("Comienza la ejecución de HELP\n");
		System.out.println("HELP: Muestra esta ayuda");
		System.out.println("QUIT: Cierra la aplicacion");
		System.out.println("NEWINST BYTECODE: Introduce una nueva instrucción al programa");
		System.out.println("RESET: Vacia el programa actual");
		System.out.println("REPLACE N: Reemplaza la instruccion N por la solicitada al usuario\n");
	}
	
	public boolean newinst(ByteCode instruccion){
		System.out.print("Comienza la ejecución de NEWINST ");
		if (instruccion==null || instruccion.getOp()==null)return false;
		if (instruccion.getOp() == ENUM_BYTECODE.PUSH ||
			instruccion.getOp() == ENUM_BYTECODE.STORE ||
			instruccion.getOp() == ENUM_BYTECODE.LOAD){
			System.out.print(instruccion.getOp());
			if(instruccion.getPar()==null)return false;
			else System.out.println(" "+instruccion.getPar());
			}
		else System.out.println(instruccion.getOp());
		if(!pushback(instruccion)){
			System.out.println("No se ha podido añadir la instruccion");
			return false;
			}
		return true;
	}
	
	public void reset(){
		System.out.println("Comienza la ejecución de RESET");
		this.program = new ByteCodeProgram();
	}
	
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
	}
	
	public boolean run(){
		System.out.println("Comienza la ejecución de RUN");
		boolean fallo=false;
		CPU cpu=new CPU();
		int i=0;
		while(i<this.program.getnumInst() && !cpu.getHalt()&&!fallo){
			if(!cpu.execute(this.program.getInstr(i)))fallo=true;
			if (this.program.getInstr(i).getOp() == ENUM_BYTECODE.PUSH ||
				this.program.getInstr(i).getOp() == ENUM_BYTECODE.STORE ||
				this.program.getInstr(i).getOp() == ENUM_BYTECODE.LOAD){
			System.out.println("El estado de la maquina tras ejecutar la instruccion " + 
			this.program.getInstr(i).getOp() + ' ' + this.program.getInstr(i).getPar());
			}
			else System.out.println("El estado de la maquina tras ejecutar la instruccion " + 
					this.program.getInstr(i).getOp());
			System.out.println();
			System.out.println(cpu.toString());
			
			i++;
		}
		return !fallo;
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
			if(com.getCommand() != ENUM_COMMAND.HELP)System.out.println(program.toString());
			}
			else System.out.println("Error: Ejecucion incorrecta del comando");
		}
		else System.out.println("Error: El comando introducido no es valido");
		while (!end){
			System.out.print("> ");
			linea = in.nextLine();
			linea=linea.toUpperCase();
			com= CommandParser.parse(linea);
			if(com!=null){
			if(com.execute(this)){
				if(com.getCommand() != ENUM_COMMAND.HELP)System.out.println(program.toString());
				}
			else System.out.println("Error: Ejecucion incorrecta del comando");
			}
			else System.out.println("Error: El comando introducido no es valido");
			}
		System.out.println("Fin de la ejecución...");
		in.close();
	}
	


}
