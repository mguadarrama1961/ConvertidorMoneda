Convertidor de Monedas

Este proyecto de Java realiza conversiones de moneda utilizando tasas de cambio actualizadas proporcionadas por una API externa. Permite a los usuarios convertir montos entre diversas monedas. 

Características

Consulta de tasas de cambio: Usa la API de "ExchangeRate-API" para obtener las tasas actuales. 

Conversión de moneda: Permite convertir montos de una moneda a otra. 

Interfaz de usuario: Interfaz de consola simple para realizar las conversiones y visualizar las tasas. 

Registro de conversiones: Guarda un historial de conversiones en un archivo CSV. 

Tecnologías Utilizadas 
Java 11 Gson para el parsing de JSON 
Librería Java HTTP Client Configuración y Ejecución 

Prerrequisitos Java JDK 11+ Dependencias (Gson), incluyendo las dependencias necesarias en tu archivo pom.xml. 

Ejecución 
Solo Sigue las instrucciones en la consola: 
1)Se muestra el listado de monedas que se pueden usar y su tasa de conversión
2)Introduce la moneda de origen
3)Introduce la moneda de destino
4)Escribe la cantidad a convertir
5)El programa te mostrará la tasa de conversión y el resultado.
6)Se efectuará el registro de conversiones efectuadas en el archivo conversiones.csv

7) Es posible Clonar el repositorio: git clone [URL del repositorio]

Codigo

Implementa una aplicación que permite al usuario convertir cantidades de una moneda a otra utilizando tasas de cambio obtenidas de un servicio externo. A continuación, se detalla paso a paso lo que realiza el código:

Importaciones:
Utiliza com.google.gson.JsonObject y com.google.gson.JsonParser para manejar datos JSON.
Incluye clases de Java para manejar archivos, entrada/salida, fechas, y otras utilidades como colecciones.
Definición de constantes:
Define constantes para cambiar colores y estilos del texto en la consola, lo que mejora la experiencia de usuario al hacer la interfaz más legible y llamativa.

Método main:
Inicializa un objeto ApiMoneda que presumiblemente se conecta a una API para obtener tasas de cambio de monedas.
Crea un objeto Scanner para leer la entrada del usuario desde la consola.
Obtener y procesar tasas de cambio:
Llama a apiMoneda.obtenerTasas() para obtener las tasas de cambio en formato JSON.
Analiza el resultado JSON y verifica si contiene el objeto "rates".
Extrae el objeto "rates" y almacena las tasas de cambio en un TreeMap, asegurando que las monedas estén ordenadas alfabéticamente.
Interfaz de usuario en consola:
Muestra las tasas de cambio disponibles en la consola con formato y colores.
Utiliza un bucle infinito para permitir al usuario realizar múltiples conversiones hasta que decida salir escribiendo 'salir'.
Captura y maneja excepciones que pueden surgir si el usuario introduce datos no válidos.
Conversión de monedas:
Pide al usuario que ingrese la moneda de origen y destino, y la cantidad a convertir.
Utiliza el objeto ConversorMoneda para calcular el resultado de la conversión basado en las tasas de cambio almacenadas.

Mostrar y guardar resultados:
Muestra el resultado de la conversión en la consola con formato csv.
Llama a guardarConversionCSV para escribir los detalles de la conversión en un archivo CSV para su registro.

Método guardarConversionCSV:
Prepara un archivo CSV y escribe los detalles de cada conversión de moneda, incluyendo las monedas de origen y destino, la cantidad convertida, el resultado, y la fecha y hora de la conversión.
Maneja errores relacionados con la escritura en archivos.

Cierre y manejo de excepciones:
Cierra el objeto Scanner al final para liberar recursos.
Captura excepciones generales que podrían ocurrir durante la ejecución, mostrando mensajes de error y detalles adicionales para depuración.
