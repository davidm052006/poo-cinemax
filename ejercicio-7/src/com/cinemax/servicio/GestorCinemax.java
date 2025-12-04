package com.cinemax.servicio;

import com.cinemax.modelo.*;
import com.cinemax.excepciones.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorCinemax {
    private List<Funcion> funciones;
    private List<String> reservas;

    public GestorCinemax() {
        this.funciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarFuncion(Funcion f) {
        funciones.add(f);
    }

    /**
     * Reserva un boleto con validaciones completas
     */
    public String reservarBoleto(String codigoFuncion, Cliente cliente, double precioPagado)
            throws ReservaInvalidaException, FuncionNoDisponibleException {

        if (cliente == null) {
            throw new ReservaInvalidaException("El cliente no puede ser nulo");
        }
        if (precioPagado <= 0) {
            throw new ReservaInvalidaException("El precio debe ser mayor a 0");
        }
        if (!codigoFuncion.matches("F\\d{3}")) {
            throw new ReservaInvalidaException("Código de función inválido. Debe ser F001, F002, etc.");
        }

        Funcion funcion = funciones.stream()
                .filter(f -> f.getCodigo().equals(codigoFuncion))
                .findFirst()
                .orElseThrow(() -> new ReservaInvalidaException("Función no encontrada: " + codigoFuncion));

        if (funcion.getAsientosDisponibles() <= 0) {
            throw new FuncionNoDisponibleException("No hay asientos disponibles para " + funcion.getPelicula().getTitulo());
        }

        if (funcion.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new FuncionNoDisponibleException("La función ya pasó: " + funcion.getFechaHora());
        }

        // Reserva exitosa
        funcion.ocuparAsiento();
        String codigoReserva = "RES" + (reservas.size() + 1001);
        reservas.add(codigoReserva + ":" + cliente.getNombre());

        System.out.println("RESERVA EXITOSA: " + codigoReserva);
        System.out.println("Cliente: " + cliente);
        System.out.println("Función: " + funcion);
        System.out.println("Precio: $" + String.format("%,.0f", precioPagado));
        return codigoReserva;
    }

    public List<Funcion> getFunciones() { return funciones; }
}