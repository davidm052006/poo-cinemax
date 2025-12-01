package cinemax;

public class Pelicula {
    private String titulo;
    private String genero;
    private int duracionMinutos;
    private String clasificacion; // estreno, infantil, general

    // Constructor completo
    public Pelicula(String titulo, String genero, int duracionMinutos, String clasificacion) {
        setTitulo(titulo);
        setGenero(genero);
        setDuracionMinutos(duracionMinutos);
        setClasificacion(clasificacion);
    }

    // Constructor solo título y género
    public Pelicula(String titulo, String genero) {
        this(titulo, genero, 120, "general");
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public String getClasificacion() { return clasificacion; }

    // Setters con validación
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty())
            throw new IllegalArgumentException("El título no puede estar vacío");
        this.titulo = titulo.trim();
    }

    public void setGenero(String genero) {
        if (genero == null || genero.trim().isEmpty())
            throw new IllegalArgumentException("El género es obligatorio");
        this.genero = genero.trim();
    }

    public void setDuracionMinutos(int duracionMinutos) {
        if (duracionMinutos <= 0 || duracionMinutos > 300)
            throw new IllegalArgumentException("Duración debe estar entre 1 y 300 minutos");
        this.duracionMinutos = duracionMinutos;
    }

    public void setClasificacion(String clasificacion) {
        if (clasificacion == null || clasificacion.trim().isEmpty())
            clasificacion = "general";
        this.clasificacion = clasificacion.trim().toLowerCase();
    }

    @Override
    public String toString() {
        return titulo + " (" + genero + ") - " + duracionMinutos + " min";
    }
}
