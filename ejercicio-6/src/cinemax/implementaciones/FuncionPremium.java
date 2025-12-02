package cinemax.implementaciones;

import cinemax.PeliculaBase;
import cinemax.Sala;
import cinemax.interfaces.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Clase que representa una función especial con múltiples capacidades.
 * Implementa TRES interfaces: Reservable, Calificable y Descuentable
 */
public class FuncionPremium implements Reservable, Calificable, Descuentable {

    private PeliculaBase pelicula;
    private Sala sala;
    private String fecha;
    private String hora;
    private double precioBase;
    private int capacidadMaxima;
    private int asientosReservados;

    // Para Reservable
    private String ultimoCodigoReserva;
    private ArrayList<String> reservasActivas;

    // Para Calificable
    private ArrayList<Integer> calificaciones;
    private ArrayList<String> comentarios;

    public FuncionPremium(PeliculaBase pelicula, Sala sala, String fecha, String hora, double precioBase) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.precioBase = precioBase;
        this.capacidadMaxima = 50; // Funciones premium tienen capacidad limitada
        this.asientosReservados = 0;
        this.reservasActivas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    // ========== IMPLEMENTACIÓN DE RESERVABLE ==========
    @Override
    public boolean verificarDisponibilidad(String fecha, String hora) {
        if (!this.fecha.equals(fecha) || !this.hora.equals(hora)) {
            return false; // Fecha/hora no coinciden
        }
        return asientosReservados < capacidadMaxima;
    }

    @Override
    public String realizarReserva(String cliente, String fecha, String hora) {
        if (!verificarDisponibilidad(fecha, hora)) {
            return null; // No hay disponibilidad
        }

        ultimoCodigoReserva = "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        reservasActivas.add(ultimoCodigoReserva + ":" + cliente);
        asientosReservados++;

        System.out.println("✓ Reserva confirmada para " + cliente);
        System.out.println("  Película: " + pelicula.getTitulo());
        System.out.println("  Fecha: " + fecha + " - Hora: " + hora);

        return ultimoCodigoReserva;
    }

    @Override
    public boolean cancelarReserva(String codigoReserva) {
        for (String reserva : reservasActivas) {
            if (reserva.startsWith(codigoReserva)) {
                reservasActivas.remove(reserva);
                asientosReservados--;
                System.out.println("✓ Reserva " + codigoReserva + " cancelada");
                return true;
            }
        }
        return false;
    }

    @Override
    public String obtenerCodigoReserva() {
        return ultimoCodigoReserva;
    }

    // ========== IMPLEMENTACIÓN DE CALIFICABLE ==========
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas < 1 || estrellas > 5) {
            System.out.println("⚠ Calificación debe estar entre 1 y 5 estrellas");
            return;
        }
        calificaciones.add(estrellas);
        comentarios.add(comentario != null ? comentario : "Sin comentario");
        System.out.println("✓ Calificación agregada: " + estrellas + " estrellas");
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;

        int suma = 0;
        for (int cal : calificaciones) {
            suma += cal;
        }
        return (double) suma / calificaciones.size();
    }

    @Override
    public int obtenerTotalCalificaciones() {
        return calificaciones.size();
    }

    @Override
    public void mostrarCalificaciones() {
        if (calificaciones.isEmpty()) {
            System.out.println("Sin calificaciones aún");
            return;
        }

        System.out.println("\n--- Calificaciones de " + pelicula.getTitulo() + " ---");
        for (int i = 0; i < calificaciones.size(); i++) {
            System.out.println("⭐".repeat(calificaciones.get(i)) + " - " + comentarios.get(i));
        }
        System.out.println("Promedio: " + String.format("%.1f", obtenerPromedioCalificaciones()) + " estrellas");
    }

    // ========== IMPLEMENTACIÓN DE DESCUENTABLE ==========
    @Override
    public boolean esElegibleDescuento() {
        // Premium es elegible si tiene menos del 70% de ocupación
        return asientosReservados < (capacidadMaxima * 0.7);
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        if (!esElegibleDescuento()) {
            System.out.println("⚠ Función no elegible para descuento (alta demanda)");
            return precioBase;
        }

        if (porcentaje < 0 || porcentaje > 100) {
            System.out.println("⚠ Porcentaje inválido");
            return precioBase;
        }

        double descuento = precioBase * (porcentaje / 100);
        return precioBase - descuento;
    }

    @Override
    public double obtenerPrecioBase() {
        return precioBase;
    }

    @Override
    public double calcularAhorro(double porcentaje) {
        if (!esElegibleDescuento()) return 0.0;
        return precioBase * (porcentaje / 100);
    }

    // ========== MÉTODOS PROPIOS ==========
    public void mostrarInfo() {
        System.out.println("\n=== FUNCIÓN PREMIUM ===");
        System.out.println("Película: " + pelicula.getTitulo());
        System.out.println("Sala: " + sala.getNumero());
        System.out.println("Fecha: " + fecha + " | Hora: " + hora);
        System.out.println("Precio: $" + String.format("%,.0f", precioBase));
        System.out.println("Disponibilidad: " + (capacidadMaxima - asientosReservados) + "/" + capacidadMaxima);
        System.out.println("Calificación: " + String.format("%.1f", obtenerPromedioCalificaciones()) +
                " ⭐ (" + obtenerTotalCalificaciones() + " votos)");
    }

    public PeliculaBase getPelicula() { return pelicula; }
}
