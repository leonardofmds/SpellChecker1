package pm.SpellCheckerLeonardo;

import java.util.ArrayList;
import java.util.List;

import pm.SpellCheckerLeonardo.LevenshteinCalculator;
import pm.SpellCheckerLeonardo.KeyboardLayout;

public class BurkhardKellerTree
{

	private Node raiz;

	/**
	 * Chama a funcao de busca do nó
	 */
	public List<String> busca(String str, int distanciaMaximaPermitida)
	{
		return raiz.busca(str.toUpperCase(), distanciaMaximaPermitida, new KeyboardLayout());
	}
	public BurkhardKellerTree()
	{
		
	}
	public BurkhardKellerTree(Node root)
	{
		raiz = root;
	}

	/**
	 * Devolve a arvore resultado da busca
	 */
	
	public Node getRaiz()
	{
		return raiz;
	}
	public BurkhardKellerTreeSearchResult search(String string, int i, int j)
	{
			
		BurkhardKellerTreeSearchResult bktreesearchresult = new BurkhardKellerTreeSearchResult();
		return null;
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
		if (srcNode.equals(novoNo))
		{
			return;
		}

		LevenshteinCalculator levenshteinCalculator = new LevenshteinCalculator(new KeyboardLayout());

		int distancia = (int)levenshteinCalculator.distance(srcNode.getPalavra(), novoNo.getPalavra());

		Node bkNode = srcNode.filhosNumaDistancia(distancia);

		if (bkNode == null)
		{
			srcNode.adicionaNoFilho(distancia, novoNo);

		}
		// senao cria um nó filho
		else
		{
			adiciona(bkNode, novoNo);
		}
	}

}