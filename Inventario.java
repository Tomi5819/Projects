import java.util.ArrayList;

public class Inventario {

    // Atributo que guarda la capacidad máxima
    private int capacidad;

    // Lista que guarda los items del inventario
    private ArrayList<String> items;

    // Constructor que recibe la capacidad
    public Inventario(int capacidad) {
        // Guarda la capacidad recibida
        this.capacidad = capacidad;

        // Crea la lista vacía de items
        this.items = new ArrayList<String>();
    }

    // Método para agregar un item al inventario
    public void agregarItem(String item) {
        // Comprueba si todavía hay espacio
        if (items.size() < capacidad) {
            // Agrega el item a la lista
            items.add(item);

            // Muestra un mensaje de confirmación
            System.out.println("Ítem agregado: " + item);
        } else {
            // Muestra el mensaje pedido cuando está lleno
            System.out.println("Inventario lleno.");
        }
    }

    // Método para consultar el inventario
    public String[] consultarInventario() {
        // Crea un arreglo para devolver los items
        String[] listaItems = new String[items.size()];

        // Copia los items al arreglo
        for (int i = 0; i < items.size(); i++) {
            listaItems[i] = items.get(i);
        }

        // Muestra un título para la lista
        System.out.println("Inventario:");

        // Comprueba si no hay items
        if (items.size() == 0) {
            // Muestra un mensaje si está vacío
            System.out.println("El inventario está vacío.");
        } else {
            // Recorre todos los items guardados
            for (int i = 0; i < items.size(); i++) {
                // Muestra cada item por pantalla
                System.out.println("- " + items.get(i));
            }
        }

        // Devuelve el arreglo con los items
        return listaItems;
    }
}
