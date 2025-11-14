package com.alura.conversor.de.monedas.principal;

import com.alura.conversor.de.monedas.modelos.RespuestaCambio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        // Creando cliente HTTP

        boolean ciclo = true;

        while(ciclo){

            double resultado = 0.0;
            RespuestaCambio respuesta = new RespuestaCambio();
            double cantidadDinero = 0.0;
            System.out.println("""
  
                    ******************************************************
                    """);
            System.out.println("Sea bienvenido al conversor de monedas");

            System.out.println("""
                    1) Dòlares => Peso argentino
                    2) Peso argentino => Dòlares
                    3) Dòlar => Real brasileño
                    4) Real brasileño => Dòlares
                    5) Dòlar => Peso colombiano
                    6) Peso colombiano => Dòlares
                    7) Salir
                    """);

            System.out.println("Ingrese la opcion valida: ");
            System.out.println("""
                    
                    ******************************************************
                    
                    """);
            var busqueda = lectura.nextLine();
            //String monedaDestino = System.console().readLine().toUpperCase();
            switch (busqueda){
                case "1":
                    System.out.println("Ingrese la cantidad en Dòlares: ");
                    cantidadDinero = Double.parseDouble(lectura.nextLine());
                    resultado =respuesta.obtenerTasaDeCambio("USD", "ARS", cantidadDinero);
                    System.out.printf(cantidadDinero + " Dolares equivale a %.2f Pesos Argentinos", resultado);
                    break;

                case "2":
                    System.out.println("Ingrese la cantidad en Pesos Argentinos: ");
                    cantidadDinero = Double.parseDouble(lectura.nextLine());
                    resultado =respuesta.obtenerTasaDeCambio("ARS", "USD", cantidadDinero);
                    System.out.printf(cantidadDinero + " Pesos Argentinos equivale a %.2f Dolares", resultado);
                    break;

                case "3":
                    System.out.println("Ingrese la cantidad en Dòlares: ");
                    cantidadDinero = Double.parseDouble(lectura.nextLine());
                    resultado =respuesta.obtenerTasaDeCambio("USD", "BRL", cantidadDinero);
                    System.out.printf(cantidadDinero + " Dolares equivale a %.2f Reales Brasileños", resultado);
                    break;

                case "4":
                    System.out.println("Ingrese la cantidad en Reales Brasileños: ");
                    cantidadDinero = Double.parseDouble(lectura.nextLine());
                    resultado =respuesta.obtenerTasaDeCambio("BRL", "USD", cantidadDinero);
                    System.out.printf(cantidadDinero + " Reales Brasileños equivale a %.2f Dolares", resultado);
                    break;

                case "5":
                    System.out.println("Ingrese la cantidad en Dòlares: ");
                    cantidadDinero = Double.parseDouble(lectura.nextLine());
                    resultado =respuesta.obtenerTasaDeCambio("USD", "COP", cantidadDinero);
                    System.out.printf(cantidadDinero + " Dolares equivale a %.2f Pesos Colombianos", resultado);
                    break;

                case "6":
                    System.out.println("Ingrese la cantidad en Reales Brasileños: ");
                    cantidadDinero = Double.parseDouble(lectura.nextLine());
                    resultado =respuesta.obtenerTasaDeCambio("COP", "USD", cantidadDinero);
                    System.out.printf(cantidadDinero + " Pesos Colombianos equivale a %.2f Dolares", resultado);
                    break;

                case "7":
                    ciclo = false;
            }

        }
    }
}