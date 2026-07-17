public class Guerrero extends Personaje {

    // Atributo que guarda la fuerza del guerrero
    private int fuerza;

    // Atributo que guarda la defensa del guerrero
    private int defensa;

    // Atributo que guarda la fuerza original del guerrero
    private int fuerzaBase;

    // Atributo que guarda la defensa original del guerrero
    private int defensaBase;

    // Atributo que guarda la mascota del guerrero
    private Mascota mascota;

    // Constructor del guerrero
    public Guerrero(String nombre, int salud, int fuerza, int defensa, int nivel) {
        // Llama al constructor de la clase padre Personaje
        super(nombre, salud, nivel);

        // Guarda la fuerza recibida
        this.fuerza = fuerza;

        // Guarda la defensa recibida
        this.defensa = defensa;

        // Guarda la fuerza original
        this.fuerzaBase = fuerza;

        // Guarda la defensa original
        this.defensaBase = defensa;

        // Al principio el guerrero no tiene mascota
        this.mascota = null;
    }

    // Método para asignar una mascota al guerrero
    public void setMascota(Mascota mascota) {
        // Comprueba si el guerrero no tiene mascota
        if (this.mascota == null) {
            // Guarda la mascota recibida
            this.mascota = mascota;
        } else {
            // Muestra un mensaje si ya tiene mascota
            System.out.println("Este guerrero ya tiene una mascota.");
        }
    }

    // Método para obtener la mascota del guerrero
    public Mascota getMascota() {
        return mascota;
    }

    // Método que simula el uso de una espada
    public void usarEspada() {
        // Calcula el daño usando la fuerza y el nivel
        int danio = fuerza + getNivel();

        // Muestra el daño realizado con la espada
        System.out.println(getNombre() + " usa su espada y causa " + danio + " puntos de daño.");
    }

    // Método que usa la espada contra un objetivo
    public void usarEspada(Personaje objetivo) {
        // Calcula el daño usando la fuerza y el nivel
        int danio = fuerza + getNivel();

        // Comprueba que el objetivo exista
        if (objetivo != null) {
            // Calcula la nueva salud del objetivo
            int nuevaSalud = objetivo.getSalud() - danio;

            // Evita que la salud sea negativa
            if (nuevaSalud < 0) {
                nuevaSalud = 0;
            }

            // Cambia la salud del objetivo
            objetivo.setSalud(nuevaSalud);

            // Muestra el resultado del ataque
            System.out.println(getNombre() + " usa su espada contra " + objetivo.getNombre() + " y causa " + danio + " puntos de daño.");

            // Muestra la salud restante del objetivo
            System.out.println("Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
        } else {
            // Usa la espada sin objetivo
            usarEspada();
        }
    }

    // Método que simula un desafío
    public void gritarDesafio() {
        // Aumenta la defensa de forma sencilla
        defensa = defensaBase + 10;

        // Muestra un mensaje de desafío
        System.out.println(getNombre() + " grita un desafío al enemigo.");

        // Muestra la defensa actual
        System.out.println("Defensa aumentada temporalmente a " + defensa + ".");
    }

    // Método que simula un grito de guerra
    public void gritarGuerra() {
        // Aumenta la fuerza de forma sencilla
        fuerza = fuerzaBase + 10;

        // Muestra un mensaje de guerra
        System.out.println(getNombre() + " grita: ¡Por la victoria!");

        // Muestra la fuerza actual
        System.out.println("Fuerza aumentada temporalmente a " + fuerza + ".");
    }
}
