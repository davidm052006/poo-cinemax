package cinemax.implementaciones;

import cinemax.abstractas.ClienteBase;

/**
 * Cliente regular sin membresía especial
 */
public class ClienteNormal extends ClienteBase {

    private int comprasRealizadas;

    public ClienteNormal(String nombre, String documento, int edad) {
        super(nombre, documento, edad);
        this.comprasRealizadas = 0;
    }

    @Override
    public double calcularDescuento(double precioBase) {
        // Descuento del 5% solo si ha hecho más de 5 compras
        if (comprasRealizadas > 5) {
            double descuento = precioBase * 0.05;
            System.out.println("🎫 Descuento por fidelidad (5%): -$" + String.format("%,.0f", descuento));
            return precioBase - descuento;
        }

        System.out.println("Sin descuento (cliente regular)");
        return precioBase;
    }

    @Override
    public String getTipoCliente() {
        return "NORMAL";
    }

    @Override
    public boolean tieneBeneficios() {
        // Solo tiene beneficios si ha comprado más de 5 veces
        return comprasRealizadas > 5;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Compras realizadas: " + comprasRealizadas);
        System.out.println("Estado: " + (tieneBeneficios() ? "Cliente frecuente" : "Cliente ocasional"));
    }

    public void registrarCompra() {
        comprasRealizadas++;
        if (comprasRealizadas == 6) {
            System.out.println("🎉 ¡Felicitaciones! Ahora tienes descuento por fidelidad");
        }
    }
}