import javax.swing.JOptionPane;
import java.util.Random;

public class Pila {

    private double[] pila;
    private int cima;
    private int capacidad;

    /* Muestra la capacidad de pila */
    public int getCapacidad() {
        return capacidad;
    }

    /* Muestra el tamaño que se ha ocupado en la pila */
    public int getDimension() {
        return cima + 1;
    }
    /* Constructor de la pila */
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.pila = new double[capacidad];
        this.cima = -1;
    }

    /* Metodo para mostrar el estado de la pila */
    public void mostrarEstado() {
        StringBuilder estado = new StringBuilder();
        estado.append("Capacidad total: ").append(capacidad).append("\n");
        estado.append("Elementos actuales: ").append(cima + 1).append("\n");
        estado.append("Contenido de la pila: ");

        if (estaVacia()) {
            estado.append("Pila vacía");
        }
        else {
            for (int i = 0; i <= cima; i++) {
                estado.append(pila[i]).append(i < cima ? ", " : "");
            }
        }
        JOptionPane.showMessageDialog(null, estado.toString(), "ESTADO", JOptionPane.INFORMATION_MESSAGE);
    }

    /* Metodo para apilar los elementos */
    public void push(double valor) {
        if (!estaLlena()) {
            cima++;
            pila[cima] = valor;
        } else {
            JOptionPane.showMessageDialog(null, "La pila está llena",
                    "SIN ESPACIO", JOptionPane.ERROR_MESSAGE);
        }
    }

    /* Metodo para desapilar y mostrar */
    public Double pop() {
        if (!estaVacia()) {
            double valorEliminado = pila[cima--];
            JOptionPane.showMessageDialog(null, "Se ha eliminado el elemento: " + valorEliminado + ".", "ESTADO", JOptionPane.INFORMATION_MESSAGE);
            return valorEliminado;
        } else {
            JOptionPane.showMessageDialog(null, "La pila está vacía",
                    "SIN ELEMENTOS", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /* Metodo para validar si está vacía */
    public boolean estaVacia() {
        return cima == -1;
    }

    /* Metodo para validar si está llena */
    public boolean estaLlena() {
        return cima == capacidad - 1;
    }

    /* Metodo para llenar aleatoriamente */
    public void llenarAleatorio() {
        Random rand = new Random();
        while (!estaLlena()) {
            double valor = rand.nextDouble();
            push(valor);
            String mostrarValor = String.format("%.2f", valor);
            JOptionPane.showMessageDialog(null, "Se ha apilado el elemento: " + mostrarValor,
                    "ESTADO" , JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /* Metodo para llenar manualmente */
    public void llenarManual() {
        while (!estaLlena()) {
            String entradaValor = JOptionPane.showInputDialog(null, "Ingrese el valor que desea añadir a la pila. \n" +
                     "De lo contrario, escriba la palabra salir para terminar.",
                    "ESTADO", JOptionPane.QUESTION_MESSAGE);
            if (entradaValor.equalsIgnoreCase("salir")) {
                break;
            }
            push(Double.parseDouble(entradaValor));
        }
    }
}