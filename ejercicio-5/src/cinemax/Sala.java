package cinemax;

public class Sala {
    private int numero;
    private int capacidad;
    private boolean formato3D;

    // Constructor con 3D
    public Sala(int numero, int capacidad, boolean formato3D) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.formato3D = formato3D;
    }

    // Constructor sin 3D (por defecto 2D)
    public Sala(int numero, int capacidad) {
        this(numero, capacidad, false);
    }

    // Getters que usamos
    public int getNumero() {
        return numero;
    }

    public boolean isFormato3D() {
        return formato3D;
    }
}