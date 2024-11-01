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

//--------------------------------------------------------------------------------//
//Ejemplo para Probar la PilaEnlazada (Dado Por ChatGPT):
public class EjemploUsoPilasEnlazadas<T> implements Pila<T>{
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

    public static void main(String[] args) {
        // Crear una pila de enteros
        EjemploUsoPilasEnlazadas<Integer> pila = new EjemploUsoPilasEnlazadas<>();
    
        // Apilar elementos
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);
    
        // Mostrar el elemento en la parte superior
        System.out.println("Elemento en el tope: " + pila.tope()); // Debería imprimir 30
    
        // Desapilar un elemento
        pila.desapilar(); // Debería imprimir 30
    
        // Mostrar el nuevo elemento en la parte superior
        System.out.println("Elemento en el tope: " + pila.tope()); // Debería imprimir 20
    
        // Desapilar el resto de los elementos
        pila.desapilar(); // Debería imprimir 20
        pila.desapilar(); // Debería imprimir 10
    
        // Verificar si la pila está vacía
        System.out.println("La pila está vacía: " + pila.esVacia()); // Debería imprimir true
      }
}
