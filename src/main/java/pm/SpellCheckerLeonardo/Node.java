package pm.SpellCheckerLeonardo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pm.SpellCheckerLeonardo.LevenshteinCalculator;
import pm.SpellCheckerLeonardo.KeyboardLayout;

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

	public List<String> busca(String no, int distanciaMaxima)
	{

		List<String> palavrasCompativeis = new ArrayList<String>();

		LevenshteinCalculator levenshteinCalculator = new LevenshteinCalculator(new KeyboardLayout());

		int distanciaLevenshtein = levenshteinCalculator.computeLevenshteinDistance(palavra, no);
		if (distanciaLevenshtein <= distanciaMaxima)
		{
			palavrasCompativeis.add(palavra);
		}

		if (filhos.size() == 0)
		{
			return palavrasCompativeis;
		}

		for (int i = Math.max(1, distanciaLevenshtein - distanciaMaxima); i <= distanciaLevenshtein
				+ distanciaMaxima; i++)
		{

			Node filho = filhos.get(i);
			if (filho != null)
			{
				palavrasCompativeis.addAll(filho.busca(no, distanciaMaxima));
			}
		}
		return palavrasCompativeis;
	}

	public List<String> busca(String no, int distanciaMaxima, KeyboardLayout layout)
	{
		List<String> palavrasCompativeis = new ArrayList<String>();
		LevenshteinCalculator levenshteinCalculator = new LevenshteinCalculator(layout);

		int distanciaLevenshtein = levenshteinCalculator.computeLevenshteinDistance(palavra, no);
		if (distanciaLevenshtein <= distanciaMaxima)
		{
			palavrasCompativeis.add(palavra);
		}

		if (filhos.size() == 0)
		{
			return palavrasCompativeis;
		}

		for (int i = Math.max(1, distanciaLevenshtein - distanciaMaxima); i <= distanciaLevenshtein
				+ distanciaMaxima; i++)
		{

			Node filho = filhos.get(i);
			if (filho != null)
			{
				palavrasCompativeis.addAll(filho.busca(no, distanciaMaxima));
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