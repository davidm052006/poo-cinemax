package cinemax;

public abstract class PeliculaBase {
    protected String titulo;
    protected String genero;
    protected int duracionMinutos;

    public PeliculaBase(String titulo, String genero, int duracionMinutos) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
    }

    // Métodos que todas las películas comparten
    public void mostrarInfo() {
        System.out.println("Película: " + titulo);
        System.out.println("Género: " + genero + " | Duración: " + duracionMinutos + " min");
    }

    // Este método será diferente en cada hija → abstract
    public abstract double getRecargo();  // ¿cuánto cuesta de más?

    public abstract String getTipo();

    // Getters
    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracionMinutos() { return duracionMinutos; }
}
