//Reemplaza una intruccion por otra
package Comando;

import Practica2.Engine;

public class Replace extends Command
{
	private int replace;
	public Replace()
	{}
	public Replace(int replace2)
	{
		this.replace = replace2;
	}
	public boolean execute(Engine engine)
	{
		return engine.replaceByteCode(replace);
	}
	@Override
	public Command parse(String[] s)
	{
		if (s.length!=2 || !s[0].equalsIgnoreCase("REPLACE")) return null;
		else 
		{
			this.replace = Integer.parseInt(s[1]);
			return new Replace(this.replace);
		}
	}
	@Override
	public String textHelp()
	{
		return " REPLACE: Permite cambiar una instruccion por otra " +
		System.getProperty("line.separator");
	}
	public String toString()
	{
		return "REPLACE" + this.replace;
	}
}
