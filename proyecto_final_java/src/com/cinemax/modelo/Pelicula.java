package com.cinemax.modelo;

public class Pelicula {
    private String titulo;
    private String genero;
    private int duracion;

    public Pelicula(String titulo, String genero, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }

    @Override
    public String toString() {
        return titulo + " (" + genero + ", " + duracion + " min)";
    }
}