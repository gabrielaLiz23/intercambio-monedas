import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultaApi {
    double valFinal, conversion, monto;

    public Moneda buscarMonedas (String moneda_base, String moneda_conversion){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/74ebd5fde453b8c93644c554/pair/" + moneda_base + "/" + moneda_conversion);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa película.");
        }

    }

    public void calcularCambio(String moneda_base, String  moneda_convertida, Scanner lectura){

        System.out.println("Ingrese el valor que desea convertir: ");
        try {
            monto = lectura.nextDouble();  // Intentar leer un valor numérico
            conversion = buscarMonedas(moneda_base, moneda_convertida).conversion_rate();  // Obtener la tasa de conversión
            valFinal = monto * conversion;
            System.out.println("El valor de " + monto + " (" + moneda_base + ")" + " es de: " + valFinal + " (" + moneda_convertida + ")");
        } catch (InputMismatchException e) {
            System.out.println("El valor ingresado no es una cantidad numérica");
            lectura.next();  // Limpiar el valor inválido del buffer
        }

    }

}
