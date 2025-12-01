package cinemax;

import java.util.ArrayList;

public class Cine {
    private String nombre;
    private ArrayList<Boleto> boletosVendidos;

    public Cine(String nombre) {
        setNombre(nombre);
        this.boletosVendidos = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            this.nombre = "CineMax";
        else
            this.nombre = nombre.trim();
    }

    public String getNombre() { return nombre; }

    public void venderBoleto(Boleto boleto) {
        if (boleto == null) throw new IllegalArgumentException("Boleto no puede ser nulo");
        boletosVendidos.add(boleto);
        boleto.imprimirBoleto();
    }

    // ... resto igual que antes (mostrarRecaudacionTotal, etc.)
    // (los métodos de reporte no cambian)
}