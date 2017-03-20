package OAuth;

public class OAuth_Constants {
    //https://github.com/hhru/api/blob/master/docs/authorization.md
    public static final String RESPONSE_TYPE = "";//способ получения авторизации
    public static final String CLIENT_ID = "J9JT1VFTB0KEM6AAVR9Q61K4F6SEIT9BOGQCJ4T2NJ2NVI98V0832G9K7306GLTV";//идентификатор, получаемый при создании приложения
    public static final String STATE = "";//необязательный параметр для безопасности
    public static final String REDIRECT_URI = "https://ex.com";//uri для перенаправления пользователя после авторизации(не обязателен)
    public static final String CLIENT_SECRET = "N15GDJTCAVF3EPJO6DGEFBBIV3PBN4SB0RM32KTR3KHV4IHD5TVM1RP6B9721OQI";//пароль, получаемый вместе с client_id
    public static final String AUTHORIZTAION_CODE = "";
    public static final String ACCESS_TOKEN = "ME8V0ESGEOKEFEFUAGCRNNBES69DUHLKCRQ8OD0GOP0GUU6P8KV60IHP4OT6N60B";//
    public static final String PROTECTED_RESOURCE_URL = "https://api.hh.ru/vacancies?text=&specialization=1&area=4&per_page=500";//right query
    public static final String REDIRECT_URL = "https://novosibirsk.hh.ru";
    public static final String USER_ID = "16646808";
    public static final String name_vac_node = "vacancy-list-item__name";
    public static final String date_vac_node = "vacancy-pubdate";
    public static final String org_vac_node = "vacancy-list-item__company";
    public static final String payment_vac_node = "vacancy-list-item__salary";
    
    
    public static final int HTTP_OK = 200;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_UNAUTHORIZED = 401;
}
//https://novosibirsk.hh.ru/search/vacancy?text=&specialization=1&area=4&salary=&currency_code=RUR&experience=doesNotMatter&order_by=relevance&search_period=&items_on_page=20&no_magic=true


