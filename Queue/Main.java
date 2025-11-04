class Customer {
    int id;
    String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "Customer{id=" + id + ", name='" + name + "'}";
    }
}

class Nodo {
    Customer valor;
    Nodo siguiente;
    Nodo(Customer valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class ArrayQueue {
    Nodo frente, fin;
    int size;

    void enqueue(Customer valor) {
        Nodo nuevo = new Nodo(valor);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        size++;
    }

    Customer dequeue() {
        if (frente == null) return null;
        Customer valor = frente.valor;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        size--;
        return valor;
    }

    boolean vacia() {
        return frente == null;
    }

    int tamanio() {
        return size;
    }

    void mostrar() {
        System.out.print("[");
        Nodo temp = frente;
        while (temp != null) {
            System.out.print(temp.valor);
            if (temp.siguiente != null) System.out.print(", ");
            temp = temp.siguiente;
        }
        System.out.println("]");
    }

    void reverse() {
        Pila aux = new Pila();
        while (!vacia()) {
            aux.push(dequeue());
        }
        while (!aux.vacia()) {
            enqueue(aux.pop());
        }
    }
}

class Pila {
    Nodo cima;

    void push(Customer valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    Customer pop() {
        if (cima == null) return null;
        Customer dato = cima.valor;
        cima = cima.siguiente;
        return dato;
    }

    boolean vacia() {
        return cima == null;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayQueue fila = new ArrayQueue();
        fila.enqueue(new Customer(1, "Ana"));
        fila.enqueue(new Customer(2, "Luis"));
        fila.enqueue(new Customer(3, "Maya"));
        fila.enqueue(new Customer(4, "Pakoo"));
        fila.enqueue(new Customer(5, "Sofia"));

        System.out.println("Antes de invertir:");
        fila.mostrar();

        int antes = fila.tamanio();
        fila.reverse();
        int despues = fila.tamanio();

        System.out.println("Después de invertir:");
        fila.mostrar();

        System.out.println("Elementos antes = " + antes + ", elementos después = " + despues);
    }
}
