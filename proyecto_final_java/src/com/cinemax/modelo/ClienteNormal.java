package com.cinemax.modelo;

public class ClienteNormal extends Cliente {

    public ClienteNormal(String documento, String nombre, int edad) {
        super(documento, nombre, edad, TipoCliente.NORMAL);
    }

    @Override
    public double calcularDescuento(double precioBase) {
        return precioBase; // Sin descuento
    }
}