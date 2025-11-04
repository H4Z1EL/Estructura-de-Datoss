class Nodo {
    int valor;
    Nodo siguiente;
    Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class Lista {
    Nodo inicio;

    void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    void mostrar() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.print(temp.valor + " -> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    Lista pares() {
        Lista listaPares = new Lista();
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.valor % 2 == 0) listaPares.agregar(temp.valor);
            temp = temp.siguiente;
        }
        return listaPares;
    }

    Lista impares() {
        Lista listaImpares = new Lista();
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.valor % 2 != 0) listaImpares.agregar(temp.valor);
            temp = temp.siguiente;
        }
        return listaImpares;
    }
}

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.agregar(4);
        lista.agregar(5);

        System.out.print("Original: ");
        lista.mostrar();

        Lista pares = lista.pares();
        System.out.print("Pares: ");
        pares.mostrar();

        Lista impares = lista.impares();
        System.out.print("Impares: ");
        impares.mostrar();
    }
}
