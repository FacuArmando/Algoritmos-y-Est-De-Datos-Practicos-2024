
/**
 * Write a description of class Ej1Pract4 here.
 * 
 * @author Facundo Armando
 * @version 1.0
 */
import java.util.LinkedList;
import java.util.Random;

public class Ej1Pract4 {
    public static LinkedList<Integer> generarlistNrosEnteros (int N){
        Random nrosEnteros = new Random();

        LinkedList <Integer> listNrosEnteros = new LinkedList<>();

        for(int i=0; i < N; i++){
            int numAleatorio = nrosEnteros.nextInt(101);
            listNrosEnteros.add(numAleatorio);
        }
        return listNrosEnteros;
    }

    public static void main (String[] args){
        int N = 20;
        LinkedList<Integer> listNEnterosGenerada = generarlistNrosEnteros(N);
        System.out.println("Lista de " + N + " números enteros: " + listNEnterosGenerada);
    }
}