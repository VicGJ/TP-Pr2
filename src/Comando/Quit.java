//Sale del programa
package Comando;

import Practica2.Engine;

public class Quit extends Command
{
	public Quit(){}
	public boolean execute(Engine engine)
	{
		return engine.endExecution();
	}
	@Override
	public Command parse(String[] s)
	{
		if (s.length!=1 || !s[0].equalsIgnoreCase("QUIT")) return null;
		else return new Quit();
	}
	@Override
	public String textHelp()
	{
		return " QUIT: Permite salir del programa " +
		System.getProperty("line.separator");
	}
	public String toString()
	{
		return "QUIT";
	}
}
