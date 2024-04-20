import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PrincipalCambioMoneda {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_BLINK = "\u001B[5m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";

    public static void main(String[] args) {
        ApiMoneda apiMoneda = new ApiMoneda();
        Scanner scanner = new Scanner(System.in);

        try {
            String resultado = apiMoneda.obtenerTasas();
            JsonObject objetoJson = JsonParser.parseString(resultado).getAsJsonObject();

            if (objetoJson.has("rates")) {
                JsonObject rates = objetoJson.getAsJsonObject("rates");
                Map<String, Double> sortedRates = new TreeMap<>();

                for (String key : rates.keySet()) {
                    sortedRates.put(key, rates.get(key).getAsDouble());
                }

                System.out.println(ANSI_BLUE + "Tasas de cambio disponibles:");
                System.out.println("-----------------------------------" + ANSI_RESET);
                sortedRates.forEach((key, value) -> System.out.printf(ANSI_BLUE + "%-10s : %.4f%n" + ANSI_RESET, key, value));
                System.out.println(ANSI_BLUE + "-----------------------------------" + ANSI_RESET);

                ConversorMoneda conversor = new ConversorMoneda(sortedRates);

                while (true) {
                    try {
                        System.out.println(ANSI_BOLD + ANSI_WHITE + "Ingrese la moneda de origen (o escriba 'salir' para finalizar):" + ANSI_RESET);
                        String monedaOrigen = scanner.next().toUpperCase();

                        if (monedaOrigen.equalsIgnoreCase("salir")) {
                            break;
                        }

                        System.out.println(ANSI_WHITE + "Ingrese la moneda de destino:" + ANSI_RESET);
                        String monedaDestino = scanner.next().toUpperCase();
                        if (monedaDestino.equalsIgnoreCase("salir")) {
                            break;
                        }

                        System.out.println(ANSI_BOLD + ANSI_BLUE + "Ingrese la cantidad a convertir:" + ANSI_RESET);
                        double cantidad = scanner.nextDouble();

                        double resultadoConversion = conversor.convertir(monedaOrigen, monedaDestino, cantidad);
                        System.out.printf(ANSI_UNDERLINE + ANSI_BOLD + ANSI_GREEN + "Resultado de %f %s a %s es: %f%n" + ANSI_RESET, cantidad, monedaOrigen, monedaDestino, resultadoConversion);

                        guardarConversionCSV(monedaOrigen, monedaDestino, cantidad, resultadoConversion, LocalDateTime.now());

                    } catch (InputMismatchException ime) {
                        System.out.println("Por favor, introduzca un número válido.");
                        scanner.nextLine();  // consume the invalid input
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error al obtener tasas de cambio: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    public static void guardarConversionCSV(String monedaOrigen, String monedaDestino, double cantidad, double resultado, LocalDateTime fecha) {
        String archivo = "conversiones.csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (PrintWriter out = new PrintWriter(new FileWriter(archivo, true))) {
            out.println(monedaOrigen + "," + monedaDestino + "," + cantidad + "," + resultado + "," + fecha.format(formatter));
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
