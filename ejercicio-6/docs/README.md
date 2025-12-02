# Semana 06 - Abstracción (Clases Abstractas + Interfaces)

## 📋 Descripción
Sistema de gestión de cine CineMax con implementación completa de **clases abstractas** e **interfaces** para demostrar los pilares de la Programación Orientada a Objetos.

## 🎯 Objetivos Logrados
- ✅ Creación de 2 clases abstractas (`ClienteBase`, `PeliculaBase`)
- ✅ Implementación de 3 interfaces (`Reservable`, `Calificable`, `Descuentable`)
- ✅ Mínimo 5 clases concretas que heredan/implementan abstracciones
- ✅ Clase con **múltiple implementación de interfaces** (`FuncionPremium`)
- ✅ Demostración de polimorfismo con tipos abstractos
- ✅ Uso de referencias de tipo interface
- ✅ Documento de análisis completo

## 📦 Estructura del Proyecto

```
semana-06/
├── README.md                           # Este archivo
├── ANALISIS.md                         # Documento de diseño
├── Main.java                           # Programa de demostración
│
├── abstractas/                         # Clases abstractas
│   ├── ClienteBase.java               # Define comportamiento común de clientes
│   └── PeliculaBase.java              # (heredada de semana 05)
│
├── interfaces/                         # Interfaces
│   ├── Reservable.java                # Capacidad de hacer reservas
│   ├── Calificable.java               # Capacidad de recibir calificaciones
│   └── Descuentable.java              # Capacidad de aplicar descuentos
│
└── implementaciones/                   # Clases concretas
    ├── ClientePremium.java            # Cliente con membresía premium
    ├── ClienteEstudiante.java         # Cliente con descuento estudiantil
    ├── ClienteNormal.java             # Cliente regular sin membresía
    ├── FuncionPremium.java            # Implementa 3 interfaces
    └── ComboSnacks.java               # Implementa Descuentable
```

## 🏗️ Arquitectura

### Clases Abstractas

#### 1. `ClienteBase` (abstracta)
Define el comportamiento común de todos los clientes del cine.

**Atributos protegidos:**
- `nombre`, `documento`, `edad`, `puntosAcumulados`

**Métodos concretos:**
- `acumularPuntos(montoCompra)` - Suma puntos por compra
- `mostrarInfo()` - Muestra información del cliente
- `puedeCanjearPuntos()` - Verifica si puede canjear
- `canjearPuntos()` - Redime puntos

**Métodos abstractos:**
- `calcularDescuento(precioBase)` - Cada tipo calcula distinto
- `getTipoCliente()` - Retorna el tipo de cliente
- `tieneBeneficios()` - Indica si tiene beneficios especiales

**Subclases concretas:**
- `ClientePremium` → 20% descuento, doble puntos
- `ClienteEstudiante` → 30% descuento con carnet
- `ClienteNormal` → 5% descuento tras 5 compras

#### 2. `PeliculaBase` (abstracta)
Heredada de semana 05, define el comportamiento de películas.

**Subclases:**
- `PeliculaEstreno` → Recargo $8,000
- `PeliculaNormal` → Sin recargo

---

### Interfaces

#### 1. `Reservable`
Define la capacidad de gestionar reservas.

**Métodos:**
```java
boolean verificarDisponibilidad(String fecha, String hora)
String realizarReserva(String cliente, String fecha, String hora)
boolean cancelarReserva(String codigoReserva)
String obtenerCodigoReserva()
```

**Implementada por:** `FuncionPremium`

#### 2. `Calificable`
Define la capacidad de recibir calificaciones de usuarios.

**Métodos:**
```java
void agregarCalificacion(int estrellas, String comentario)
double obtenerPromedioCalificaciones()
int obtenerTotalCalificaciones()
void mostrarCalificaciones()
```

**Implementada por:** `FuncionPremium`

#### 3. `Descuentable`
Define la capacidad de aplicar descuentos.

**Métodos:**
```java
boolean esElegibleDescuento()
double aplicarDescuento(double porcentaje)
double obtenerPrecioBase()
double calcularAhorro(double porcentaje)
```

**Implementada por:** `FuncionPremium`, `ComboSnacks`

---

### Clases Concretas

#### `FuncionPremium` (⭐ Múltiple Implementación)
Representa funciones especiales con capacidad limitada.

**Implementa 3 interfaces:**
- ✅ `Reservable` - Permite hacer reservas
- ✅ `Calificable` - Permite calificar experiencia
- ✅ `Descuentable` - Aplica descuentos por baja ocupación

**Ejemplo de uso:**
```java
FuncionPremium funcion = new FuncionPremium(pelicula, sala, "2025-12-15", "20:00", 35000);

// Como Reservable
Reservable r = funcion;
String codigo = r.realizarReserva("Ana García", "2025-12-15", "20:00");

// Como Calificable
Calificable c = funcion;
c.agregarCalificacion(5, "Excelente");

// Como Descuentable
Descuentable d = funcion;
double precio = d.aplicarDescuento(20);
```

#### `ComboSnacks`
Productos de confitería con capacidad de descuento.

**Implementa:** `Descuentable`

---

## 🚀 Cómo Ejecutar

### Requisitos
- Java JDK 8 o superior
- IDE (Eclipse, IntelliJ, NetBeans) o terminal

### Compilación
```bash
# Desde la carpeta semana-06/
javac -d bin cinemax/*.java cinemax/abstractas/*.java cinemax/interfaces/*.java cinemax/implementaciones/*.java
```

### Ejecución
```bash
java -cp bin cinemax.Main
```

---

## 📊 Salida Esperada

El programa demuestra:

1. **Polimorfismo con ClienteBase**
   - Array de tipo abstracto con diferentes tipos de clientes
   - Cada uno calcula descuento diferente

2. **Polimorfismo con PeliculaBase**
   - Cartelera con diferentes tipos de películas
   - Recargos diferentes según tipo

3. **Interface Reservable**
   - Verificación de disponibilidad
   - Creación de reservas con código único
   - Validación de fechas

4. **Interface Calificable**
   - Agregar múltiples calificaciones
   - Cálculo de promedio
   - Mostrar comentarios

5. **Interface Descuentable**
   - Verificación de elegibilidad
   - Aplicación de descuentos
   - Cálculo de ahorro

6. **Múltiple Implementación**
   - FuncionPremium usando las 3 interfaces simultáneamente

---

## 🎓 Conceptos Aplicados

### Clase Abstracta vs Interface

| Aspecto | Clase Abstracta | Interface |
|---------|----------------|-----------|
| Herencia | Solo una | Múltiples |
| Estado | Puede tener atributos | Solo constantes |
| Implementación | Puede tener métodos concretos | Solo firma (Java 7) |
| Relación | "es-un" | "puede-hacer" |
| Uso | Jerarquía clara | Capacidades cruzadas |

### Principios SOLID Aplicados

- ✅ **SRP**: Cada clase tiene una responsabilidad
- ✅ **OCP**: Abierto a extensión, cerrado a modificación
- ✅ **LSP**: Subclases sustituyen a superclase
- ✅ **ISP**: Interfaces específicas y cohesivas
- ✅ **DIP**: Dependemos de abstracciones

---

## 🔍 Diferencias con Semana 05

| Aspecto | Semana 05 | Semana 06 |
|---------|-----------|-----------|
| Clientes | Un solo tipo básico | 3 tipos con jerarquía abstracta |
| Descuentos | Solo por edad | Polimórfico por tipo de cliente |
| Reservas | No existía | Sistema completo con interface |
| Calificaciones | No existía | Sistema con interface |
| Múltiple herencia | No | Sí, mediante interfaces |

---

## 📖 Documentación Adicional

Para más detalles sobre las decisiones de diseño, consulta:
- **[ANALISIS.md](./ANALISIS.md)** - Análisis completo de arquitectura

---

## 👨‍💻 Autor
**[Tu Nombre]**  
Bootcamp OOP - Semana 06  
Fecha: Diciembre 2025

---

## 📝 Notas de Implementación

### ¿Por qué ClienteBase es abstracta?
- Todos los clientes comparten estado (nombre, puntos)
- Hay comportamiento común (acumular puntos, mostrar info)
- El descuento varía según el tipo (método abstracto)

### ¿Por qué usar interfaces para capacidades?
- Una función puede ser Reservable + Calificable + Descuentable
- Clases no relacionadas pueden ser Descuentable (FuncionPremium y ComboSnacks)
- Permite polimorfismo sin herencia

### Ventajas del diseño actual
1. Fácil agregar nuevos tipos de clientes
2. Fácil agregar nuevas capacidades (interfaces)
3. Código reutilizable y mantenible
4. Respeta principios SOLID
5. Flexible para cambios futuros