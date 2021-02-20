package co.edu.unbosque.controller;

import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.view.Vista;

import java.util.Scanner;

public class Controller {
    Vista view;
    Matriz matriz;
    System.out.print("paso mi perro");

    public Controller() {
        view = new Vista();
        leer = new Scanner(System.in);
        funcionar();

    }

    private void funcionar() {
        int fila;
        int columna;

        fila = view.capturarDato("Señor usuario ingrese valor para las filas");
        columna = view.capturarDato("Señor usuario ingrese valor para las columnas");

        matriz = new Matriz(fila, columna);
        matriz.llenarMatriz();  //Se llena la matriz con números del 1 al 10000
        view.mostrarDato("Matriz creada con exito");
        menu();


    }

    public void menu() {
        String menu = "\n Digite opcion: " +
                "\n\n 1. Método que calcule el promedio de todos los números encontrados en la matriz." +
                "\n 2. Método que indique si un número existe dentro de la matríz (hacer uso de búsqueda binaria)." +
                "\n 3. Método que indique si un número existe más de m veces indicadas por parámetro en la matriz (hacer uso de búsqueda secuencial). " +
                "\n 4. Método que retorne un vector con los primeros n números impares de la matriz, ordenados ascendentemente (hacer uso del algoritmo burbuja).";

        view.mostrarDato(menu);
        String opcion = leer.nextLine();

        if (opcion.equals("1")) { //Primer Punto
            view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
            view.mostrarDato("El Promedio de los números de la matriz es " + matriz.promedioNumeros());

        } else if (opcion.equals("2")) {
            int númeroBuscar = view.capturarDato("Ingrese número a buscar en la matriz");
            view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
            if (matriz.buscarNumero(númeroBuscar)) {
                view.mostrarDato("El número " + númeroBuscar + " si esta en la matriz");
            } else {
                view.mostrarDato("El número " + númeroBuscar + " no esta en la matriz");
            }


        } else if (opcion.equals("3")) {
            int numeroExiste = view.capturarDato("Ingrese número a buscar en la matriz:");
            view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
            view.mostrarDato("El numero " + numeroExiste + " esta " + matriz.repeticionesNumero(numeroExiste) + " veces en la matriz");

        } else if (opcion.equals("4")) {

            int numerosImpares = view.capturarDato("Ingrese cantidad de números impares a buscar");
            if (numerosImpares > matriz.getColumnas() * matriz.getFilas()) {
                view.mostrarDato("La cantidad excede al tamaño de la matriz");
            } else {
                String r = "";
                view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
                for (int i = 0; i < matriz.ordenadorBurbuja(numerosImpares).length; i++) {
                    r += matriz.ordenadorBurbuja(numerosImpares)[i] + "  ";
                }
                view.mostrarDato("Los primeros " + numerosImpares + " numeros impares ordenados asendentemente de la matriz son : " + r);
            }
        } else if (opcion.equals("5")) {


        }

    }


}
