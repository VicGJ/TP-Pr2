//Clase de la que heredan otras clases
package ByteCode;

import CPU.CPU;

//ByteCode: Encapsula los distintos bytecodes de la practica
abstract public class ByteCode 
{
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] words);
}
