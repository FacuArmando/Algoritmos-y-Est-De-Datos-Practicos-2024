package Ejercicio13;


public class ColaCircular implements NewCola{
    private int maxSize; //Para almacenar la capacidad maxima de la cola
    private int[] cola; //Un arreglo para almacenar los elementos de la cola
    private int frente; //Indice para iniciar la cola
    private int fin; //Indice para finalizar la cola
    private int tamaño; //Indica la cantidad de elementos actuales en la cola

    public ColaCircular(int size){
        this.maxSize = size; //Inicializa maxSize
        this.cola = new int[maxSize]; // Inicializa el arreglo
        this.frente = 0; // Inicializa frente
        this.fin = -1; //Inicializa fin
        this.tamaño = 0; //Inicializa tamaño
    }

    @Override
    public void encolar(int elemento) {
        if(estaLlena()){
            System.out.println("La cola está llena");
            return;
        }else{
            fin = (fin + 1) % maxSize; //Mueve "fin" al siguiente indice
            cola[fin] = elemento; //Agrega el elemento en el indice "fin"
            tamaño++; //Aumenta el tamaño de la cola
        }
        
    }

    @Override
    public int desencolar() {
        if(estaVacia()){
            throw new IllegalStateException("La cola está vacia");
        }else{
            int elemento = cola[frente]; //Accede al elemento en el frente
            frente = (frente + 1) % maxSize; //Mueve el indice frente al siguiente
            tamaño--; //Disminuye el tamaño
            return elemento; //Devuelve el elemento desencolado
        }
        
    }

    @Override
    public boolean estaLlena() {
        if(tamaño == maxSize){
            return true; //La cola esta llena
        }else{
            return false; //La cola NO esta llena
        }
    }

    @Override
    public boolean estaVacia() {
        if(tamaño == 0){
            return true; //La cola esta vacia
        }else{
            return false; //La cola NO esta vacia
        }
    }

    @Override
    public void imprimir() {
        if(estaVacia()){
            System.out.println("La cola está vacia");
            return;
        }

        int indice = frente;

        int indice2 = 0;
        while (indice2 < tamaño) {
            System.out.print(cola[indice]); //Imprime el elemento actual

            //Verifica si no es el ultimo elemento para imprimir la coma
            if(indice2 < tamaño - 1){
                System.out.print(", "); //Solo si no es el ultimo elemento
            }

            //Actualizar el indice para el siguiente elemento
            indice = (indice + 1) % maxSize; 

            //Incremento el indice utilizado en el While
            indice2++;
        }
        System.out.println(); // Para mover a la siguiente línea al final
    }
}