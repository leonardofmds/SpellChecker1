package Teclado;

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
	
	double maxDistance;

	char teclasMatrix[][];

	public KeyboardLayout()
	{
		lines = new ArrayList<Line>();
	}
	
	public boolean isNeutro()
	{
		return false;
	}
	/**
	 * prepara uma matriz que representa a disposição das teclas de um teclado e cada uma de suas letras
	 */
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
		prepareKeysMatrix();
		maxDistance = getMaximumDistance();
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
	/**
	 * utilizado para ajudar no calculo da distância quando são comparadas linhas não vizinhas, somando os offsets de cada linha entre elas
	 * @param n numero de linhas do teclado
	 * @return
	 */
	public Double getAllOffSets(int n)
	{
		double offsetSum = 0;

		for (int i = 0; i <= n; i++)
		{
			offsetSum = offsetSum + lines.get(i).getOffset();
		}

		return offsetSum;
	}
	/**
	 * utiliza a matriz montada no prepare distances para calcular a distância entre pontos utilizando suas coordenadas e os offsets(quando houver)
	 * @param c primeira tecla a ser comparada
	 * @param d segunda tecla a ser comparada
	 * @return
	 */
	public double getNominalDistance(char c, char d)
	{
		c = Character.toUpperCase(c);
		d = Character.toUpperCase(d);

		double cX = 0, cY = 0, dX = 0, dY = 0;

		for (int j = 0; j < altura; j++)
		{
			for (int i = 0; i < largura; i++)
			{
				if ((teclasMatrix[i][j]) == (c))
				{
					cX = i + getAllOffSets(j);
					cY = j;
				}
				if ((teclasMatrix[i][j]) == (d))
				{
					dX = i + getAllOffSets(j);
					dY = j;
				}

			}

		}

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
		double value = 0.25;
		return value;
	}
	
	public double getRelativeDistance(char firstChar, char secondChar)
	{
		return (getNominalDistance(firstChar, secondChar)/maxDistance);
	}

	public double getMaximumDistance()
	{
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
