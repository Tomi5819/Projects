public class Personaje {

    // Atributo que guarda el nombre del personaje
    private String nombre;

    // Atributo que guarda la salud del personaje
    private int salud;

    // Atributo que guarda el nivel del personaje
    private int nivel;

    // Atributo que guarda el daño básico del personaje
    private int danioBase;

    // Constructor que recibe el nombre, la salud y el nivel
    public Personaje(String nombre, int salud, int nivel) {
        // Guarda el nombre recibido
        this.nombre = nombre;

        // Guarda la salud recibida
        this.salud = salud;

        // Guarda el nivel recibido
        this.nivel = nivel;

        // Guarda un daño básico para todos los personajes
        this.danioBase = 10;
    }

    // Método que muestra un ataque básico
    public void atacar() {
        // Muestra el daño del ataque básico
        System.out.println(nombre + " ataca y causa " + danioBase + " puntos de daño.");
    }

    // Método que ataca a un objetivo concreto
    public void atacar(Personaje objetivo) {
        // Comprueba que el objetivo exista
        if (objetivo != null) {
            // Calcula la nueva salud del objetivo
            int nuevaSalud = objetivo.getSalud() - danioBase;

            // Evita que la salud sea negativa
            if (nuevaSalud < 0) {
                nuevaSalud = 0;
            }

            // Cambia la salud del objetivo
            objetivo.setSalud(nuevaSalud);

            // Muestra el resultado del ataque
            System.out.println(nombre + " ataca a " + objetivo.getNombre() + " y causa " + danioBase + " puntos de daño.");

            // Muestra la salud restante del objetivo
            System.out.println("Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
        } else {
            // Usa el ataque básico si no hay objetivo
            atacar();
        }
    }

    // Devuelve el nombre del personaje
    public String getNombre() {
        return nombre;
    }

    // Cambia el nombre del personaje
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve la salud del personaje
    public int getSalud() {
        return salud;
    }

    // Cambia la salud del personaje
    public void setSalud(int salud) {
        this.salud = salud;
    }

    // Devuelve el nivel del personaje
    public int getNivel() {
        return nivel;
    }

    // Cambia el nivel del personaje
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    // Devuelve el daño básico del personaje
    public int getDanioBase() {
        return danioBase;
    }

    // Cambia el daño básico del personaje
    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }
}
