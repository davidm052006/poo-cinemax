package cinemax;



public class Boleto {
    private Cliente cliente;
    private Pelicula pelicula;
    private Sala sala;
    private String asiento;
    private double precio;

    public Boleto(Cliente cliente, Pelicula pelicula, Sala sala, String asiento) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asiento = asiento;
        this.precio = calcularPrecio();
    }


    private double calcularPrecio() {
        double base = 15000;
        if (pelicula.getClasificacion().equalsIgnoreCase("estreno")) base += 8000;
        if (sala.isFormato3D()) base += 10000;
        if (cliente.getEdad() < 12) base *= 0.5;
        return base;
    }

    public void imprimirBoleto() {
        System.out.println("=====================================");
        System.out.println("         CINEMAX - BOLETO            ");
        System.out.println("=====================================");
        System.out.println("Cliente : " + cliente.getNombre());
        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("Sala    : " + sala.getNumero() + (sala.isFormato3D() ? " (3D)" : ""));
        System.out.println("Asiento : " + asiento);
        System.out.println("Precio  : $" + String.format("%,.0f", precio));
        System.out.println("=====================================\n");
    }

    public double getPrecio() { return precio; }
    public Cliente getCliente() { return cliente; }
}