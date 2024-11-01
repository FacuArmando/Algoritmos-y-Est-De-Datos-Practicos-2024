
/**
 * Esta clase implementa el TAD Lista utilizando memoria dinámica (Nodos enlazados)
 * 
 * NOTA: existen dos versiones de listas enlazadas (con y sin ficticio). Implementar una de las dos.
 */
public class ListaEnlazada<T> implements Lista<T> {
    
    private class Nodo {
        @SuppressWarnings("unused")
        T elem;
        @SuppressWarnings("unused")
        Nodo siguiente;

        @SuppressWarnings("unused")
        Nodo(T elem) {
            this.elem = elem;
            this.siguiente = null;
        }
    }

    @SuppressWarnings("unused")
    private Nodo cabeza;

    public ListaEnlazada(){
        //Completar

        // this.cabeza = null # Para listas sin ficticio
        // this.cabeza = new Nodo(null) # Para listas con ficticio
    }

    public void insertarFin(T item){
        //Completar
    }

    public void insertarInicio(T elem){
        //Completar
    }

    public void insertarPos(T elem, int pos){
        //Completar
    }

    public boolean eliminar(T item){
        return false;
        //Completar
    }

    public int buscar(T item){
        return 0;
        //Completar
    }

    public int longitud(){
        return 0;
        //Completar
    }

    public void imprimir(){
        //Completar
    }

}
