package Calculos;

import Teclado.KeyboardLayout;
/**
 * Implementada para calcular a distancia entre palavras usando o algoritmo de Leveinstein
 * @author suporte
 *
 */
public class LevenshteinCalculator implements IDistanceCalculator
{
	KeyboardLayout keyboardLayout = new KeyboardLayout();
	
	/**
	 * Calcula o valor mínimo entre 3 entradas
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static double minimum(double a, double b, double c)
	{
		return Math.min(Math.min(a, b), c);
	}
	
	/**
	 * Calcula o valor mínimo entre 2 entradas.
	 * @param a
	 * @param b
	 * @return
	 */
	public KeyboardLayout getKeyboardLayout()
	{
		return keyboardLayout;
	}
	/**
	 * Calcula a distância de acordo com o algoritmo de Leveinshtein
	 */
	public double distance(String s1, String s2)
	{
		CharSequence lhs = s1;
		CharSequence rhs = s2; 
				
		double[][] distance = new double[lhs.length() + 1][rhs.length() + 1];

		for (int i = 0; i <= lhs.length(); i++)
			distance[i][0] = i;
		for (int j = 1; j <= rhs.length(); j++)
			distance[0][j] = j;

		for (int i = 1; i <= lhs.length(); i++)
			for (int j = 1; j <= rhs.length(); j++)
				distance[i][j] = minimum(distance[i - 1][j] + keyboardLayout.getInsertDeleteDistance(), //remocao
										 distance[i][j - 1] + keyboardLayout.getInsertDeleteDistance(), //insercao
										 distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 //substituicao
								: keyboardLayout.getRelativeDistance(lhs.charAt(i - 1), rhs.charAt(j - 1))));
		
		return ((distance[lhs.length()][rhs.length()]));

	}
	/**
	 * Retorna o KeyboardLayout utilizado no calculo do custo das distancias.
	 */
	public LevenshteinCalculator(KeyboardLayout kl)
	{
		keyboardLayout = kl;
	}

}
