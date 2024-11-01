package Ejercicio10;
public interface Cola<T>{
    public void insertarFin(T item); //Inserta un elemento al final de la lista
    public void insertarInicio(T elem); //Inserta un elemento al comienzo de la lista
    public void insertarPos(T elem, int pos); //Inserta un elemento en una posición determinada, y los demás elementos se mueven un lugar a la derecha
    public boolean eliminar(T item); //Elimina la primera ocurrencia del elemento 
    public int buscar(T item); //Busca la posición en la que se encuentra un elemento
    public int longitud(); //Retorna la cantidad de elementos que actualmente almacena la lista
    public void imprimir(); //Imprime por pantalla los elementos de la lista
}