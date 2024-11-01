package Ejercicio5.proyecto;

class Nodo<T> {
    T item;
    Nodo<T> siguiente;
    
    public Nodo(T item){
        this.item = item;
        this.siguiente = null;
    }
}

interface Lista<T> {
    void agregar(T item);
    void eliminar(T item);
    T buscar(T item);
    int tamaño();
}

public class EjemploUsoListaEnlazada<T> implements Lista<T> {
    private Nodo<T> primer;
    private Nodo<T> ultimo;
    private int longitud;
    
    public EjemploUsoListaEnlazada(){
        primer = null;
        ultimo = null;
        longitud = 0;
    }
    
    public void agregar(T item) {
        Nodo<T> nodo = new Nodo<T>(item);
        if(ultimo == null){
            primer = nodo;
            ultimo = nodo;
        }else{
            ultimo.siguiente = nodo;
            ultimo = nodo;
        }
        longitud++;
    }

    public void eliminar(T item) {
        if (primer == null) return; // Lista vacía
    
        // Manejo del primer nodo
        while (primer != null && primer.item.equals(item)) {
            primer = primer.siguiente;
            longitud--;
        }

        //Si la lista queda vacia, actualiza ultimo
        if(primer == null){
            ultimo = null;
            return; //Termina si la lista esta vacia
        }
    
        // Manejo de los nodos restantes
        Nodo<T> actual = primer;
        Nodo<T> previo = null; //Nodo previo para mantener el enlace

        while (actual != null) {
            if (actual.item.equals(item)) {
                if(previo != null){
                    previo.siguiente = actual.siguiente; // Eliminar nodo
                }
                longitud--;
            } else {
               previo = actual; // Avanzar al siguiente nodo 
            }
            actual = actual.siguiente;
        }
    
        // Actualizar el último nodo si es necesario
        if (previo != null && previo.siguiente == null) {
            ultimo = previo; // Si eliminamos el último nodo
        }
    }
    
    public T buscar(T item) {
        Nodo<T> elemActual = primer;

        while (elemActual != null) {
            if (elemActual.item.equals(item)) {
                return elemActual.item;
            }
            elemActual = elemActual.siguiente;
        }
        return null;
    }

    public int tamaño() {
        return longitud;
    }    

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------//
//Ejemplo Para Probar ListaEnlazada:
    public static void main(String[] args) {
        // Crear una instancia de ListaEnlazada
        EjemploUsoListaEnlazada<Integer> lista = new EjemploUsoListaEnlazada<>();

        // Agregar elementos
        lista.agregar(10);
        lista.agregar(20);
        lista.agregar(30);
        lista.agregar(20); // Agregando un duplicado para probar

        // Mostrar tamaño
        System.out.println("Tamaño de la lista: " + lista.tamaño()); // Debe ser 4

        // Buscar elementos
        System.out.println("Buscar 20: " + lista.buscar(20)); // Debe imprimir 20
        System.out.println("Buscar 40: " + lista.buscar(40)); // Debe imprimir null

        // Eliminar un elemento
        lista.eliminar(20);
        System.out.println("Tamaño de la lista después de eliminar 20: " + lista.tamaño()); // Debe ser 2

        // Intentar eliminar un elemento que no existe
        lista.eliminar(40); // No debe afectar la lista
        System.out.println("Tamaño de la lista después de intentar eliminar 40: " + lista.tamaño()); // Debe seguir siendo 2

        // Mostrar todos los elementos restantes
        System.out.print("Elementos restantes en la lista: ");
        for (int i = 10; i <= 30; i += 10) {
            if (lista.buscar(i) != null) {
                System.out.print(lista.buscar(i) + " ");
            }
        }
        System.out.println(); // Salto de línea después de imprimir los elementos
    }
}
