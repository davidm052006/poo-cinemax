package cinemax;

import java.util.ArrayList;

public class Cine {
    private String nombre;
    private ArrayList<Boleto> boletosVendidos = new ArrayList<>();

    public Cine(String nombre) {
        this.nombre = nombre;
    }

    public void venderBoleto(Boleto boleto) {
        if (boleto != null) {
            boletosVendidos.add(boleto);
            boleto.imprimirBoleto();
        }
    }
}