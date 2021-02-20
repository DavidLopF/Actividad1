package co.edu.unbosque.model;

import java.util.Arrays;
import java.util.Random;

public class Matriz {

    private int filas;
    private int columnas;
    private int[][] array;


    public Matriz(int filas, int columnas) {

        this.filas = filas;
        this.columnas = columnas;
        System.out.println(filas + " " + columnas);
        array = new int[this.filas][this.columnas];

    }

    public void llenarMatriz() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                Random rnd = new Random();
                int valor = rnd.nextInt(10);
                array[i][j] = valor;

            }
        }
    }

    public float promedioNumeros() {
        int valor = 0;
        float promedio = 0;
        int cantidadElementos = filas * columnas;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                valor += array[i][j];
            }
        }
        promedio = (float) valor / cantidadElementos;
        return promedio;

    }

    public boolean buscarNumero(int a) {
        int tamaño = filas * columnas;
        int[] temp = new int[tamaño];
        int cont = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                temp[cont] = array[i][j];
                cont++;
            }
        }
        Arrays.sort(temp);
        if (Arrays.binarySearch(temp, a) > 0) { //busqueda binaria
            return true;
        } else {
            return false;
        }

    }

    public int repeticionesNumero(int a) {
        int cont = 0;
        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) {
                if (a == array[j][i]) {
                    cont++;
                }
            }
        }
        return cont;
    }


    public String mostrarMatriz() {
        String r = "";
        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) {
                r += " " + array[j][i];
            }
            r += "\n";
        }
        return r;
    }

    public int[] ordenadorBurbuja(int a) {
        int[] temp = new int[a];
        int cont = 0;
        int aux = 0;
        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) {
                if (array[j][i] % 2 == 1 && cont < a) {
                    temp[cont] = array[j][i];
                    cont++;
                }
            }
        }

        return temp;

    }

    private boolean esPrimo(int numero) {
        int contador = 2;
        boolean primo=true;

        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }

        return primo;
    }

    public int[] ordenarNumerosPrimos() {
        int[] temp = new int[filas * columnas];
        int[] primos = new int[temp.length];
        int cont = 0;
        int pos = 0;
        int aux = 0;
        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) {
                if (esPrimo(array[j][i])) {
                    temp[cont] = array[j][i];
                    cont++;
                }
            }
        }


        for (int i = 0; i < temp.length; i++) { //ordenamiento por selección
            pos = i;
            aux = temp[i];

            while (pos > 0 && temp[pos - 1] > aux) {
                temp[pos] = temp[pos - 1];
                pos--;
            }
        }

        return temp;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}