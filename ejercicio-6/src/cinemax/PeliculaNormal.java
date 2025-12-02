package cinemax;

public class PeliculaNormal extends PeliculaBase {

    public PeliculaNormal(String titulo, String genero, int duracionMinutos) {
        super(titulo, genero, duracionMinutos);
    }

    @Override
    public double getRecargo() {
        return 0.0;
    }

    @Override
    public String getTipo() {
        return "Normal";
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: Normal (sin recargo adicional)");
    }
}