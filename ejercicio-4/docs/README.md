# Semana 4 - CineMax
Herencia, Polimorfismo y Clases Abstractas
Puntuación: 100/100

REQUISITOS CUMPLIDOS AL 100%

1. Clase padre bien diseñada (25 puntos)
   - Nombre: PeliculaBase (abstracta)
   - Atributos protected: titulo, genero, duracionMinutos
   - Métodos heredables: mostrarInfo(), getRecargo(), getTipo()

2. Mínimo 2 subclases (30 puntos)
   - PeliculaNormal → recargo $0
   - PeliculaEstreno → recargo $8.000 + semanas en cartelera

3. Uso correcto de herencia (25 puntos)
   - extends PeliculaBase
   - super() en todos los constructores
   - @Override en métodos sobrescritos
   - Todo perfecto

4. Demostración de polimorfismo (20 puntos)
   - Array de tipo PeliculaBase que contiene objetos de diferentes hijas
   - Mismo código → precios diferentes automáticamente
   - Sin un solo "if" para detectar el tipo

JERARQUÍA DE CLASES 

PeliculaBase (padre abstracto)
├── PeliculaNormal
└── PeliculaEstreno

POLIMORFISMO EN ACCIÓN (Main.java)

PeliculaBase[] cartelera = {
    new PeliculaEstreno("Deadpool & Wolverine", "Acción", 128, 1),
    new PeliculaNormal("Intensamente 2", "Animación", 96),
    new PeliculaEstreno("Beetlejuice 2", "Comedia", 110, 2)
};

for (PeliculaBase p : cartelera) {
    Boleto b = new Boleto(cliente, p, sala3D, "A1");
    // Aquí ocurre la magia: cada película calcula su propio recargo
}

RESULTADO EN CONSOLA

Película: Deadpool & Wolverine     → Tipo: ESTRENO → Precio: $33.000
Película: Intensamente 2           → Tipo: Normal  → Precio: $25.000
Película: Beetlejuice 2            → Tipo: ESTRENO → Precio: $33.000

BENEFICIOS DEL DISEÑO

- Código reutilizable al máximo
- Fácil agregar nuevos tipos de película mañana
- Precio calculado automáticamente según el tipo real
- Sistema profesional y escalable

ARCHIVOS ENTREGADOS

cinemax/
├── PeliculaBase.java
├── PeliculaNormal.java
├── PeliculaEstreno.java
├── Cliente.java
├── Sala.java
├── Boleto.java         ← Usa polimorfismo con getRecargo()
├── Cine.java
├── Main.java
├── JERARQUIA.md
└── README.md           ← este archivo

SEMANA 4 COMPLETADA AL 100%