package Arvore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * É responsavel por armazenar a busca dos resultados compatíveis de uma palavra dentro de uma distancia feita em uma árvore BK
 * @author suporte
 *
 */
public class BurkhardKellerTreeSearchResult
{
	private List<PalavraDistancia> listaPalavras;
	
	public BurkhardKellerTreeSearchResult(List<PalavraDistancia> listaDePalavrasCompativeis)
	{
		this.listaPalavras = listaDePalavrasCompativeis;
		Collections.sort(listaPalavras);
		for(int i = 0; i< listaDePalavrasCompativeis.size();i++)
		{
			if(listaDePalavrasCompativeis.get(i).getDistancia()<0.63)
			System.out.println(listaDePalavrasCompativeis.get(i).getPalavra()+" "+listaDePalavrasCompativeis.get(i).getDistancia());
		}
		System.out.println(listaDePalavrasCompativeis.size());		
	}	
	/**
	 * Retorna a palavra da busca feita na bktree que se encontra na posicao passada por parâmetro.
	 * @param position
	 * @return
	 */
	public Object getWord(int position)
	{
		return listaPalavras.get(position).getPalavra();
		
	}
	/**
	 * Retorna a distancia da palavra feita na busca da bktree que se encontra na posicao passada por parâmetro.
	 * @param position
	 * @return
	 */
	public double getDistance(int position)
	{
		return listaPalavras.get(position).getDistancia();
	}
	/**
	 * Procura a palavra na lista da busca feita na bktree e a retorna se for encontrada
	 * @param word Palavra a ser encontrada na lista da busca feita na bktree
	 * @return 
	 */
	public String findWord(String word)
	{
		for (PalavraDistancia palavraDistancia : listaPalavras)
		{
			if(palavraDistancia.getPalavra().equals(word))
				return word;
		}
		return null;
	}
	/**
	 * Retorna a distância de uma palavra que se encontra na lista da busca feita na bktree
	 * @param word Palavra a ser encontrada
	 * @return Distancia da palavra
	 */
	public double getPalavraDistancia(String word)
	{
		for (PalavraDistancia palavraDistancia : listaPalavras)
		{
			if(palavraDistancia.getPalavra().equals(word))
				return palavraDistancia.getDistancia();
		}
		return -1;
	}

}
