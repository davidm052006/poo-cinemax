package cinemax;



public class Pelicula {
    private String titulo;
    private String genero;
    private int duracionMinutos;
    private String clasificacion; // ej: "estreno", "infantil", "general"

    public Pelicula(String titulo, String genero, int duracionMinutos, String clasificacion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.clasificacion = clasificacion;
    }

    // Getters y setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public String getClasificacion() { return clasificacion; }
    public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    @Override
    public String toString() {
        return titulo + " (" + genero + ") - " + duracionMinutos + " min";
    }
}