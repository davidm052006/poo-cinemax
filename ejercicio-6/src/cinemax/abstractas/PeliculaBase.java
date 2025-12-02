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

    public void mostrarInfo() {
        System.out.println("Película: " + titulo);
        System.out.println("Género: " + genero + " | Duración: " + duracionMinutos + " min");
    }

    public abstract double getRecargo();
    public abstract String getTipo();

    // SOBRESCRITURA del método toString() de Object
    @Override
    public String toString() {
        return getTipo() + " → " + titulo + " (" + genero + ")";
    }

    // Getters
    public String getTitulo() { return titulo; }
}