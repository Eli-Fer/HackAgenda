// Paquete para la gestión de la agenda de contactos
package com.generation.hackaton2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Clase que gestiona una colección de contactos con capacidad limitada
public class Agenda {
    private List<com.generation.hackaton2.Contactos> contactos;  // Lista de contactos
    private int maxSize;  // Tamaño máximo de la agenda

    // Constructor con tamaño personalizado de agenda
    public Agenda(int maxSize) {
        this.maxSize = maxSize;
        this.contactos = new ArrayList<>();
    }

    // Constructor por defecto con tamaño de 10 contactos
    public Agenda() {
        this(10);
    }

    // Añade un nuevo contacto con múltiples validaciones
    public boolean añadirContacto(com.generation.hackaton2.Contactos c) {
        // Verifica que el nombre y apellido no estén vacíos
        if (c.getNombre().isEmpty() || c.getApellido().isEmpty()) {
            System.out.println("Error: El nombre y apellido no pueden estar vacíos.");
            return false;
        }
        // Evita contactos duplicados
        if (contactos.contains(c)) {
            System.out.println("Error: El contacto ya existe en la agenda.");
            return false;
        }
        // Verifica que no se exceda el tamaño máximo
        if (contactos.size() >= maxSize) {
            System.out.println("Error: La agenda está llena.");
            return false;
        }
        // Añade el contacto si pasa todas las validaciones
        contactos.add(c);
        System.out.println("Contacto añadido correctamente.");
        return true;
    }

    // Verifica si un contacto ya existe en la agenda
    public boolean existeContacto(com.generation.hackaton2.Contactos c) {
        return contactos.contains(c);
    }

    // Lista todos los contactos ordenados por nombre y apellido
    public void listarContactos() {
        // Ordena los contactos antes de mostrarlos
        contactos.sort(Comparator.comparing(com.generation.hackaton2.Contactos::getNombre)
                .thenComparing(com.generation.hackaton2.Contactos::getApellido));

        // Muestra los contactos o un mensaje si está vacía
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            contactos.forEach(System.out::println);
        }
    }

    // Busca un contacto por nombre y apellido
    public void buscaContacto(String nombre, String apellido) {
        for (com.generation.hackaton2.Contactos c : contactos) {
            // Búsqueda sin considerar mayúsculas
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Elimina un contacto de la agenda
    public void eliminarContacto(com.generation.hackaton2.Contactos c) {
        if (contactos.remove(c)) {
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("Error: El contacto no existe en la agenda.");
        }
    }

    // Modifica el teléfono de un contacto existente
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        for (com.generation.hackaton2.Contactos c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                c.setTelefono(nuevoTelefono);
                System.out.println("Teléfono actualizado correctamente.");
                return;
            }
        }
        System.out.println("Error: Contacto no encontrado.");
    }

    // Comprueba si la agenda ha alcanzado su capacidad máxima
    public boolean agendaLlena() {
        return contactos.size() >= maxSize;
    }

    // Calcula los espacios libres en la agenda
    public int espacioLibres() {
        return maxSize - contactos.size();
    }
}
