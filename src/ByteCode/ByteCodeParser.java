//Parsea bytecodes
package ByteCode;


import ByteCodesOneParameter.Goto;
import ByteCodesOneParameter.Load;
import ByteCodesOneParameter.Push;
import ByteCodesOneParameter.Store;
import ConditionalJumps.IfEq;
import ConditionalJumps.IfLe;
import ConditionalJumps.IfLeq;
import ConditionalJumps.IfNeq;
import aritmetics.Add;
import aritmetics.Div;
import aritmetics.Mul;
import aritmetics.Sub;

//ByeCodeParser: Parsea un string y lo transforma en bytecode o en null, si no es válido
public class ByteCodeParser
{
	private final static ByteCode[] bytecode = {new Out(), new Halt(),
												new Store(), new Load(), new Push(), new Goto(),
												new IfNeq(), new IfEq(), new IfLeq(), new IfLe(),
												new Sub(), new Add(), new Mul(), new Div()};
	
	public static ByteCode parse(String line)
	{
		String[] aux;
		line = line.trim();
		aux = line.split(" +");
		boolean found = false;
		int i=0;
		ByteCode c = null;
		
		while (i < bytecode.length && !found)
		{
			c = bytecode[i].parse(aux);
			if (c!=null) found=true;
			else i++;
		}
		return c;
	}
	public static boolean IsNumber(String string1)
	{
		return (string1.matches("[+-]?\\d*")&& string1.equals("") == false);
	}
}
