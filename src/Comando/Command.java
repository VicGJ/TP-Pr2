//Dirige otras clases que heredan de esta
package Comando;

import Practica2.Engine;

//Command: Encapsula los distintos comandos de la aplicacion
abstract public class Command 
{
	abstract public boolean execute(Engine engine);
	
	abstract public Command parse(String[] s);
	
	abstract public String textHelp();
	
}
