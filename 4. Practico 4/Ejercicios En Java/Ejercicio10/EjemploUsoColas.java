package Ejercicio10;
public class EjemploUsoColas {
    // Método para cargar elementos en una cola
    private static void cargarCola(Cola<Integer> cola) {
        System.out.println("Cargar elementos en la Cola: ");

        // Se insertan varios elementos en la cola
        cola.insertarFin(3);
        System.out.println("Se cargó el elemento: 3");
        
        cola.insertarFin(4);
        System.out.println("Se cargó el elemento: 4");

        cola.insertarFin(2);
        System.out.println("Se cargó el elemento: 2");
        
        cola.insertarFin(8);
        System.out.println("Se cargó el elemento: 8");
        
        cola.insertarFin(43);
        System.out.println("Se cargó el elemento: 43");
        
        cola.insertarFin(32);
        System.out.println("Se cargó el elemento: 32 \n");
    }

    public static void main(String[] args) {
        // Se crean instancias de las colas
        Cola<Integer> colaArreglo = new ColaArreglo<>(); // Crea una cola basada en un arreglo
        Cola<Integer> colaEnlazada = new ColaEnlazada<>(); // Crea una cola basada en nodos
        
        // Cargar elementos en ambas colas
        cargarCola(colaArreglo);
        cargarCola(colaEnlazada);

        // Eliminar el último elemento agregado (32) de cada cola
        if (colaArreglo.eliminar(32)) {
            System.out.println("Se eliminó el elemento 32 de colaArreglo.");
        } else {
            System.out.println("No se encontró el elemento 32 en colaArreglo.");
        }

        if (colaEnlazada.eliminar(32)) {
            System.out.println("Se eliminó el elemento 32 de colaEnlazada.");
            System.out.println();
        } else {
            System.out.println("No se encontró el elemento 32 en colaEnlazada.");
            System.out.println();
        }

        // Buscar un elemento en ambas colas
        int indice4 = colaArreglo.buscar(4); // Busca el elemento 4 en la cola de arreglos
        System.out.println(indice4 != -1 ? 
            "El elemento 4 fue encontrado en colaArreglo en el índice: " + indice4 : 
            "El elemento 4 no fue encontrado en colaArreglo.");

        int indice8 = colaEnlazada.buscar(8); // Busca el elemento 8 en la cola enlazada
        System.out.println(indice8 != -1 ? 
            "El elemento 8 fue encontrado en colaEnlazada en el índice: " + indice8 : 
            "El elemento 8 no fue encontrado en colaEnlazada.");
        System.out.println();    

        // Mostrar la longitud de ambas colas
        System.out.println("Longitud de ambas colas: ");
        System.out.println("Longitud de colaArreglo: " + colaArreglo.longitud()); // Muestra la longitud de la cola de arreglos
        System.out.println("Longitud de colaEnlazada: " + colaEnlazada.longitud()); // Muestra la longitud de la cola enlazada
        System.out.println();

        // Mostrar los elementos de ambas colas
        System.out.println("Mostrando la cola implementada sobre arreglos:");
        colaArreglo.imprimir(); // Imprime los elementos de la cola de arreglos
        System.out.println();

        System.out.println("Mostrando la cola implementada con Nodos:");
        colaEnlazada.imprimir(); // Imprime los elementos de la cola enlazada
    }
}