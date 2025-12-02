package cinemax.interfaces;

/**
 * Interface que define la capacidad de aplicar descuentos.
 * Aplicable a productos, servicios o promociones.
 */
public interface Descuentable {

    /**
     * Verifica si el elemento es elegible para descuento
     * @return true si se puede aplicar descuento
     */
    boolean esElegibleDescuento();

    /**
     * Aplica un porcentaje de descuento
     * @param porcentaje Porcentaje de descuento (0-100)
     * @return Precio con descuento aplicado
     */
    double aplicarDescuento(double porcentaje);

    /**
     * Obtiene el precio original sin descuentos
     * @return Precio base
     */
    double obtenerPrecioBase();

    /**
     * Calcula el monto ahorrado con el descuento
     * @param porcentaje Porcentaje de descuento aplicado
     * @return Cantidad ahorrada
     */
    double calcularAhorro(double porcentaje);
}