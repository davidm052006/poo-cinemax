package com.cinemax.modelo;

public abstract class Cliente {
    private String documento;
    private String nombre;
    private int edad;
    private TipoCliente tipo;

    public Cliente(String documento, String nombre, int edad, TipoCliente tipo) {
        if (documento == null || documento.trim().isEmpty())
            throw new IllegalArgumentException("El documento es obligatorio");
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio");
        if (edad < 0 || edad > 120)
            throw new IllegalArgumentException("Edad inválida");

        this.documento = documento;
        this.nombre = nombre;
        this.edad = edad;
        this.tipo = tipo;
    }

    // Getters
    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public TipoCliente getTipo() { return tipo; }

    // Método abstracto → POLIMORFISMO
    public abstract double calcularDescuento(double precioBase);

    // Sobrecarga de método
    public String saludar() {
        return "Hola, soy " + nombre + " (" + tipo.getDescripcion() + ")";
    }

    public String saludar(String mensaje) {
        return mensaje + ", " + nombre + "!";
    }

    @Override
    public String toString() {
        return nombre + " | " + tipo.getDescripcion() + " | Edad: " + edad;
    }
}