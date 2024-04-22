import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;
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
        Scanner escritura = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 7){
            System.out.println("""
                **************************************************
                    Sea bienvenido/a al Conversor de Divisas
                1. Dólar (USD)         ==>   Peso Mexicano(MXN)
                2. Peso Mexicano(MXD)  ==>   Dólar(USD)
                3. Dólar (USD)         ==>   Real Brasileño(BRL)
                4. Real Brasileño(BRL) ==>   Dólar(USD)
                5. Dólar(USD)          ==>   Peso Colombiano(COP)
                6. Peso Colombiano(COP ==>   Dólar(USD)
                7. Salir
                ***************************************************
                          Digite una opción del 1-7
                """);
            opcion= escritura.nextInt();
            if(opcion == 7){
                break;
            }else{
                String monedaOrigen = "";
                String monedaDestino = "";
                double cantidad = 0;
                System.out.println("Digite la cantidad que quiere convertir");
                cantidad =  escritura.nextDouble();
                switch (opcion){
                    case 1:
                        monedaOrigen= "USD";
                        monedaDestino = "MXN";
                        break;
                    case 2:
                        monedaOrigen = "MXN";
                        monedaDestino = "USD";
                        break;
                    case 3:
                        monedaOrigen = "USD";
                        monedaDestino = "BRL";
                    case 4:
                        monedaOrigen = "BRL";
                        monedaDestino = "USD";
                        break;
                    case 5:
                        monedaOrigen = "USD";
                        monedaDestino = "COP";
                        break;
                    case 6:
                        monedaOrigen = "COP";
                        monedaDestino = "USD";
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opción no valida");
                }
                String url_str = "https://v6.exchangerate-api.com/v6/c13901c49b8e52b594143010/latest/" + monedaOrigen;

                URL url = new URL(url_str);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();
                JsonParser jp = new JsonParser();
                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                JsonObject jsonobj = root.getAsJsonObject();

                JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
                String req_result =  rates.get(monedaDestino).getAsString();
                System.out.println(String.format("%s %.2f %s %s %s","$" ,Double.parseDouble(req_result) * cantidad , "(",monedaDestino,")"));
            }
        }
    }
}
