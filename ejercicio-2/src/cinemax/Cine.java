package cinemax;

import java.util.ArrayList;

public class Cine {
    private String nombre;
    private ArrayList<Boleto> boletosVendidos;

    public Cine(String nombre) {
        this.nombre = nombre;
        this.boletosVendidos = new ArrayList<>();
    }

    public void venderBoleto(Boleto boleto) {
        boletosVendidos.add(boleto);
        boleto.imprimirBoleto();
    }

    public void mostrarRecaudacionTotal() {
        double total = 0;
        for (Boleto b : boletosVendidos) {
            total += b.getPrecio();
        }
        System.out.println("RECAUDACIÓN TOTAL " + nombre + ": $" + String.format("%,.0f", total) + "\n");
    }

    public void mostrarTodosLosBoletos() {
        System.out.println("--- BOLETOS VENDIDOS HOY ---");
        for (Boleto b : boletosVendidos) {
            System.out.println(b.getCliente().getNombre() + " → " + b.getCliente().clasificarEdad() +
                    " → " + b.getCliente().getEdad() + " años → $" + String.format("%,.0f", b.getPrecio()));
        }
        System.out.println();
    }

    public int totalBoletos() {
        return boletosVendidos.size();
    }
}