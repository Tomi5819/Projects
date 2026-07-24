public class ObjetoMagico {

    // Atributos del objeto mágico
    private String nombre;
    private String tipo;
    private int potencia;
    private int durabilidad;
    private int durabilidadMaxima;

    // Constructor del objeto mágico
    public ObjetoMagico(String nombre, String tipo, int potencia, int durabilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.potencia = potencia;
        this.durabilidad = durabilidad;
        this.durabilidadMaxima = durabilidad;
    }

    // Método para usar el objeto mágico
    public void usar() {
        if (durabilidad > 0) {
            System.out.println("Se usa " + nombre + " de tipo " + tipo + ".");
            durabilidad--;
            System.out.println("Durabilidad actual: " + durabilidad);
        } else {
            System.out.println(nombre + " no tiene durabilidad.");
        }
    }

    // Método para reparar el objeto mágico
    public void reparar() {
        durabilidad = durabilidadMaxima;
        System.out.println(nombre + " ha sido reparado.");
    }
    public int getPotencia() {
        return potencia;
    }
    public String getNombre() {
        return nombre;
    }
    public int getDurabilidad() {
        return durabilidad;
    }
}
