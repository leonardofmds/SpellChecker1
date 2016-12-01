package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import Arvore.BurkhardKellerTree;
import Calculos.IDistanceCalculator;
/**
 * Lê o conteúdo de um arquivo zip que contêm um dicionário de palavras e os adiciona em uma BK Tree.
 * @author suporte
 *
 */
public class DictionaryReader
{

	public static void main(String[] args)
	{
		DictionaryReader dr = new DictionaryReader();
	}

	public BurkhardKellerTree loadFromFile(String string,IDistanceCalculator calculator)
	{
		ArrayList<String> palavras = new ArrayList<String>();
		
		BurkhardKellerTree bktree = new BurkhardKellerTree(calculator);

		try
		{
			ZipFile zf = new ZipFile(string);

			ZipEntry entry = zf.entries().nextElement();

			InputStream inputStream = zf.getInputStream(entry);
			InputStreamReader isr = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(isr);
			String linha;
			while ((linha = buffer.readLine()) != null)
			{
				palavras.add(linha);
			}
			zf.close();
		} catch (IOException e)
		{

			e.printStackTrace();
		}
		
		bktree.adicionaListaDeNo(palavras);
		
		return bktree;
	}

}
