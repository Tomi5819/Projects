public class Mascota {
    // Atributos de la mascota
    private String nombre;
    private int lealtad;

    // Constructor de la mascota
    public Mascota(String nombre, int lealtad) {
        this.nombre = nombre;
        this.lealtad = lealtad;
    }

    // Método que muestra que la mascota acompaña
    public void acompañar() {
        int ventaja = lealtad / 10;
        System.out.println(nombre + " acompaña a su dueño.");
        System.out.println("Ventaja pasiva por lealtad: +" + ventaja + ".");
    }
    public int getLealtad() {
        return lealtad;
    }
    public void setLealtad(int lealtad) {
        this.lealtad = lealtad;
    }
}
