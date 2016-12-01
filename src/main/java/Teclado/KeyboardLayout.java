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
	/**
	 * Retorna falso se o KeyboardLayout não é neutro
	 * @return
	 */
	public boolean isNeutro()
	{
		return false;
	}
	/**
	 * prepara uma matriz que representa a disposição das teclas de um teclado e cada uma de suas letras
	 */
	/**
	 * Instancia e preenche uma matriz que represente o teclado, suas teclas e coordenadas.
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
	/**
	 * Executa a função que instancia e preenche a matriz de teclado e a função que calcula a distância máxima do teclado.
	 */
	public void prepareDistances()
	{
		prepareKeysMatrix();
		maxDistance = getMaximumDistance();
	}
	/**
	 * Retorna modelo do teclado
	 * @return
	 */
	public String getModel()
	{
		return model;
	}
	/**
	 * Seta o modelo do teclado
	 * @param model
	 */
	public void setModel(String model)
	{
		this.model = model;
	}
	/**
	 *Retorna uma lista com as linhas do teclado 
	 * @return
	 */
	public ArrayList<Line> getLines()
	{
		return lines;
	}
	/**
	 * Seta as linhas do teclado
	 * @param lines Lista de objetos Line, que são as linhas do teclado
	 */
	public void setLines(ArrayList<Line> lines)
	{
		this.lines = lines;
	}
	/**
	 * Adiciona uma linha no teclado
	 * @param line
	 */
	public void addLine(Line line)
	{
		lines.add(line);
	}
	/**
	 * utilizado para ajudar no calculo da distância quando são comparadas linhas não vizinhas, somando os offsets de cada linha entre elas
	 * @param n numero de linhas do teclado
	 * @return soma dos offsets entre as linhas
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
	/**
	 * Retorna o custo da remoção ou inserção.
	 */
	public double getInsertDeleteDistance()
	{
		double value = 0.25;
		return value;
	}
	/**
	 * Retorna o valor relativo da distancia de duas teclas pelo maximo do teclado neutro
	 * @param firstChar Primeira tecla a ser calculada
	 * @param secondChar Segunda tecla a ser calculada
	 * @return
	 */
	public double getRelativeDistance(char firstChar, char secondChar)
	{
		return (getNominalDistance(firstChar, secondChar)/maxDistance);
	}
	/**
	 * Retorna a maior distância entre as teclas dispostas no teclado
	 * @return
	 */
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
