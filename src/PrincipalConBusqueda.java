import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url_str = "https://v6.exchangerate-api.com/v6/c13901c49b8e52b594143010/latest/USD";

// Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        //System.out.println(jsonobj);
// Accessing object
        //String req_result = jsonobj.get("result").getAsString();

        JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
        String req_result = rates.get("MXN").getAsString();
        System.out.println(req_result);
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://v6.exchangerate-api.com/v6/c13901c49b8e52b594143010/latest/USD"))
//                .build();
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response.body());
    }
}
