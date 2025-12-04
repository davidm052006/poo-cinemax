package com.cinemax.modelo;

public enum TipoCliente {
    NORMAL("Cliente Normal"),
    VIP("Cliente VIP"),
    ESTUDIANTE("Estudiante"),
    JUBILADO("Jubilado");

    private final String descripcion;

    TipoCliente(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}