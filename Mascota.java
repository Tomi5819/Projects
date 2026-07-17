public class Mascota {

    // Atributo que guarda el nombre de la mascota
    private String nombre;

    // Atributo que guarda la lealtad de la mascota
    private int lealtad;

    // Constructor que recibe el nombre y la lealtad
    public Mascota(String nombre, int lealtad) {
        // Guarda el nombre recibido
        this.nombre = nombre;

        // Guarda la lealtad recibida
        this.lealtad = lealtad;
    }

    // Método que muestra que la mascota acompaña
    public void acompañar() {
        // Calcula una ventaja sencilla usando la lealtad
        int ventaja = lealtad / 10;

        // Muestra un mensaje sencillo
        System.out.println(nombre + " acompaña a su dueño.");

        // Muestra la ventaja pasiva de la mascota
        System.out.println("Ventaja pasiva por lealtad: +" + ventaja + ".");
    }

    // Devuelve la lealtad de la mascota
    public int getLealtad() {
        return lealtad;
    }

    // Cambia la lealtad de la mascota
    public void setLealtad(int lealtad) {
        this.lealtad = lealtad;
    }
}
