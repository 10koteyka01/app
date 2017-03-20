package Data_parser;
public class Query_for_get_data {
    private final String address = "https://api.hh.ru/vacancies?text=";
    private String area;//area=4 - Новосибирск
    private String specialization;//specialization=1 - IT
    
    public String getQuery(){
        return "https://api.hh.ru/vacancies?text=&specialization=%d&area=%d&per_page=100&page=3";
    }
    
}

