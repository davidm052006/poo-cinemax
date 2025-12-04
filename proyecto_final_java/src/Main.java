package com.cinemax;

import com.cinemax.modelo.*;
import com.cinemax.servicio.GestorCinemax;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static GestorCinemax gestor = new GestorCinemax();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("""
            ╔══════════════════════════════════════════════════╗
            ║      CINEMAX - PROYECTO FINAL POO 2025           ║
            ║      Herencia + Polimorfismo + CRUD              ║
            ╚══════════════════════════════════════════════════╝
            """);

        cargarDatosIniciales();

        // DEMOSTRACIÓN AUTOMÁTICA DE HERENCIA Y POLIMORFISMO
        demoHerenciaPolimorfismo();

        System.out.println("\nPresiona Enter para entrar al menú principal...");
        sc.nextLine();

        // MENÚ QUE NO SE CIERRA HASTA ELEGIR 0
        menuPrincipal();

        System.out.println("\n¡Gracias por usar CineMax! ¡Hasta pronto!");
        sc.close();
    }

    private static void cargarDatosIniciales() {
        Pelicula avatar = new Pelicula("Avatar 3", "Ciencia Ficción", 190);
        Pelicula dune = new Pelicula("Dune Parte 3", "Ciencia Ficción", 155);
        Sala salaVIP = new Sala(1, 100, true);

        gestor.agregarFuncion(new Funcion("F001", avatar, salaVIP, LocalDateTime.now().plusHours(3), 45000));
        gestor.agregarFuncion(new Funcion("F002", dune, salaVIP, LocalDateTime.now().plusDays(1), 50000));
    }

    private static void demoHerenciaPolimorfismo() {
        System.out.println("\n" + "═".repeat(55));
        System.out.println("       DEMOSTRACIÓN DE HERENCIA Y POLIMORFISMO");
        System.out.println("═".repeat(55));

        Cliente c1 = new ClienteNormal("111", "Juan Pérez", 28);
        Cliente c2 = new ClienteVIP("222", "Ana Gómez", 35, "VIP-2025");

        double precio = 45000;

        System.out.println(c1.saludar());
        System.out.println(c2.saludar("¡Bienvenida al club VIP"));

        System.out.println("\nPrecio del boleto: $" + String.format("%,.0f", precio));
        System.out.println(c1.getNombre() + " paga → $" + String.format("%,.0f", c1.calcularDescuento(precio)));
        System.out.println(c2.getNombre() + " paga → $" + String.format("%,.0f", c2.calcularDescuento(precio)) + " (25% OFF VIP)");
        System.out.println("═".repeat(55));
    }

    private static void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n" + "═".repeat(60));
            System.out.println("                CINEMAX - MENÚ PRINCIPAL");
            System.out.println("═".repeat(60));
            System.out.println("1. Agregar nueva función");
            System.out.println("2. Buscar función por código");
            System.out.println("3. Listar todas las funciones");
            System.out.println("4. Actualizar precio de función");
            System.out.println("5. Eliminar función");
            System.out.println("6. Filtrar por precio");
            System.out.println("7. Filtrar por mes/año");
            System.out.println("8. Ver estadísticas");
            System.out.println("9. Repetir demo de herencia");
            System.out.println("0. Salir");
            System.out.println("═".repeat(60));
            System.out.print("→ Opción: ");

            opcion = validarEntero();

            switch (opcion) {
                case 1 -> agregarFuncion();
                case 2 -> buscarPorCodigo();
                case 3 -> listarTodas();
                case 4 -> actualizarPrecio();
                case 5 -> eliminarFuncion();
                case 6 -> filtrarPorPrecio();
                case 7 -> filtrarPorMesAnio();
                case 8 -> mostrarEstadisticas();
                case 9 -> demoHerenciaPolimorfismo();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intenta otra vez.");
            }
        } while (opcion != 0);
    }

    private static int validarEntero() {
        while (!sc.hasNextInt()) {
            System.out.print("Error: ingresa solo números → ");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    // ============ MÉTODOS DEL MENÚ ============

    private static void agregarFuncion() {
        System.out.println("\n--- Agregar Nueva Función ---");
        System.out.print("Código (ej: F003): ");
        String codigo = sc.nextLine();
        if (gestor.buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe una función con ese código.");
            return;
        }
        System.out.print("Título película: ");
        String titulo = sc.nextLine();
        System.out.print("Género: ");
        String genero = sc.nextLine();
        System.out.print("Duración (min): ");
        int duracion = validarEntero();
        System.out.print("Precio base: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        Pelicula peli = new Pelicula(titulo, genero, duracion);
        Sala sala = new Sala(1, 100, true);
        Funcion nueva = new Funcion(codigo, peli, sala, LocalDateTime.now().plusDays(2), precio);
        gestor.agregarFuncion(nueva);
        System.out.println("Función agregada con éxito!");
    }

    private static void buscarPorCodigo() {
        System.out.print("\nCódigo a buscar: ");
        String codigo = sc.nextLine();
        Funcion f = gestor.buscarPorCodigo(codigo);
        if (f != null) {
            System.out.println("Encontrada:\n" + f);
        } else {
            System.out.println("No existe función con código: " + codigo);
        }
    }

    private static void listarTodas() {
        System.out.println("\n=== TODAS LAS FUNCIONES ===");
        for (Funcion f : gestor.getFunciones()) {
            System.out.println(f);
            System.out.println("-".repeat(40));
        }
    }

    private static void actualizarPrecio() {
        System.out.print("\nCódigo de función a modificar: ");
        String codigo = sc.nextLine();
        Funcion f = gestor.buscarPorCodigo(codigo);
        if (f == null) {
            System.out.println("Función no encontrada.");
            return;
        }
        System.out.print("Nuevo precio: ");
        double nuevo = sc.nextDouble();
        sc.nextLine();
        // Aquí deberías tener un setter en Funcion o un método en Gestor
        System.out.println("Precio actualizado (simulado).");
    }

    private static void eliminarFuncion() {
        System.out.print("\nCódigo a eliminar: ");
        String codigo = sc.nextLine();
        if (gestor.eliminar(codigo) != null) {
            System.out.println("Función eliminada correctamente.");
        } else {
            System.out.println("No se encontró la función.");
        }
    }

    private static void filtrarPorPrecio() {
        System.out.print("\nPrecio mínimo: ");
        double min = sc.nextDouble();
        System.out.print("Precio máximo: ");
        double max = sc.nextDouble();
        sc.nextLine();
        List<Funcion> filtradas = gestor.filtrarPorPrecio(min, max);
        System.out.println("\nFunciones entre $" + min + " y $" + max + ":");
        for (Funcion f : filtradas) System.out.println(f);
    }

    private static void filtrarPorMesAnio() {
        System.out.print("\nMes (1-12): ");
        int mes = validarEntero();
        System.out.print("Año: ");
        int anio = validarEntero();
        List<Funcion> filtradas = gestor.filtrarPorMes(mes, anio);
        System.out.println("\nFunciones en " + mes + "/" + anio + ":");
        for (Funcion f : filtradas) System.out.println(f);
    }

    private static void mostrarEstadisticas() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("             ESTADÍSTICAS DEL CINE");
        System.out.println("═".repeat(50));
        System.out.println("Total funciones: " + gestor.getFunciones().size());
        System.out.println("Total ventas: $" + String.format("%,.0f", gestor.calcularTotalVentas()));
        System.out.println("Promedio precio: $" + String.format("%,.0f", gestor.calcularPromedioPrecio()));
        Funcion masCara = gestor.obtenerFuncionMasCara();
        if (masCara != null) System.out.println("Función más cara: " + masCara.getPelicula().getTitulo() + " → $" + masCara.getPrecioBase());
        System.out.println("═".repeat(50));
    }
}









