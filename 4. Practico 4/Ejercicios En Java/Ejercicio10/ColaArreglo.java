package Ejercicio10;
public class ColaArreglo<T> implements Cola<T>{
    private T[] arreglo;
    private int tope;

    @SuppressWarnings("unchecked")
    public ColaArreglo(){
        arreglo = (T[]) new Object[10];
        tope = 0; //Cola vacia
    }

    @Override
    public void insertarFin(T item) {
        //Verifico si el arreglo esta lleno
        if(tope == arreglo.length){
            aumentarTamañoArreglo(); //Duplica el tamaño del arreglo
        }
        arreglo[tope] = item; //Agrego el nuevo elemento a la cola
        tope++; //Incremento el tope
    }

    private void aumentarTamañoArreglo() {
        @SuppressWarnings("unchecked")
        T[] nuevoArreglo = (T[]) new Object [arreglo.length * 2]; //Duplica el tamaño del arreglo 
        for(int i = 0; i < tope; i++){
            nuevoArreglo[i] = arreglo[i]; //Copia los elementos
        }
        arreglo = nuevoArreglo;
    }

    @Override
    public void insertarInicio(T elem) {
        //Verifico si el arreglo esta lleno
        if(tope == arreglo.length){
            aumentarTamañoArreglo(); //Duplica el tamaño del arreglo
        }

        //Desplazo todos los elementos de la cola a la derecha
        for(int contador = tope; contador>0; contador--){
            arreglo[contador] = arreglo[contador - 1]; //Desplazo el elemento de la cola a la derecha
        }

        //Inserto el nuevo elemento en la posición 0
        arreglo[0] = elem; //Agrego el nuevo elemento
        tope++; //Incremento el tope
    }

    @Override
    public void insertarPos(T elem, int pos) {
        //Verifico si el arreglo esta lleno
        if(tope == arreglo.length){
            aumentarTamañoArreglo(); //Duplica el tamaño del arreglo
        }

        if (pos < 0 || pos > tope) {
            throw new IndexOutOfBoundsException("Posición inválida"); // Verifica la posición
        }

        //Desplazo todos los elementos de la cola a la derecha
        for(int contador = tope; contador > pos; contador--){
            arreglo[contador] = arreglo[contador - 1]; //Desplazo el elemento de la cola a la derecha
        }

        //Inserto el nuevo elemento en la posición 0
        arreglo[pos] = elem; //Agrego el nuevo elemento
        tope++; //Incremento el tope
    }

    @Override
    public boolean eliminar(T item) {
        if(item == null){
            throw new IllegalArgumentException("El elemento no puede ser null.");
        }

        int indice = buscar(item); //Busca el indice en donde se encuentra el elemento en la cola

        if(indice == -1){
            return false; //Si no se encuentra un elemento en la cola, retorna falso
        }else{
            while(indice < tope-1){
                arreglo[indice] = arreglo[indice + 1]; //Mueve el elemento a la izquierda
                indice++; //Incrementa el indice
            }
            arreglo[--tope] = null; //Decrementa el tope despues de mover los elementos de la cola y establece el ultimo elemento en null
        }
        return true; //Elimino el elemento de la cola
    }

    @Override
    public int buscar(T item) {
        if(item == null){
            throw new IllegalArgumentException("El elemento no puede ser null");
        }

        int contador = 0; //Contador
        while (contador < tope) {
            if(arreglo[contador].equals(item)){
                return contador;
            }
            contador++;
        }
        return -1;
    }

    @Override
    public int longitud() {
        return tope;
    }

    @Override
    public void imprimir() {
        if(tope == 0){
            System.out.println("La cola está vacia.");
            return;
        }

        int indice = 0;

        while (indice < tope) {
            System.out.print(arreglo[indice]);

            //Agrega una coma y un espacio solo si no es el ultimo elemento
            if(indice < tope - 1){
                System.out.print(", ");
            }
    
            indice++;
        }
        System.out.println(); //Agrega un salto de linea al final
    }
}
