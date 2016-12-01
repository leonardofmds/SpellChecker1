package Teclado;

import java.util.ArrayList;
import java.util.Iterator;

public class KeyboardLayoutNeutro extends KeyboardLayout
{
	public KeyboardLayoutNeutro()
	{

	}
	
	public double getRelativeDistance(char firstChar, char secondChar)
	{
		return 1;
	}

	public double getInsertDeleteDistance()
	{
		return 1;
	}
	
	public boolean isNeutro()
	{
		return true;
	}

	public double getMaximumDistance()
	{
		// TODO Auto-generated method stub
		return 1;
	}
}
