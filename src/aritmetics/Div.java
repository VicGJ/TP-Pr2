//Clase que divide la cima y subcime de la pila
package aritmetics;


public class Div extends Aritmetics{
	
	public Div(){}
	

	public int Operation(int n2, int n1)
	{
		int resul = 0;
		if(n2 == 0)
		{
			okDiv = false;
		}
		else
		{
			resul = n1 / n2;
		}
		
		return resul;
	}
	public Aritmetics parseAux(String s) {
		if (s.equalsIgnoreCase("Div")) return new Div();
		else return null;
	}
	
	public String toString(){ return "DIV"; }
}
