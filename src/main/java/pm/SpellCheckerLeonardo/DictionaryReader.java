package pm.SpellCheckerLeonardo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DictionaryReader
{

	public static void main(String[] args)
	{
		DictionaryReader dr = new DictionaryReader();

//		ArrayList<String> al = new ArrayList<String>();
//		al = dr.loadFromFile(local);
//
//		for (int i = 0; i < al.size(); i++)
//		{
//			System.out.println(al.get(i));
//		}
	}

	public BurkhardKellerTree loadFromFile(String string, IDistanceCalculator calculator)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public BurkhardKellerTree loadFromFile(String string)
	{
		string = "dictionary_pt-br.zip";
		ArrayList<String> palavras = new ArrayList<String>();
		
		BurkhardKellerTree bktree = new BurkhardKellerTree();

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
