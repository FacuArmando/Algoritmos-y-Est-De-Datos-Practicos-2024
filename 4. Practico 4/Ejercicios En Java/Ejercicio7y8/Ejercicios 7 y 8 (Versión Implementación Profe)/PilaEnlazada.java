class Nodo<T> {
    T dato;
    Nodo<T> siguiente;
    
    public Nodo(T item){
        this.dato = item;
        this.siguiente = null;
    }
}

interface NewPila<T> {
    void insertarFin(T item);
    void insertarInicio(T elem);
    void insertarPos(T elem, int pos);
    boolean eliminar(T item);
    int buscar(T item);
    int longitud();
    void imprimir(); 
}

public class PilaEnlazada<T> implements NewPila<T> {
    private Nodo<T> cabeza = null; //Inicio de la pila
    private Nodo<T> fin = null; //Final de la pila

    @Override
    public void insertarFin(T item) {
        Nodo<T> nuevoNodo = new Nodo<>(item);

        if(cabeza == null){
            cabeza = nuevoNodo; //Si la pila esta vacia, nuevoNodo es la cabeza
            fin = nuevoNodo; //nuevoNodo se convierte en el fin
        }else{
            fin.siguiente = nuevoNodo; //El elemento actual de fin apunta al nuevoNodo
            fin = nuevoNodo; //Actualizamos el elemento de fin a ser el nuevoNodo
        }
        
    }

    @Override
    public void insertarInicio(T elem) {
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        nuevoNodo.siguiente = cabeza; //El nuevoNodo apunta al elemento cabeza actual
        cabeza = nuevoNodo; //Actualizamos la cabeza

        if(fin == null){
            fin = nuevoNodo; //Si estaba vacio, nuevoNodo es el fin
        }
    }

    @Override
    public void insertarPos(T elem, int pos) {
        Nodo<T> nuevoNodo = new Nodo<>(elem);
        if(pos == 0){
            insertarInicio(elem);
            return; //Para salir del metodo
        }else{
            if(pos > 0){
                Nodo<T> elemActual = cabeza;
                Nodo<T> elemAnterior = null;
                int i = 0; //Contador

                //Recorremos hasta la posicion que queremos o hasta el final
                while (elemActual != null && i < pos){
                    elemAnterior = elemActual;
                    elemActual = elemActual.siguiente;
                    i++;
                }

                //Ingresamos el nuevoNodo
                if(elemAnterior != null){
                    elemAnterior.siguiente = nuevoNodo;
                    nuevoNodo.siguiente = elemActual;
                }
            }
        }
    }

    @Override
    public boolean eliminar(T item) {
        Nodo<T> elemActual = cabeza;
        Nodo<T> elemAnterior = null;

        while (elemActual != null) {
            if(elemActual.dato.equals(item)){

                if(elemAnterior == null){
                    cabeza = elemActual.siguiente; //Actualizo la cabeza
                }else{
                   elemAnterior.siguiente = elemActual.siguiente;
                }   

            if(elemActual == fin){
                fin = elemAnterior; //Actualizo el fin
            }
            return true; //Se elimino el elemento
          }
          elemAnterior = elemActual;
          elemActual = elemActual.siguiente;
        }
        return false; //No se encontro un elemento para eliminar
    }

    @Override
    public int buscar(T item) {
        Nodo<T> elemActual = cabeza;
        int contador = 0; 

        while(elemActual != null){
            if(elemActual.dato.equals(item)){
                return contador; //Devuelve la posición
            }
            elemActual = elemActual.siguiente; //Avanza al nodoSiguente
            contador++; //Incrementa el contador
        }
        return -1;
    }

    @Override
    public int longitud() {
        Nodo<T> elemActual = cabeza;
        int contador = 0;

        while(elemActual != null){
            contador++;
            elemActual = elemActual.siguiente;
        }
        return contador;
    }

    @Override
    public void imprimir() {
        Nodo<T> elemActual = cabeza;

        while (elemActual != null) {
            System.out.println(elemActual.dato);
            elemActual = elemActual.siguiente;
        }
    }
}