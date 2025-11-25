public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("     SISTEMA CINEMAX - BOGOTÁ    ");
        System.out.println("========================================\n");

        Pelicula p1 = new Pelicula("AVN2025", "Avengers: Secret Wars", "Acción", 180, 35000, true, 13);
        Pelicula p2 = new Pelicula("ANI2030", "Zootopia 2", "Animación", 105, 28000, false, 0);

        Sala sala5 = new Sala(5, "IMAX", 320, true);
        Sala sala8 = new Sala(8, "3D", 180, true);

        p1.mostrarInformacion();
        System.out.println("Recaudación estimada (500 boletos): $" +
                String.format("%,.0f", p1.calcularRecaudacionEstimada(500)));
        System.out.println();

        p2.mostrarInformacion();
        System.out.println();

        sala5.mostrarInformacionSala();
        sala8.mostrarInformacionSala();
        System.out.println();

        sala5.asignarPelicula(p1.getTitulo());
        sala8.asignarPelicula(p2.getTitulo());
        System.out.println();

        sala5.mostrarInformacionSala();
        sala8.mostrarInformacionSala();
        System.out.println();

        p1.setEsEstreno(false);
        System.out.println("Después de quitar el estado de estreno:");
        p1.mostrarInformacion();
        System.out.println();

        System.out.println("¿Sala 5 está disponible? " + (sala5.estaDisponible() ? "SÍ" : "NO"));
        System.out.println("¿Sala 8 está disponible? " + (sala8.estaDisponible() ? "SÍ" : "NO"));
    }
}