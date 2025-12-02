package cinemax.interfaces;

/**
 * Interface que define la capacidad de ser reservado.
 * Aplicable a servicios que requieren reservación previa.
 */
public interface Reservable {

    /**
     * Verifica si hay disponibilidad para la fecha/hora solicitada
     * @param fecha Fecha en formato YYYY-MM-DD
     * @param hora Hora en formato HH:MM
     * @return true si hay disponibilidad
     */
    boolean verificarDisponibilidad(String fecha, String hora);

    /**
     * Realiza una reserva
     * @param cliente Nombre del cliente
     * @param fecha Fecha de la reserva
     * @param hora Hora de la reserva
     * @return Código de reserva generado
     */
    String realizarReserva(String cliente, String fecha, String hora);

    /**
     * Cancela una reserva existente
     * @param codigoReserva Código de la reserva a cancelar
     * @return true si se canceló exitosamente
     */
    boolean cancelarReserva(String codigoReserva);

    /**
     * Obtiene el código de la última reserva realizada
     * @return Código de reserva
     */
    String obtenerCodigoReserva();
}