package pm.SpellCheckerLeonardo;

import java.util.ArrayList;
import java.util.List;

public class BurkhardKellerTreeSearchResult
{
	List<String> result = new ArrayList<String>();
	
	public BurkhardKellerTreeSearchResult()
	{
		// TODO Auto-generated constructor stub
	}
	public BurkhardKellerTreeSearchResult(List<String> listaDePalavrasCompativeis)
	{
		// TODO Auto-generated constructor stub
		result = listaDePalavrasCompativeis;
	}	

	public Object getWord(int position)
	{
		// TODO Auto-generated method stub
		//return null;
		
		return result.get(position);
		
	}

	public double getDistance(int position)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
