import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ej2Pract4 {
    public static void main (String[] args){
        int i = 0;
        int cantNros, buscarNum;
        @SuppressWarnings("resource")
        Scanner LeerNros = new Scanner(System.in);
        List<Integer> NrosEnteros = new ArrayList<>();
        
        //Ingresar la lista de N números enteros:
        System.out.println("Ingrese la cantidad de nros enteros que quiera ingresar: ");
        cantNros = LeerNros.nextInt();
        
        //Leer los números enteros:
        while (i < cantNros) {
            System.out.println("Ingrese un Número Entero: ");
            int num = LeerNros.nextInt();
            NrosEnteros.add(num);   
            i++;
        }
        
        //Buscar los números enteros:
        System.out.println("Ingrese el nro entero que quiere buscar en la lista: ");
        buscarNum = LeerNros.nextInt();

        // Verificar si el número está en la lista
        boolean nroEncontrado = contieneNumero(NrosEnteros, buscarNum);
        System.out.println(nroEncontrado);
    }
    
    // Función para verificar si un número está en la lista   
    public static boolean contieneNumero (List<Integer> NrosEnteros, int num) {
        return NrosEnteros.contains(num);
    }
}