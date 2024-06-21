package com.aluracursos.conversordemonedas.consultaApi;

import com.aluracursos.conversordemonedas.modelo.Moneda;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class OpenExchangeRateApi {
    public static final String codigoApi = "7354e25ca6ecf586358d3353";

    public static Moneda obtenerInformacionMoneda(String nombreMoneda) throws IOException, InterruptedException {
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/USD", codigoApi);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonObject libroJson = jsonObject.getAsJsonObject("conversion_rates");
            for (Map.Entry<String, JsonElement> entry : libroJson.entrySet()) {
                String nombreMonedaApi = entry.getKey();
                double valorMonedaApi = entry.getValue().getAsDouble();
                if (nombreMoneda.equalsIgnoreCase(nombreMonedaApi)) {
                    return new Moneda(nombreMonedaApi, valorMonedaApi);
                }
            }
        } else {
            System.out.println("Error en la consulta a la API: " + response.statusCode());
        }
        return null;
    }
}
