package Ejercicio10;

class Nodo<T> {
    T dato;
    Nodo<T> siguiente;
    
    public Nodo(T item){
        this.dato = item;
        this.siguiente = null;
    }
}

interface Cola<T> {
    void insertarFin(T item);
    void insertarInicio(T elem);
    void insertarPos(T elem, int pos);
    boolean eliminar(T item);
    int buscar(T item);
    int longitud();
    void imprimir(); 
}

public class ColaEnlazada<T> implements Cola<T>{
    private Nodo<T> inicioCola = null; //Inicio de la cola
    private Nodo<T> finalCola = null; //Final de la cola

    //Metodo para saber si la cola esta vacia
    public boolean ColaVacia(){
        if(inicioCola == null){
            return true; //La cola esta vacia
        }else{
            return false; //La cola No esta vacia
        }
    }

    //Metodo para insertar un elemento al final de la cola
    @Override
    public void insertarFin(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item);
        nuevoNodo.dato = item;
        nuevoNodo.siguiente = null;

        if(ColaVacia()){
            inicioCola = nuevoNodo;
            finalCola = nuevoNodo;
        }else{
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
    }

    //Metodo para insertar un elemento al inicio de la cola
    @Override
    public void insertarInicio(T elem) {
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        nuevoNodo.siguiente = inicioCola;
        inicioCola = nuevoNodo;

        if(finalCola == null){   
            finalCola = nuevoNodo;
        }
    }

    //Metodo para insertar un elemento en una posición determinada a la cola
    @Override
    public void insertarPos(T elem, int pos) {
        if(pos < 0){
            throw new IndexOutOfBoundsException("La posición no puede ser negativa.");
        }

        Nodo<T> nuevoNodo = new Nodo<>(elem);

        //Si se quiere insertar en el inicio
        if(pos == 0){
            insertarInicio(elem);
            return; //Para salir del metodo
        }

        Nodo<T> elementoActual = inicioCola;
        Nodo<T> elementoAnterior = null;
        int contador = 0; //Contador

        //Recorro hasta la posición deseada o hasta el final
        while(elementoActual != null && contador<pos){
            elementoAnterior = elementoActual;
            elementoActual = elementoActual.siguiente;
            contador++;
        }

        //Si llegamos a la posición deseada, insertamos el nuevoNodo
        if(elementoAnterior != null){
            elementoAnterior.siguiente = nuevoNodo;
            nuevoNodo.siguiente = elementoActual;
        }else{
            if(elementoAnterior == null){
                inicioCola = nuevoNodo;
                nuevoNodo.siguiente = elementoActual; //En este caso elementoActual = null
            }
        }

        //Si estamos insertando un elemento al final de la cola, actualizamos finalCola
        if(elementoActual == null){
            finalCola = nuevoNodo;
        }
    }

    //Metodo para eliminar un elemento de la cola
    @Override
    public boolean eliminar(T item) {
        Nodo<T> elementoActual = inicioCola;
        Nodo<T> elementoAnterior = null;

        while (elementoActual != null) {
            if(elementoActual.dato.equals(item)){
                if(elementoAnterior == null){
                    //El elemento a eliminar es el primer elemento de la cola
                    inicioCola = elementoActual.siguiente; //Actualizo el inicio de la cola
                    
                    //Si la cola queda vacía, tambien actualizo finalCola
                    if(inicioCola == null){
                        finalCola = null;
                    }
                }else{
                    //El elemento que queremos eliminar de la cola se encuentra en el medio o al final
                    elementoAnterior.siguiente = elementoActual.siguiente;

                    //Si estamos eliminando el ultimo elemento de la cola, actualizamos finalCola
                    if(elementoActual == finalCola){
                        finalCola = elementoAnterior; //Actualizo el final de la cola
                    }
                }
                return true; //Se elimino el elemento de la cola
            }
            elementoAnterior = elementoActual;
            elementoActual = elementoActual.siguiente;
        }
        return false; //No se encontro un elemento de la cola para eliminar
    }

    //Metodo para buscar un elemento en la cola
    @Override
    public int buscar(T item) {
        Nodo<T> elementoActual = inicioCola;
        int contador = 0;

        while (elementoActual != null) {
            if((item == null && elementoActual.dato == null) || (item != null && item.equals(elementoActual.dato))){
                return contador; //Devuelve la posición
            }
            elementoActual = elementoActual.siguiente; //Avanza al nodoSiguiente
            contador++; //Incrementa el contador
        }
        return -1;
    }

    //Metodo para mostrar la longitud de la cola
    @Override
    public int longitud() {
        Nodo<T> elementoActual = inicioCola;
        int contador = 0;

        while (elementoActual != null){
            contador++;
            elementoActual = elementoActual.siguiente; //Avanza al siguiente nodo
        }
        return contador; //Devuelve la longitud total 
    }

    //Metodo para imprimir los elementos de la cola
    @Override
    public void imprimir() {
        Nodo<T> elementoActual = inicioCola;

        if(elementoActual == null){
            System.out.println("La cola esta vacía.");
            return;
        }

        while (elementoActual != null){
            System.out.print(elementoActual.dato); //Imprime sin salto de linea
            elementoActual = elementoActual.siguiente; //Avanza al siguiente nodo

            if(elementoActual != null){
                System.out.print(" -> "); //Separador entre elementos
            }
        }
        System.out.println(); //Salto de linea al final
    }
}
