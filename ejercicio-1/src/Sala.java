public class Sala {
    private int numeroSala;
    private String tipoSala;
    private int capacidadAsientos;
    private boolean tieneSonidoDolby;
    private String peliculaActual;

    public Sala(int numeroSala, String tipoSala, int capacidadAsientos, boolean tieneSonidoDolby) {
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.capacidadAsientos = capacidadAsientos;
        this.tieneSonidoDolby = tieneSonidoDolby;
        this.peliculaActual = "SIN PELÍCULA ASIGNADA";
    }

    public void mostrarInformacionSala() {
        System.out.println("--- SALA " + numeroSala + " ---");
        System.out.println("Tipo: " + tipoSala);
        System.out.println("Capacidad: " + capacidadAsientos + " asientos");
        System.out.println("Sonido Dolby: " + (tieneSonidoDolby ? "SÍ" : "NO"));
        System.out.println("Película en proyección: " + peliculaActual);
    }

    public void asignarPelicula(String tituloPelicula) {
        this.peliculaActual = tituloPelicula;
        System.out.println("Película '" + tituloPelicula + "' asignada a la Sala " + numeroSala);
    }

    public boolean estaDisponible() {
        return peliculaActual.equals("SIN PELÍCULA ASIGNADA");
    }
}