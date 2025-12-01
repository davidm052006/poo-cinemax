package cinemax;

public class Cliente {
    private String nombre;
    private String documento;
    private String email;
    private int edad;

    // Constructor completo
    public Cliente(String nombre, String documento, String email, int edad) {
        setNombre(nombre);
        setDocumento(documento);
        setEmail(email);
        setEdad(edad);
    }

    // Constructor básico (solo nombre y documento)
    public Cliente(String nombre, String documento) {
        this(nombre, documento, nombre.toLowerCase().replace(" ", "") + "@cinemax.com", 18);
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getEmail() { return email; }
    public int getEdad() { return edad; }

    // Setters con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es obligatorio");
        this.nombre = nombre.trim();
    }

    public void setDocumento(String documento) {
        if (documento == null || !documento.matches("\\d{6,10}"))
            throw new IllegalArgumentException("Documento inválido (solo números, 6-10 dígitos)");
        this.documento = documento;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains("."))
            throw new IllegalArgumentException("Email inválido");
        this.email = email.toLowerCase().trim();
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 120)
            throw new IllegalArgumentException("Edad debe estar entre 0 y 120 años");
        this.edad = edad;
    }

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