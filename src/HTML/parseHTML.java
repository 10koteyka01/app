package HTML;

import Entity.Vacancy;
import OAuth.OAuth_Constants;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//http://info.javarush.ru/translation/2014/12/21/3-примера-как-разобрать-HTML-файл-в-Java-используя-Jsoup-.html
//https://jsoup.org/cookbook/
//example: https://github.com/jhy/jsoup/blob/master/src/main/java/org/jsoup/examples/ListLinks.java 

public class parseHTML {
    private final String file_name;
    
    public parseHTML(String file_name){
        this.file_name = file_name;
    }
    
    public void parse(){
    Document doc;
    File file = new File(file_name);
        try {
//            doc = Jsoup.connect(file_name).get();
            doc = Jsoup.parse(file, "UTF-8", OAuth_Constants.PROTECTED_RESOURCE_URL);
            Elements links = doc.getElementsByTag("div");
            for (Element link : links) {
                Vacancy vac = new Vacancy();
                if(link.tagName().contains(OAuth_Constants.name_vac_node)){
                    vac.setName(link.text());
            }
                if(link.tagName().contains(OAuth_Constants.org_vac_node)){
                    vac.setOrganization(link.text());
        } 
                if(link.tagName().contains(OAuth_Constants.payment_vac_node)){
                    vac.setPayment(link.text());
                }
                System.out.println(link.attr(OAuth_Constants.name_vac_node));
//                System.out.println(link.text());
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(parseHTML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
           new parseHTML("C:\\Users\\константин\\Desktop\\1.html").parse();
    }
}

