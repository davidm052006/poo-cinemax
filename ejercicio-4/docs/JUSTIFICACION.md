# Jerarquía de Clases - Semana 04


## Justificación
Elegí esta jerarquía porque en un cine real existen:
- Películas normales (precio estándar)
- Películas en estreno (con recargo de $8.000)

Esto permite:
- Código reutilizable (título, género, duración → en la clase padre)
- Comportamiento diferente según el tipo (polimorfismo)
- Fácil agregar nuevos tipos (PeliculaInfantil, Pelicula3D, etc.)

## Atributos Heredados (protected)
- titulo (String)
- genero (String)
- duracionMinutos (int)

## Métodos Sobrescritos
- getRecargo(): 
  - Normal → 0
  - Estreno → 8000
- mostrarInfo(): cada una muestra su tipo
- getTipo(): devuelve "Normal" o "ESTRENO"

¡Herencia perfecta + polimorfismo real en un cine!
