package cinemax;

public class Main {
    public static void main(String[] args) {
        System.out.println("¡CineMax - Semana 3: Encapsulación Total!\n");

        // Probando constructores sobrecargados
        Pelicula p1 = new Pelicula("Avengers: Endgame", "Acción");
        Cliente c1 = new Cliente("David Mateo", "1023456789");
        Sala s1 = new Sala(1, 120);

        Boleto b1 = new Boleto(c1, p1, s1, "F10");
        Boleto b2 = new Boleto(new Cliente("Sofía", "987654321"),
                new Pelicula("Frozen 2", "Animación"),
                new Sala(5, 80));

        Cine cine = new Cine("CineMax Plaza");
        cine.venderBoleto(b1);
        cine.venderBoleto(b2);
    }
}