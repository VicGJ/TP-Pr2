//Para la ejecucion
package ByteCode;

import CPU.CPU;

public class Halt extends ByteCode 
{
	public Halt(){}
	public boolean execute(CPU cpu)
	{
	cpu.halt();
	cpu.increaseProgramCounter();
	return true;
	}
	public ByteCode parse(String[] s) {
		if (s[0].equalsIgnoreCase("Halt")) return new Halt();
		else return null;}
	
	public String toString(){ return "HALT"; }
}
