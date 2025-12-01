package cinemax;

public class PeliculaEstreno extends PeliculaBase {
    private int semanasEnCartelera;

    public PeliculaEstreno(String titulo, String genero, int duracionMinutos, int semanasEnCartelera) {
        super(titulo, genero, duracionMinutos);
        this.semanasEnCartelera = semanasEnCartelera;
    }

    @Override
    public double getRecargo() {
        return 8000; // $8.000 de más por ser estreno
    }

    @Override
    public String getTipo() {
        return "ESTRENO";
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: ESTRENO (+$8.000) - Semana " + semanasEnCartelera);
    }
}