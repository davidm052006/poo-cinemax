package com.cinemax;

import com.cinemax.modelo.*;
import com.cinemax.servicio.GestorCinemax;
import com.cinemax.excepciones.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorCinemax gestor = new GestorCinemax();
        Scanner scanner = new Scanner(System.in);

        // Datos iniciales
        Pelicula avatar = new Pelicula("Avatar 3", "Ciencia Ficción", 190);
        Pelicula dune = new Pelicula("Dune Parte 3", "Ciencia Ficción", 155);
        Sala salaVIP = new Sala(1, 100, true);
        gestor.agregarFuncion(new Funcion("F001", avatar, salaVIP, LocalDateTime.now().plusHours(3), 45000));
        gestor.agregarFuncion(new Funcion("F002", dune, salaVIP, LocalDateTime.now().plusDays(1), 50000));

        int opcion;
        do {
            System.out.println("\n=== CINEMAX - GESTIÓN DE FUNCIONES ===");
            System.out.println("1. Agregar función");
            System.out.println("2. Buscar por código");
            System.out.println("3. Listar todas las funciones");
            System.out.println("4. Filtrar por precio");
            System.out.println("5. Ver estadísticas");
            System.out.println("6. Eliminar función");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: agregarFuncion(gestor, scanner); break;
                case 2: buscarFuncion(gestor, scanner); break;
                case 3: listarTodas(gestor); break;
                case 4: filtrarPorPrecio(gestor, scanner); break;
                case 5: mostrarEstadisticas(gestor); break;
                case 6: eliminarFuncion(gestor, scanner); break;
                case 0: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarFuncion(GestorCinemax gestor, Scanner scanner) {
        System.out.print("Código de función (ej: F003): ");
        String codigo = scanner.nextLine();
        System.out.print("Título película: ");
        String titulo = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();
        System.out.print("Duración (min): ");
        int duracion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Precio base: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        Pelicula peli = new Pelicula(titulo, genero, duracion);
        Sala sala = new Sala(2, 100, false);
        Funcion nueva = new Funcion(codigo, peli, sala, LocalDateTime.now().plusDays(1), precio);
        gestor.agregarFuncion(nueva);
        System.out.println("Función agregada exitosamente!");
    }

    private static void buscarFuncion(GestorCinemax gestor, Scanner scanner) {
        System.out.print("Código a buscar: ");
        String codigo = scanner.nextLine();
        Funcion f = gestor.buscarPorCodigo(codigo);
        if (f != null) {
            System.out.println("Encontrada: " + f);
        } else {
            System.out.println("No existe función con código: " + codigo);
        }
    }

    private static void listarTodas(GestorCinemax gestor) {
        System.out.println("\n=== LISTA DE FUNCIONES ===");
        for (Funcion f : gestor.getFunciones()) {
            System.out.println(f);
        }
    }

    private static void filtrarPorPrecio(GestorCinemax gestor, Scanner scanner) {
        System.out.print("Precio mínimo: ");
        double min = scanner.nextDouble();
        System.out.print("Precio máximo: ");
        double max = scanner.nextDouble();
        scanner.nextLine();
        List<Funcion> filtradas = gestor.filtrarPorPrecio(min, max);
        System.out.println("\nFunciones en rango de precio:");
        for (Funcion f : filtradas) {
            System.out.println(f);
        }
    }

    private static void mostrarEstadisticas(GestorCinemax gestor) {
        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println("Total funciones: " + gestor.getFunciones().size());
        System.out.println("Total ventas: $" + String.format("%,.0f", gestor.calcularTotalVentas()));
        System.out.println("Promedio precio: $" + String.format("%,.0f", gestor.calcularPromedioPrecio()));

        Funcion masCara = gestor.obtenerFuncionMasCara();
        if (masCara != null) {
            System.out.println("Más cara: " + masCara);
        }

        System.out.println("\nConteo por película:");
        Map<String, Integer> conteo = gestor.contarPorPelicula();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void eliminarFuncion(GestorCinemax gestor, Scanner scanner) {
        System.out.print("Código a eliminar: ");
        String codigo = scanner.nextLine();
        Funcion eliminada = gestor.eliminar(codigo);
        if (eliminada != null) {
            System.out.println("Eliminada: " + eliminada);
        } else {
            System.out.println("No existe función con código: " + codigo);
        }
    }
}