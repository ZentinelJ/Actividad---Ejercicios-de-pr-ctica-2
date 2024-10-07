import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bienvenido al administrador de pilas.", "BIENVENIDO", JOptionPane.INFORMATION_MESSAGE);

        ArrayList<Pila> pilasCreadas = new ArrayList<>(); //Para guardar los objetos de la clase pila
        ArrayList<Stack<Double>> stacksCreados = new ArrayList<>(); //Para guardar los objetos de la clase stack
        ArrayList<Integer> capacidadesStacks = new ArrayList<>(); //Para manejar la capacidad de los objetos clase stack

        while(true) {

            String entrada = JOptionPane.showInputDialog(null, "Por favor seleccione el modo de operación: \n" +
                    "1. Operar con clase Pila. \n" +
                    "2. Operar con clase Stack. \n" +
                    "3. Salirse del programa. \n",
                    "SELECTOR DE MODO", JOptionPane.QUESTION_MESSAGE);

            int menuPrincipalOpcion = Integer.parseInt(entrada);

            switch (menuPrincipalOpcion) {
                case 1:
                    boolean modoPila = true;
                    while(modoPila) {
                        
                    String entradaPila = JOptionPane.showInputDialog(null, "Por favor indique que desea hacer: \n" +
                            "1. Crear una nueva pila. \n" +
                            "2. Llenar aleatoriamente la pila. \n" +
                            "3. LLenar manualmente la pila. \n" +
                            "4. Conocer el estado de la pila. \n" +
                            "5. Sacar un valor de la pila y conocerlo. \n" +
                            "6. Regresar al selector de modo. \n" +
                            "7. Salir del programa. \n",
                            "MODO PILA", JOptionPane.QUESTION_MESSAGE);
                    
                    int menuPilaOpcion = Integer.parseInt(entradaPila);
                    
                    switch (menuPilaOpcion) {
                        case 1: //Este es el bloque que permite la creación de la pila.
                            JOptionPane.showMessageDialog(null,"Usted ha elegido crear una pila.", "CREADOR", JOptionPane.INFORMATION_MESSAGE);
                            boolean creadorPila = true;
                            while(creadorPila) {
                                String pilaDimension = JOptionPane.showInputDialog(null, "Especifica el tamaño de la pila a crear.", "CREADOR", JOptionPane.QUESTION_MESSAGE);

                                int tamPila = Integer.parseInt(pilaDimension);

                                if(tamPila <= 0) {
                                    JOptionPane.showMessageDialog(null, "El valor no puede ser igual o inferior a 0.", "¡ERROR!",JOptionPane.ERROR_MESSAGE);
                                }
                                else{
                                Pila pila = new Pila(tamPila);
                                pilasCreadas.add(pila);
                                JOptionPane.showMessageDialog(null, "Usted ha creado una pila con el tamaño: " + tamPila + ".", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                                }

                                String decision = JOptionPane.showInputDialog(null,"¿Desea continuar? (s/n).", "¿CONTINUAR?", JOptionPane.QUESTION_MESSAGE);
                                if(decision.equalsIgnoreCase("n")) {
                                    creadorPila = false;
                                }
                            }
                            break;
                        case 2: //Con este bloque llenamos aleatoreamente la pila seleccionada.
                            if (pilasCreadas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay pilas disponibles para llenar.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                StringBuilder pilasDisponibles = new StringBuilder("Seleccione una pila para llenar aleatoriamente:\n");
                                for (int i = 0; i < pilasCreadas.size(); i++) {
                                    pilasDisponibles.append(i + 1).append(". Pila ").append(i + 1).append(" (Capacidad: ").append(pilasCreadas.get(i).getCapacidad()).append(", Espacio ocupado: ").append(pilasCreadas.get(i).getDimension()).append(")\n");
                                }

                                String entradaSeleccion = JOptionPane.showInputDialog(null, pilasDisponibles.toString(), "Seleccionar Pila", JOptionPane.QUESTION_MESSAGE);

                                int seleccion = Integer.parseInt(entradaSeleccion);

                                Pila pilaSeleccionada = pilasCreadas.get(seleccion - 1);
                                pilaSeleccionada.llenarAleatorio();
                            }
                            break;
                        case 3: //Este bloque permite llenar manualmente la pila seleccionada
                            if (pilasCreadas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay pilas disponibles para llenar.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                StringBuilder pilasDisponibles = new StringBuilder("Seleccione una pila para llenar aleatoriamente:\n");
                                for (int i = 0; i < pilasCreadas.size(); i++) {
                                    pilasDisponibles.append(i + 1).append(". Pila ").append(i + 1).append(" (Capacidad: ").append(pilasCreadas.get(i).getCapacidad()).append(", Espacio ocupado: ").append(pilasCreadas.get(i).getDimension()).append(")\n");
                                }

                                String entradaSeleccion = JOptionPane.showInputDialog(null, pilasDisponibles.toString(), "Seleccionar Pila", JOptionPane.QUESTION_MESSAGE);

                                int seleccion = Integer.parseInt(entradaSeleccion);

                                Pila pilaSeleccionada = pilasCreadas.get(seleccion - 1);
                                pilaSeleccionada.llenarManual();
                            }
                            break;
                        case 4: //Este bloque permite conocer las pilas y su estado
                            if (pilasCreadas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay pilas disponibles.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                StringBuilder pilasDisponibles = new StringBuilder("Seleccione la pila que desea conocer:\n");
                                for (int i = 0; i < pilasCreadas.size(); i++) {
                                    pilasDisponibles.append(i + 1).append(". Pila ").append(i + 1).append("\n");
                                }

                                String entradaSeleccion = JOptionPane.showInputDialog(null, pilasDisponibles.toString(), "Seleccionar Pila", JOptionPane.QUESTION_MESSAGE);

                                int seleccion = Integer.parseInt(entradaSeleccion);

                                Pila pilaSeleccionada = pilasCreadas.get(seleccion - 1);
                                pilaSeleccionada.mostrarEstado();
                            }
                            break;
                        case 5: //Este bloque extrae un valor y lo muestra
                            if (pilasCreadas.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay pilas disponibles.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                            }
                            else {
                                StringBuilder pilasDisponibles = new StringBuilder("Seleccione la pila a la que desea quitar un elemento:\n");
                                for (int i = 0; i < pilasCreadas.size(); i++) {
                                    pilasDisponibles.append(i + 1).append(". Pila ").append(i + 1).append("\n");
                                }

                                String entradaSeleccion = JOptionPane.showInputDialog(null, pilasDisponibles.toString(), "Seleccionar Pila", JOptionPane.QUESTION_MESSAGE);

                                int seleccion = Integer.parseInt(entradaSeleccion);

                                Pila pilaSeleccionada = pilasCreadas.get(seleccion - 1);
                                pilaSeleccionada.pop();
                            }
                            break;
                        case 6: //Regresa al menú principal
                            JOptionPane.showMessageDialog(null,"Eligió regresar al selector de modo.", "REGRESANDO", JOptionPane.INFORMATION_MESSAGE);
                            modoPila = false;
                            break;
                        case 7: //Salida del programa
                            JOptionPane.showMessageDialog(null, "¡Hasta luego!", "SALIDA", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        default:
                            JOptionPane.showMessageDialog(null, "Usted ha elegido la opción: " + menuPilaOpcion + ". \n" + "Por favor intente nuevamente.",
                                    "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    }
                    break;
                case 2:
                    boolean modoStack = true;
                    while(modoStack) {

                    String entradaStack = JOptionPane.showInputDialog(null, "Por favor indique que desea hacer: \n" +
                            "1. Crear una pila de clase Stack. \n" +
                            "2. Agregar valores al Stack. \n" +
                            "3. Inversar un Stack y crear otro. \n" +
                            "4. Conocer los valores de los Stack's. \n" +
                            "5. Regresar al selector de modo. \n" +
                            "6. Salirse del programa.",
                            "MODO STACK", JOptionPane.QUESTION_MESSAGE);

                    int menuStackOpcion = Integer.parseInt(entradaStack);

                    switch (menuStackOpcion) {
                        case 1: //Bloque para la creación de stacks
                            boolean creadorStack = true;
                            while (creadorStack) {
                                String stackDimension = JOptionPane.showInputDialog(null, "Especifica el tamaño del Stack a crear.", "CREADOR", JOptionPane.QUESTION_MESSAGE);
                                int tamStack = Integer.parseInt(stackDimension);

                                if (tamStack <= 0) {
                                    JOptionPane.showMessageDialog(null, "El valor no puede ser igual o inferior a 0.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                                } else {
                                    Stack<Double> stack = new Stack<>();
                                    stacksCreados.add(stack);
                                    capacidadesStacks.add(tamStack); // Guarda la capacidad correspondiente
                                    JOptionPane.showMessageDialog(null, "Usted ha creado un Stack con el tamaño: " + tamStack + ".", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                                }

                                String decision = JOptionPane.showInputDialog(null, "¿Desea continuar? (s/n).", "¿CONTINUAR?", JOptionPane.QUESTION_MESSAGE);
                                if (decision.equalsIgnoreCase("n")) {
                                    creadorStack = false;
                                }
                            }
                            break;
                        case 2: //Bloque para el llenado de stack seleccionado
                            boolean llenarStack = true;
                            while (llenarStack) {
                                if (stacksCreados.isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "No hay Stack's disponibles para llenar.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                                    break;
                                } else {
                                    StringBuilder stacks = new StringBuilder("Selecciona el stack que deseas llenar:\n");
                                    for (int i = 0; i < stacksCreados.size(); i++) {
                                        stacks.append(i + 1).append(". Stack ").append(i + 1)
                                                .append(" (Capacidad: ").append(capacidadesStacks.get(i)).append(", Ocupado: ").append(stacksCreados.get(i).size()).append(")\n");
                                    }

                                    String entradaSeleccion = JOptionPane.showInputDialog(null, stacks.toString(), "Seleccionar Stack", JOptionPane.QUESTION_MESSAGE);
                                    int seleccion = Integer.parseInt(entradaSeleccion) - 1;

                                    String entradaValor = JOptionPane.showInputDialog(null, "Introduzca el valor que desea agregar al stack.", "INGRESAR", JOptionPane.QUESTION_MESSAGE);
                                    double valor = Double.parseDouble(entradaValor);

                                    if (stacksCreados.get(seleccion).size() < capacidadesStacks.get(seleccion)) {
                                        stacksCreados.get(seleccion).push(valor);
                                        JOptionPane.showMessageDialog(null, "Valor " + valor + " agregado al Stack " + (seleccion + 1) + ".");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El Stack está lleno. No se puede agregar más elementos.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                                    }

                                    String decision = JOptionPane.showInputDialog(null, "¿Desea continuar? (s/n)", "¿CONTINUAR?", JOptionPane.QUESTION_MESSAGE);
                                    if (decision.equalsIgnoreCase("n")) {
                                        llenarStack = false;
                                    }
                                }
                            }
                            break;
                        case 3: //Bloque para llenar de forma inversa
                            if (stacksCreados.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay Stack's disponibles para invertir.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                            } else {
                                StringBuilder stacks = new StringBuilder("Selecciona el stack que deseas invertir:\n");
                                for (int i = 0; i < stacksCreados.size(); i++) {
                                    stacks.append(i + 1).append(". Stack ").append(i + 1).append("\n");
                                }

                                String entradaSeleccion = JOptionPane.showInputDialog(null, stacks.toString(), "Seleccionar Stack", JOptionPane.QUESTION_MESSAGE);
                                int seleccion = Integer.parseInt(entradaSeleccion) - 1;

                                Stack<Double> stackFuente = stacksCreados.get(seleccion);
                                Stack<Double> stackDestino = new Stack<>();

                                for (int i = stackFuente.size() - 1; i >= 0; i--) {
                                    stackDestino.push(stackFuente.get(i));
                                }

                                stacksCreados.add(stackDestino);
                                JOptionPane.showMessageDialog(null, "Stack creado con los valores en orden inverso del Stack " + (seleccion + 1) + ".", "ÉXITO", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case 4: //Bloque para mostrar los stack y estado
                            if (stacksCreados.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "No hay Stack's disponibles.", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                            } else {
                                StringBuilder stacksEstado = new StringBuilder("Estado de los Stack's:\n");
                                for (int i = 0; i < stacksCreados.size(); i++) {
                                    stacksEstado.append("Stack ").append(i + 1).append(": ");
                                    Stack<Double> stackActual = stacksCreados.get(i);
                                    if (stackActual.isEmpty()) {
                                        stacksEstado.append("Vacío\n");
                                    } else {
                                        stacksEstado.append(stackActual.toString()).append("\n");
                                    }
                                }
                                JOptionPane.showMessageDialog(null, stacksEstado.toString(), "Estado de los Stack's", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        case 5: //Retorno al menú principal
                            JOptionPane.showMessageDialog(null,"Eligió regresar al selector de modo.", "REGRESANDO", JOptionPane.INFORMATION_MESSAGE);
                            modoStack= false;
                            break;
                        case 6: //Salida
                            JOptionPane.showMessageDialog(null, "¡Hasta luego!", "SALIDA", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);
                        default:
                            JOptionPane.showMessageDialog(null, "Usted ha pulsado la opción: " + menuStackOpcion + ". \n" + "Por favor intente nuevamente.",
                                    "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                    }
                    break;
                case 3://salida
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.",
                            "¡NOS VEMOS!", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Usted ha pulsado la opción: " + menuPrincipalOpcion + ". \n" + "Por favor intente nuevamente.",
                            "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
