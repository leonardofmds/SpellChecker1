package Calculos;

import Teclado.KeyboardLayout;
/**
 * Interface a ser implementada nas classes LevenshteinCalculator e DemerauLevenshteinCalculator
 * @author suporte
 *
 */
public interface IDistanceCalculator
{
	public double distance(String word1, String word2);
	public KeyboardLayout getKeyboardLayout();
}
