package Teclado;

import java.util.ArrayList;
import java.util.Iterator;

public class KeyboardLayoutNeutro extends KeyboardLayout
{
	public KeyboardLayoutNeutro()
	{

	}
	/**
	 * Retorna o valor relativo da distancia de duas teclas pelo maximo do teclado neutro
	 * @param firstChar Primeira tecla a ser calculada
	 * @param secondChar Segunda tecla a ser calculada
	 * @return
	 */
	public double getRelativeDistance(char firstChar, char secondChar)
	{
		return 1;
	}

	/**
	 * Retorna o custo da remoção ou inserção no teclado neutro.
	 */
	public double getInsertDeleteDistance()
	{
		return 1;
	}
	/**
	 * Retorna verdadeiro quando teclado neutro
	 */
	public boolean isNeutro()
	{
		return true;
	}
	/**
	 * Retorna maior distância entre teclas num teclado neutro 
	 */
	public double getMaximumDistance()
	{
		// TODO Auto-generated method stub
		return 1;
	}
}
