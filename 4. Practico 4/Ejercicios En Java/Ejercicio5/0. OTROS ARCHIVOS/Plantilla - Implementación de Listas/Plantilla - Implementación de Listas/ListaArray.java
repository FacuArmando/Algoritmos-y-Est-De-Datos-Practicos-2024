
/**
 * Esta clase implementa el TAD Lista utilizando un arreglo como estructura base.
 */
public class ListaArray<T> implements Lista<T>
{
    @SuppressWarnings("unused")
    private T[] elems;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public ListaArray(int maxSize){
        this.elems = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
    }

    public void insertarFin(T item){
        //Completar
    }

    public void insertarInicio(T elem){
        //Completar
    }

    public void insertarPos(T elem, int pos){
        //Completar
    }

    public boolean eliminar(T item){
        return false;
        //Completar
    }

    public int buscar(T item){
        return maxSize;
        //Completar
    }

    public int longitud(){
        return maxSize;
        //Completar
    }

    public void imprimir(){
        //Completar
    }
}
