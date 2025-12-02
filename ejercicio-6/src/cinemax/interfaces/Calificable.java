package cinemax.interfaces;

/**
 * Interface que define la capacidad de recibir calificaciones.
 * Aplicable a películas, servicios, experiencias, etc.
 */
public interface Calificable {

    /**
     * Agrega una calificación al elemento
     * @param estrellas Calificación de 1 a 5 estrellas
     * @param comentario Comentario opcional del usuario
     */
    void agregarCalificacion(int estrellas, String comentario);

    /**
     * Obtiene el promedio de todas las calificaciones
     * @return Promedio de estrellas (0.0 a 5.0)
     */
    double obtenerPromedioCalificaciones();

    /**
     * Obtiene el número total de calificaciones recibidas
     * @return Cantidad de calificaciones
     */
    int obtenerTotalCalificaciones();

    /**
     * Muestra todas las calificaciones con comentarios
     */
    void mostrarCalificaciones();
}