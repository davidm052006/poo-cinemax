package com.cinemax.modelo;

public class Sala {
    private int numero;
    private int capacidad;
    private boolean esVIP;

    public Sala(int numero, int capacidad, boolean esVIP) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.esVIP = esVIP;
    }

    public int getNumero() { return numero; }
    public int getCapacidad() { return capacidad; }
    public boolean esVIP() { return esVIP; }

    @Override
    public String toString() {
        return "Sala " + numero + " (VIP: " + esVIP + ", Cap: " + capacidad + ")";
    }
}