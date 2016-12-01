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
	/**
	 * Retorna o Node filho que se encontra na distancia
	 * @param distancia: Posicao na hashmap onde se encontra o filho 
	 * @return Node filho na posição distancia
	 */
	public Node filhosNumaDistancia(int distancia)
	{
		return filhos.get(distancia);
	}
	/**
	 * Adiciona um Node à hashmap de filhos na posicao passada
	 * @param posicao posição onde irá ser inserido Node
	 * @param noFilho Node a ser inserido
	 */
	public void adicionaNoFilho(int posicao, Node noFilho)
	{
		filhos.put(posicao, noFilho);
	}
	
	/**
	 * Retorna uma lista de PalavraDistancia
	 * @param no Palavra a ser comparada
	 * @param distanciaMaxima Distancia máxima entre a palavra a ser comparada e as palavras do dicionário.
	 * @param calculator Tipo de cálculo que será realizado, Levenshtein ou Damerau-Leveinshtein
	 * @return
	 */
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
	/**
	 * Testa se a palavra do nó é a mesma que a palavra de outro nó passado no parâmetro
	 * @param outroNo
	 * @return 
	 */
	public boolean equals(Node outroNo)
	{
		return palavra.equals(outroNo.palavra);
	}
	
	/**
	 * Retorna a palavra do no
	 * @return
	 */
	public String getPalavra()
	{
		return palavra;
	}

}