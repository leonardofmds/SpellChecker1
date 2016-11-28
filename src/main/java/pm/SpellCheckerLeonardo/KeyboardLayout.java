package pm.SpellCheckerLeonardo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import pm.SpellCheckerLeonardo.*;

public class KeyboardLayout
{

	private String model;
	private ArrayList<Line> lines;

	int largura = 0;
	int altura;

	char teclasMatrix[][];
	final int ALPHABETSIZE = 26;
	double distanciasMatrix[][];

	public KeyboardLayout()
	{
		lines = new ArrayList<Line>();
	}

	public void prepareKeysMatrix()
	{
		largura = 0;
		altura = lines.size();

		for (int i = 0; i < lines.size(); i++)
		{
			if (largura < lines.get(i).getContent().length())
				largura = lines.get(i).getContent().length();

		}

		teclasMatrix = new char[largura][altura];

		for (int j = 0; j < altura; j++)
		{
			for (int i = 0; i < largura; i++)
			{
				try
				{
					teclasMatrix[i][j] = lines.get(j).getContent().charAt(i);
				} catch (Exception e)
				{
				}
			}
		}
	}

	public void prepareDistances()
	{
		// TODO Auto-generated method stub
		prepareKeysMatrix();
	}

	public Iterator iterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}

	public ArrayList<Line> getLines()
	{
		return lines;
	}

	public void setLines(ArrayList<Line> lines)
	{
		this.lines = lines;
	}

	public void addLine(Line line)
	{
		lines.add(line);
	}

	public Double getAllOffSets(int n)
	{
		double offsetSum = 0;

		for (int i = 0; i <= n; i++)
		{
			offsetSum = offsetSum + lines.get(i).getOffset();
		}

		return offsetSum;
	}

	public double getNominalDistance(char c, char d)
	{
		c = Character.toUpperCase(c);
		d = Character.toUpperCase(d);
		// TODO Auto-generated method stub
		double cX = 0, cY = 0, dX = 0, dY = 0;

		for (int j = 0; j < altura; j++)
		{
			for (int i = 0; i < largura; i++)
			{
				// System.out.println(teclasMatrix[i][j]);
				if ((teclasMatrix[i][j]) == (c))
				{
					// System.out.println(teclasMatrix[i][j]);
					cX = i + getAllOffSets(j);
					cY = j;
				}
				if ((teclasMatrix[i][j]) == (d))
				{
					// System.out.println(teclasMatrix[i][j]);
					dX = i + getAllOffSets(j);
					dY = j;
				}

			}

		}

		// System.out.println(cX +" "+ cY+ " "+ dX+ " "+ dY);

		// x = x + lines.get((int)y).getOffset();
		// System.out.println(x);

		double difX;
		double difY;

		if (cX >= dX)
			difX = cX - dX;
		else
			difX = dX - cX;

		if (cY > dY)
			difY = cY - dY;
		else
			difY = dY - cY;

		double distancia = Math.sqrt(Math.pow((cX - dX), 2) + Math.pow((cY - dY), 2));

		return distancia;
	}

	public double getInsertDeleteDistance()
	{
		// TODO Auto-generated method stub
		double value = 0.25;
		
		double allOffsets = getAllOffSets(lines.size()-1);
		//System.out.println(allOffsets);
		
		if(allOffsets==0)
		{
			return 0;
		}	
		
		return value;
	}

	public double getMaximumDistance()
	{
		// TODO Auto-generated method stub
		double maior = 0;

		for (int j = 0; j < altura; j++)
		{
			for (int i = 0; i < largura; i++)
			{
				for (int k = 0; k < altura; k++)
				{
					for (int n = 0; n < largura; n++)
					{

						if ((teclasMatrix[i][j] != '\0'))
						{
							if ((teclasMatrix[n][k] != '\0'))
							{
								if (maior < getNominalDistance(teclasMatrix[i][j], teclasMatrix[n][k]))
								{
									maior = getNominalDistance(teclasMatrix[i][j], teclasMatrix[n][k]);
//									System.out.println(maior);
//									System.out.println(" " + teclasMatrix[i][j] + " " + teclasMatrix[n][k]);
								}
							}
						}

					}
				}
			}
		}
		return maior;
	}

}
