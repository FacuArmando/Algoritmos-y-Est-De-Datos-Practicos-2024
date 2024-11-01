import java.util.Scanner;

class Nodo<T> {
    T item;
    Nodo<T> siguiente;
    
    public Nodo(T item){
        this.item = item;
        this.siguiente = null;
    }
}

interface NewPila2<T>{
    public void insertarFin(T item); //Inserta un elemento al final de la lista
    public void insertarInicio(T elem); //Inserta un elemento al comienzo de la lista
    public void insertarPos(T elem, int pos); //Inserta un elemento en una posición determinada, y los demás elementos se mueven un lugar a la derecha
    public boolean eliminar(T item); //Elimina la primera ocurrencia del elemento 
    public int buscar(T item); //Busca la posición en la que se encuentra un elemento
    public int longitud(); //Retorna la cantidad de elementos que actualmente almacena la lista
    public void imprimir(); //Imprime por pantalla los elementos de la lista
    public boolean isEmpty(); //Verifica si la pila esta vacia
}

public class Ej9Pract4<T> implements NewPila2<T> {
   private Nodo<T> tope; //Nodo tope de la pila
   private int longitud; //Llevar la cuenta de la longitud

   public Ej9Pract4(){
    this.tope = null;
    this.longitud = 0;
   }

    @Override
    public void insertarFin(T item) {
        Nodo<T> nodoNuevo = new Nodo<>(item);

        if(tope == null){
            tope = nodoNuevo;
        }else{
            Nodo<T> nodoActual = tope;
            while (nodoActual.siguiente != null) {
                nodoActual = nodoActual.siguiente;
            }
            nodoActual.siguiente = nodoNuevo;
        }
        longitud++;
    }

    @Override
    public void insertarInicio(T elem) {
        Nodo<T> nodoNuevo = new Nodo<>(elem);
        nodoNuevo.siguiente = tope;
        tope = nodoNuevo;

        longitud++;
    }

    @Override
    public void insertarPos(T elem, int pos) {
        Nodo<T> nodoNuevo = new Nodo<>(elem);
        if(pos == 0){
            insertarInicio(elem);
            return; //Para salir del metodo
        }else{
            Nodo<T> nodoActual = tope;
            int contador = 0;

            //Recorremos hasta la posición que queremos o hasta el final
            while (nodoActual != null && contador < pos - 1) {
                nodoActual = nodoActual.siguiente;
                contador++;
            }

            //Ingresamos el nuevoNodo
            if(nodoActual != null){
                nodoNuevo.siguiente = nodoActual.siguiente;
                nodoActual.siguiente = nodoNuevo;
            }
        }
        longitud++;    
    }

    @Override
    public boolean eliminar(T item) {
        if(tope == null){
            return false; 
        }

        if(tope.item.equals(item)){
            tope = tope.siguiente;
            longitud--;   
            return true; //Se elimino el elemento
        }

        Nodo<T> nodoActual = tope;
        while (nodoActual.siguiente != null) {
            if(nodoActual.siguiente.item.equals(item)){
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                longitud--;
                return true; 
            }
            nodoActual = nodoActual.siguiente;
        }
        return false; //Elemento no encontrado 
    }

    @Override
    public int buscar(T item) {
        Nodo<T> nodoActual = tope;
        int contador = 0;

        while (nodoActual != null) {
            if(nodoActual.item.equals(item)){
                return contador;
            }
            nodoActual = nodoActual.siguiente; //Avanza al nodo siguiente
            contador++; //Incrementa el contador
        }
        return -1;
    }

    @Override
    public int longitud() {
        return longitud;
    }

    @Override
    public void imprimir() {
        Nodo<T> nodoActual = tope;

        while (nodoActual != null) {
            System.out.println(nodoActual.item);
            nodoActual = nodoActual.siguiente; //Avanza al nodo siguiente
        }
    }
    
    @Override
    public boolean isEmpty(){
        return tope == null;
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        // Crear un escáner para leer la entrada del usuario
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); 
        
        // Solicitar al usuario que ingrese una expresión matemática
        System.out.print("Ingrese una expresión matemática: ");
        String entrada = scanner.nextLine(); // Leer la línea completa ingresada por el usuario
    
        // Crear una instancia de la pila para almacenar los paréntesis
        Ej9Pract4<Character> pila = new Ej9Pract4<>(); 
    
        // Recorrer cada carácter de la entrada
        for (int i = 0; i < entrada.length(); i++) {
            char caracter = entrada.charAt(i); // Obtener el carácter actual
    
            // Si el carácter es un paréntesis de apertura, lo añadimos a la pila
            if (caracter == '(') {
                pila.insertarFin(caracter); 
            } 
            // Si es un paréntesis de cierre, verificamos si la pila está vacía
            else if (caracter == ')') {
                if (pila.isEmpty()) {
                    System.out.println("La expresión está incorrecta.");
                    return; // Finaliza el programa si hay un error
                } else {
                    pila.eliminar(pila.tope.item); // Eliminar el último '(' de la pila
                }
            }
        }
    
        // Al final, verificamos si la pila está vacía
        if (pila.isEmpty()) {
            System.out.println("La expresión está balanceada.");
        } else {
            System.out.println("La expresión no está balanceada.");
        }
        
        scanner.close(); // Cerrar el escáner
    }    
}