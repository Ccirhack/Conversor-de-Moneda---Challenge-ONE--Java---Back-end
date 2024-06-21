package com.aluracursos.conversordemonedas.modelo;

import com.aluracursos.conversordemonedas.consultaApi.OpenExchangeRateApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConversorMoneda {
    private List<Moneda> listaDeMoneda;

    public ConversorMoneda() {
        this.listaDeMoneda = new ArrayList<>();
    }

    public void informacionDeLaMoneda(String nombreMoneda1, String nombreMoneda2) {
        this.listaDeMoneda = new ArrayList<>();
        try{
            Moneda moneda1 = OpenExchangeRateApi.obtenerInformacionMoneda(nombreMoneda1);
            Moneda moneda2 = OpenExchangeRateApi.obtenerInformacionMoneda(nombreMoneda2);
            this.listaDeMoneda.add(moneda1);
            this.listaDeMoneda.add(moneda2);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar con la API");
        }
    }

    public Double convertirMoneda(double valorIngresado) {
        return (valorIngresado * this.listaDeMoneda.get(1).getValor())/this.listaDeMoneda.get(0).getValor();
    }
}
