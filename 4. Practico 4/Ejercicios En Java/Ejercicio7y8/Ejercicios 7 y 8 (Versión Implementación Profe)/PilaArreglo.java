public class PilaArreglo<T> implements NewPila<T> {
    private T[] arreglo;
    private int tope;
   
    @SuppressWarnings("unchecked")
    public PilaArreglo(){
        arreglo = (T[]) new Object[10];
        tope = 0; //Pila vacia
    }

    @Override
    public void insertarFin(T item) {
        //Verifico si el arreglo esta lleno
        if(tope == arreglo.length){
            aumentarTamañoArreglo(); //Duplica el tamaño del arreglo
        }
        arreglo[tope] = item; //Agrego el nuevo elemento
        tope++; //Incremento el tope
    }

    private void aumentarTamañoArreglo() {
        @SuppressWarnings("unchecked")
        T[] nuevoArreglo = (T[]) new Object [arreglo.length * 2]; //Duplica el tamaño del arreglo 
        for(int i = 0; i < tope; i++){
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

    @Override
    public void insertarInicio(T elem) {
        //Verifico si el arreglo esta lleno
        if(tope == arreglo.length){
            aumentarTamañoArreglo(); //Duplica el tamaño del arreglo
        }

        //Desplazo todos los elementos a la derecha
        int i = tope;
        while (i>0) {
            arreglo[i] = arreglo[i-1]; //Desplazo el elemento a la derecha
            i--;
        }

        //Inserto el nuevo elemento en la posición 0
        arreglo[0] = elem; //Agrego el nuevo elemento
        tope++; //Incremento el tope
    }

    @Override
    public void insertarPos(T elem, int pos) {
        if(tope == arreglo.length){
            aumentarTamañoArreglo(); //Duplica el tamaño del arreglo
        }

        if (pos < 0 || pos > tope) {
            throw new IndexOutOfBoundsException("Posición inválida"); // Verifica la posición
        }

        //Desplazo todos los elementos a la derecha
        int i = tope;
        while (i > pos) {
            arreglo[i] = arreglo[i-1]; //Desplazo el elemento a la derecha
            i--;
        }

        //Inserto el nuevo elemento en la posición deseada
        arreglo[pos] = elem; //Agrego el nuevo elemento
        tope++; //Incremento el tope
    }

    @Override
    public boolean eliminar(T item) {
        if (item == null) {
            throw new IllegalArgumentException("El elemento no puede ser null");
        }

        int i = buscar(item); //Busca el indice del elemento

        if(i == -1){
            return false; //Si no se encuentra un elemento, retorna falso
        }else{
            while (i < tope-1) {
                arreglo[i] = arreglo[i+1]; //Mueve el elemento a la siguiente posicion
                i++; //Incrementa el indice
            }
            tope--; //Decrementa el tope despues de mover los elementos
        }
        return true; //Elimino el elemento
    }

    @Override
    public int buscar(T item) {
        if(item == null){
            throw new IllegalArgumentException("El elemento no puede ser null");
        }

        int i = 0; //Contador
        while (i < tope) {
            if(arreglo[i].equals(item)){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public int longitud() {
        return tope;
    }

    @Override
    public void imprimir() {
        int i = 0;

        while (i < tope) {
            System.out.println(arreglo[i]);
            i++;
        }
    }
    
}
