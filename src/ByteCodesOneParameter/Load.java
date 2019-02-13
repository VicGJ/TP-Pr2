//Carga la posicion j de la memoria
package ByteCodesOneParameter;

import ByteCode.ByteCode;
import ByteCode.ByteCodeParser;
import CPU.CPU;

public class Load extends ByteCodesOneParameter{
	public Load(){}
	public Load(int j)
	{super(j);}
	@Override
	protected ByteCode parseAux(String string1, String string2) {
		if (string1.equalsIgnoreCase("Load") && ByteCodeParser.IsNumber(string2)) return new Load(Integer.parseInt(string2));
		else return null;
	}

	@Override
	protected String toStringAux() {
		return "Load";
	}

	@Override
	public boolean execute(CPU cpu) {
		cpu.push(cpu.read(this.param));
		cpu.increaseProgramCounter();
		return true;
	}
}
