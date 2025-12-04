package com.cinemax.modelo;

public class Cliente {
    private String nombre;
    private String documento;
    private int edad;
    private boolean esVIP;

    public Cliente(String nombre, String documento, int edad, boolean esVIP) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.esVIP = esVIP;
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public int getEdad() { return edad; }
    public boolean esVIP() { return esVIP; }

    @Override
    public String toString() {
        return nombre + " (VIP: " + esVIP + ")";
    }
}