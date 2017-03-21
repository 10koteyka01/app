package Data_parser;

import Entity.Vacancy;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parse_Json {
    
    private final ArrayList<Vacancy> list = new ArrayList();
    private JSONObject js;
    
    public Parse_Json(String str){
        init_Json(str);
    }
    
    Parse_Json(JSONObject js) {
        this.js = js;
    }
    
    private void init_Json(String str){
        try{
            js = new JSONObject(str);
        }
        catch(JSONException e){
            System.err.println("Не удаётся передать строку в JSONObject " + e);
        }
    }
    
    public ArrayList<Vacancy> parse() throws JSONException, IOException{
        JSONArray arr = js.getJSONArray("items");
        JSONObject js1;
        if (arr != null)
            for (int i = 0; i < arr.length(); i++){
                Vacancy v = new Vacancy();
                js1 = (JSONObject) arr.get(i);
                v.setName((String) js1.get("name"));
                v.setDate((String) js1.get("published_at"));
                v.setOrganization((String) js1.getJSONObject("employer").get("name"));
                try{
                v.setPayment("from: " + js1.getJSONObject("salary").get("from") 
                        + " to: " + js1.getJSONObject("salary").get("to"));
                }
                catch(JSONException e){
                    v.setPayment("по результатам собеседования");
                }
                list.add(v);
            }
        else throw new IOException();
        return list;
    }
    
    public ArrayList getVacancyList(){
        return list;
    }
    
    @Override
    public String toString(){
        return iter_list();
    }
    
    public String iter_list(){
        StringBuilder sb = new StringBuilder();
        for(Vacancy v : list){
            sb.append(v.toString()).append("\n");
        }
        return sb.toString();
    }

    public boolean isListEmpty() {
        return list == null;
    }
}
