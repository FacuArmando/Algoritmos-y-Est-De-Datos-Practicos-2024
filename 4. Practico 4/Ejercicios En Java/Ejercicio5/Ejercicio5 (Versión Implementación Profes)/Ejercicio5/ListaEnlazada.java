class Nodo<T> {
    T dato;
    Nodo<T> siguiente;
    
    public Nodo(T item){
        this.dato = item;
        this.siguiente = null;
    }
}

interface Lista<T> {
    void insertarFin(T item);
    void insertarInicio(T elem);
    void insertarPos(T elem, int pos);
    boolean eliminar(T item);
    int buscar(T item);
    int longitud();
    void imprimir(); 
}

public class ListaEnlazada<T> implements Lista<T> {
    Nodo<T> cabeza;
    private int tamLista;
     
    public ListaEnlazada(){
        cabeza = null;
        tamLista = 0;
    }


    @Override
    public void insertarFin(T item) {
        Nodo<T> nodoNuevo = new Nodo<T>(item);
        if(cabeza == null){
            cabeza = nodoNuevo;
        }else{
            Nodo<T> aux = new Nodo<T>(item);
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = nodoNuevo;
        }
        tamLista++;
    }

    @Override
    public void insertarInicio(T elem) {
        Nodo<T> nuevoNodo = new Nodo<T>(elem);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
        tamLista++;
    }

    @Override
    public void insertarPos(T elem, int pos) {
        if(pos <=0 ){
            insertarInicio(elem);;
        }else{
            if(pos >= tamLista){
                insertarFin(elem);
            }else{
                Nodo<T> nuevoNodo = new Nodo<T>(elem);
                Nodo<T> aux = cabeza;

                int i = 0;
                while (i < pos-1) {
                    aux = aux.siguiente;
                    i++;
                }
                nuevoNodo.siguiente = aux.siguiente;
                aux.siguiente = nuevoNodo;
                tamLista++;
            }
        }
    }

    @Override
    public boolean eliminar(T item) {
        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;
        
        while (actual !=null && !actual.dato.equals(item)){
            anterior = actual;
            actual = actual.siguiente;
        }
        
        if(actual == null){
            return false;
        }

        if(anterior == null){
            cabeza = actual.siguiente;
        }else{
            anterior.siguiente = actual.siguiente;
        }
        return true;
    }

    @Override
    public int buscar(T item) {
        Nodo<T> actual = cabeza;
        int pos = 0;

        while (actual != null) {
            if (actual.dato.equals(item)) {
                return pos;
            }
            actual = actual.siguiente;
            pos++;
        }
        return -1;
    }

    @Override
    public int longitud(){
        return tamLista;
    }

    @Override
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " "); // Imprime el dato del nodo actual
            actual = actual.siguiente; // Avanza al siguiente nodo
        }
        System.out.println(); // Salto de línea al final
    }
}
