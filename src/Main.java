// Clase principal para ejecutar la Agenda Telefónica
import com.generation.hackaton2.Agenda;
import com.generation.hackaton2.Contactos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un Scanner para capturar la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        // Crear una nueva instancia de la agenda
        Agenda agenda = new Agenda();
        int opcion = 0;

        // Bucle principal para mostrar el menú al usuario
        do {
            System.out.println("\n--- Menú de Agenda Telefónica ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Ver si la agenda está llena");
            System.out.println("7. Ver espacios libres");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que la entrada sea un número
            if (!scanner.hasNextInt()) {
                System.out.println("❌ Error: Solo se aceptan números. Intente de nuevo.");
                scanner.next(); // Descarta la entrada incorrecta
                continue;       // Vuelve al inicio del bucle
            }

            // Capturar la opción del usuario
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            // Ejecutar la acción correspondiente a la opción seleccionada
            switch (opcion) {
                case 1:
                    // Capturar datos del nuevo contacto
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String telefono = scanner.nextLine();
                    agenda.añadirContacto(new Contactos(nombre, apellido, telefono)); // Añadir contacto a la agenda
                    break;
                case 2:
                    // Listar todos los contactos de la agenda
                    agenda.listarContactos();
                    break;
                case 3:
                    // Buscar un contacto por nombre y apellido
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellido = scanner.nextLine();
                    agenda.buscaContacto(nombre, apellido);
                    break;
                case 4:
                    // Eliminar un contacto por nombre y apellido
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(new Contactos(nombre, apellido, ""));
                    break;
                case 5:
                    // Modificar el teléfono de un contacto existente
                    System.out.print("Ingrese nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese nuevo teléfono: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case 6:
                    // Comprobar si la agenda está llena
                    System.out.println(agenda.agendaLlena() ? "La agenda está llena." : "Aún hay espacio en la agenda.");
                    break;
                case 7:
                    // Mostrar cuántos espacios libres quedan en la agenda
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
                    break;
                case 8:
                    // Salir del programa
                    System.out.println("Saliendo...");
                    break;
                default:
                    // Mensaje para opciones inválidas
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 8); // Finalizar cuando el usuario seleccione 8

        scanner.close(); // Cerrar el Scanner para liberar recursos
    }
}
