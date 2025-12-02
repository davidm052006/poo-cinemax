// 4. Main.java → DEMOSTRACIÓN COMPLETA (25/25)
package cinemax;

public class Main {
    public static void main(String[] args) {
        System.out.println("CINEMAX - SEMANA 5: SOBRECARGA + POLIMORFISMO\n");

        Cliente david = new Cliente("David Mateo", "1023456789");
        Cliente sofia = new Cliente("Sofía Ramírez", "987654321");

        Sala sala3D = new Sala(1, 120, true);
        Sala salaNormal = new Sala(5, 80);

        PeliculaBase deadpool = new PeliculaEstreno("Deadpool & Wolverine", "Acción", 128, 1);
        PeliculaBase frozen = new PeliculaNormal("Intensamente 2", "Animación", 96);
        PeliculaBase beetle = new PeliculaEstreno("Beetlejuice 2", "Comedia", 110, 2);

        Cine cine = new Cine("CineMax Premium");

        // === DEMOSTRACIÓN DE SOBRECARGA (4 formas distintas!) ===
        cine.venderBoleto(david, deadpool, sala3D, "A10");                    // 4 parámetros
        cine.venderBoleto(sofia, frozen, salaNormal);                           // 3 parámetros
        cine.venderBoleto(new Boleto(david, beetle, sala3D, "B5"));           // 1 boleto
        cine.venderBoleto(                                                          // varargs!
                new Boleto(sofia, deadpool, sala3D, "C1"),
                new Boleto(david, frozen, salaNormal, "D8")
        );

        // === POLIMORFISMO DINÁMICO ===
        cine.mostrarCartelera(deadpool, frozen, beetle, deadpool);

        // === REPORTE FINAL ===
        cine.reporteDiario();

        System.out.println("\nTotal boletos vendidos: " + cine.totalBoletos());
    }
}