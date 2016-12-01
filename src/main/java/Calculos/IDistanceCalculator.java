package Calculos;

import Teclado.KeyboardLayout;

public interface IDistanceCalculator
{
	public double distance(String word1, String word2);
	public KeyboardLayout getKeyboardLayout();
}
