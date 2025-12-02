
package cinemax;

import java.util.ArrayList;

public class Cine {
    private String nombre;
    private ArrayList<Boleto> boletosVendidos = new ArrayList<>();

    public Cine(String nombre) {
        this.nombre = nombre;
    }

    // ================= SOBRECARGA (OVERLOADING) =================
    // 1. Vender un solo boleto
    public void venderBoleto(Boleto boleto) {
        if (boleto != null) {
            boletosVendidos.add(boleto);
            boleto.imprimirBoleto();
        }
    }

    // 2 Vender varios boletos a la vez (sobrecarga!)
    public void venderBoleto(Boleto... boletos) {  // varargs = cantidad variable
        for (Boleto b : boletos) {
            venderBoleto(b);  // reutiliza el método anterior
        }
    }

    // 3 Vender boleto solo con datos básicos (sobrecarga útil)
    public void venderBoleto(Cliente cliente, PeliculaBase pelicula, Sala sala) {
        venderBoleto(new Boleto(cliente, pelicula, sala));
    }

    // 4 Vender con asiento incluido
    public void venderBoleto(Cliente cliente, PeliculaBase pelicula, Sala sala, String asiento) {
        venderBoleto(new Boleto(cliente, pelicula, sala, asiento));
    }

    // ================= POLIMORFISMO DINÁMICO =================
    public void mostrarCartelera(PeliculaBase... peliculas) {
        System.out.println("\n=== CARTELERA " + nombre.toUpperCase() + " ===");
        for (PeliculaBase p : peliculas) {
            p.mostrarInfo();                         // ← POLIMORFISMO
            System.out.println("Recargo adicional: $" + String.format("%,.0f", p.getRecargo()));
            System.out.println("---");
        }
    }

    public void reporteDiario() {
        System.out.println("\n=== REPORTE DIARIO " + nombre + " ===");
        double total = 0;
        for (Boleto b : boletosVendidos) {
            System.out.printf("%s → %s → $%,.0f%n",
                    b.getCliente().getNombre(),
                    b.getPelicula().getTipo(),
                    b.getPrecio());
            total += b.getPrecio();
        }
        System.out.println("TOTAL RECAUDADO: $" + String.format("%,.0f", total));
    }

    public int totalBoletos() { return boletosVendidos.size(); }
}