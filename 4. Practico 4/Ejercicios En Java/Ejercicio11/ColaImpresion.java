package Ejercicio11;
import Ejercicio10.ColaEnlazada;

public class ColaImpresion {
    public static void main(String[] args) {
        ColaEnlazada <String> colaImpresion = new ColaEnlazada<>();

        //Ingresa los elementos al inicio:
        colaImpresion.insertarInicio("Trabajo1.txt");
        colaImpresion.insertarInicio("Trabajo2.pdf");
        colaImpresion.insertarInicio("Trabajo3.doc");

        //Mostrar la cantidad de elementos que se van a imprimir:
        System.out.println("Longitud de la colaImpresion: " + colaImpresion.longitud());

        //Imprimir los elementos;
        colaImpresion.imprimir();

        //Eliminar los elementos:
        colaImpresion.eliminar("Trabajo1.txt");
        colaImpresion.eliminar("Trabajo2.pdf");
        colaImpresion.eliminar("Trabajo3.doc");
    }
}