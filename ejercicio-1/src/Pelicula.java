public class Pelicula {   // ← sin package arriba
    private String codigo;
    private String titulo;
    private String genero;
    private int duracionMinutos;
    private double precioBoleto;
    private boolean esEstreno;
    private int clasificacionEdad;

    public Pelicula(String codigo, String titulo, String genero, int duracionMinutos,
                    double precioBoleto, boolean esEstreno, int clasificacionEdad) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
        this.precioBoleto = precioBoleto;
        this.esEstreno = esEstreno;
        this.clasificacionEdad = clasificacionEdad;
    }

    public void mostrarInformacion() {
        System.out.println("=== PELÍCULA ===");
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracionMinutos + " minutos");
        System.out.println("Precio boleto: $" + String.format("%,.0f", precioBoleto));
        System.out.println("Clasificación: +" + clasificacionEdad);
        System.out.println("Estado: " + (esEstreno ? "ESTRENO" : "CARTELERA NORMAL"));
    }

    public double calcularRecaudacionEstimada(int boletosVendidos) {
        return boletosVendidos * precioBoleto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setEsEstreno(boolean esEstreno) {
        this.esEstreno = esEstreno;
    }
}