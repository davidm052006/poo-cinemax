package com.cinemax.excepciones;

/**
 * Excepción lanzada cuando los datos de la reserva son inválidos.
 */
public class ReservaInvalidaException extends Exception {
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
    public ReservaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}