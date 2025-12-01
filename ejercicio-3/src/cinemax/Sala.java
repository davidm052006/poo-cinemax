package cinemax;

public class Sala {
    private int numero;
    private int capacidad;
    private boolean formato3D;

    // Constructor completo
    public Sala(int numero, int capacidad, boolean formato3D) {
        setNumero(numero);
        setCapacidad(capacidad);
        setFormato3D(formato3D);
    }

    // Constructor sin 3D
    public Sala(int numero, int capacidad) {
        this(numero, capacidad, false);
    }

    // Getters
    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
    public boolean isFormato3D() { return formato3D; }

    // Setters con validación
    public void setNumero(int numero) {
        if (numero <= 0 || numero > 50)
            throw new IllegalArgumentException("Número de sala inválido (1-50)");
        this.numero = numero;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0 || capacidad > 500)
            throw new IllegalArgumentException("Capacidad debe estar entre 1 y 500");
        this.capacidad = capacidad;
    }

    public void setFormato3D(boolean formato3D) {
        this.formato3D = formato3D;
    }

    @Override
    public String toString() {
        return "Sala " + numero + " (" + capacidad + " puestos" + (formato3D ? " - 3D" : "") + ")";
    }
}