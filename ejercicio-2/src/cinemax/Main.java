package cinemax;


public class Main {
    public static void main(String[] args) {
        System.out.println("¡Bienvenido a CineMax!\n");

        // Objetos básicos (semana 1)
        Pelicula p1 = new Pelicula("Avengers: Endgame", "Acción", 181, "estreno");
        Pelicula p2 = new Pelicula("Frozen 2", "Animación", 103, "infantil");

        Sala sala3D = new Sala(1, 120, true);
        Sala salaNormal = new Sala(5, 80, false);

        // Clientes nuevos
        Cliente c1 = new Cliente("David Mateo Paredes", "1023456789", "david@gmail.com", 19);
        Cliente c2 = new Cliente("Sofía Ramírez", "987654321", "sofia@gmail.com", 10);
        Cliente c3 = new Cliente("Carlos López", "123456789", "carlos@gmail.com", 35);

        // Boletas con relaciones
        Boleto b1 = new Boleto(c1, p1, sala3D, "G10");
        Boleto b2 = new Boleto(c2, p2, salaNormal, "D5");
        Boleto b3 = new Boleto(c3, p1, sala3D, "G11");

        // Gestor con ArrayList
        Cine cine = new Cine("CineMax Plaza de las Américas");

        cine.venderBoleto(b1);
        cine.venderBoleto(b2);
        cine.venderBoleto(b3);

        cine.mostrarTodosLosBoletos();
        cine.mostrarRecaudacionTotal();
        System.out.println("Total boletos vendidos: " + cine.totalBoletos());
    }
}