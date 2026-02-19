package com.alura.conversormoneda;

import java.util.Scanner;

public class Conversor {
   private static final String API_KEY = "f21977d0c865a18bb82e057e";
   private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

   public Conversor() {
   }

   public static void eleccionUserMenu() {
      Scanner entradaUsuario = new Scanner(System.in);

      while(true) {
         double cantidadAConvertir;
         String monedaOrigen;
         String monedaDestino;
         
         System.out.println("\n*******************************************");
         System.out.println("   CONVERSOR DE MONEDAS - ALURA LATAM");
         System.out.println("*******************************************");
         System.out.println();
         System.out.println("1) Dolar ==> Peso Argentino");
         System.out.println("2) Dolar ==> Boliviano");
         System.out.println("3) Dolar ==> Real Brasileno");
         System.out.println("4) Dolar ==> Peso Chileno");
         System.out.println("5) Dolar ==> Peso Colombiano");
         System.out.println("6) Salir");
         System.out.println("*******************************************");
         System.out.print("Elija una opcion valida: ");
         
         int opcionSeleccionada = entradaUsuario.nextInt();
         
         if (opcionSeleccionada == 6) {
            System.out.println("\nGracias por utilizar el Conversor de Monedas");
            System.out.println("Hasta pronto!");
            entradaUsuario.close();
            return;
         }
         
         System.out.print("\nIngrese el valor a convertir: ");
         cantidadAConvertir = entradaUsuario.nextDouble();
         monedaOrigen = "USD";
         monedaDestino = "";
         
         switch (opcionSeleccionada) {
            case 1:
               monedaDestino = "ARS";
               break;
            case 2:
               monedaDestino = "BOB";
               break;
            case 3:
               monedaDestino = "BRL";
               break;
            case 4:
               monedaDestino = "CLP";
               break;
            case 5:
               monedaDestino = "COP";
               break;
            default:
               System.out.println("\nOpcion no valida. Por favor, elija entre 1 y 6.");
               continue;
         }

         try {
            String urlCompleta = BASE_URL + API_KEY + "/pair/" + monedaOrigen + "/" + monedaDestino;
            double tasaDeConversion = ConversorApp.obtenerTasa(urlCompleta);
            double resultadoConversion = cantidadAConvertir * tasaDeConversion;
            
            System.out.println("\n*******************************************");
            System.out.println("           RESULTADO DE CONVERSION");
            System.out.println("*******************************************");
            System.out.printf("Valor: %.2f [%s]%n", cantidadAConvertir, monedaOrigen);
            System.out.printf("Convertido: %.2f [%s]%n", resultadoConversion, monedaDestino);
            System.out.println("-------------------------------------------");
            System.out.printf("Tasa de Cambio: 1 %s = %.4f %s%n", monedaOrigen, tasaDeConversion, monedaDestino);
            System.out.println("*******************************************\n");
            
         } catch (Exception errorConexion) {
            System.out.println("\n*** ERROR DE CONEXION ***");
            System.out.println("Mensaje: " + errorConexion.getMessage());
            System.out.println("Verifique su conexion a internet e intente nuevamente\n");
         }
      }
   }
}
