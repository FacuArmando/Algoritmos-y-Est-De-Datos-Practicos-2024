package  Ejercicio5.proyecto;   

//Interfaz Generica Lista
public interface Lista<T> {
    void agregar(T item);
    void eliminar(T item);
    T buscar(T item);
    int tamaño();
}