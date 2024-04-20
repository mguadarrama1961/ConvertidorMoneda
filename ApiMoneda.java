import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.logging.Logger;

public class ApiMoneda {
    private final Logger logger = Logger.getLogger(ApiMoneda.class.getName());
    private final HttpClient cliente = HttpClient.newBuilder()
            .version(Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public ApiMoneda() {
    }

    public String obtenerTasas() throws Exception {
        logger.info("Iniciando solicitud de tasas de cambio...");
        String uri = "https://api.exchangerate-api.com/v4/latest/USD";
        String claveApi = "5cb7dec42a7d67fe392eacd7";
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(uri + "?apikey=" + claveApi))
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());
        logger.info("Respuesta recibida con éxito.");

        return respuesta.body();
    }
}
