package Calculos;

import Teclado.KeyboardLayout;

public class LevenshteinCalculator implements IDistanceCalculator
{
	KeyboardLayout keyboardLayout = new KeyboardLayout();

	private static double minimum(double a, double b, double c)
	{
		return Math.min(Math.min(a, b), c);
	}
	
	public KeyboardLayout getKeyboardLayout()
	{
		return keyboardLayout;
	}

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
				distance[i][j] = minimum(distance[i - 1][j] + keyboardLayout.getInsertDeleteDistance(), distance[i][j - 1] + keyboardLayout.getInsertDeleteDistance(),
						distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 
								: keyboardLayout.getRelativeDistance(lhs.charAt(i - 1), rhs.charAt(j - 1))));
		
		return ((distance[lhs.length()][rhs.length()]));

	}

	public LevenshteinCalculator(KeyboardLayout kl)
	{
		keyboardLayout = kl;
	}

}
