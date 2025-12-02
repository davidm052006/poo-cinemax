package cinemax;

public class Boleto {
    private Cliente cliente;
    private PeliculaBase pelicula;
    private Sala sala;
    private String asiento;
    private double precio;

    public Boleto(Cliente cliente, PeliculaBase pelicula, Sala sala, String asiento) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = (asiento == null || asiento.trim().isEmpty()) ? "Sin asignar" : asiento.toUpperCase();
        this.precio = calcularPrecio();
    }

    public Boleto(Cliente cliente, PeliculaBase pelicula, Sala sala) {
        this(cliente, pelicula, sala, "Sin asignar");
    }

    private double calcularPrecio() {
        double base = 15000.0;
        base += pelicula.getRecargo();           // POLIMORFISMO
        if (sala.isFormato3D()) base += 10000.0;
        if (cliente.getEdad() < 12) base *= 0.5;
        return base;
    }

    public void imprimirBoleto() {
        System.out.println("=====================================");
        System.out.println("         CINEMAX - BOLETO            ");
        System.out.println("=====================================");
        System.out.println("Cliente : " + cliente.getNombre());
        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("Tipo    : " + pelicula.getTipo());
        System.out.println("Sala    : " + sala.getNumero() + (sala.isFormato3D() ? " (3D)" : ""));
        System.out.println("Asiento : " + asiento);
        System.out.println("Precio  : $" + String.format("%,.0f", precio));
        System.out.println("=====================================\n");
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    public PeliculaBase getPelicula() { return pelicula; }
    public double getPrecio() { return precio; }
}