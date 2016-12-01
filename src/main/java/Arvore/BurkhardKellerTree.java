package Arvore;

import java.util.ArrayList;
import java.util.List;

import Calculos.IDistanceCalculator;
import Calculos.LevenshteinCalculator;
import Teclado.KeyboardLayout;
/**
 * Implementa um objeto Node e uma Interface IDistanceCalculator
 * É responsavel por estruturar os dados de um dicionário e as distancias entre as palavras seguindo uma métrica
 * com o calculo de Leveinshtein ou Damerau-Leveinshtein
 * @author suporte
 *
 */
public class BurkhardKellerTree
{
	private Node raiz;

	private IDistanceCalculator calculator;

	/**
	 * Chama a funcao de busca do nó
	 */
//	public List<PalavraDistancia> busca(String str, int distanciaMaximaPermitida, IDistanceCalculator calculator)
//	{
//		return raiz.busca(str.toUpperCase(), distanciaMaximaPermitida, calculator);
//	}

	public BurkhardKellerTree(IDistanceCalculator calculator)
	{
		this.calculator = calculator;
	}

	/**
	 * Devolve a arvore resultado da busca
	 */

	public Node getRaiz()
	{
		return raiz;
	}
	/**
	 * Chama a fução de busca do nó
	 * @param string Palavra a ser buscada
	 * @param i distância máxima da palavra buscada
	 * @param j quantidade máxima de elementos da lista retornada
	 * @return Lista de PalavraDistancia das palavras dentro da distância calculada por Leveinshtein ou Damerau-Levenshtein
	 */
	public BurkhardKellerTreeSearchResult search(String string, int i, int j)
	{
		ArrayList<PalavraDistancia> al = new ArrayList<PalavraDistancia>();
		al = (ArrayList<PalavraDistancia>) raiz.busca(string.toUpperCase(), i, calculator);

		BurkhardKellerTreeSearchResult bktreeSearch = new BurkhardKellerTreeSearchResult(al);

		return bktreeSearch;
	}

	/**
	 * Cria no a partir de string passada e adiciona o no a arvore
	 */
	public void adicionaNo(String no)
	{
		if (no == null || no.isEmpty())
		{
		} else
		{

			Node newNode = new Node(no);
			if (raiz == null)
			{
				raiz = newNode;
			} else
			{
				adiciona(raiz, newNode);
			}
		}
	}

	/**
	 * Adiciona lista de palavras nos a arvore
	 */
	public void adicionaListaDeNo(List<String> nos)
	{
		for (String node : nos)
		{
			adicionaNo(node);
		}
	}

	/**
	 * Adiciona nó a árvore
	 */
	private void adiciona(Node srcNode, Node novoNo)
	{
		double modifier = 1;
		
		if (srcNode.equals(novoNo))
		{
			return;
		}

		double distancia = calculator.distance(srcNode.getPalavra(), novoNo.getPalavra());
		if(calculator.getKeyboardLayout().isNeutro()==false)
			modifier = 100;
		
			distancia = distancia*modifier;
		
		Node bkNode = srcNode.filhosNumaDistancia((int)distancia);

		if (bkNode == null)
		{
			srcNode.adicionaNoFilho((int)distancia, novoNo);

		}
		// senao cria um nó filho
		else
		{
			adiciona(bkNode, novoNo);
		}
	}

}