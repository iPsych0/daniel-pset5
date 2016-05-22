package daniel.daniel_pset5;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Jasper school on 22-5-2016.
 */
public class Test {

    private static final String url1 = "http://api.filmtotaal.nl/filmsoptv.xml";
    private static final String url2 = "?apikey=j8noahkyi6fq4v1bgqrcfysgvvxaicb9";
    private static final String url3 = "&format=json";

    protected static synchronized String downloadFromServer(String... params) {
        //declare return string result
        String result = "";

        //chosen tag from argument
        String chosenTag = params[0];

        //complete string url
        String fullUrl = url1 + url2 + "&dag=" + chosenTag + "&sorteer=0" + url3;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fullUrl);
            NodeList filmList = doc.getElementsByTagName("titel");
            for(int i = 0; i < filmList.getLength(); i++){
                Node f = filmList.item(i);
                if(f.getNodeType()==Node.ELEMENT_NODE){
                    Element film = (Element) f;
                    NodeList titles = film.getChildNodes();
                    for(int j = 0; j < titles.getLength(); j++){
                        Node t = titles.item(j);
                        if (t.getNodeType()==Node.ELEMENT_NODE){
                            Element title = (Element) t;
                            String alltitles = title.getNodeValue();
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
