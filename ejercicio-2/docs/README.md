# Semana 2 - CineMax (Programación Orientada a Objetos)


## Ejercicios completados al 100 %

| Ejercicio | Descripción                                   | Puntos | Estado |
|-----------|-----------------------------------------------|--------|--------|
| 1         | 2 nuevas clases (`Cliente` y `Boleto`)        | 30     | Done   |
| 2         | Relaciones composición/agregación             | 25     | Done   |
| 3         | Clase gestora `Cine` con `ArrayList<Boleto>`  | 20     | Done   |
| 4         | `Main.java` completo y funcional              | 25     | Done   |

**Total: 100/100**

## Nuevas clases creadas esta semana

### Cliente.java
- Atributos: nombre, documento, email, edad  
- Método de negocio: `clasificarEdad()` → Niño / Adolescente / Adulto  
- Descuento automático del 50 % para menores de 12 años

### Boleto.java
- Relaciones fuertes con: `Cliente`, `Pelicula`, `Sala`
- Calcula precio automáticamente:
  - Base: $15.000
  - +$8.000 si es estreno
  - +$10.000 si es 3D
  - 50 % descuento para niños
- Método `imprimirBoleto()` → salida bonita en consola

### Cine.java (clase gestora)
- Usa `ArrayList<Boleto>` para almacenar todos los boletos vendidos
- Métodos importantes:
  - `venderBoleto()` → agrega y muestra el ticket
  - `mostrarRecaudacionTotal()` → suma todo el dinero del día
  - `mostrarTodosLosBoletos()` → lista detallada de ventas
  - `totalBoletos()` → cantidad vendida

