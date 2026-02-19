# Conversor de Monedas - Alura Challenge

Conversor de monedas desarrollado en Java que consume la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.

## Descripcion del Proyecto

Proyecto desarrollado como parte del programa ONE (Oracle Next Education) de Alura Latam. Este conversor permite realizar conversiones entre el dolar estadounidense y cinco monedas latinoamericanas utilizando tasas de cambio actualizadas en tiempo real.

## Caracteristicas

- Conversion en tiempo real usando API REST
- Soporte para 5 monedas latinoamericanas
- Interfaz de consola clara y facil de usar
- Codigo limpio y bien documentado
- Manejo robusto de errores

## Monedas Soportadas

- USD (Dolar estadounidense)
- ARS (Peso argentino)
- BOB (Boliviano)
- BRL (Real brasileno)
- CLP (Peso chileno)
- COP (Peso colombiano)

## Tecnologias Utilizadas

- Java 11 o superior
- Gson 2.10.1 (para manejo de JSON)
- ExchangeRate-API (API de tasas de cambio)
- HttpClient (java.net.http)

## Requisitos Previos

- JDK 11 o superior instalado
- Conexion a Internet
- API Key de ExchangeRate-API (gratuita)

## Instalacion

### 1. Clonar el repositorio

```bash
git clone https://github.com/TU_USUARIO/conversor-monedas-alura.git
cd conversor-monedas-alura
```

### 2. Configurar API Key

Abre el archivo `src/com/alura/conversormoneda/Conversor.java` y reemplaza la API Key:

```java
private static final String API_KEY = "TU_API_KEY_AQUI";
```

Para obtener una API Key gratuita, registrate en: https://www.exchangerate-api.com/

### 3. Compilar el proyecto

**Linux/Mac:**
```bash
javac -cp "lib/gson-2.10.1.jar" -d bin src/com/alura/conversormoneda/*.java
```

**Windows:**
```bash
javac -cp "lib/gson-2.10.1.jar" -d bin src/com/alura/conversormoneda/*.java
```

### 4. Ejecutar el programa

**Linux/Mac:**
```bash
java -cp "bin:lib/gson-2.10.1.jar" com.alura.conversormoneda.ConversorApp
```

**Windows:**
```bash
java -cp "bin;lib/gson-2.10.1.jar" com.alura.conversormoneda.ConversorApp
```

## Uso del Programa

Al ejecutar el programa, veras el siguiente menu:

```
*******************************************
   CONVERSOR DE MONEDAS - ALURA LATAM
*******************************************

1) Dolar ==> Peso Argentino
2) Dolar ==> Boliviano
3) Dolar ==> Real Brasileno
4) Dolar ==> Peso Chileno
5) Dolar ==> Peso Colombiano
6) Salir
*******************************************
Elija una opcion valida:
```

Selecciona la conversion que deseas realizar, ingresa el monto y obten el resultado instantaneamente.

## Estructura del Proyecto

```
conversor-monedas-alura/
├── src/
│   └── com/
│       └── alura/
│           └── conversormoneda/
│               ├── Conversor.java        # Logica principal y menu
│               └── ConversorApp.java     # Punto de entrada y consumo de API
├── lib/
│   └── gson-2.10.1.jar                   # Biblioteca para JSON
├── bin/                                   # Archivos compilados (generado)
├── README.md                              # Documentacion
├── .gitignore                             # Archivos ignorados por Git
└── LICENSE                                # Licencia del proyecto
```

## Funcionamiento Tecnico

### Consumo de API

El programa utiliza HttpClient de Java 11+ para realizar peticiones GET a la API:

```java
HttpClient clienteHttp = HttpClient.newHttpClient();
HttpRequest solicitudHttp = HttpRequest.newBuilder()
    .uri(URI.create(urlAPI))
    .GET()
    .build();
HttpResponse<String> respuestaHttp = clienteHttp.send(solicitudHttp, BodyHandlers.ofString());
```

### Procesamiento de JSON

La respuesta JSON es procesada usando la biblioteca Gson:

```java
JsonElement elementoJson = JsonParser.parseString(respuestaHttp.body());
JsonObject objetoJson = elementoJson.getAsJsonObject();
double tasaConversion = objetoJson.get("conversion_rate").getAsDouble();
```

### Calculo de Conversion

La conversion se realiza multiplicando el monto ingresado por la tasa obtenida:

```java
double resultadoConversion = cantidadAConvertir * tasaDeConversion;
```

## Ejemplo de Uso

```
Elija una opcion valida: 1
Ingrese el valor a convertir: 100

*******************************************
           RESULTADO DE CONVERSION
*******************************************
Valor: 100.00 [USD]
Convertido: 95750.00 [ARS]
-------------------------------------------
Tasa de Cambio: 1 USD = 957.5000 ARS
*******************************************
```

## Manejo de Errores

El programa incluye manejo de excepciones para:

- Errores de conexion a Internet
- Respuestas invalidas de la API
- Entradas incorrectas del usuario
- Opciones de menu no validas

## Aprendizajes del Proyecto

Este proyecto demuestra conocimientos en:

- Consumo de APIs REST con HttpClient
- Manipulacion de datos JSON con Gson
- Programacion orientada a objetos en Java
- Manejo de excepciones
- Interaccion con el usuario mediante consola
- Buenas practicas de codigo limpio

## Autor

Desarrollado como parte del desafio de Alura Latam - Programa ONE

## Licencia

Este proyecto esta bajo la Licencia MIT - consulta el archivo LICENSE para mas detalles.

## Agradecimientos

- Alura Latam por el desafio y el aprendizaje
- Oracle por el programa ONE (Oracle Next Education)
- ExchangeRate-API por proporcionar la API gratuita

---

Proyecto desarrollado con fines educativos - Alura Challenge 2024
