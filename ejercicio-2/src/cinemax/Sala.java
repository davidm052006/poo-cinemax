package cinemax;


public class Sala {
    private int numero;
    private int capacidad;
    private boolean formato3D;

    public Sala(int numero, int capacidad, boolean formato3D) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.formato3D = formato3D;
    }

    // Getters y setters
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public boolean isFormato3D() { return formato3D; }
    public void setFormato3D(boolean formato3D) { this.formato3D = formato3D; }

    @Override
    public String toString() {
        return "Sala " + numero + " (" + capacidad + " puestos" + (formato3D ? " - 3D" : "") + ")";
    }
}