public class Guerrero extends Personaje {

    // Atributos del guerrero
    private int fuerza;
    private int defensa;
    private int fuerzaBase;
    private int defensaBase;
    private Mascota mascota;

    // Constructor del guerrero
    public Guerrero(String nombre, int salud, int fuerza, int defensa, int nivel) {
        super(nombre, salud, nivel);

        this.fuerza = fuerza;
        this.defensa = defensa;
        this.fuerzaBase = fuerza;
        this.defensaBase = defensa;
        this.mascota = null;
    }

    // Método para asignar una mascota al guerrero
    public void setMascota(Mascota mascota) {
        if (this.mascota == null) {
            this.mascota = mascota;
        } else {
            System.out.println("Este guerrero ya tiene una mascota.");
        }
    }

    // Método para obtener la mascota del guerrero
    public Mascota getMascota() {
        return mascota;
    }

    // Método que simula el uso de una espada
    public void usarEspada() {
        int danio = fuerza + getNivel();
        System.out.println(getNombre() + " usa su espada y causa " + danio + " puntos de daño.");
    }

    // Método que usa la espada contra un objetivo
    public void usarEspada(Personaje objetivo) {
        int danio = fuerza + getNivel();

        if (objetivo != null) {
            int nuevaSalud = objetivo.getSalud() - danio;

            if (nuevaSalud < 0) {
                nuevaSalud = 0;
            }

            objetivo.setSalud(nuevaSalud);
            System.out.println(getNombre() + " usa su espada contra " + objetivo.getNombre() + " y causa " + danio + " puntos de daño.");
            System.out.println("Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
        } else {
            usarEspada();
        }
    }

    // Método que simula un desafío
    public void gritarDesafio() {
        defensa = defensaBase + 10;
        System.out.println(getNombre() + " grita un desafío al enemigo.");
        System.out.println("Defensa aumentada temporalmente a " + defensa + ".");
    }

    // Método que simula un grito de guerra
    public void gritarGuerra() {
        fuerza = fuerzaBase + 10;
        System.out.println(getNombre() + " grita: ¡Por la victoria!");
        System.out.println("Fuerza aumentada temporalmente a " + fuerza + ".");
    }
}