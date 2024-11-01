class Nodo<T> {
    T item;
    Nodo<T> siguiente;
    
    public Nodo(T item){
        this.item = item;
        this.siguiente = null;
    }
}

interface Pila <T>{
    void apilar (T item); //Apila un item al tope de la pila
    void desapilar(); //Desapila el elemento al tope de la pila
    T tope(); //Retorna el elemento al tope de la pila
    boolean esVacia(); //Dice si la pila es vacia o no
    void vaciar(); //Vacia la pila de elementos
}

public class PilaEnlazada <T> implements Pila<T>{
    private Nodo<T> cabeza = null;
    
    @Override
    public void apilar(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }
    
    @Override
    public void desapilar() {
        if(esVacia()){
            System.out.println("La pila esta vacia.");
            return;
        }
        cabeza = cabeza.siguiente;
    }

    @Override
    public T tope() {
        if(esVacia()){
            System.out.println("La pila esta vacia.");
            return null;
        }
        return cabeza.item;
    }

    @Override
    public boolean esVacia() {
        if(cabeza == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void vaciar() {
        cabeza = null;
    }
}