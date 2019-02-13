//OperandStack: Pila de operandos de la maquina virtual
package CPU;

public class OperandStack {
	
	public static final int MAX = 200;
	private int[] stack;
	private int contador;
	
	public OperandStack()
	{
		this.contador = 0;
		this.stack = new int[OperandStack.MAX];
	}
	public boolean push(int value)
	{
		boolean in = false;
		
		if(this.contador <= MAX)
			{
				this.stack[this.contador] = value;
				this.contador++;
				in = true;
			}
		return in;
	}
	public int pop()
	{
		int aux = this.stack[this.contador - 1];
		this.contador--;
		return aux;
	}
	public int getNumElems()
	{
		return this.contador;
	}
	public String toString(){
		if (this.contador == 0) return "<vacia>";
		else 
		{
		String s="";
		for (int i=0; i < this.contador; i++)
			{
			s = s + this.stack[i] + " ";
			}
		return s;
		}
		}
}
