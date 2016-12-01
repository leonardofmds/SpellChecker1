package Arvore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Calculos.IDistanceCalculator;
import Calculos.LevenshteinCalculator;
import Teclado.KeyboardLayout;

public class Node
{
	private final String palavra;

	private final Map<Integer, Node> filhos = new HashMap<Integer, Node>();

	public Node(String palavra)
	{
		this.palavra = palavra;
	}

	public Node filhosNumaDistancia(int distancia)
	{
		return filhos.get(distancia);
	}

	public void adicionaNoFilho(int posicao, Node noFilho)
	{
		filhos.put(posicao, noFilho);
	}

	public List<PalavraDistancia> busca(String no, int distanciaMaxima, IDistanceCalculator calculator)
	{
		ArrayList<PalavraDistancia> palavrasCompativeiss = new ArrayList<PalavraDistancia>();
		double distanciaLevenshtein = calculator.distance(palavra, no);
		
		double modifier = 1;
		
		if(calculator.getKeyboardLayout().isNeutro()==false)
			modifier = 100;
			
		distanciaLevenshtein = distanciaLevenshtein*modifier;
		distanciaMaxima = (int) (distanciaMaxima*modifier);
			
			
		if (distanciaLevenshtein <= distanciaMaxima)
		{
			palavrasCompativeiss.add(new PalavraDistancia(palavra, distanciaLevenshtein/modifier));
		}

		if (filhos.size() == 0)
		{
			return palavrasCompativeiss;
		}

		for (int i = Math.max(1, (int) distanciaLevenshtein - distanciaMaxima); i <= distanciaLevenshtein
				+ distanciaMaxima; i++)
		{
			// for (int i = 0; i < filhos.size(); i++)
			// {
			Node filho = filhos.get(i);
			if (filho != null)
			{
				palavrasCompativeiss.addAll(filho.busca(no, distanciaMaxima/(int)modifier, calculator));
			}
		}

		return palavrasCompativeiss;
	}

	public List<String> buscaStr(String no, int distanciaMaxima, IDistanceCalculator calculator)
	{
		// ArrayList<PalavraDistancia> palavrasCompativeiss = new
		// ArrayList<PalavraDistancia>();
		List<String> palavrasCompativeis = new ArrayList<String>();
		int distanciaLevenshtein = (int) calculator.distance(palavra, no);

		if (distanciaLevenshtein <= distanciaMaxima)
		{
			palavrasCompativeis.add(palavra);

			// palavrasCompativeiss.add(new PalavraDistancia(no,
			// distanciaMaxima-distanciaLevenshtein));
		}

		if (filhos.size() == 0)
		{
			return palavrasCompativeis;
			// return palavrasCompativeiss;
		}

		for (int i = Math.max(1, distanciaLevenshtein - distanciaMaxima); i <= distanciaLevenshtein
				+ distanciaMaxima; i++)
		{

			Node filho = filhos.get(i);
			if (filho != null)
			{
				palavrasCompativeis.addAll(filho.buscaStr(no, distanciaMaxima, calculator));
				// palavrasCompativeiss.addAll(filho.busca(no,
				// distanciaMaxima,calculator));
			}
		}

		return palavrasCompativeis;

	}

	public boolean equals(Node outroNo)
	{
		return palavra.equals(outroNo.palavra);
	}

	public String getPalavra()
	{
		return palavra;
	}

}