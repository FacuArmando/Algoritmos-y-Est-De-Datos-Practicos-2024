import java.util.Arrays;

@SuppressWarnings("unused")
public class ListaArreglo<T> implements Lista<T> {
    private T[] arreglo;
    private int tamaño;
    private static final int capInicialArreglo = 10;

    @SuppressWarnings("unchecked")
    public ListaArreglo(){
        arreglo = (T[]) new Object [capInicialArreglo];
        tamaño = 0;
    }

    @SuppressWarnings("unchecked")
    public ListaArreglo(int capacidadInicial) {
        arreglo = (T[]) new Object[capacidadInicial];
        tamaño = 0;
    }

    @Override
    public void insertarFin(T item) {
        if(tamaño == arreglo.length){
            aumentarTamañoArreglo();
        }
        arreglo[tamaño++] = item;
    }

    private void aumentarTamañoArreglo() {
        @SuppressWarnings("unchecked")
        T[] nuevoArreglo = (T[]) new Object [arreglo.length * 2]; //Duplica el tamaño del arreglo 
        for(int i = 0; i < tamaño; i++){
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

    @Override
    public void insertarInicio(T elem) {
        if(tamaño == arreglo.length){
            aumentarTamañoArreglo();
        }

        int i = tamaño;
        while (i > 0) {
            arreglo[i] = arreglo[i-1]; //Mueve cada elemento una posición hacia la derecha
            i--;
        }
        arreglo[0] = elem; //Inserta el nuevo elemento en la primera posición
        tamaño++; //Incrementa el tamaño
        
    }

    @Override
    public void insertarPos(T elem, int pos) {
        if (pos < 0 || pos > tamaño) {
            throw new IndexOutOfBoundsException("Posición no válida");
        }
        
        if(tamaño == arreglo.length){
            aumentarTamañoArreglo(); //Aumenta el tamaño si es necesario
        }

        int i = tamaño;
        while (i > pos) {
            arreglo[i] = arreglo[i-1]; //Mueve cada elemento una posición hacia la derecha
            i--;
        }
        arreglo[pos] = elem; //Inserta el nuevo elemento en la posición deseada
        tamaño++; //Incrementa el tamaño

    }

    @Override
    public boolean eliminar(T item) {
       int i = 0;
       while(i<tamaño){
         if(arreglo[i] != null && arreglo[i].equals(item)){
            int j = i;
            while(j < tamaño - 1){
                arreglo[j] = arreglo[j+1];
                j++;
            }
            arreglo[tamaño - 1] = null;
            tamaño--;
            return true;
         } 
         i++;
       }
       return false;
    }

    @Override
    public int buscar(T item) {
        for(int i = 0; i < tamaño; i++){
            if(arreglo[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int longitud() {
        return tamaño;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
}
