package Data_parser;
public class Query_for_get_data {
    
    private final String address = "https://api.hh.ru/vacancies?text=";
    
    public String getQuery(double area, double specialization){
        return String.format(address + "&specialization=%f&area=%f&per_page=100&page=", area, specialization);
    }
    
}

