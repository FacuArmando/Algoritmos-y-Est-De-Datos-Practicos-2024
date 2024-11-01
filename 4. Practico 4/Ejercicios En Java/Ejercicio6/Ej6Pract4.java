import java.util.Scanner;
import java.util.Stack;

public class Ej6Pract4 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner x = new Scanner(System.in);

        System.out.print("Ingrese una expresión matematica: ");
        String entradaElem = x.next();

        Stack <Character> p = new Stack<Character>();

        int i; //Indice
        int tam = entradaElem.length(); //Tamaño de la lista

        for(i = 0; i < tam; i++){
            if(entradaElem.charAt(i) == '('){
                p.push('(');
            }else{
                if(entradaElem.charAt(i) == ')'){
                    if(p.isEmpty()){
                        System.out.println("La expresion esta incorrecta.");
                        break; //Cuando tenemos parentesis cerrado, y esta vacio, salimos del bucle
                    }else{
                        p.pop(); //Cuando tenemos parentesis cerrado, y hay datos
                    }
                }
            }
        }

        if(p.isEmpty() && i==tam){
            System.out.println("La expresion esta Balanceada."); 
        }else{
            System.out.println("La expresion no esta Balanceada.");
        }
    }
}
