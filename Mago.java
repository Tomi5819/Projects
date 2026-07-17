import java.util.ArrayList;

public class Mago extends Personaje {

    // Atributo que guarda el maná del mago
    private int mana;

    // Atributo que guarda el maná máximo del mago
    private int manaMaximo;

    // Atributo que guarda la inteligencia del mago
    private int inteligencia;

    // Lista que guarda los hechizos conocidos
    private ArrayList<String> hechizosConocidos;

    // Atributo que guarda el inventario del mago
    private Inventario inventario;

    // Constructor del mago
    public Mago(String nombre, int salud, int mana, int inteligencia, int nivel) {
        // Llama al constructor de la clase padre Personaje
        super(nombre, salud, nivel);

        // Guarda el maná recibido
        this.mana = mana;

        // Guarda el maná máximo inicial
        this.manaMaximo = mana;

        // Guarda la inteligencia recibida
        this.inteligencia = inteligencia;

        // Crea la lista vacía de hechizos
        this.hechizosConocidos = new ArrayList<String>();

        // Al principio el mago no tiene inventario
        this.inventario = null;
    }

    // Método para asignar un inventario al mago
    public void setInventario(Inventario inventario) {
        // Comprueba si el mago no tiene inventario
        if (this.inventario == null) {
            // Guarda el inventario recibido
            this.inventario = inventario;
        } else {
            // Muestra un mensaje si ya tiene inventario
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

        // Muestra un mensaje de confirmación
        System.out.println(getNombre() + " aprende el hechizo: " + hechizo);
    }

    // Método que muestra todos los hechizos conocidos
    public void mostrarHechizosConocidos() {
        // Muestra un título para la lista
        System.out.println("Hechizos conocidos:");

        // Recorre la lista de hechizos
        for (int i = 0; i < hechizosConocidos.size(); i++) {
            // Muestra cada hechizo con su número
            System.out.println((i + 1) + ". " + hechizosConocidos.get(i));
        }
    }

    // Método que devuelve un hechizo según el número elegido
    public String getHechizoConocido(int numero) {
        // Calcula la posición real en la lista
        int posicion = numero - 1;

        // Comprueba si la posición existe
        if (posicion >= 0 && posicion < hechizosConocidos.size()) {
            // Devuelve el hechizo elegido
            return hechizosConocidos.get(posicion);
        } else {
            // Devuelve null si el número no es válido
            return null;
        }
    }

    // Método que recupera maná
    public void recuperarMana() {
        // Suma 20 puntos de maná
        mana = mana + 20;

        // Evita que el maná pase del máximo
        if (mana > manaMaximo) {
            mana = manaMaximo;
        }

        // Muestra el maná actual
        System.out.println(getNombre() + " recupera maná. Maná actual: " + mana);
    }

    // Método que lanza un hechizo si el mago lo conoce
    public void lanzarHechizo(String hechizo) {
        // Lanza el hechizo sin objetivo concreto
        lanzarHechizo(hechizo, null);
    }

    // Método que lanza un hechizo contra un objetivo
    public void lanzarHechizo(String hechizo, Personaje objetivo) {
        // Variable para saber si el hechizo existe
        boolean encontrado = false;

        // Coste sencillo de maná para lanzar hechizos
        int costeMana = 15;

        // Recorre la lista de hechizos conocidos
        for (int i = 0; i < hechizosConocidos.size(); i++) {
            // Compara el hechizo sin importar mayúsculas o minúsculas
            if (hechizosConocidos.get(i).equalsIgnoreCase(hechizo)) {
                // Marca que el hechizo fue encontrado
                encontrado = true;
            }
        }

        // Si el hechizo fue encontrado, se lanza
        if (encontrado && mana >= costeMana) {
            // Resta el coste de maná
            mana = mana - costeMana;

            // Calcula un daño mágico sencillo
            int danio = inteligencia + getNivel();

            // Muestra un mensaje de lanzamiento
            System.out.println(getNombre() + " lanza el hechizo: " + hechizo + ".");

            // Muestra el daño mágico
            System.out.println("Daño mágico causado: " + danio + ".");

            // Si hay objetivo, se le resta salud
            if (objetivo != null) {
                // Calcula la nueva salud del objetivo
                int nuevaSalud = objetivo.getSalud() - danio;

                // Evita que la salud sea negativa
                if (nuevaSalud < 0) {
                    nuevaSalud = 0;
                }

                // Cambia la salud del objetivo
                objetivo.setSalud(nuevaSalud);

                // Muestra la salud restante
                System.out.println("Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
            }

            // Muestra el maná restante
            System.out.println("Maná restante: " + mana);

        } else if (encontrado && mana < costeMana) {
            // Muestra un mensaje si no tiene maná suficiente
            System.out.println(getNombre() + " no tiene maná suficiente para lanzar " + hechizo + ".");

        } else {
            // Muestra un mensaje si no conoce el hechizo
            System.out.println(getNombre() + " no conoce el hechizo: " + hechizo);
        }
    }

    // Método que invoca un elemento
    public void invocarElemento(String elemento) {
        // Coste sencillo de maná para invocar elementos
        int costeMana = 20;

        // Comprueba si hay maná suficiente
        if (mana >= costeMana) {
            // Resta el coste de maná
            mana = mana - costeMana;

            // Muestra un mensaje sencillo de invocación
            System.out.println(getNombre() + " invoca el elemento: " + elemento);

            // Muestra el maná restante
            System.out.println("Maná restante: " + mana);

        } else {
            // Muestra un mensaje si no hay maná
            System.out.println(getNombre() + " no tiene maná suficiente para invocar " + elemento + ".");
        }
    }

    // Método que usa un objeto mágico
    public void usarObjetoMagico(ObjetoMagico objeto) {
        // Comprueba que el objeto exista
        if (objeto != null) {
            // Comprueba si el objeto tiene durabilidad
            if (objeto.getDurabilidad() > 0) {
                // Llama al método usar del objeto mágico
                objeto.usar();

                // Calcula una potencia sencilla usando el objeto
                int potenciaTotal = inteligencia + objeto.getPotencia();

                // Muestra la potencia total
                System.out.println("Potencia mágica total: " + potenciaTotal + ".");
            } else {
                // Muestra el mensaje del objeto si no se puede usar
                objeto.usar();
            }
        } else {
            // Muestra un mensaje si no hay objeto
            System.out.println("No hay objeto mágico para usar.");
        }
    }
}
