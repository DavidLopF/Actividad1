package co.edu.unbosque.controller;

import co.edu.unbosque.model.Matriz;
import co.edu.unbosque.view.Vista;

import java.util.Scanner;

public class Controller {
    Vista view;
    Matriz matriz;


    public Controller() {
        view = new Vista();
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
                "\n 4. Método que retorne un vector con los primeros n números impares de la matriz, ordenados ascendentemente (hacer uso del algoritmo burbuja)." +
                "\n 5. Método que retorne un vector con todos los números primos existentes en la matriz, ordenados de manera descendente (hacer uso del algoritmo de selección)." +
                "\n 6. Método que retorne un arreglo con los primeros n múltiplos de x, ordenados ascendentemente (hacer uso del algoritmo de inserción).";


        view.mostrarDato(menu);
        Scanner leer = new Scanner(System.in);
        String opcion = leer.nextLine();

        switch (opcion) {

            case "1" -> {
                view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
                view.mostrarDato("El Promedio de los números de la matriz es " + matriz.promedioNumeros());
            }
            case "2" -> {
                int númeroBuscar = view.capturarDato("Ingrese número a buscar en la matriz");
                view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
                if (matriz.buscarNumero(númeroBuscar)) {
                    view.mostrarDato("El número " + númeroBuscar + " si esta en la matriz");
                } else {
                    view.mostrarDato("El número " + númeroBuscar + " no esta en la matriz");
                }
            }
            case "3" -> {
                int numeroExiste = view.capturarDato("Ingrese número a buscar en la matriz:");
                view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
                view.mostrarDato("El numero " + numeroExiste + " esta " + matriz.repeticionesNumero(numeroExiste) + " veces en la matriz");
            }
            case "4" -> {
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
            }
            case "5" -> {
                String r = "";
                view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
                for (int i = 0; i < matriz.ordenarNumerosPrimos().length; i++) {
                    r += matriz.ordenarNumerosPrimos()[i] + " ";
                }
                view.mostrarDato("Lo números primos de la matriz son: " + r);
            }
            case "6" -> {
                int numero = view.capturarDato("Señor usuario ingrese el número para buscar sus multiplos en la matriz");
                int cantidadMultiplos = view.capturarDato("Señor usuario ingrese cuantos multiplos de " + numero + " se van a buscar en la matriz");
                view.mostrarDato("La matriz es: \n" + matriz.mostrarMatriz());
                String r = "";
                for (int i = 0; i < matriz.multiplosDeX(numero, cantidadMultiplos).length; i++) {
                    r += matriz.multiplosDeX(numero, cantidadMultiplos)[i] + " ";
                }
                view.mostrarDato("Los " + cantidadMultiplos+ " primeros multiplos de " + numero + " que estan en la matriz son: " + r);

            }
        }

    }


}
