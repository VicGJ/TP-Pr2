//Maquina virtual capaz de ejecutar un bytecode
package CPU;

import ByteCode.ByteCode;
import ByteCode.ByteCodeProgram;



public class CPU 
{
	private Memory mem = new Memory();
	private OperandStack pila = new OperandStack();
	private boolean parada = false;
	private int programCounter = 0;
	private ByteCodeProgram program = new ByteCodeProgram();
	
	public CPU(ByteCodeProgram program) {
	this.program = program;
	}
	
	public void halt() { this.parada = true; }
	
	public String toString(){ 
		String s = System.getProperty("line.separator") +
			"Estado de la CPU: " + System.getProperty("line.separator") +
			" Memoria: " + this.mem + System.getProperty("line.separator") +
			" Pila: " + this.pila + System.getProperty("line.separator");
			return s; }
	
	public int getSizeStack() {return this.pila.getNumElems();}
	
	public int pop() { return this.pila.pop();}
	
	public boolean push(int i) {
		return this.pila.push(i);}
	
	public int read(int param) {
		return this.mem.read(param);
		}

	public void write(int param, int value) {this.mem.write(param, value);}
	
	public void setProgramCounter(int jump) {this.programCounter = jump;}
	
	public void increaseProgramCounter() {this.programCounter++;}
	
	
	public boolean run()
	{
		this.programCounter=0;
		boolean error = false;
		while (this.programCounter < program.getNumberOfByteCodes() && !this.parada) 
		{
			ByteCode bc = program.getByteCode(this.programCounter);
			if (bc.execute(this))
			{
				error = true;
			}
		}
	return error;
	}
}

