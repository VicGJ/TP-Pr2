//Clase que maneja operaciones entre la cima y subcima de la pila
package aritmetics;

import ByteCode.ByteCode;
import CPU.CPU;

public abstract class Aritmetics extends ByteCode 
{
	protected boolean okDiv = true;
	public Aritmetics(){}
	
	public boolean execute(CPU cpu)
	{
		if (cpu.getSizeStack()>=2)
		{
			int n2 = cpu.pop();
			int n1 = cpu.pop();
			int resul = Operation(n2,n1);
			if(okDiv)
				{
				cpu.push(resul);
				cpu.increaseProgramCounter();
				return true;}
			else
				return false;
			
		}
		else return false;
	}
	public ByteCode parse(String[] words)
	{
		if (words.length!=1) return null;
		else return this.parseAux(words[0]);
	}
	abstract protected int Operation(int n2, int n1);
	abstract public ByteCode parseAux(String s1);
}