package Ejercicio13;

public class EjemploUsoColaCircular{
    // Método main para probar la ColaCircular
    public static void main(String[] args) {
        ColaCircular cola = new ColaCircular(5); // Crea una cola circular con tamaño 5

        // Verifica si la cola está vacía
        System.out.println("¿La cola está vacía? " + cola.estaVacia());
        System.out.println();

        // Encolando elementos
        System.out.println("Encolando elementos:");
        
        int i = 1;
        while (i <= 5) {
            cola.encolar(i);
            System.out.println("Elemento " + i + " encolado.");
            cola.imprimir(); // Imprime la cola después de cada encolado
            i++;
        }
        System.out.println();


        // Intento de encolar un elemento en una cola llena
        System.out.println("Intentando encolar el 6:");
        cola.encolar(6);
        cola.imprimir();
        System.out.println();

        // Verifica si la cola está llena
        System.out.println("¿La cola está llena? " + cola.estaLlena());
        System.out.println();

        // Desencolando elementos
        System.out.println("Desencolando elementos:");

        while (i <= 3) {
            int desencolado = cola.desencolar();
            System.out.println("Desencolado: " + desencolado);
            cola.imprimir(); // Imprime la cola después de cada desencolado
            i++;
        }
        
        // Verifica nuevamente si la cola está vacía
        System.out.println("¿La cola está vacía? " + cola.estaVacia());
        System.out.println();

        // Encolando más elementos para probar el comportamiento
        System.out.println("Encolando más elementos:");
        cola.encolar(6);
        cola.encolar(7);
        cola.imprimir();

        System.out.println();
        // Desencolar hasta vaciar la cola
        System.out.println("Desencolando hasta vaciar la cola:");
        while (!cola.estaVacia()) {
            int desencolado = cola.desencolar();
            System.out.println("Desencolado: " + desencolado);
            cola.imprimir();
        }
        System.out.println();

        // Verifica si la cola está vacía al final
        System.out.println("¿La cola está vacía? " + cola.estaVacia());
    }
}
