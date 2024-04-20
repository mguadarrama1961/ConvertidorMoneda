import java.util.Map;

public class ConversorMoneda {
    private Map<String, Double> tasas;

    public ConversorMoneda(Map<String, Double> tasas) {
        this.tasas = tasas;
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        if (!tasas.containsKey(monedaOrigen) || !tasas.containsKey(monedaDestino)) {
            throw new IllegalArgumentException("Una de las monedas no está disponible para la conversión.");
        }

        double tasaOrigen = tasas.get(monedaOrigen);
        double tasaDestino = tasas.get(monedaDestino);
        return (cantidad / tasaOrigen) * tasaDestino;
    }
}
