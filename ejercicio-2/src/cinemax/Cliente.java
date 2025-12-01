package cinemax;


public class Cliente {
    private String nombre;
    private String documento;
    private String email;
    private int edad;

    public Cliente(String nombre, String documento, String email, int edad) {
        this.nombre = nombre;
        this.documento = documento;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDocumento() { return documento; }
    public String getEmail() { return email; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String clasificarEdad() {
        if (edad >= 18) return "Adulto";
        else if (edad >= 12) return "Adolescente";
        else return "Niño";
    }

    @Override
    public String toString() {
        return nombre + " (" + documento + ") - " + clasificarEdad();
    }
}