public class Personaje {

    // Atributos del personaje
    private String nombre;
    private int salud;
    private int nivel;
    private int danioBase;

    // Constructor del personaje
    public Personaje(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.danioBase = 10;
    }

    // Método que muestra un ataque básico
    public void atacar() {
        System.out.println(nombre + " ataca y causa " + danioBase + " puntos de daño.");
    }

    // Método que ataca a un objetivo concreto
    public void atacar(Personaje objetivo) {
        if (objetivo != null) {
            int nuevaSalud = objetivo.getSalud() - danioBase;

            if (nuevaSalud < 0) {
                nuevaSalud = 0;
            }

            // Cambia la salud del objetivo
            objetivo.setSalud(nuevaSalud);
            System.out.println(nombre + " ataca a " + objetivo.getNombre() + " y causa " + danioBase + " puntos de daño.");
            System.out.println("Salud restante de " + objetivo.getNombre() + ": " + objetivo.getSalud());
        } else {
            atacar();
        }
    }

    // Los get y set del personaje
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getSalud() {
        return salud;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getDanioBase() {
        return danioBase;
    }
    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }
}
