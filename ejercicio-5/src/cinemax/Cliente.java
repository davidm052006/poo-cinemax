package cinemax;

public class Cliente {
    private String nombre;
    private int edad;

    // Constructor rápido que usamos en semana 5
    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.edad = 18; // por defecto
    }

    // Getters obligatorios
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}