import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proceso {

    private int opcion;
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    Scanner escritura = new Scanner(System.in);

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion() {
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
            try{
                this.opcion = escritura.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Solo números del 1-7");
            }
    }

    public void setMonedasConvertir(int opcion){
            switch (opcion) {
                case 1:
                    this.monedaOrigen = "USD";
                    this.monedaDestino = "MXN";
                    break;
                case 2:
                    this.monedaOrigen = "MXN";
                    this.monedaDestino = "USD";
                    break;
                case 3:
                    this.monedaOrigen = "USD";
                    this.monedaDestino = "BRL";
                    break;
                case 4:
                    this.monedaOrigen = "BRL";
                    this.monedaDestino = "USD";
                    break;
                case 5:
                    this.monedaOrigen = "USD";
                    this.monedaDestino = "COP";
                    break;
                case 6:
                    this.monedaOrigen = "COP";
                    this.monedaDestino = "USD";
                    break;
                default:
                    System.out.println("Opción no valida");
                    setOpcion();
            }
    }
    public String getMonedaOrigen() {
            return monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad() {
        System.out.println("Digite la cantidad que quiere convertir");
                try{
                    this.cantidad= escritura.nextDouble();
                }catch (InputMismatchException e){
                    System.out.println("Solo puede ingresar números, si son decimales separados por,");
                    System.out.println(e.getMessage());
                }
    }

    public double Resultado(String monedaOrigen, String monedaDestino) throws IOException {
            String url_str = "https://v6.exchangerate-api.com/v6/c13901c49b8e52b594143010/latest/" + monedaOrigen;
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject jsonobj = root.getAsJsonObject();
            JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
            String req_result = rates.get(monedaDestino).getAsString();
            return Double.parseDouble(req_result);
    }

    public String toString(double resultado, double cantidad){
        return String.format("%s %.2f %s %s %s","Valor $" ,resultado * cantidad , "(",monedaDestino,")");
    }
}
