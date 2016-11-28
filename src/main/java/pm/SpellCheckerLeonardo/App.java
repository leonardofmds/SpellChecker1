package pm.SpellCheckerLeonardo;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
//    	BurkhardKellerTree bktree = new BurkhardKellerTree();
//    	DictionaryReader dicionarioReader = new DictionaryReader();
//    	ArrayList<String> dicionario = dicionarioReader.loadFromFile("");
//    	
//    	bktree.adicionaListaDeNo(dicionario);
//    	
//    	bktree.busca("A",0).get(0);
//    	
//    	System.out.println(bktree.busca("A",1).get(21));    	
//    

//		IDistanceCalculator calculator = new LevenshteinCalculator(layout);
//		BurkhardKellerTree tree = new DictionaryReader().loadFromFile("data/dictionary pt-br.zip");
//		
//		BurkhardKellerTreeSearchResult result1 = new BurkhardKellerTreeSearchResult();
//		result1 = tree.search("casa", 0, 0);
		
		//System.out.println(result1.getWord(0));
    	
    	KeyboardLayoutList layouts = new KeyboardLayoutReader().loadFromFile("");
    	LevenshteinCalculator lc = new LevenshteinCalculator(layouts.getLayoutByName("QWERTY"));
    	System.out.println(lc.distance("casa", "caca"));
    
    
    
    }
}
