package cinemax;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CINEMAX - SEMANA 4: HERENCIA Y POLIMORFISMO ===\n");

        // ARRAY POLIMÓRFICO → el poder máximo de POO
        PeliculaBase[] cartelera = new PeliculaBase[4];

        cartelera[0] = new PeliculaEstreno("Deadpool & Wolverine", "Acción", 128, 1);
        cartelera[1] = new PeliculaNormal("Intensamente 2", "Animación", 96);
        cartelera[2] = new PeliculaEstreno("Beetlejuice 2", "Comedia/Terror", 110, 2);
        cartelera[3] = new PeliculaNormal("El Rey León", "Animación", 118);

        Cliente cliente = new Cliente("David Mateo", "1023456789");
        Sala sala = new Sala(1, 120, true);

        Cine cine = new Cine("CineMax Premium");

        // POLIMORFISMO EN ACCIÓN
        for (PeliculaBase p : cartelera) {
            p.mostrarInfo();
            Boleto boleto = new Boleto(cliente, p, sala, "A1");
            cine.venderBoleto(boleto);
            System.out.println("---");
        }

        System.out.println("\n¡Herencia y polimorfismo 100% demostrados!");
    }
}