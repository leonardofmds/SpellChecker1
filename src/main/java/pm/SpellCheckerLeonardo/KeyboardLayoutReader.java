package pm.SpellCheckerLeonardo;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class KeyboardLayoutReader {

	private static final int LINHAS_PADRAO = 3;
	
	public static void main(String[] args) 
	{
		KeyboardLayoutReader.loadFromFile("");
	}
	
	public static KeyboardLayoutList loadFromFile(String string) {
		
		string = "KeyboardLayouts.xml";
		
		//cria uma instância de keyboardlayoutlist que é uma lista de layouts
		KeyboardLayoutList keylaylist = new KeyboardLayoutList();

		try {

			File fXmlFile = new File(string);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("layout");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);


				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					//cria instancia de keyboard que será lida do xml e adicionada a lista de layouts
					KeyboardLayout kl = new KeyboardLayout();

					Element eElement = (Element) nNode;
					
					//adiciona o model ao keyboardlayout
					kl.setModel(eElement.getAttribute("model"));
					
					System.out.println("");
					System.out.println(kl.getModel());

					for (int i = 0; i < LINHAS_PADRAO; i++) {
						
						Line line = new Line();
						
						String content = eElement.getElementsByTagName("line").item(i).getTextContent();
						line.setContent(content);
						kl.addLine(line);

						String offset = ""+ eElement.getElementsByTagName("line").item(i).getAttributes().getNamedItem("offset");
						
						if (!offset.equals("null")) {
							//a string retornada por getNamedItem retorna todo o atributo, incluindo o nome dele ex: offset="0.5"
							//substring na String offset cortará a parte da string "offset=" para que só o valor seja pego
							offset = offset.substring(8, offset.length() - 1);
							Double cont = Double.parseDouble(offset);
							//adiciona-se o valor do offset para a linha
							line.setOffset(cont);

						}
						//adiona um keyboardlayout a lista de layouts.
						keylaylist.add(kl);
						System.out.println(kl.getLines().get(i).getContent() + " offset :" +kl.getLines().get(i).getOffset() );

					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
		return keylaylist;

	}

}
