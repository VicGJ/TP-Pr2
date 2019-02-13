//Saca la cima de la pila
package ByteCode;

import CPU.CPU;

public class Out extends ByteCode 
{
	public Out(){}
	public boolean execute(CPU cpu)
	{
		System.out.println("La cima de la pila: " + cpu.pop());
		cpu.increaseProgramCounter();
		return true;
	}
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("OUT")) return new Out();
		else return null;}
	
	public String toString(){ return "OUT"; }
}
