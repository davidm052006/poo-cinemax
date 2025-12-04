package com.cinemax;

import com.cinemax.modelo.*;
import com.cinemax.servicio.GestorCinemax;
import com.cinemax.excepciones.*;

import java.time.LocalDateTime;

public class Main {

    // SOLUCIÓN PROFESIONAL: Declaramos que main lanza las excepciones checked
    public static void main(String[] args) throws ReservaInvalidaException, FuncionNoDisponibleException {

        System.out.println("=== CINEMAX - Semana 07: Paquetes y Excepciones Personalizadas ===\n");

        GestorCinemax gestor = new GestorCinemax();

        // Datos de prueba
        Pelicula avatar = new Pelicula("Avatar 3", "Ciencia Ficción", 190);
        Pelicula dune = new Pelicula("Dune Parte 3", "Ciencia Ficción", 155);
        Sala salaVIP = new Sala(1, 6, true);  // 6 asientos para poder probar todo
        Cliente cliente1 = new Cliente("Ana López", "1001234567", 28, true);
        Cliente cliente2 = new Cliente("Carlos Ruiz", "1007654321", 19, false);

        // Agregar funciones disponibles
        Funcion funcion1 = new Funcion("F001", avatar, salaVIP, LocalDateTime.now().plusHours(3), 45000);
        Funcion funcion2 = new Funcion("F002", dune, salaVIP, LocalDateTime.now().plusDays(1), 50000);
        gestor.agregarFuncion(funcion1);
        gestor.agregarFuncion(funcion2);

        System.out.println("Funciones cargadas correctamente.\n");

        // ===================================================================
        // CASO 1: Reserva exitosa
        // ===================================================================
        System.out.println("--- Caso 1: Reserva Válida ---");
        String codigo1 = gestor.reservarBoleto("F001", cliente1, 45000);
        System.out.println("Código de reserva: " + codigo1 + "\n");

        // ===================================================================
        // CASO 2: Código de función inválido (formato incorrecto)
        // ===================================================================
        System.out.println("--- Caso 2: Código de Función Inválido ---");
        try {
            gestor.reservarBoleto("XYZ999", cliente2, 40000);
        } catch (ReservaInvalidaException e) {
            System.err.println("Error detectado: " + e.getMessage() + "\n");
        }

        // ===================================================================
        // CASO 3: Precio inválido (negativo o cero)
        // ===================================================================
        System.out.println("--- Caso 3: Precio Negativo ---");
        try {
            gestor.reservarBoleto("F001", cliente2, -10000);
        } catch (ReservaInvalidaException e) {
            System.err.println("Error detectado: " + e.getMessage() + "\n");
        }

        // ===================================================================
        // CASO 4: Sin disponibilidad (llenamos la sala)
        // ===================================================================
        System.out.println("--- Caso 4: Llenando la sala para agotar cupo ---");
        for (int i = 1; i <= 5; i++) {
            Cliente temp = new Cliente("ClienteTemp" + i, "999" + i, 20 + i, false);
            gestor.reservarBoleto("F001", temp, 45000);
        }
        System.out.println("Intentando reserva cuando ya no hay cupo...");
        try {
            gestor.reservarBoleto("F001", cliente2, 45000);
        } catch (FuncionNoDisponibleException e) {
            System.err.println("Error detectado: " + e.getMessage() + "\n");
        }

        // ===================================================================
        // CASO 5: Recuperación exitosa (nueva función disponible)
        // ===================================================================
        System.out.println("--- Caso 5: Recuperación - Reserva en otra función ---");
        String codigo2 = gestor.reservarBoleto("F002", cliente2, 50000);
        System.out.println("Reserva exitosa después del error: " + codigo2 + "\n");

        // ===================================================================
        // Finally con recurso (Scanner simulado)
        // ===================================================================
        java.util.Scanner scanner = null;
        try {
            scanner = new java.util.Scanner(System.in);
            System.out.println("Presiona Enter para finalizar el programa...");
            scanner.nextLine();
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("Recursos liberados correctamente en el bloque finally.");
            }
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN - SEMANA 07 COMPLETADA CON ÉXITO ===");
        System.out.println("Paquetes organizados ✓ | Excepciones personalizadas ✓ | Manejo correcto ✓");
    }
}