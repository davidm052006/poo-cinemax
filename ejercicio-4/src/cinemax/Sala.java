package cinemax;

public class Sala {
    private int numero;
    private int capacidad;
    private boolean formato3D;

    public Sala(int numero, int capacidad, boolean formato3D) {
        setNumero(numero);
        setCapacidad(capacidad);
        this.formato3D = formato3D;
    }

    public Sala(int numero, int capacidad) {
        this(numero, capacidad, false);
    }

    // Getters
    public int getNumero() { return numero; }
    public boolean isFormato3D() { return formato3D; }

    // Setters con validación
    public void setNumero(int numero) {
        if (numero <= 0 || numero > 50)
            throw new IllegalArgumentException("Número de sala inválido");
        this.numero = numero;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0 || capacidad > 500)
            throw new IllegalArgumentException("Capacidad inválida");
        this.capacidad = capacidad;
    }
}