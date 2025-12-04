package com.cinemax.excepciones;

/**
 * Excepción lanzada cuando no hay cupo en la función.
 */
public class FuncionNoDisponibleException extends Exception {
    public FuncionNoDisponibleException(String mensaje) {
        super(mensaje);
    }
    public FuncionNoDisponibleException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}