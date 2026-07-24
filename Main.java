import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Crea la lista de personajes
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();

        //Crea la lista de objetos mágicos
        ArrayList<ObjetoMagico> objetosMagicos = new ArrayList<ObjetoMagico>();

        objetosMagicos.add(new ObjetoMagico("Bastón antiguo", "Bastón", 40, 20));

        objetosMagicos.add(new ObjetoMagico("Amuleto brillante", "Amuleto", 25, 20));

        boolean salir = false;

        //Bucle del menú principal
        while (!salir) {

            System.out.println();
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Crear personaje");

            // Opción para cuando ya existe algún personaje
            if (personajes.size() > 0) {
                System.out.println("2. Seleccionar personaje creado");
                System.out.println("3. Ver personajes creados");
            }

            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearPersonaje(scanner, personajes);
                    break;

                case 2:
                    if (personajes.size() > 0) {
                        mostrarPersonajes(personajes);

                        System.out.print("Elige un personaje: ");
                        int numeroPersonaje = scanner.nextInt();

                        scanner.nextLine();

                        // Calcula la posición real del personaje, comprueba que existe y abre su menú
                        int posicion = numeroPersonaje - 1;

                        if (posicion >= 0 && posicion < personajes.size()) {
                            Personaje personajeElegido = personajes.get(posicion);

                            usarPersonaje(scanner, personajeElegido, personajes, objetosMagicos);
                        } else {
                            System.out.println("Personaje no válido.");
                        }
                    } else {
                        System.out.println("Primero debes crear un personaje.");
                    }
                    break;

                case 3:
                    // Comprueba si ya existen personajes y los muestra
                    if (personajes.size() > 0) {
                        mostrarPersonajes(personajes);
                    } else {

                        System.out.println("Primero debes crear un personaje.");
                    }
                    break;

                case 0:
                    salir = true;

                    System.out.println("Programa terminado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }

    // Método que crea un personaje según el tipo elegido
    public static void crearPersonaje(Scanner scanner, ArrayList<Personaje> personajes) {

        System.out.println();
        System.out.println("Elige el tipo de personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.print("Opción: ");

        int tipo = scanner.nextInt();

        scanner.nextLine();

        // Pide los atributos del personaje
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Salud: ");
        int salud = scanner.nextInt();

        System.out.print("Nivel: ");
        int nivel = scanner.nextInt();

        scanner.nextLine();

        switch (tipo) {
            case 1:
                // Pide los atributos del guerrero
                System.out.print("Fuerza: ");
                int fuerza = scanner.nextInt();

                System.out.print("Defensa: ");
                int defensa = scanner.nextInt();

                scanner.nextLine();

                // Crea el guerrero y lo guarda en la lista de personajes
                Guerrero guerrero = new Guerrero(nombre, salud, fuerza, defensa, nivel);

                personajes.add(guerrero);

                System.out.println("Guerrero creado correctamente.");
                break;

            case 2:
                // Pide los atributos del mago
                System.out.print("Maná: ");
                int mana = scanner.nextInt();

                System.out.print("Inteligencia: ");
                int inteligencia = scanner.nextInt();

                scanner.nextLine();

                // Crea el mago, le asigna inventario y hechizos y lo guarda en a lista de personajes
                Mago mago = new Mago(nombre, salud, mana, inteligencia, nivel);

                Inventario inventario = crearInventarioPrecargado();

                mago.setInventario(inventario);

                mago.agregarHechizo("Bola de fuego");
                mago.agregarHechizo("Escudo mágico");
                mago.agregarHechizo("Rayo de hielo");
                mago.agregarHechizo("Tormenta eléctrica");
                mago.agregarHechizo("Luz sagrada");

                personajes.add(mago);

                System.out.println("Mago creado correctamente.");
                break;

            default:
                System.out.println("Tipo de personaje no válido.");
                break;
        }
    }

    // Método que crea un inventario con objetos ya cargados
    public static Inventario crearInventarioPrecargado() {

        Inventario inventario = new Inventario(3);

        // Agrega los 3 items
        inventario.agregarItem("Poción de vida");

        inventario.agregarItem("Pergamino");

        inventario.agregarItem("Cristal mágico");

        return inventario;
    }

    // Método que muestra todos los personajes creados
    public static void mostrarPersonajes(ArrayList<Personaje> personajes) {

        System.out.println();
        System.out.println("Personajes creados:");

        // Recorre la lista de personajes
        for (int i = 0; i < personajes.size(); i++) {

            Personaje personaje = personajes.get(i);

            // Variable para guardar el tipo de personaje
            String tipo = "Personaje";

            // Comprueba si el personaje es guerrero o mago
            if (personaje instanceof Guerrero) {
                tipo = "Guerrero";
            }

            if (personaje instanceof Mago) {
                tipo = "Mago";
            }

            // Muestra sus atributos
            System.out.println((i + 1) + ". " + tipo + " - " + personaje.getNombre() + " - Nivel " + personaje.getNivel() + " - Salud " + personaje.getSalud());
        }
    }

    // Método que abre el menú del personaje seleccionado
    public static void usarPersonaje(Scanner scanner, Personaje personaje, ArrayList<Personaje> personajes, ArrayList<ObjetoMagico> objetosMagicos) {

        // Comprueba el tipo de personaje para usar el menú correcto
        if (personaje instanceof Guerrero) {

            Guerrero guerrero = (Guerrero) personaje;

            menuGuerrero(scanner, guerrero, personajes);

        } else if (personaje instanceof Mago) {

            Mago mago = (Mago) personaje;

            menuMago(scanner, mago, personajes, objetosMagicos);
        }
    }

    // Método con las opciones del guerrero
    public static void menuGuerrero(Scanner scanner, Guerrero guerrero, ArrayList<Personaje> personajes) {

        boolean volver = false;

        while (!volver) {

            System.out.println();
            System.out.println("===== GUERRERO: " + guerrero.getNombre() + " =====");
            System.out.println("1. Atacar");
            System.out.println("2. Usar espada");
            System.out.println("3. Gritar desafío");
            System.out.println("4. Gritar guerra");
            System.out.println("5. Crear mascota");
            System.out.println("6. Hacer que la mascota acompañe");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Personaje objetivoAtaque = elegirObjetivo(scanner, personajes, guerrero);

                    guerrero.atacar(objetivoAtaque);
                    break;

                case 2:
                    Personaje objetivoEspada = elegirObjetivo(scanner, personajes, guerrero);

                    guerrero.usarEspada(objetivoEspada);
                    break;

                case 3:
                    guerrero.gritarDesafio();
                    break;

                case 4:
                    guerrero.gritarGuerra();
                    break;

                case 5:
                    // Comprueba si el guerrero no tiene mascota para crearla
                    if (guerrero.getMascota() == null) {
                        // Pide los atributos de la mascota
                        System.out.print("Nombre de la mascota: ");
                        String nombreMascota = scanner.nextLine();

                        System.out.print("Lealtad: ");
                        int lealtad = scanner.nextInt();

                        scanner.nextLine();

                        // Crea la mascota y se la asigna al guerrero
                        Mascota mascota = new Mascota(nombreMascota, lealtad);

                        guerrero.setMascota(mascota);

                        System.out.println("Mascota asignada correctamente.");
                    } else {
                        System.out.println("Este guerrero ya tiene una mascota.");
                    }
                    break;

                case 6:
                    // Comprueba si el guerrero tiene mascota para que lo acompañe
                    if (guerrero.getMascota() != null) {
                        guerrero.getMascota().acompañar();
                    } else {
                        System.out.println("Este guerrero no tiene mascota.");
                    }
                    break;

                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Método con las opciones del mago
    public static void menuMago(Scanner scanner, Mago mago, ArrayList<Personaje> personajes, ArrayList<ObjetoMagico> objetosMagicos) {

        boolean volver = false;

        while (!volver) {

            System.out.println();
            System.out.println("===== MAGO: " + mago.getNombre() + " =====");
            System.out.println("1. Atacar");
            System.out.println("2. Recuperar maná (+20)");
            System.out.println("3. Lanzar hechizo (-15)");
            System.out.println("4. Invocar elemento (-20)");
            System.out.println("5. Usar objeto mágico");
            System.out.println("6. Reparar objeto mágico");
            System.out.println("7. Ver potencia del objeto mágico");
            System.out.println("8. Consultar inventario");
            System.out.println("0. Volver");
            System.out.print("Elige una opción: ");


            int opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Personaje objetivoAtaque = elegirObjetivo(scanner, personajes, mago);

                    mago.atacar(objetivoAtaque);
                    break;

                case 2:
                    mago.recuperarMana();
                    break;

                case 3:
                    // Muestra los hechizos conocidos y pide uno
                    mago.mostrarHechizosConocidos();

                    System.out.print("Elige un hechizo: ");
                    int numeroHechizo = scanner.nextInt();

                    scanner.nextLine();

                    String hechizo = mago.getHechizoConocido(numeroHechizo);

                    // Comprueba si el hechizo existe y pide un objetivo
                    if (hechizo != null) {
                        Personaje objetivoHechizo = elegirObjetivo(scanner, personajes, mago);

                        mago.lanzarHechizo(hechizo, objetivoHechizo);
                    } else {
                        System.out.println("Hechizo no válido.");
                    }
                    break;

                case 4:
                    System.out.print("Elemento: ");
                    String elemento = scanner.nextLine();

                    mago.invocarElemento(elemento);
                    break;

                case 5:
                    // Elige un objeto mágico para usarlo
                    ObjetoMagico objetoUsar = elegirObjetoMagico(scanner, objetosMagicos);

                    if (objetoUsar != null) {
                        mago.usarObjetoMagico(objetoUsar);
                    }
                    break;

                case 6:
                    // Elige un objeto mágico para repararlo
                    ObjetoMagico objetoReparar = elegirObjetoMagico(scanner, objetosMagicos);

                    if (objetoReparar != null) {
                        objetoReparar.reparar();
                    }
                    break;

                case 7:
                    // Elige un objeto mágico para ver su potencia
                    ObjetoMagico objetoPotencia = elegirObjetoMagico(scanner, objetosMagicos);

                    if (objetoPotencia != null) {
                        System.out.println("Potencia del objeto mágico: " + objetoPotencia.getPotencia());
                    }
                    break;

                case 8:
                    // Muestra el inventario del mago
                    mago.getInventario().consultarInventario();
                    break;

                case 0:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Método para elegir un objeto mágico de la lista
    public static ObjetoMagico elegirObjetoMagico(Scanner scanner, ArrayList<ObjetoMagico> objetosMagicos) {

        System.out.println();
        System.out.println("Objetos mágicos:");

        // Recorre los objetos mágicos y pide uno
        for (int i = 0; i < objetosMagicos.size(); i++) {
            System.out.println((i + 1) + ". " + objetosMagicos.get(i).getNombre());
        }

        System.out.print("Elige un objeto: ");
        int opcionObjeto = scanner.nextInt();

        scanner.nextLine();

        int posicion = opcionObjeto - 1;

        // Comprueba si la posición existe
        if (posicion >= 0 && posicion < objetosMagicos.size()) {
            return objetosMagicos.get(posicion);
        } else {
            System.out.println("Objeto no válido.");

            return null;
        }
    }

    // Método para elegir un objetivo de ataque
    public static Personaje elegirObjetivo(Scanner scanner, ArrayList<Personaje> personajes, Personaje atacante) {

        int cantidadObjetivos = 0;

        System.out.println();
        System.out.println("Objetivos disponibles:");

        // Recorre todos los personajes para calcular los objetivos
        for (int i = 0; i < personajes.size(); i++) {

            Personaje personaje = personajes.get(i);

            // Muestra solo personajes distintos al atacante con sus atributos
            if (personaje != atacante) {
                System.out.println((i + 1) + ". " + personaje.getNombre() + " - Salud " + personaje.getSalud());

                cantidadObjetivos++;
            }
        }

        if (cantidadObjetivos == 0) {
            System.out.println("No hay otros personajes para atacar.");

            return null;
        }

        // Pide el objetivo
        System.out.print("Elige un objetivo: ");
        int numeroObjetivo = scanner.nextInt();

        scanner.nextLine();

        int posicion = numeroObjetivo - 1;

        // Comprueba si la posición es válida
        if (posicion >= 0 && posicion < personajes.size() && personajes.get(posicion) != atacante) {
            return personajes.get(posicion);
        } else {
            System.out.println("Objetivo no válido.");

            return null;
        }
    }
}