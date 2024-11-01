public class PilaArreglo <T> implements Pila<T>{
    private T[] arreglo;
    private int tope;
    private static final int capInicialArreglo = 10; //Capacidad inicial del Arreglo


    @SuppressWarnings("unchecked")
    public PilaArreglo(){
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
}