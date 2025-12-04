package com.cinemax.modelo;

import java.time.LocalDateTime;

public class Funcion {
    private String codigo;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDateTime fechaHora;
    private double precioBase;
    private int asientosOcupados;
    private int capacidadTotal;

    public Funcion(String codigo, Pelicula pelicula, Sala sala, LocalDateTime fechaHora, double precioBase) {
        this.codigo = codigo;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fechaHora = fechaHora;
        this.precioBase = precioBase;
        this.capacidadTotal = sala.getCapacidad();
        this.asientosOcupados = 0;
    }

    public String getCodigo() { return codigo; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public double getPrecioBase() { return precioBase; }
    public int getAsientosDisponibles() { return capacidadTotal - asientosOcupados; }
    public void ocuparAsiento() { this.asientosOcupados++; }

    @Override
    public String toString() {
        return "Función: " + codigo + " | " + pelicula.getTitulo() + " | " + fechaHora.toLocalDate() + " " + fechaHora.toLocalTime();
    }
}