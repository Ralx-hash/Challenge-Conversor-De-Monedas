package com.alura.conversor.de.monedas.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Objects;

public class RespuestaCambio {
    private Map<String, Double> conversion_rates;

    public Double getConversion_rates(String key) {
        return conversion_rates.get(key);
    }

    public Double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino, Double Cantidad) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        var direccion = "https://v6.exchangerate-api.com/v6/4fcbed11207c06b91e4ff6b5/latest/" + monedaOrigen;
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            // Creando la solicitud
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .GET()
                    .build();
            HttpResponse<String> response = cliente
                    .send(solicitud, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            RespuestaCambio respuesta = gson.fromJson(json, RespuestaCambio.class);
            double tasa = respuesta.getConversion_rates(monedaDestino);

            return (Cantidad * tasa);

        } catch (Exception e) {
            System.out.println("Ocurrió un error al obtener la tasa de cambio: " + e.getMessage());
            return null;
        }
    }
}

