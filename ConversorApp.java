package com.alura.conversormoneda;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ConversorApp {
   
   public ConversorApp() {
   }

   public static void main(String[] argumentos) throws IOException, InterruptedException {
      Conversor.eleccionUserMenu();
   }

   public static double obtenerTasa(String urlAPI) throws IOException, InterruptedException {
      HttpClient clienteHttp = HttpClient.newHttpClient();
      HttpRequest solicitudHttp = HttpRequest.newBuilder().uri(URI.create(urlAPI)).GET().build();
      HttpResponse<String> respuestaHttp = clienteHttp.send(solicitudHttp, BodyHandlers.ofString());
      JsonElement elementoJson = JsonParser.parseString(respuestaHttp.body());
      JsonObject objetoJson = elementoJson.getAsJsonObject();
      double tasaConversion = objetoJson.get("conversion_rate").getAsDouble();
      return tasaConversion;
   }
}
