public interface Pila <T>{
    void apilar (T item); //Apila un item al tope de la pila
    void desapilar(); //Desapila el elemento al tope de la pila
    T tope(); //Retorna el elemento al tope de la pila
    boolean esVacia(); //Dice si la pila es vacia o no
    void vaciar(); //Vacia la pila de elementos
    int longitud();
}