/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.ejercicios05dic2017;

/**
 *
 * @author HugoM
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        String respuesta = comprobarTriangulo((int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1);
        System.out.println(respuesta);
    }

    public static String comprobarTriangulo(int a, int b, int c) {

        int mayor = 0;
        int posicion = 0;
        int[] parametros = new int[3];
        int[] resto = new int[2];
        int incrResto = 0;
        parametros[0] = a;
        parametros[1] = b;
        parametros[2] = c;
        System.out.println("Los parametros son: " + a + " " + b + " " + c);
        for (int i = 0; i < parametros.length; i++) {
            if (parametros[i] > mayor) {
                mayor = parametros[i];
                posicion = i;
            }

        }

        for (int i = 0; i < parametros.length; i++) {
            if (i != posicion) {
                resto[incrResto] = parametros[i];
                incrResto++;
            }

        }
        if (mayor < resto[0] + resto[1]) {
            return ("Es un triangulo");
        } else {
            return ("No es un triangulo");
        }

    }

}
