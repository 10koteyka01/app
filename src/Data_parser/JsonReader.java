package Data_parser;

import Entity.Vacancy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {
    
    public JsonReader(){
        
    }
    

//receive url, set it to the function readjsonfromurl
//parse it and return arraylist
//if somthing wrong it returns null
    
    public ArrayList<Vacancy> get_list_vacancies_from_URL(String url){
        try {
            JSONObject json = readJsonFromUrl(url);
            Parse_Json ps = new Parse_Json(json);
            System.out.println(ps.toString());
            return ps.parse();
        } catch (IOException | JSONException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //connect to url, which receive by string, open inputstream, 
    //download all data from url and return it by JSONObject
    
    private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    try (InputStream is = new URL(url).openStream()) {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    }
  }
   
    //receive reader and append data into stringbuilder
    //which returns by string
    
    private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }
//  public static void main(String[] args) throws IOException, JSONException {
//    JSONObject json = readJsonFromUrl("https://api.hh.ru/vacancies?text=&specialization=1&area=4&per_page=100&page=3");
//    Parse_Json ps = new Parse_Json(json);
//    ps.parse();
//  }
}
