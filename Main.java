import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Método principal del programa
    public static void main(String[] args) {

        // Scanner para leer datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Lista que guarda todos los personajes creados
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();

        // Lista que guarda los objetos mágicos precargados
        ArrayList<ObjetoMagico> objetosMagicos = new ArrayList<ObjetoMagico>();

        // Agrega el primer objeto mágico precargado
        objetosMagicos.add(new ObjetoMagico("Bastón antiguo", "Bastón", 40, 20));

        // Agrega el segundo objeto mágico precargado
        objetosMagicos.add(new ObjetoMagico("Amuleto brillante", "Amuleto", 25, 20));

        // Variable para controlar el menú principal
        boolean salir = false;

        // Bucle del menú principal
        while (!salir) {

            // Muestra el menú principal
            System.out.println();
            System.out.println("===== MENÚ PRINCIPAL =====");
            System.out.println("1. Crear personaje");

            // Esta opción aparece cuando ya existe algún personaje
            if (personajes.size() > 0) {
                System.out.println("2. Seleccionar personaje creado");
                System.out.println("3. Ver personajes creados");
            }

            // Opción para terminar el programa
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            // Lee la opción elegida
            int opcion = scanner.nextInt();

            // Limpia el salto de línea pendiente
            scanner.nextLine();

            // Opción para crear un personaje
            if (opcion == 1) {

                // Muestra los tipos de personaje disponibles
                System.out.println();
                System.out.println("Elige el tipo de personaje:");
                System.out.println("1. Guerrero");
                System.out.println("2. Mago");
                System.out.print("Opción: ");

                // Lee el tipo elegido
                int tipo = scanner.nextInt();

                // Limpia el salto de línea pendiente
                scanner.nextLine();

                // Pide el nombre del personaje
                System.out.print("Nombre: ");
                String nombre = scanner.nextLine();

                // Pide la salud del personaje
                System.out.print("Salud: ");
                int salud = scanner.nextInt();

                // Pide el nivel del personaje
                System.out.print("Nivel: ");
                int nivel = scanner.nextInt();

                // Limpia el salto de línea pendiente
                scanner.nextLine();

                // Si el usuario quiere crear un guerrero
                if (tipo == 1) {

                    // Pide la fuerza del guerrero
                    System.out.print("Fuerza: ");
                    int fuerza = scanner.nextInt();

                    // Pide la defensa del guerrero
                    System.out.print("Defensa: ");
                    int defensa = scanner.nextInt();

                    // Limpia el salto de línea pendiente
                    scanner.nextLine();

                    // Crea el guerrero
                    Guerrero guerrero = new Guerrero(nombre, salud, fuerza, defensa, nivel);

                    // Guarda el guerrero en la lista de personajes
                    personajes.add(guerrero);

                    // Muestra un mensaje de confirmación
                    System.out.println("Guerrero creado correctamente.");

                // Si el usuario quiere crear un mago
                } else if (tipo == 2) {

                    // Pide el maná del mago
                    System.out.print("Maná: ");
                    int mana = scanner.nextInt();

                    // Pide la inteligencia del mago
                    System.out.print("Inteligencia: ");
                    int inteligencia = scanner.nextInt();

                    // Limpia el salto de línea pendiente
                    scanner.nextLine();

                    // Crea el mago
                    Mago mago = new Mago(nombre, salud, mana, inteligencia, nivel);

                    // Crea un inventario individual para este mago
                    Inventario inventario = crearInventarioPrecargado();

                    // Asigna el inventario al mago
                    mago.setInventario(inventario);

                    // Agrega hechizos iniciales al mago
                    mago.agregarHechizo("Bola de fuego");
                    mago.agregarHechizo("Escudo mágico");
                    mago.agregarHechizo("Rayo de hielo");
                    mago.agregarHechizo("Tormenta eléctrica");
                    mago.agregarHechizo("Luz sagrada");

                    // Guarda el mago en la lista de personajes
                    personajes.add(mago);

                    // Muestra un mensaje de confirmación
                    System.out.println("Mago creado correctamente.");

                } else {

                    // Muestra un mensaje si el tipo no existe
                    System.out.println("Tipo de personaje no válido.");
                }

            // Opción para seleccionar un personaje creado
            } else if (opcion == 2 && personajes.size() > 0) {

                // Muestra todos los personajes disponibles
                mostrarPersonajes(personajes);

                // Pide el número de personaje
                System.out.print("Elige un personaje: ");
                int numeroPersonaje = scanner.nextInt();

                // Limpia el salto de línea pendiente
                scanner.nextLine();

                // Calcula la posición real en la lista
                int posicion = numeroPersonaje - 1;

                // Comprueba si la posición es válida
                if (posicion >= 0 && posicion < personajes.size()) {

                    // Obtiene el personaje seleccionado
                    Personaje personajeElegido = personajes.get(posicion);

                    // Abre el menú del personaje seleccionado
                    usarPersonaje(scanner, personajeElegido, personajes, objetosMagicos);

                } else {

                    // Muestra un mensaje si no existe
                    System.out.println("Personaje no válido.");
                }

            // Opción para ver los personajes creados
            } else if (opcion == 3 && personajes.size() > 0) {

                // Muestra todos los personajes
                mostrarPersonajes(personajes);

            // Opción para salir
            } else if (opcion == 0) {

                // Cambia la variable para cerrar el bucle
                salir = true;

                // Muestra un mensaje final
                System.out.println("Programa terminado.");

            } else {

                // Muestra un mensaje si la opción no sirve
                System.out.println("Opción no válida.");
            }
        }

        // Cierra el Scanner
        scanner.close();
    }

    // Método que crea un inventario con objetos ya cargados
    public static Inventario crearInventarioPrecargado() {

        // Crea un inventario con capacidad para 3 items
        Inventario inventario = new Inventario(3);

        // Agrega el primer item
        inventario.agregarItem("Poción de vida");

        // Agrega el segundo item
        inventario.agregarItem("Pergamino");

        // Agrega el tercer item
        inventario.agregarItem("Cristal mágico");

        // Devuelve el inventario creado
        return inventario;
    }

    // Método que muestra todos los personajes creados
    public static void mostrarPersonajes(ArrayList<Personaje> personajes) {

        // Muestra un título
        System.out.println();
        System.out.println("Personajes creados:");

        // Recorre la lista de personajes
        for (int i = 0; i < personajes.size(); i++) {

            // Obtiene un personaje de la lista
            Personaje personaje = personajes.get(i);

            // Variable para guardar el tipo de personaje
            String tipo = "Personaje";

            // Comprueba si el personaje es guerrero
            if (personaje instanceof Guerrero) {
                tipo = "Guerrero";
            }

            // Comprueba si el personaje es mago
            if (personaje instanceof Mago) {
                tipo = "Mago";
            }

            // Muestra el número, tipo, nombre y nivel
            System.out.println((i + 1) + ". " + tipo + " - " + personaje.getNombre() + " - Nivel " + personaje.getNivel() + " - Salud " + personaje.getSalud());
        }
    }

    // Método que abre el menú del personaje seleccionado
    public static void usarPersonaje(Scanner scanner, Personaje personaje, ArrayList<Personaje> personajes, ArrayList<ObjetoMagico> objetosMagicos) {

        // Comprueba si el personaje es guerrero
        if (personaje instanceof Guerrero) {

            // Convierte el personaje a guerrero
            Guerrero guerrero = (Guerrero) personaje;

            // Usa el menú del guerrero
            menuGuerrero(scanner, guerrero, personajes);

        // Comprueba si el personaje es mago
        } else if (personaje instanceof Mago) {

            // Convierte el personaje a mago
            Mago mago = (Mago) personaje;

            // Usa el menú del mago
            menuMago(scanner, mago, personajes, objetosMagicos);
        }
    }

    // Método con las opciones del guerrero
    public static void menuGuerrero(Scanner scanner, Guerrero guerrero, ArrayList<Personaje> personajes) {

        // Variable para volver al menú principal
        boolean volver = false;

        // Bucle del menú del guerrero
        while (!volver) {

            // Muestra el menú del guerrero
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

            // Lee la opción elegida
            int opcion = scanner.nextInt();

            // Limpia el salto de línea pendiente
            scanner.nextLine();

            // Ejecuta la opción elegida
            if (opcion == 1) {
                // Elige un objetivo para el ataque
                Personaje objetivo = elegirObjetivo(scanner, personajes, guerrero);

                // Ataca al objetivo elegido
                guerrero.atacar(objetivo);

            } else if (opcion == 2) {
                // Elige un objetivo para la espada
                Personaje objetivo = elegirObjetivo(scanner, personajes, guerrero);

                // Usa la espada contra el objetivo elegido
                guerrero.usarEspada(objetivo);

            } else if (opcion == 3) {
                guerrero.gritarDesafio();

            } else if (opcion == 4) {
                guerrero.gritarGuerra();

            } else if (opcion == 5) {

                // Comprueba si el guerrero ya tiene mascota
                if (guerrero.getMascota() == null) {

                    // Pide el nombre de la mascota
                    System.out.print("Nombre de la mascota: ");
                    String nombreMascota = scanner.nextLine();

                    // Pide la lealtad de la mascota
                    System.out.print("Lealtad: ");
                    int lealtad = scanner.nextInt();

                    // Limpia el salto de línea pendiente
                    scanner.nextLine();

                    // Crea la mascota
                    Mascota mascota = new Mascota(nombreMascota, lealtad);

                    // Asigna la mascota al guerrero seleccionado
                    guerrero.setMascota(mascota);

                    // Muestra un mensaje de confirmación
                    System.out.println("Mascota asignada correctamente.");

                } else {

                    // Muestra un mensaje si ya tiene mascota
                    System.out.println("Este guerrero ya tiene una mascota.");
                }

            } else if (opcion == 6) {

                // Comprueba si el guerrero tiene mascota
                if (guerrero.getMascota() != null) {

                    // La mascota acompaña al guerrero
                    guerrero.getMascota().acompañar();

                } else {

                    // Muestra un mensaje si no tiene mascota
                    System.out.println("Este guerrero no tiene mascota.");
                }

            } else if (opcion == 0) {

                // Vuelve al menú principal
                volver = true;

            } else {

                // Muestra un mensaje si la opción no existe
                System.out.println("Opción no válida.");
            }
        }
    }

    // Método con las opciones del mago
    public static void menuMago(Scanner scanner, Mago mago, ArrayList<Personaje> personajes, ArrayList<ObjetoMagico> objetosMagicos) {

        // Variable para volver al menú principal
        boolean volver = false;

        // Bucle del menú del mago
        while (!volver) {

            // Muestra el menú del mago
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

            // Lee la opción elegida
            int opcion = scanner.nextInt();

            // Limpia el salto de línea pendiente
            scanner.nextLine();

            // Ejecuta la opción elegida
            if (opcion == 1) {
                // Elige un objetivo para el ataque
                Personaje objetivo = elegirObjetivo(scanner, personajes, mago);

                // Ataca al objetivo elegido
                mago.atacar(objetivo);

            } else if (opcion == 2) {
                mago.recuperarMana();

            } else if (opcion == 3) {

                // Muestra la lista de hechizos conocidos
                mago.mostrarHechizosConocidos();

                // Pide el número del hechizo
                System.out.print("Elige un hechizo: ");
                int numeroHechizo = scanner.nextInt();

                // Limpia el salto de línea pendiente
                scanner.nextLine();

                // Obtiene el hechizo elegido
                String hechizo = mago.getHechizoConocido(numeroHechizo);

                // Comprueba si el hechizo existe
                if (hechizo != null) {
                    // Elige un objetivo para el hechizo
                    Personaje objetivo = elegirObjetivo(scanner, personajes, mago);

                    // Lanza el hechizo contra el objetivo elegido
                    mago.lanzarHechizo(hechizo, objetivo);
                } else {
                    // Muestra un mensaje si el número no existe
                    System.out.println("Hechizo no válido.");
                }

            } else if (opcion == 4) {

                // Pide el elemento que se quiere invocar
                System.out.print("Elemento: ");
                String elemento = scanner.nextLine();

                // Invoca el elemento
                mago.invocarElemento(elemento);

            } else if (opcion == 5) {

                // Elige un objeto mágico precargado
                ObjetoMagico objeto = elegirObjetoMagico(scanner, objetosMagicos);

                // Comprueba si el objeto existe
                if (objeto != null) {
                    // El mago usa el objeto mágico
                    mago.usarObjetoMagico(objeto);
                }

            } else if (opcion == 6) {

                // Elige un objeto mágico precargado
                ObjetoMagico objeto = elegirObjetoMagico(scanner, objetosMagicos);

                // Comprueba si el objeto existe
                if (objeto != null) {
                    // Repara el objeto mágico
                    objeto.reparar();
                }

            } else if (opcion == 7) {

                // Elige un objeto mágico precargado
                ObjetoMagico objeto = elegirObjetoMagico(scanner, objetosMagicos);

                // Comprueba si el objeto existe
                if (objeto != null) {
                    // Muestra la potencia del objeto
                    System.out.println("Potencia del objeto mágico: " + objeto.getPotencia());
                }

            } else if (opcion == 8) {

                // Consulta el inventario individual del mago
                mago.getInventario().consultarInventario();

            } else if (opcion == 0) {

                // Vuelve al menú principal
                volver = true;

            } else {

                // Muestra un mensaje si la opción no existe
                System.out.println("Opción no válida.");
            }
        }
    }

    // Método para elegir un objeto mágico de la lista
    public static ObjetoMagico elegirObjetoMagico(Scanner scanner, ArrayList<ObjetoMagico> objetosMagicos) {

        // Muestra un título
        System.out.println();
        System.out.println("Objetos mágicos:");

        // Recorre los objetos mágicos
        for (int i = 0; i < objetosMagicos.size(); i++) {
            // Muestra cada objeto con un número sencillo
            System.out.println((i + 1) + ". " + objetosMagicos.get(i).getNombre());
        }

        // Pide al usuario que elija uno
        System.out.print("Elige un objeto: ");
        int opcionObjeto = scanner.nextInt();

        // Limpia el salto de línea pendiente
        scanner.nextLine();

        // Calcula la posición real en la lista
        int posicion = opcionObjeto - 1;

        // Comprueba si la posición existe
        if (posicion >= 0 && posicion < objetosMagicos.size()) {
            // Devuelve el objeto elegido
            return objetosMagicos.get(posicion);
        } else {
            // Muestra un mensaje si no existe
            System.out.println("Objeto no válido.");

            // Devuelve null si no se eligió bien
            return null;
        }
    }

    // Método para elegir un objetivo de ataque
    public static Personaje elegirObjetivo(Scanner scanner, ArrayList<Personaje> personajes, Personaje atacante) {

        // Variable para saber si hay objetivos
        int cantidadObjetivos = 0;

        // Muestra un título
        System.out.println();
        System.out.println("Objetivos disponibles:");

        // Recorre todos los personajes
        for (int i = 0; i < personajes.size(); i++) {

            // Obtiene un personaje de la lista
            Personaje personaje = personajes.get(i);

            // Muestra solo personajes distintos al atacante
            if (personaje != atacante) {
                // Muestra el número, nombre y salud
                System.out.println((i + 1) + ". " + personaje.getNombre() + " - Salud " + personaje.getSalud());

                // Suma un objetivo disponible
                cantidadObjetivos++;
            }
        }

        // Si no hay objetivos, devuelve null
        if (cantidadObjetivos == 0) {
            // Muestra un mensaje sencillo
            System.out.println("No hay otros personajes para atacar.");

            // Devuelve null
            return null;
        }

        // Pide el objetivo
        System.out.print("Elige un objetivo: ");
        int numeroObjetivo = scanner.nextInt();

        // Limpia el salto de línea pendiente
        scanner.nextLine();

        // Calcula la posición real
        int posicion = numeroObjetivo - 1;

        // Comprueba si la posición es válida
        if (posicion >= 0 && posicion < personajes.size() && personajes.get(posicion) != atacante) {
            // Devuelve el objetivo elegido
            return personajes.get(posicion);
        } else {
            // Muestra un mensaje si no es válido
            System.out.println("Objetivo no válido.");

            // Devuelve null
            return null;
        }
    }
}
