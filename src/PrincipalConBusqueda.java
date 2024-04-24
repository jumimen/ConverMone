
import java.io.IOException;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Proceso objeto = new Proceso();
        objeto.setOpcion();
        while(objeto.getOpcion() != 7){
            objeto.setMonedasConvertir(objeto.getOpcion());
            if(objeto.getMonedaOrigen() != null) {
                objeto.Resultado(objeto.getMonedaOrigen(), objeto.getMonedaDestino());
                objeto.setCantidad();
                if(objeto.getCantidad() != 0.00) {
                    System.out.println(objeto.toString(objeto.Resultado(objeto.getMonedaOrigen(), objeto.getMonedaDestino()), objeto.getCantidad()));
                    objeto.setOpcion();
                }else{
                     break;
                }
            }else {
                break;
            }
        }

//        Scanner escritura = new Scanner(System.in);
//        int opcion = 0;
//        while (opcion != 7){
//            System.out.println("""
//                **************************************************
//                    Sea bienvenido/a al Conversor de Divisas
//                1. Dólar (USD)         ==>   Peso Mexicano(MXN)
//                2. Peso Mexicano(MXD)  ==>   Dólar(USD)
//                3. Dólar (USD)         ==>   Real Brasileño(BRL)
//                4. Real Brasileño(BRL) ==>   Dólar(USD)
//                5. Dólar(USD)          ==>   Peso Colombiano(COP)
//                6. Peso Colombiano(COP ==>   Dólar(USD)
//                7. Salir
//                ***************************************************
//                          Digite una opción del 1-7
//                """);
//            try{
//                opcion = escritura.nextInt();
//            }catch (InputMismatchException e){
//                System.out.println("Solo números del 1-7");
//                System.out.println(e.getMessage());
//                break;
//            }
//            if(opcion == 7){
//                System.out.println("Vuelve pronto");
//                break;
//            }else{
//                String monedaOrigen = "";
//                String monedaDestino = "";
//                double cantidad = 0;
//                switch (opcion){
//                    case 1:
//                        monedaOrigen= "USD";
//                        monedaDestino = "MXN";
//                        break;
//                    case 2:
//                        monedaOrigen = "MXN";
//                        monedaDestino = "USD";
//                        break;
//                    case 3:
//                        monedaOrigen = "USD";
//                        monedaDestino = "BRL";
//                        break;
//                    case 4:
//                        monedaOrigen = "BRL";
//                        monedaDestino = "USD";
//                        break;
//                    case 5:
//                        monedaOrigen = "USD";
//                        monedaDestino = "COP";
//                        break;
//                    case 6:
//                        monedaOrigen = "COP";
//                        monedaDestino = "USD";
//                        break;
//                    case 7:
//                        System.out.println("Vuelve pronto");
//                        break;
//                    default:
//                        System.out.println("Opción no valida");
//                        continue;
//                }
//                System.out.println("Digite la cantidad que quiere convertir");
//                try{
//                    cantidad= escritura.nextDouble();
//                }catch (InputMismatchException e){
//                    System.out.println("Solo puede ingresar números, si son decimales separados por,");
//                    System.out.println(e.getMessage());
//                }
//                String url_str = "https://v6.exchangerate-api.com/v6/c13901c49b8e52b594143010/latest/" + monedaOrigen;
//                URL url = new URL(url_str);
//                HttpURLConnection request = (HttpURLConnection) url.openConnection();
//                request.connect();
//                JsonParser jp = new JsonParser();
//                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//                JsonObject jsonobj = root.getAsJsonObject();
//                JsonObject rates = jsonobj.getAsJsonObject("conversion_rates");
//                String req_result =  rates.get(monedaDestino).getAsString();
//                System.out.println(String.format("%s %.2f %s %s %s","Valor $" ,Double.parseDouble(req_result) * cantidad , "(",monedaDestino,")"));
//            }
//        }
      }
}
