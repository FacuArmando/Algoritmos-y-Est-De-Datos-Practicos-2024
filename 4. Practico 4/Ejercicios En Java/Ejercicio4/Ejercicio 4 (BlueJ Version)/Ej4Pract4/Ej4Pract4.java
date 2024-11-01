
/**
 * Write a description of class Ej4Pract4 here.
 * 
 * @author Facundo Armando
 * @version 1.0
 */
import java.util.ArrayList;

public class Ej4Pract4 {
    public static void main(String[] args) {
        ArrayList<Integer> listaNumEnt = new ArrayList<>();
        
        listaNumEnt.add(7);
        listaNumEnt.add(9);
        listaNumEnt.add(3);
        listaNumEnt.add(1);

        System.out.println("Este es el Arreglo de Forma Desordenada: ");
        mostrarArrayList(listaNumEnt);

        System.out.println("Este es el Arreglo Ordenado de Menor A Mayor: ");
        arrayListMenAMay(listaNumEnt);
        mostrarArrayList(listaNumEnt);

        System.out.println("Este es el Arreglo Ordenado de Mayor A Menor: ");
        arrayListMayAMen(listaNumEnt);
        mostrarArrayList(listaNumEnt);
    }
    
    //Muestra el ArrayList de Forma Desordenada:
    public static void mostrarArrayList(ArrayList<Integer> arrayNum) {
        System.out.print("[");
        for(int i = 0; i < arrayNum.size(); i++){
            System.out.print(arrayNum.get(i));
            if(i < arrayNum.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println("] \n");
    }
    
    //Muestra el ArrayList Ordenado de Menor A Mayor:
    public static void arrayListMenAMay(ArrayList<Integer> listaNumEnt) {
        for(int i = 0; i < listaNumEnt.size()-1; i++){
            for(int j = 0; j < listaNumEnt.size()-1; j++){
                if(listaNumEnt.get(j) > listaNumEnt.get(j+1)){
                    //Imprimo los valores del arreglo con Temp
                    int temp = listaNumEnt.get(j);
                    listaNumEnt.set(j, listaNumEnt.get(j+1));
                    listaNumEnt.set(j+1, temp);
                }
            }
        }
    }

    //Muestra el ArrayList Ordenado de Mayor A Menor:
    public static void arrayListMayAMen(ArrayList<Integer> listaNumEnt) {
        for(int i = 0; i < listaNumEnt.size()-1; i++){
            for(int j = 0; j < listaNumEnt.size()-1; j++){
                if(listaNumEnt.get(j) < listaNumEnt.get(j+1)){
                    //Imprimo los valores del arreglo con Temp
                    int temp = listaNumEnt.get(j);
                    listaNumEnt.set(j, listaNumEnt.get(j+1));
                    listaNumEnt.set(j+1, temp);
                }
            }
        }
    }
}