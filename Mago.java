import java.util.ArrayList;

public class Mago extends Personaje {

    // Atributos del mago
    private int mana;

    private int manaMaximo;

    private int inteligencia;

    private ArrayList<String> hechizosConocidos;

    private Inventario inventario;

    // Constructor del mago
    public Mago(String nombre, int salud, int mana, int inteligencia, int nivel) {
        // Llama al constructor de la clase padre Personaje
        super(nombre, salud, nivel);

        this.mana = mana;

        this.manaMaximo = mana;

        this.inteligencia = inteligencia;

        this.hechizosConocidos = new ArrayList<String>();

        this.inventario = null;
    }

    // Método para asignar un inventario al mago
    public void setInventario(Inventario inventario) {
        // Comprueba si el mago no tiene inventario
        if (this.inventario == null) {
            // Guarda el inventario recibido
            this.inventario = inventario;
        } else {
            System.out.println("Este mago ya tiene un inventario.");
        }
    }

    // Método para obtener el inventario del mago
    public Inventario getInventario() {
        return inventario;
    }

    // Método para agregar un hechizo a la lista
    public void agregarHechizo(String hechizo) {
        // Agrega el hechizo recibido
        hechizosConocidos.add(hechizo);

        System.out.println(getNombre() + " aprende el hechizo: " + hechizo);
    }

    // Método que muestra todos los hechizos conocidos
    public void mostrarHechizosConocidos() {
        System.out.println("Hechizos conocidos:");

        // Recorre la lista de hechizos
        for (int i = 0; i < hechizosConocidos.size(); i++) {
            System.out.println((i + 1) + ". " + hechizosConocidos.get(i));
        }
    }

    // Método que devuelve un hechizo según el número elegido
    public String getHechizoConocido(int numero) {
        int posicion = numero - 1;

        if (posicion >= 0 && posicion < hechizosConocidos.size()) {
            return hechizosConocidos.get(posicion);
        } else {
            return null;
        }
    }

    // Método que recupera maná
    public void recuperarMana() {
        mana = mana + 20;

        if (mana > manaMaximo) {
            mana = manaMaximo;
        }

        System.out.println(getNombre() + " recupera maná. Maná actual: " + mana);
    }

    // Método que lanza un hechizo si el mago lo conoce
    public void lanzarHechizo(String hechizo) {
        // Lanza el hechizo sin objetivo concreto
        lanzarHechizo(hechizo, null);
    }

    // Método que lanza un hechizo contra un objetivo
    public void lanzarHechizo(String hechizo, Personaje objetivo) {
        boolean encontrado = false;

        int costeMana = 15;

        // Recorre la lista de hechizos conocidos
        for (int i = 0; i < hechizosConocidos.size(); i++) {
            // Compara el hechizo sin importar mayúsculas o minúsculas
            if (hechizosConocidos.get(i).equalsIgnoreCase(hechizo)) {
                encontrado = true;
            }
        }

        // Si el hechizo fue encontrado, se lanza
        if (encontrado && mana >= costeMana) {
            mana = mana - costeMana;

            int danio = inteligencia + getNivel();

            System.out.println(getNombre() + " lanza el hechizo: " + hechizo + ".");

            System.out.println("Daño mágico causado: " + danio + ".");

            // Si hay objetivo, se le resta salud
            if (objetivo != null) {
                int nuevaSalud = objetivo.getSalud() - danio;

                if (nuevaSalud < 0) {
                    nuevaSalud = 0;
                }

                objetivo.setSalud(nuevaSalud);

                System.out.println("Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
            }

            System.out.println("Maná restante: " + mana);

        } else if (encontrado && mana < costeMana) {
            System.out.println(getNombre() + " no tiene maná suficiente para lanzar " + hechizo + ".");

        } else {
            System.out.println(getNombre() + " no conoce el hechizo: " + hechizo);
        }
    }

    // Método que invoca un elemento
    public void invocarElemento(String elemento) {
        int costeMana = 20;

        // Comprueba si hay maná suficiente
        if (mana >= costeMana) {
            mana = mana - costeMana;

            System.out.println(getNombre() + " invoca el elemento: " + elemento);

            System.out.println("Maná restante: " + mana);

        } else {
            System.out.println(getNombre() + " no tiene maná suficiente para invocar " + elemento + ".");
        }
    }

    // Método que usa un objeto mágico
    public void usarObjetoMagico(ObjetoMagico objeto) {
        // Comprueba que el objeto exista
        if (objeto != null) {
            if (objeto.getDurabilidad() > 0) {
                // Llama al método usar del objeto mágico
                objeto.usar();

                int potenciaTotal = inteligencia + objeto.getPotencia();

                System.out.println("Potencia mágica total: " + potenciaTotal + ".");
            } else {
                objeto.usar();
            }
        } else {
            System.out.println("No hay objeto mágico para usar.");
        }
    }
}