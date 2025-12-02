package cinemax.implementaciones;

import cinemax.abstractas.ClienteBase;

/**
 * Cliente estudiante - tiene descuentos especiales ciertos días
 */
public class ClienteEstudiante extends ClienteBase {

    private String institucion;
    private String carnet;

    public ClienteEstudiante(String nombre, String documento, int edad, String institucion, String carnet) {
        super(nombre, documento, edad);
        this.institucion = institucion;
        this.carnet = carnet;
    }

    @Override
    public double calcularDescuento(double precioBase) {
        // 30% de descuento para estudiantes
        double descuento = precioBase * 0.30;
        System.out.println("🎓 Descuento Estudiante (30%): -$" + String.format("%,.0f", descuento));
        return precioBase - descuento;
    }

    @Override
    public String getTipoCliente() {
        return "ESTUDIANTE 🎓";
    }

    @Override
    public boolean tieneBeneficios() {
        // Solo tiene beneficios si es menor de 25 años
        return edad < 25;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Institución: " + institucion);
        System.out.println("Carnet: " + carnet);
        System.out.println("Descuento activo: " + (tieneBeneficios() ? "Sí" : "No (>25 años)"));
    }
}