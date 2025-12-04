package com.cinemax.modelo;

public class ClienteVIP extends Cliente {
    private String codigoMembresia;

    public ClienteVIP(String documento, String nombre, int edad, String codigoMembresia) {
        super(documento, nombre, edad, TipoCliente.VIP);
        this.codigoMembresia = codigoMembresia;
    }

    @Override
    public double calcularDescuento(double precioBase) {
        return precioBase * 0.75; // 25% de descuento VIP
    }

    public String getCodigoMembresia() { return codigoMembresia; }

    @Override
    public String toString() {
        return super.toString() + " | Membresía: " + codigoMembresia;
    }
}