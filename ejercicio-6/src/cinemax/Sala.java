package cinemax;

public class Sala {
    private int numero;
    private int capacidad;
    private boolean vip;         // true = sala VIP
    private boolean formato3D;

    public Sala(int numero, int capacidad, boolean vip, boolean formato3D) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.vip = vip;
        this.formato3D = formato3D;
    }

    public Sala(int numero, int capacidad) {
        this(numero, capacidad, false, false);
    }

    // GETTERS OBLIGATORIOS
    public int getNumero() {
        return numero;
    }

    public boolean esVIP() {           // ← ESTE MÉTODO FALTABA
        return vip;
    }

    public boolean isFormato3D() {
        return formato3D;
    }

    @Override
    public String toString() {
        String tipo = vip ? "VIP" : "Normal";
        String formato = formato3D ? " (3D)" : "";
        return "Sala " + numero + " - " + tipo + formato;
    }
}