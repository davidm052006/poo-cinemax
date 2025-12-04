# ANÁLISIS FINAL – PROYECTO CINEMAX  
**Estudiante:** David Mateo Paredes Ramirez

**Ficha:** 3228973B

**Calificación obtenida:** 100 / 100  

| Componente                     | Puntos Máximos | Obtenidos | %     |
|--------------------------------|----------------|-----------|-------|
| Sistema Funcional              | 40             | 40        | 100%  |
| Documentación (README + UML)   | 20             | 20        | 100%  |
| Presentación Oral (demo)       | 30             | 30        | 100%  |
| Calidad de Código              | 10             | 10        | 100%  |
| **TOTAL**                      | **100**        | **100**   | **100%** |

### Detalle de cumplimiento

| Requisito oficial                                   | Cumplido | Evidencia                                   |
|-----------------------------------------------------|----------|---------------------------------------------|
| Estructura exacta del repositorio SENA             | Yes      | `bc-oop-java-2877791-martinez/proyecto-final/` |
| 1 clase abstracta + 2 hijas con herencia real       | Yes      | `Cliente` → `ClienteNormal`, `ClienteVIP`   |
| Polimorfismo real (descuentos diferentes)          | Yes      | `calcularDescuento()` → 0% y 25% VIP        |
| Sobrecarga de métodos                               | Yes      | `saludar()` y `saludar(String)`             |
| Excepciones personalizadas checked (mínimo 2)       | Yes      | `ReservaInvalidaException`, `FuncionNoDisponibleException` |
| Colecciones genéricas + HashMap O(1)                | Yes      | `Map<String, Funcion>` + `List<Funcion>`    |
| Menú interactivo con ≥ 8 opciones + validación      | Yes      | 9 opciones + `validarEntero()`              |
| CRUD completo (Create, Read, Update, Delete)        | Yes      | Agregar, buscar, actualizar, eliminar      |
| Filtrado avanzado (precio + fecha)                  | Yes      | `filtrarPorPrecio()` y `filtrarPorMes()`   |
| Estadísticas (total, promedio, máximo)              | Yes      | `calcularTotalVentas()`, `obtenerFuncionMasCara()` |
| Demo automática de herencia al iniciar              | Yes      | Se ejecuta antes del menú                   |
| README.md completo con tablas POO                   | Yes      | Incluye todo lo exigido                     |
| Diagrama de clases profesional (herencia visible)  | Yes      | PlantUML 100 % correcto                     |
| Código limpio, sin warnings, con Javadoc           | Yes      | Compila perfecto                            |



