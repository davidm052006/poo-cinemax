package cinemax.abstractas;

/**
 * Clase abstracta que representa diferentes tipos de clientes del cine.
 * Define comportamiento común y métodos abstractos para descuentos específicos.
 */
public abstract class ClienteBase {

    protected String nombre;
    protected String documento;
    protected int edad;
    protected int puntosAcumulados;

    public ClienteBase(String nombre, String documento, int edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.puntosAcumulados = 0;
    }

    // ========== MÉTODOS CONCRETOS (compartidos) ==========

    /**
     * Acumula puntos por cada compra
     */
    public void acumularPuntos(double montoCompra) {
        int puntosGanados = (int)(montoCompra / 1000); // 1 punto por cada $1000
        puntosAcumulados += puntosGanados;
        System.out.println("✓ " + nombre + " ganó " + puntosGanados + " puntos");
    }

    /**
     * Muestra información básica del cliente
     */
    public void mostrarInfo() {
        System.out.println("Cliente: " + nombre);
        System.out.println("Tipo: " + getTipoCliente());
        System.out.println("Edad: " + edad);
        System.out.println("Puntos: " + puntosAcumulados);
    }

    /**
     * Verifica si el cliente puede canjear puntos
     */
    public boolean puedeCanjearPuntos(int puntosNecesarios) {
        return puntosAcumulados >= puntosNecesarios;
    }

    /**
     * Canjea puntos por descuento
     */
    public boolean canjearPuntos(int puntos) {
        if (puedeCanjearPuntos(puntos)) {
            puntosAcumulados -= puntos;
            System.out.println("✓ " + puntos + " puntos canjeados");
            return true;
        }
        System.out.println("⚠ Puntos insuficientes");
        return false;
    }

    // ========== MÉTODOS ABSTRACTOS (implementación variable) ==========

    /**
     * Calcula el descuento aplicable según el tipo de cliente
     * @param precioBase Precio original del boleto
     * @return Precio con descuento aplicado
     */
    public abstract double calcularDescuento(double precioBase);

    /**
     * Retorna el tipo de cliente (Normal, Premium, Estudiante, etc.)
     * @return Tipo de cliente
     */
    public abstract String getTipoCliente();

    /**
     * Indica si el cliente tiene beneficios especiales
     * @return true si tiene beneficios adicionales
     */
    public abstract boolean tieneBeneficios();

    // ========== GETTERS ==========
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public int getPuntosAcumulados() { return puntosAcumulados; }
}