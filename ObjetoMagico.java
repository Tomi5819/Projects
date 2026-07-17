public class ObjetoMagico {

    // Atributo que guarda el nombre del objeto
    private String nombre;

    // Atributo que guarda el tipo del objeto
    private String tipo;

    // Atributo que guarda la potencia del objeto
    private int potencia;

    // Atributo que guarda la durabilidad del objeto
    private int durabilidad;

    // Atributo que guarda la durabilidad máxima del objeto
    private int durabilidadMaxima;

    // Constructor del objeto mágico
    public ObjetoMagico(String nombre, String tipo, int potencia, int durabilidad) {
        // Guarda el nombre recibido
        this.nombre = nombre;

        // Guarda el tipo recibido
        this.tipo = tipo;

        // Guarda la potencia recibida
        this.potencia = potencia;

        // Guarda la durabilidad recibida
        this.durabilidad = durabilidad;

        // Guarda la durabilidad máxima original
        this.durabilidadMaxima = durabilidad;
    }

    // Método para usar el objeto mágico
    public void usar() {
        // Comprueba si el objeto tiene durabilidad
        if (durabilidad > 0) {
            // Muestra un mensaje de uso
            System.out.println("Se usa " + nombre + " de tipo " + tipo + ".");

            // Reduce la durabilidad del objeto en 1
            durabilidad--;

            // Muestra la durabilidad actual
            System.out.println("Durabilidad actual: " + durabilidad);
        } else {
            // Muestra un mensaje si no se puede usar
            System.out.println(nombre + " no tiene durabilidad.");
        }
    }

    // Método para reparar el objeto mágico
    public void reparar() {
        // Deja la durabilidad nuevamente en su valor máximo
        durabilidad = durabilidadMaxima;

        // Muestra un mensaje de reparación
        System.out.println(nombre + " ha sido reparado.");
    }

    // Devuelve la potencia del objeto
    public int getPotencia() {
        return potencia;
    }

    // Devuelve el nombre del objeto
    public String getNombre() {
        return nombre;
    }

    // Devuelve la durabilidad del objeto
    public int getDurabilidad() {
        return durabilidad;
    }
}
