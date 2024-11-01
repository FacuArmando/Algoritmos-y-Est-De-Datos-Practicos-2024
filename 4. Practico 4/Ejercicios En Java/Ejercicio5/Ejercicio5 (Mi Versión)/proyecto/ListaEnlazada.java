package  Ejercicio5.proyecto;   

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

public class ListaEnlazada<T> implements Lista<T> {
    private Nodo<T> primer;
    private Nodo<T> ultimo;
    private int longitud;
    
    public ListaEnlazada(){
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
}