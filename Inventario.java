import java.util.ArrayList;

public class Inventario {

    private int capacidad;
    private ArrayList<String> items;

    // Constructor que recibe la capacidad
    public Inventario(int capacidad) {
        this.capacidad = capacidad;
        this.items = new ArrayList<String>();
    }

    // Método para agregar un item al inventario
    public void agregarItem(String item) {
        // Comprueba si todavía hay espacio
        if (items.size() < capacidad) {
            items.add(item);
            System.out.println("Ítem agregado: " + item);
        } else {
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
        System.out.println("Inventario:");
        
        if (items.size() == 0) {
            System.out.println("El inventario está vacío.");
        } else {
            for (int i = 0; i < items.size(); i++) {
                // Muestra cada item por pantalla
                System.out.println("- " + items.get(i));
            }
        }

        // Devuelve el arreglo con los items
        return listaItems;
    }
}
