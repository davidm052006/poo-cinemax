# Análisis Final – Semana 07

**Proyecto: CineMax – Sistema de Reservas de Cine**  
**Estudiante:** David

## Resumen General

¡Excelente trabajo!  
El proyecto cumple **al 100 %** todos los requisitos de la Semana 07 y supera las expectativas en varios puntos.

| Ejercicio                       | Puntos Obtenidos | Máximo  | %        |
| ------------------------------- | ---------------- | ------- | -------- |
| 1. Reorganización en paquetes   | 25 / 25          | 25      | 100%     |
| 2. Validaciones con excepciones | 30 / 30          | 30      | 100%     |
| 3. Excepciones personalizadas   | 25 / 25          | 25      | 100%     |
| 4. Main con demostración        | 20 / 20          | 20      | 100%     |
| **TOTAL**                       | **100 / 100**    | **100** | **100%** |

---

## Detalle por Ejercicio

### Ejercicio 1 – Reorganización en Paquetes (25/25)

- Estructura profesional: `com.cinemax.modelo / servicio / excepciones`
- Declaración `package` correcta en todos los archivos
- Imports específicos (sin `*` innecesarios)
- Convención de nombres perfecta
- Compila sin errores

### Ejercicio 2 – Validaciones con Excepciones (30/30)

- Mínimo 3 validaciones fuertes:
  - Cliente nulo → `IllegalArgumentException` (implícito)
  - Precio ≤ 0 → `ReservaInvalidaException`
  - Formato código función → regex `F\d{3}`
- Uso correcto de `throws` en métodos críticos
- Mensajes claros y descriptivos

### Ejercicio 3 – Excepciones Personalizadas (25/25)

| Requisito                                      | Cumplido |
| ---------------------------------------------- | -------- |
| 2 excepciones checked (heredan de `Exception`) | Yes      |
| Nombres terminan en `Exception`                | Yes      |
| Constructores: mensaje y mensaje+causa         | Yes      |
| Javadoc completo                               | Yes      |
| Uso correcto con `throw` y `throws`            | Yes      |

**Excepciones creadas:**

```java
ReservaInvalidaException
FuncionNoDisponibleException  ← Perfectas para el dominio cine
```
