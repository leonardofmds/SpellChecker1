package Arvore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Object getWord(int position)
	{
		return listaPalavras.get(position).getPalavra();
		
	}

	public double getDistance(int position)
	{
		return listaPalavras.get(position).getDistancia();
	}
	
	public String findWord(String word)
	{
		for (PalavraDistancia palavraDistancia : listaPalavras)
		{
			if(palavraDistancia.getPalavra().equals(word))
				return word;
		}
		return null;
	}
	
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
