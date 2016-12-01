package Arvore;

import java.util.ArrayList;
import java.util.List;

import Calculos.IDistanceCalculator;
import Calculos.LevenshteinCalculator;
import Teclado.KeyboardLayout;

public class BurkhardKellerTree
{

	private Node raiz;

	private IDistanceCalculator calculator;

	/**
	 * Chama a funcao de busca do nó
	 */
	public List<PalavraDistancia> busca(String str, int distanciaMaximaPermitida, IDistanceCalculator calculator)
	{
//		 ArrayList<String> al = new ArrayList<String>();
//		
//		 al = (ArrayList<String>) raiz.buscaStr(str.toUpperCase(), distanciaMaximaPermitida, calculator);
//		
//		 for (String string : al)
//		 {
//		 System.out.println(string);
//		 }
		
		
		return raiz.busca(str.toUpperCase(), distanciaMaximaPermitida, calculator);
	}

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

	public BurkhardKellerTreeSearchResult search(String string, int i, int j)
	{
		ArrayList<PalavraDistancia> al = new ArrayList<PalavraDistancia>();
		al = (ArrayList<PalavraDistancia>) busca(string, i, calculator);

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
		if (srcNode.equals(novoNo))
		{
			return;
		}

		double distancia = calculator.distance(srcNode.getPalavra(), novoNo.getPalavra());
		if(calculator.getKeyboardLayout().isNeutro()==false)
			distancia = distancia*100;
		
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