package Ejercicio5.proyecto;
import java.util.Arrays;

@SuppressWarnings("unused")
public class EjemploUsoListaArreglo<T> implements Lista<T> {
    private T[] arreglo;
    private int tamaño;
    private static final int capInicialArreglo = 10; //Capacidad inicial del Arreglo

    @SuppressWarnings("unchecked")
    public EjemploUsoListaArreglo(){
        arreglo = (T[]) new Object [capInicialArreglo];
        tamaño = 0;
    }

    @Override
    public void agregar(T item) {
        if(tamaño == arreglo.length){
            aumentarTamañoArreglo();
        }
        arreglo[tamaño++] = item;
    }

    private void aumentarTamañoArreglo() {
        @SuppressWarnings("unchecked")
        T[] nuevoArreglo = (T[]) new Object [arreglo.length * 2]; //Duplica el tamaño del arreglo 
        for(int i = 0; i < tamaño; i++){
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

    @Override
    public void eliminar(T item) {
       int i = 0;
       while(i<tamaño){
         if(arreglo[i].equals(item)){
            int j = i;
            while(j < tamaño - 1){
                arreglo[j] = arreglo[j+1];
                j++;
            }
            arreglo[tamaño - 1] = null;
            tamaño--;
            return;
         } 
         i++;
       }
    }

    @Override
    public T buscar(T item) {
        for(int i = 0; i < tamaño; i++){
            if(arreglo[i].equals(item)){
                return arreglo[i];
            }
        }
        return null;
    }

    @Override
    public int tamaño() {
        return tamaño;
    }

     // Método para obtener un elemento por índice
     public T get(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }
        return arreglo[index];
    }

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//Ejemplo Para Probar ListaArreglo:
     public static void main(String[] args) {
        ListaArreglo<String> lista = new ListaArreglo<>();

        // Agregar elementos
        lista.agregar("Elemento 1");
        lista.agregar("Elemento 2");
        lista.agregar("Elemento 3");

        // Mostrar tamaño
        System.out.println("Tamaño de la lista: " + lista.tamaño()); // Debería ser 3

       // Buscar un elemento
       String elementoBuscado = "Elemento 2";
       String resultadoBusqueda = lista.buscar(elementoBuscado);
       System.out.println("Buscando '" + elementoBuscado + "': " + (resultadoBusqueda != null ? "Encontrado" : "No encontrado"));

       // Eliminar un elemento
       lista.eliminar("Elemento 2");
       System.out.println("Tamaño de la lista después de eliminar: " + lista.tamaño()); // Debería ser 2

       // Intentar buscar el elemento eliminado
       resultadoBusqueda = lista.buscar(elementoBuscado);
       System.out.println("Buscando '" + elementoBuscado + "': " + (resultadoBusqueda != null ? "Encontrado" : "No encontrado"));

       // Mostrar todos los elementos restantes (para verificar)
       System.out.println("Elementos restantes:");
       for (int i = 0; i < lista.tamaño(); i++) {
          System.out.println(lista.get(i)); // Tendrías que implementar un método que devuelva los elementos por índice
       }
    }
}