public class EjemploUsoPilasArreglo <T> implements Pila<T> {
    private T[] arreglo;
    private int tope;
    private static final int capInicialArreglo = 10; //Capacidad inicial del Arreglo


    @SuppressWarnings("unchecked")
    public EjemploUsoPilasArreglo(){
        arreglo = (T[]) new Object [capInicialArreglo];
        tope = -1; //Pila Vacia
    }

    @Override
    public void apilar(T item) {
        if(tope + 1 == arreglo.length){
            aumentarTamañoArreglo();
        }
        arreglo[++tope] = item;
    }

    private void aumentarTamañoArreglo() {
        @SuppressWarnings("unchecked")
        T[] nuevoArreglo = (T[]) new Object [arreglo.length * 2]; //Duplica el tamaño del arreglo 
        for(int i = 0; i <= tope; i++){
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

    @Override
    public void desapilar() {
        if(esVacia()){
            throw new IllegalStateException("La pila esta vacia");
        }
        arreglo[tope] = null; 
        tope--;
    }

    @Override
    public T tope() {
      if(esVacia()){
        throw new IllegalStateException("La pila esta vacia");
      }
      return arreglo[tope]; //Retorna el ultimo elemento
    }

    @Override
    public boolean esVacia() {
        return tope == -1; //Verifica si la pila esta vacia
    }

    @Override
    public void vaciar() {
        while (!esVacia()) {
            desapilar(); //Desapila todos los elementos
        }
    }

    public int longitud(){
        return tope + 1;
    }

    //Ejemplo para probar las PilasArreglo (Ejemplo Dado Por ChatGPT):
    public static void main(String[] args) {
        // Crear una pila de enteros
        EjemploUsoPilasArreglo<Integer> pila = new EjemploUsoPilasArreglo<>();

        // Apilar algunos elementos
        System.out.println("Apilando elementos:");
        for (int i = 1; i <= 5; i++) {
            pila.apilar(i);
            System.out.println("Elementos en la pila: " + pila.tope());
        }

        // Desapilar elementos
        System.out.println("\nDesapilando elementos:");
        while (!pila.esVacia()) {
            pila.desapilar(); // Simplemente desapilamos sin almacenar el valor
            if (!pila.esVacia()) {
                System.out.println("Nuevo tope: " + pila.tope());
            } else {
                System.out.println("La pila está vacía.");
            }
        }

        // Intentar desapilar de la pila vacía
        try {
            pila.desapilar();
        } catch (IllegalStateException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}
