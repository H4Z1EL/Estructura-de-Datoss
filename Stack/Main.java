class Nodo {
    char valor;
    Nodo siguiente;
    Nodo(char valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}
class Pila {
    Nodo cima;

    void push(char valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cima;
        cima = nuevo;
    }
    char pop() {
        if (cima == null) return '\0';
        char dato = cima.valor;
        cima = cima.siguiente;
        return dato;
    }

    boolean vacia() {
        return cima == null;
    }
}
public class Main {
    static boolean isPalindrome(String texto) {
        String limpio = "";
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (Character.isLetter(c)) limpio += Character.toLowerCase(c);
        }

        Pila pila = new Pila();
        for (int i = 0; i < limpio.length(); i++) {
            pila.push(limpio.charAt(i));
        }

        String invertido = "";
        while (!pila.vacia()) {
            invertido += pila.pop();
        }

        return limpio.equals(invertido);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Anita lava la tina"));
        System.out.println(isPalindrome("Hola"));
    }
}