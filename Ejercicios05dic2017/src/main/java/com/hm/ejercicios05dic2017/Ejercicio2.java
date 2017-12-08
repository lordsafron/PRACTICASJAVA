/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.ejercicios05dic2017;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HugoM
 */
public class Ejercicio2 {

    private static int mayor = 0;
    private static List<String> triangulos = new ArrayList<String>();
    private static List<Longitudes> lLongitudes = new ArrayList<Longitudes>();
    private static Longitudes longitudesMayores = new Longitudes();
    private static int indicador = 0;
    private static int dinamico = 2;

    public static void main(String[] args) {
        int n = 6;

        //int[] posicion = new int[3];
        List<Integer> lista = new ArrayList<Integer>();
        int perimetro = 0;

        /*
        lista.add(3);
        lista.add(1);
        lista.add(5);
        lista.add(9);
        lista.add(8);
        lista.add(7);
         */
        for (int i = 0; i < n; i++) {
            lista.add((int) (Math.random() * 10) + 1);
            //System.out.println("ingresado: " + lista.get(i));
        }

        Longitudes longitudes = calcularTrianguloMayor(lista);
        perimetro = longitudes.getA() + longitudes.getB() + longitudes.getC();
        System.out.println("Las mayores longitudes del triangulo son: "
                + longitudes.getA() + " ," + longitudes.getB() + " ," + longitudes.getC()
                + " y su perimetro es: " + perimetro);

    }//end metodo main

    public static Longitudes calcularTrianguloMayor(List<Integer> lista) {

        while (lista.size() > 2) {

            for (int j = 2; j < lista.size(); j++) {
                //System.out.println(lista.get(0) + " ," + lista.get(0 + 1) + " ," + lista.get(0 + dinamico));
                String resultado = Ejercicio1.comprobarTriangulo(lista.get(0), lista.get(0 + 1), lista.get(0 + dinamico));

                if (resultado.equals("Es un triangulo")) {
                    ++indicador;
                    triangulos.add(lista.get(0) + "," + lista.get(0 + 1) + "," + lista.get(0 + dinamico));

                }
                dinamico++;
            }// end for

            dinamico = 2;
            lista.remove(0);

        }// end while
        //System.out.println("Triangulos: " + triangulos.size());

        lLongitudes = transformarLongitudes(triangulos);

        for (Longitudes lon : lLongitudes) {
            if (lon.getA() + lon.getB() + lon.getC() > mayor) {
                mayor = lon.getA() + lon.getB() + lon.getC();
                longitudesMayores.setA(lon.getA());
                longitudesMayores.setB(lon.getB());
                longitudesMayores.setC(lon.getC());
            }
        }

        //System.out.println("El mayor perimetro es: " + mayor);
        return longitudesMayores;
    }

    public static List<Longitudes> transformarLongitudes(List<String> lista) {
        List<Longitudes> lLongitudes = new ArrayList<Longitudes>();

        for (String triangulo : triangulos) {
            Longitudes longitudes = new Longitudes();
            String[] numeros = triangulo.split(",");
            longitudes.setA(Integer.parseInt(numeros[0]));
            longitudes.setB(Integer.parseInt(numeros[1]));
            longitudes.setC(Integer.parseInt(numeros[2]));
            lLongitudes.add(longitudes);

        }

        return lLongitudes;
    }

}
