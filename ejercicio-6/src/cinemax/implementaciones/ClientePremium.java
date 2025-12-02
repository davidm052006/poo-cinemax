package cinemax.implementaciones;

import cinemax.abstractas.ClienteBase;

/**
 * Cliente con membresía Premium - tiene mayores beneficios
 */
public class ClientePremium extends ClienteBase {

    private String fechaMembresia;
    private boolean accesoSalasVIP;

    public ClientePremium(String nombre, String documento, int edad, String fechaMembresia) {
        super(nombre, documento, edad);
        this.fechaMembresia = fechaMembresia;
        this.accesoSalasVIP = true;
    }

    @Override
    public double calcularDescuento(double precioBase) {
        // 20% de descuento permanente
        double descuento = precioBase * 0.20;
        System.out.println("💎 Descuento Premium (20%): -$" + String.format("%,.0f", descuento));
        return precioBase - descuento;
    }

    @Override
    public String getTipoCliente() {
        return "PREMIUM 💎";
    }

    @Override
    public boolean tieneBeneficios() {
        return true; // Siempre tiene beneficios
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Membresía desde: " + fechaMembresia);
        System.out.println("Acceso VIP: " + (accesoSalasVIP ? "Sí" : "No"));
    }

    @Override
    public void acumularPuntos(double montoCompra) {
        // Premium gana el doble de puntos
        int puntosGanados = (int)(montoCompra / 500); // 1 punto por cada $500
        puntosAcumulados += puntosGanados;
        System.out.println("✓ " + nombre + " ganó " + puntosGanados + " puntos (x2 Premium)");
    }
}