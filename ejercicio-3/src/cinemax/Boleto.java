package cinemax;

public class Boleto {
    private Cliente cliente;
    private Pelicula pelicula;
    private Sala sala;
    private String asiento;
    private double precio;

    // Constructor completo
    public Boleto(Cliente cliente, Pelicula pelicula, Sala sala, String asiento) {
        setCliente(cliente);
        setPelicula(pelicula);
        setSala(sala);
        setAsiento(asiento);
        this.precio = calcularPrecio();
    }

    // Constructor sin asiento (se asigna después)
    public Boleto(Cliente cliente, Pelicula pelicula, Sala sala) {
        this(cliente, pelicula, sala, "Sin asignar");
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public String getAsiento() { return asiento; }
    public double getPrecio() { return precio; }

    // Setters con validación
    public void setCliente(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente obligatorio");
        this.cliente = cliente;
    }

    public void setPelicula(Pelicula pelicula) {
        if (pelicula == null) throw new IllegalArgumentException("Película obligatoria");
        this.pelicula = pelicula;
    }

    public void setSala(Sala sala) {
        if (sala == null) throw new IllegalArgumentException("Sala obligatoria");
        this.sala = sala;
    }

    public void setAsiento(String asiento) {
        if (asiento == null || asiento.trim().isEmpty())
            this.asiento = "Libre";
        else
            this.asiento = asiento.trim().toUpperCase();
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
}
