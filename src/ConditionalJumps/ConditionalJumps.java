//Heredan las instrucciones de salto
package ConditionalJumps;


import ByteCodesOneParameter.ByteCodesOneParameter;
import CPU.CPU;

abstract public class ConditionalJumps extends ByteCodesOneParameter
{
	public ConditionalJumps(){}
	
	public ConditionalJumps(int j)
	{
		super(j); 
	}
	
	@Override
	public boolean execute(CPU cpu)
	{
	if (cpu.getSizeStack()>=2)
	{
		int n2 = cpu.pop();
		int n1 = cpu.pop();
		if (!compare(n2,n1))
			cpu.setProgramCounter(this.param);
		else
			cpu.increaseProgramCounter();
	
		return true;
	}
	else return false;
	}
	
	abstract protected boolean compare(int n1, int n2);
}