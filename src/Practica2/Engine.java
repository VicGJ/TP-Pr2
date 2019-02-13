//Engine: Es el interprete de comandos
package Practica2;

import java.util.Scanner;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import ByteCode.ByteCodeProgram;
import CPU.CPU;
import Comando.Command;
import Comando.CommandParser;

public class Engine
{
	private boolean end;
	private ByteCodeProgram bcProgram;
	private static Scanner in = new Scanner(System.in);
	
	public Engine()
	{
		this.bcProgram = new ByteCodeProgram();
		this.end = false;
	}
	public void start() {
		this.end = false;
		String line = "";
		
		while (!end) 
		{
			System.out.print("> ");
			
			Command comando = null;
			line = in.nextLine();
			comando = CommandParser.parse(line);
			
			if (comando == null)
			{
				System.out.println("Error: Comando incorrecto");
			} 
			else 
			{
				System.out.println("Comienza la ejecución de " + comando);
				if (!comando.execute(this))
					System.out.println("Error: Ejecucion incorrecta del comando");
			}
			if (this.bcProgram.getNumberOfByteCodes() != 0)
			{
				System.out.println("Programa almacenado: " + System.getProperty("line.separator")
				+ this.bcProgram);
			}
			}
			System.out.println("Fin de la ejecucion....");
			in.close();
	}
	public boolean executeCommandRun()
	{
		CPU cpu = new CPU(bcProgram);
		boolean check = true;
		if (cpu.run()) 
		{
			System.out.println(cpu);
		}
		else
		{
			check = false;
		}
		return check;
	}
	public boolean showHelp() 
	{
		CommandParser.showHelp();
		return true;
		/*boolean ok = true;
		System.out.println("HELP: Muestra esta ayuda ");
		System.out.println("QUIT: Cierra la app");
		System.out.println("RUN: Ejecuta el programa");
		System.out.println("NEWINST BYTECODE: Introduce una nueva instruccion al programa");
		System.out.println("RESET: Vacia el programa actual");
		System.out.println("REPLACE N: Reemplaza la instruccion N por la solicitada al usuario");
		return ok;*/
	}
	public boolean endExecution()
	{ 
		return this.end = true; 
	}
	public boolean addByteCodeInstruction(ByteCode bc) 
	{
		return this.bcProgram.addBCInstruction(bc);
	}
	public boolean resetProgram() 
	{
		boolean ok = false;
		if(!this.end)
		{
			this.bcProgram.reset();
			ok = true;
		}
		return ok;
	}
	public boolean replaceByteCode(int replace) 
	{
		boolean ok = false;
		
		String line = "";
		line = in.nextLine();
		ByteCode bc = ByteCodeParser.parse(line);
		if(bc != null)
		{
			this.bcProgram.replace(replace, bc);
			ok = true;
		}
		return ok;
	}
	public boolean readByteCodeProgram()
	{
		boolean ok = false;
		String line;
		line = in.nextLine();
		
		while(!line.equalsIgnoreCase("End"))
		{
			ByteCode bc = ByteCodeParser.parse(line);
			if(bc!= null)
			{
				bcProgram.addBCInstruction(bc);
				ok = true;
			}
			line = in.nextLine();
		}
		return ok;
	}
		
}
