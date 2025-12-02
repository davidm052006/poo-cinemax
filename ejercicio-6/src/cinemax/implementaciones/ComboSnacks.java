package cinemax.implementaciones;

import cinemax.interfaces.Descuentable;

/**
 * Clase que representa combos de snacks del cine.
 * Implementa solo la interface Descuentable.
 */
public class ComboSnacks implements Descuentable {

    private String nombre;
    private double precio;
    private String[] items;
    private boolean esCombo;

    public ComboSnacks(String nombre, double precio, String... items) {
        this.nombre = nombre;
        this.precio = precio;
        this.items = items;
        this.esCombo = items.length > 1;
    }

    // ========== IMPLEMENTACIÓN DE DESCUENTABLE ==========

    @Override
    public boolean esElegibleDescuento() {
        // Los combos son elegibles para descuento
        return esCombo;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        if (!esElegibleDescuento()) {
            System.out.println("⚠ Este producto no es elegible para descuento");
            return precio;
        }

        if (porcentaje < 0 || porcentaje > 100) {
            System.out.println("⚠ Porcentaje inválido");
            return precio;
        }

        double descuento = precio * (porcentaje / 100);
        double precioFinal = precio - descuento;

        System.out.println("🍿 Descuento aplicado a " + nombre + ": " + porcentaje + "%");
        System.out.println("   Precio original: $" + String.format("%,.0f", precio));
        System.out.println("   Precio final: $" + String.format("%,.0f", precioFinal));

        return precioFinal;
    }

    @Override
    public double obtenerPrecioBase() {
        return precio;
    }

    @Override
    public double calcularAhorro(double porcentaje) {
        if (!esElegibleDescuento()) return 0.0;
        return precio * (porcentaje / 100);
    }

    // ========== MÉTODOS PROPIOS ==========

    public void mostrarInfo() {
        System.out.println("\n--- " + nombre + " ---");
        System.out.println("Precio: $" + String.format("%,.0f", precio));
        System.out.println("Incluye:");
        for (String item : items) {
            System.out.println("  • " + item);
        }
        if (esCombo) {
            System.out.println("✓ Elegible para descuentos");
        }
    }

    public String getNombre() { return nombre; }
}