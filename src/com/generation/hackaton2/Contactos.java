// Paquete donde se define la clase de contactos
package com.generation.hackaton2;

import java.util.Objects;

// Clase que representa un contacto con nombre, apellido y teléfono
public class Contactos {
    // Atributos privados para proteger los datos del contacto
    private String nombre;       // Nombre del contacto
    private String apellido;     // Apellido del contacto
    private String telefono;     // Número de teléfono

    // Constructor para crear un nuevo contacto
    public Contactos(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Métodos getter para obtener información del contacto
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getTelefono() { return telefono; }

    // Métodos setter para modificar información del contacto
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    // Compara contactos basándose en nombre y apellido (sin importar mayúsculas)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contactos contacto = (Contactos) obj;
        // Compara nombres y apellidos ignorando mayúsculas
        return nombre.equalsIgnoreCase(contacto.nombre) &&
                apellido.equalsIgnoreCase(contacto.apellido);
    }

    // Genera un código hash para el contacto basado en nombre y apellido
    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    // Formato de impresión del contacto
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}

