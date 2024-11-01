public class EjemploUsoPilas {
    
    // Método para cargar elementos en una pila
    private static void cargarPila(NewPila<Integer> pila) {
        System.out.println("Cargar elementos en la Pila: ");
        
        // Se insertan varios elementos en la pila
        pila.insertarFin(3);
        System.out.println("Se cargó el elemento: 3");
        
        pila.insertarFin(4);
        System.out.println("Se cargó el elemento: 4");

        pila.insertarFin(2);
        System.out.println("Se cargó el elemento: 2");
        
        pila.insertarFin(8);
        System.out.println("Se cargó el elemento: 8");
        
        pila.insertarFin(43);
        System.out.println("Se cargó el elemento: 43");
        
        pila.insertarFin(32);
        System.out.println("Se cargó el elemento: 32 \n");
    }

    public static void main(String[] args) {
        // Se crean instancias de las pilas
        NewPila<Integer> pilaArreglo = new PilaArreglo<>(); // Crea una pila basada en un arreglo
        NewPila<Integer> pilaEnlazada = new PilaEnlazada<>(); // Crea una pila basada en nodos

        // Carga elementos en ambas pilas
        cargarPila(pilaArreglo);
        cargarPila(pilaEnlazada);

        // Eliminar un elemento de cada pila
        pilaArreglo.eliminar(32); // Se elimina el último elemento cargado (32)
        System.out.println("Se eliminó el último elemento de pilaArreglo.");
        
        pilaEnlazada.eliminar(32); // Se intenta eliminar el mismo elemento de la otra pila
        System.out.println("Se eliminó el último elemento de pilaEnlazada. \n");

        // Buscar un elemento en ambas pilas
        int indice4 = pilaArreglo.buscar(4); // Busca el elemento 4 en la pila de arreglos
        System.out.println(indice4 != -1 ? 
            "El elemento 4 fue encontrado en pilaArreglo en el índice: " + indice4 : 
            "El elemento 4 no fue encontrado en pilaArreglo.");

        int indice8 = pilaEnlazada.buscar(8); // Busca el elemento 8 en la pila enlazada
        System.out.println(indice8 != -1 ? 
            "El elemento 8 fue encontrado en pilaEnlazada en el índice: " + indice8 : 
            "El elemento 8 no fue encontrado en pilaEnlazada. ");
        System.out.println();    

        // Mostrar la longitud de ambas pilas
        System.out.println("Longitud de ambas pilas: ");
        System.out.println("Longitud de pilaArreglo: " + pilaArreglo.longitud()); // Muestra la longitud de la pila de arreglos
        System.out.println("Longitud de pilaEnlazada: " + pilaEnlazada.longitud()); // Muestra la longitud de la pila enlazada
        System.out.println();

        // Mostrar los elementos de ambas pilas
        System.out.println("Mostrando la pila implementada sobre arreglos:");
        pilaArreglo.imprimir(); // Imprime los elementos de la pila de arreglos

        System.out.println("Mostrando la pila implementada con Nodos:");
        pilaEnlazada.imprimir(); // Imprime los elementos de la pila enlazada
    }
}