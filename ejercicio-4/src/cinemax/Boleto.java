package cinemax;

public class Boleto {
    private Cliente cliente;
    private PeliculaBase pelicula;  // ¡AHORA ES PeliculaBase! (polimorfismo)
    private Sala sala;
    private String asiento;
    private double precio;

    // Constructor completo
    public Boleto(Cliente cliente, PeliculaBase pelicula, Sala sala, String asiento) {
        setCliente(cliente);
        setPelicula(pelicula);
        setSala(sala);
        setAsiento(asiento);
        this.precio = calcularPrecio();
    }

    // Constructor sin asiento
    public Boleto(Cliente cliente, PeliculaBase pelicula, Sala sala) {
        this(cliente, pelicula, sala, "Sin asignar");
    }

    // Getters
    public Cliente getCliente() { return cliente; }
    public PeliculaBase getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public String getAsiento() { return asiento; }
    public double getPrecio() { return precio; }

    // Setters con validación
    public void setCliente(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente obligatorio");
        this.cliente = cliente;
    }

    public void setPelicula(PeliculaBase pelicula) {
        if (pelicula == null) throw new IllegalArgumentException("Película obligatoria");
        this.pelicula = pelicula;
    }

    public void setSala(Sala sala) {
        if (sala == null) throw new IllegalArgumentException("Sala obligatoria");
        this.sala = sala;
    }

    public void setAsiento(String asiento) {
        if (asiento == null || asiento.trim().isEmpty()) {
            this.asiento = "Sin asignar";
        } else {
            this.asiento = asiento.trim().toUpperCase();
        }
    }

    // ¡AQUÍ ESTÁ EL PODER DEL POLIMORFISMO!
    private double calcularPrecio() {
        double base = 15000.0;
        base += pelicula.getRecargo();           // ← depende del tipo de película
        if (sala.isFormato3D()) base += 10000.0;
        if (cliente.getEdad() < 12) base *= 0.5; // descuento niño
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
}