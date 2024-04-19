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
