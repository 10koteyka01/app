package OAuth;

import Data_parser.Parse_Json;
import com.github.scribejava.apis.HHApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Parameter;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;


public class OAuth_util {
    public void getToken() throws IOException, InterruptedException, ExecutionException{
        final String clientId = OAuth_Constants.CLIENT_ID;
        final String clientSecret = OAuth_Constants.CLIENT_SECRET;
        final OAuth20Service service = new ServiceBuilder()
                .apiKey(clientId)
                .apiSecret(clientSecret)
                .callback(OAuth_Constants.REDIRECT_URI)
                .build(HHApi.instance());
        final Scanner in = new Scanner(System.in);
        List<Parameter> list_vacancyes = new ArrayList();
        // Obtain the Authorization URL
        System.out.println("Fetching the Authorization URL...");
        final String authorizationUrl = service.getAuthorizationUrl();
        System.out.println("Got the Authorization URL!");
        System.out.println("Now go and authorize ScribeJava here:");
        System.out.println(authorizationUrl);
        System.out.println("And paste the authorization code here");
        System.out.print(">>");
        
        final String code = in.nextLine();
        System.out.println();
        // Trade the Request Token and Verfier for the Access Token
        System.out.println("Trading the Request Token for an Access Token...");
        final OAuth2AccessToken accessToken = service.getAccessToken(code);
        
        System.out.println("Got the Access Token!");
        System.out.println("(if your curious it looks like this: " + accessToken
                + ", 'rawResponse'='" + accessToken.getRawResponse() + "')");
        System.out.println();

        System.out.println("Now we're going to access a protected resource...");
        while (true){
            int count_pages = 0;
        final OAuthRequest request = new OAuthRequest(Verb.GET, String.format(OAuth_Constants.PROTECTED_RESOURCE_URL, count_pages));
        service.signRequest(accessToken, request);
        final Response response = service.execute(request);
        System.out.println("Got it! Lets see what we found...");

        System.out.println(response.getCode());
//        System.out.println(response.getBody());
        Parse_Json p = new Parse_Json(response.getBody());
        try {
            p.parse();
            System.out.println(p.toString());
        } catch (JSONException ex) {
            Logger.getLogger(OAuth_util.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (p.isListEmpty()) break;
        count_pages++;
        }
    }
    public static void main(String[] args){
        OAuth_util o = new OAuth_util();
        try {
            o.getToken();
        } catch (IOException ex) {
            Logger.getLogger(OAuth_util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(OAuth_util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(OAuth_util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
