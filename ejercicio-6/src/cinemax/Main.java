package cinemax;

import cinemax.abstractas.ClienteBase;
import cinemax.implementaciones.*;
import cinemax.interfaces.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║  CINEMAX - SEMANA 06: ABSTRACCIÓN E INTERFACES║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        // ============================================================
        // PARTE 1: POLIMORFISMO CON CLASE ABSTRACTA ClienteBase
        // ============================================================
        System.out.println("═══ PARTE 1: POLIMORFISMO CON CLIENTES ═══\n");

        // Array polimórfico de tipo abstracto ClienteBase
        ClienteBase[] clientes = new ClienteBase[3];

        clientes[0] = new ClientePremium("Ana García", "1001", 28, "2024-01-15");
        clientes[1] = new ClienteEstudiante("Carlos López", "1002", 21, "Universidad Nacional", "EST2024");
        clientes[2] = new ClienteNormal("María Pérez", "1003", 35);

        double precioBoleto = 25000.0;

        System.out.println("--- Procesando compras de diferentes clientes ---");
        for (ClienteBase cliente : clientes) {
            System.out.println("\n" + "─".repeat(50));
            cliente.mostrarInfo();

            // Método polimórfico: cada tipo calcula descuento diferente
            double precioFinal = cliente.calcularDescuento(precioBoleto);
            System.out.println("Precio final: $" + String.format("%,.0f", precioFinal));

            // Acumular puntos (también polimórfico en Premium)
            cliente.acumularPuntos(precioFinal);
        }

        // ============================================================
        // PARTE 2: POLIMORFISMO CON CLASE ABSTRACTA PeliculaBase
        // ============================================================
        System.out.println("\n\n═══ PARTE 2: POLIMORFISMO CON PELÍCULAS ═══\n");

        Sala sala3D = new Sala(1, 120, false, true);      // Sala normal con 3D
        Sala salaNormal = new Sala(5, 80, false, false);  // Sala normal sin 3D

        // Array polimórfico de películas
        PeliculaBase[] cartelera = {
                new PeliculaEstreno("Dune 3", "Ciencia Ficción", 155, 1),
                new PeliculaNormal("El Padrino", "Drama", 175),
                new PeliculaEstreno("Avatar 3", "Acción", 180, 2)
        };

        System.out.println("--- Cartelera disponible ---");
        for (PeliculaBase pelicula : cartelera) {
            System.out.println();
            pelicula.mostrarInfo(); // Método polimórfico
            System.out.println("Recargo: $" + String.format("%,.0f", pelicula.getRecargo()));
        }

        // ============================================================
        // PARTE 3: DEMOSTRACIÓN DE INTERFACES - Reservable
        // ============================================================
        System.out.println("\n\n═══ PARTE 3: INTERFACE RESERVABLE ═══\n");

        PeliculaBase dune = cartelera[0];
        FuncionPremium funcionVIP = new FuncionPremium(dune, sala3D, "2025-12-15", "20:00", 35000);

        funcionVIP.mostrarInfo();

        // Usar como Reservable (referencia de tipo interface)
        Reservable servicioReservable = funcionVIP;

        System.out.println("\n--- Realizando reservas ---");
        if (servicioReservable.verificarDisponibilidad("2025-12-15", "20:00")) {
            String codigo1 = servicioReservable.realizarReserva("Ana García", "2025-12-15", "20:00");
            System.out.println("Código: " + codigo1);

            String codigo2 = servicioReservable.realizarReserva("Carlos López", "2025-12-15", "20:00");
            System.out.println("Código: " + codigo2);
        }

        // Intentar fecha incorrecta
        System.out.println("\n--- Intentando reserva en fecha incorrecta ---");
        if (!servicioReservable.verificarDisponibilidad("2025-12-16", "20:00")) {
            System.out.println("⚠ No hay funciones disponibles para esa fecha");
        }

        // ============================================================
        // PARTE 4: DEMOSTRACIÓN DE INTERFACES - Calificable
        // ============================================================
        System.out.println("\n\n═══ PARTE 4: INTERFACE CALIFICABLE ═══\n");

        // Usar la misma función pero como Calificable
        Calificable servicioCalificable = funcionVIP;

        System.out.println("--- Agregando calificaciones ---");
        servicioCalificable.agregarCalificacion(5, "¡Excelente película y sonido increíble!");
        servicioCalificable.agregarCalificacion(4, "Muy buena, pero un poco larga");
        servicioCalificable.agregarCalificacion(5, "Obra maestra del cine");
        servicioCalificable.agregarCalificacion(3, "Regular, esperaba más");

        System.out.println("\nPromedio: " +
                String.format("%.1f", servicioCalificable.obtenerPromedioCalificaciones()) +
                " ⭐ (" + servicioCalificable.obtenerTotalCalificaciones() + " votos)");

        servicioCalificable.mostrarCalificaciones();

        // ============================================================
        // PARTE 5: DEMOSTRACIÓN DE INTERFACES - Descuentable
        // ============================================================
        System.out.println("\n\n═══ PARTE 5: INTERFACE DESCUENTABLE ═══\n");

        // La función también implementa Descuentable
        Descuentable servicioDescuentable = funcionVIP;

        System.out.println("--- Aplicando descuento a función ---");
        if (servicioDescuentable.esElegibleDescuento()) {
            double precioOriginal = servicioDescuentable.obtenerPrecioBase();
            double precioConDescuento = servicioDescuentable.aplicarDescuento(20);
            double ahorro = servicioDescuentable.calcularAhorro(20);

            System.out.println("Precio original: $" + String.format("%,.0f", precioOriginal));
            System.out.println("Precio con 20% descuento: $" + String.format("%,.0f", precioConDescuento));
            System.out.println("Ahorro: $" + String.format("%,.0f", ahorro));
        } else {
            System.out.println("⚠ No elegible para descuento (alta demanda)");
        }

        // ============================================================
        // PARTE 6: CLASE QUE SOLO IMPLEMENTA UNA INTERFACE
        // ============================================================
        System.out.println("\n\n═══ PARTE 6: COMBOS DE SNACKS (Descuentable) ═══\n");

        ComboSnacks combo1 = new ComboSnacks("Combo Pareja", 28000,
                "2 Gaseosas grandes", "1 Crispetas gigantes", "2 Chocolates");

        ComboSnacks combo2 = new ComboSnacks("Combo Individual", 15000,
                "1 Gaseosa mediana", "1 Crispetas medianas");

        combo1.mostrarInfo();

        // Usar como Descuentable
        Descuentable comboDescuentable = combo1;
        double precioCombo = comboDescuentable.aplicarDescuento(15);

        System.out.println();
        combo2.mostrarInfo();
        comboDescuentable = combo2;
        comboDescuentable.aplicarDescuento(10);

        // ============================================================
        // PARTE 7: MÚLTIPLE IMPLEMENTACIÓN EN ACCIÓN
        // ============================================================
        System.out.println("\n\n═══ PARTE 7: MÚLTIPLE IMPLEMENTACIÓN ═══\n");

        System.out.println("FuncionPremium implementa 3 interfaces:");
        System.out.println("  ✓ Reservable  → Permite hacer reservas");
        System.out.println("  ✓ Calificable → Permite calificar la experiencia");
        System.out.println("  ✓ Descuentable → Permite aplicar descuentos");

        System.out.println("\n--- Usando las 3 capacidades ---");
        FuncionPremium funcionMulti = new FuncionPremium(
                new PeliculaEstreno("Interestelar", "Ciencia Ficción", 169, 1),
                new Sala(2, 50, true, true), "2025-12-20", "19:00", 40000  // Sala VIP con 3D
        );

        // Como Reservable
        Reservable r = funcionMulti;
        String codigo = r.realizarReserva("Juan Pérez", "2025-12-20", "19:00");

        // Como Calificable
        Calificable c = funcionMulti;
        c.agregarCalificacion(5, "Impresionante");

        // Como Descuentable
        Descuentable d = funcionMulti;
        double precio = d.aplicarDescuento(10);

        System.out.println("\n✓ Todas las interfaces funcionando en una sola clase");

        // ============================================================
        // RESUMEN FINAL
        // ============================================================
        System.out.println("\n\n╔═══════════════════════════════════════════════╗");
        System.out.println("║           RESUMEN DE CONCEPTOS                ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("\n✓ Clase Abstracta ClienteBase con 3 subclases");
        System.out.println("✓ Clase Abstracta PeliculaBase (heredada de semana 5)");
        System.out.println("✓ Interface Reservable implementada");
        System.out.println("✓ Interface Calificable implementada");
        System.out.println("✓ Interface Descuentable implementada");
        System.out.println("✓ FuncionPremium implementa 3 interfaces simultáneamente");
        System.out.println("✓ ComboSnacks implementa 1 interface");
        System.out.println("✓ Polimorfismo demostrado con arrays de tipos abstractos");
        System.out.println("✓ Referencias de tipo interface utilizadas\n");
    }
}