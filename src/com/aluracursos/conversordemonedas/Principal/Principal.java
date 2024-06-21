package com.aluracursos.conversordemonedas.Principal;

import com.aluracursos.conversordemonedas.modelo.ConversorMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConversorMoneda conversor = new ConversorMoneda();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("""
                    **************************************************************
                    Sea bienvenido/a al Conversor de Moneda =)
                    
                    1) Dolar => Peso argentino
                    2) Peso argentino => Dolar
                    3) Dolar => Real brasileño
                    4) Real brasileño => Dolar
                    5) Dolar => Peso colombiano
                    6) Peso colombiano => Dolar
                    7) Salir
                    Elija una opción válida
                    **************************************************************
                    """);
            opcion = teclado.nextInt();

            if(opcion == 1) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valorIngresado = teclado.nextDouble();
                conversor.informacionDeLaMoneda("USD", "ARS");
                Double monedaConvertida =  conversor.convertirMoneda(valorIngresado);
                System.out.println("El valor " + valorIngresado + " [USD] corresponde al valor final de " + monedaConvertida + " [ARG]");
            } else if (opcion == 2) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valorIngresado = teclado.nextDouble();
                conversor.informacionDeLaMoneda("ARS", "USD");
                Double monedaConvertida =  conversor.convertirMoneda(valorIngresado);
                System.out.println("El valor " + valorIngresado + " [ARS] corresponde al valor final de " + monedaConvertida + " [USD]");
            } else if (opcion == 3) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valorIngresado = teclado.nextDouble();
                conversor.informacionDeLaMoneda("USD", "BRL");
                Double monedaConvertida =  conversor.convertirMoneda(valorIngresado);
                System.out.println("El valor " + valorIngresado + " [USD] corresponde al valor final de " + monedaConvertida + " [BRL]");
            } else if (opcion == 4) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valorIngresado = teclado.nextDouble();
                conversor.informacionDeLaMoneda("BRL", "USD");
                Double monedaConvertida =  conversor.convertirMoneda(valorIngresado);
                System.out.println("El valor " + valorIngresado + " [BRL] corresponde al valor final de " + monedaConvertida + " [USD]");
            } else if (opcion == 5) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valorIngresado = teclado.nextDouble();
                conversor.informacionDeLaMoneda("USD", "COP");
                Double monedaConvertida =  conversor.convertirMoneda(valorIngresado);
                System.out.println("El valor " + valorIngresado + " [USD] corresponde al valor final de " + monedaConvertida + " [COP]");
            } else if (opcion == 6) {
                System.out.println("Ingrese el valor que deseas convertir: ");
                double valorIngresado = teclado.nextDouble();
                conversor.informacionDeLaMoneda("COP", "USD");
                Double monedaConvertida =  conversor.convertirMoneda(valorIngresado);
                System.out.println("El valor " + valorIngresado + " [COP] corresponde al valor final de " + monedaConvertida + " [USD]");
            }
        }
        System.out.println("Fin del programa...");
    }
}
