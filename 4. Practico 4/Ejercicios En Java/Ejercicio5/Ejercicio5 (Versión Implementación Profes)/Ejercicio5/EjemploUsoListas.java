public class EjemploUsoListas {
    
    /**
     * Dada una lista vacia, carga valores de ejemplo.
     * Resultado esperado: [2, 3, 8, 4, 43, 32]
     * @param lista
     */
    private static void cargarLista(Lista<Integer> lista){
        System.out.println("Cargar elementos en la Lista: ");
        
        lista.insertarInicio(3);
        System.out.println("Se cargo el elemento: 3");
        
        lista.insertarFin(4);
        System.out.println("Se cargo el elemento: 4");

        lista.insertarInicio(2);
        System.out.println("Se cargo el elemento: 2");
        
        lista.insertarPos(8, 2);
        System.out.println("Se cargo el elemento: 8, en la posición 2");
        
        lista.insertarFin(43);
        System.out.println("Se cargo el elemento: 43");
        
        lista.insertarFin(32);
        System.out.println("Se cargo el elemento: 32 \n");
    }

    public static void main(String[] args) {
        ListaArreglo<Integer> listaArreglo = new ListaArreglo<>(40);
        ListaEnlazada<Integer> listaEnlazada = new ListaEnlazada<>();

        //Importante: notar que el método cargarLista() espera un tipo Lista como parámetro.
        // Ambas clases al implementar la interface Lista son compatibles como parámetro.
        // No importa que implementación de la interface se usa, todas son compatibles.
        cargarLista(listaArreglo);
        cargarLista(listaEnlazada);

        //Eliminar un elemento:
        System.out.println((listaEnlazada.eliminar(32) ? "Se elimina el elemento 32" : "No se pudo eliminar el elemento 32"));
        System.out.println((listaArreglo.eliminar(43) ? "Se elimina el elemento 43 \n" : "No se pudo eliminar el elemento 43 \n"));

       // Buscar un elemento
       int indice4 = listaEnlazada.buscar(4);
       if (indice4 != -1) {
        System.out.println("El elemento 4 fue encontrado en listaEnlazada en el índice: " + indice4);
        System.out.println();
       }else{   
        System.out.println("El elemento 4 no fue encontrado en listaEnlazada.");
       }

      int indice8 = listaArreglo.buscar(8);
      if (indice8 != -1) {
         System.out.println("El elemento 8 fue encontrado en listaArreglo en el índice: " + indice8);
         System.out.println();
      } else {
         System.out.println("El elemento 8 no fue encontrado en listaArreglo. \n");
      }

       // Mostrar la longitud de ambas listas
       System.out.println("Longitud de ambas listas: ");
       System.out.println("Longitud de listaArreglo: " + listaArreglo.longitud());
       System.out.println("Longitud de listaEnlazada: " + listaEnlazada.longitud());
       System.out.println();

       // Mostrar la lista implementada sobre arreglos y con nodos
       System.out.println("Mostrando la lista implementada sobre arreglos:");
       listaArreglo.imprimir();

       System.out.println("Mostrando la lista implementada con Nodos:");
       listaEnlazada.imprimir();
    }
}
