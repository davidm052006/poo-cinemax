Análisis de Diseño - Semana 06: Sistema de Cine CineMax
1. Identificación de Abstracciones
Clase Abstracta 1: PeliculaBase
¿Por qué es abstracta?

Representa el concepto general de "película" que todas las películas comparten
Tiene atributos comunes: título, género, duración
Define comportamiento concreto compartido (mostrarInfo())
Tiene comportamiento que varía según el tipo: el recargo es diferente para estrenos vs películas normales

Jerarquía:
PeliculaBase (abstracta)
├── PeliculaEstreno (recargo: $8,000)
└── PeliculaNormal (recargo: $0)
Clase Abstracta 2: ClienteBase
¿Por qué es abstracta?

Representa el concepto general de "cliente del cine"
Todos los clientes tienen: nombre, documento, edad, puntos
Comportamiento común: acumular puntos, mostrar info básica, canjear puntos
Comportamiento variable: el descuento cambia según el tipo de cliente (Premium 20%, Estudiante 30%, Normal 5%)

Jerarquía:
ClienteBase (abstracta)
├── ClientePremium (descuento fijo 20%, doble puntos)
├── ClienteEstudiante (descuento 30%, requiere carnet)
└── ClienteNormal (descuento 5% solo tras 5 compras)

2. Interfaces Implementadas
Interface 1: Reservable
Capacidad que define: Habilidad de hacer, verificar y cancelar reservas
Métodos:

verificarDisponibilidad(fecha, hora) → Consulta disponibilidad
realizarReserva(cliente, fecha, hora) → Crea una reserva
cancelarReserva(codigo) → Cancela reserva existente
obtenerCodigoReserva() → Devuelve código de última reserva

Clases que la implementan:

FuncionPremium: Tiene sentido porque las funciones premium requieren reserva previa debido a su capacidad limitada (50 asientos)

Interface 2: Calificable
Capacidad que define: Habilidad de recibir y gestionar calificaciones de usuarios
Métodos:

agregarCalificacion(estrellas, comentario) → Registra opinión
obtenerPromedioCalificaciones() → Calcula promedio
obtenerTotalCalificaciones() → Cuenta votos
mostrarCalificaciones() → Despliega todas las opiniones

Clases que la implementan:

FuncionPremium: Los usuarios pueden calificar su experiencia en funciones especiales

Interface 3: Descuentable
Capacidad que define: Habilidad de aplicar y calcular descuentos
Métodos:

esElegibleDescuento() → Verifica si aplica descuento
aplicarDescuento(porcentaje) → Calcula precio con descuento
obtenerPrecioBase() → Devuelve precio original
calcularAhorro(porcentaje) → Muestra cuánto se ahorra

Clases que la implementan:

FuncionPremium: Puede tener descuentos si hay baja ocupación
ComboSnacks: Los combos de comida pueden tener promociones


3. Decisiones de Diseño
¿Por qué Clase Abstracta vs Interface?
Elegí clase abstracta para ClienteBase y PeliculaBase porque:

✅ Hay una relación "es-un" clara (ClientePremium ES UN Cliente)
✅ Necesitaba compartir estado (atributos como nombre, puntosAcumulados)
✅ Había comportamiento común que podía implementar una sola vez (mostrarInfo(), acumularPuntos())
✅ Solo se necesita herencia simple (un cliente es de un solo tipo)

Elegí interfaces para Reservable, Calificable, Descuentable porque:

✅ Definen capacidades independientes de la jerarquía de clases
✅ Una clase puede tener múltiples capacidades (FuncionPremium es Reservable + Calificable + Descuentable)
✅ No necesitan compartir estado, solo definen contratos (qué hacer, no cómo)
✅ Clases no relacionadas pueden implementar la misma interface (FuncionPremium y ComboSnacks ambos son Descuentable)


4. Principios SOLID Aplicados
Single Responsibility Principle (SRP) ✓
Cada clase tiene una sola razón para cambiar:

ClienteBase → gestiona información de clientes
PeliculaBase → gestiona información de películas
FuncionPremium → gestiona funciones especiales
ComboSnacks → gestiona productos de confitería

Open/Closed Principle (OCP) ✓
El sistema está abierto a extensión, cerrado a modificación:

Puedo agregar ClienteAdultoMayor sin modificar ClienteBase
Puedo agregar PeliculaClasica sin tocar el código existente
Las interfaces permiten agregar nuevas capacidades sin romper código

Liskov Substitution Principle (LSP) ✓
Las subclases pueden sustituir perfectamente a sus clases abstractas:
javaClienteBase cliente = new ClientePremium(...);
cliente.calcularDescuento(25000); // Funciona sin problemas

PeliculaBase pelicula = new PeliculaEstreno(...);
pelicula.getRecargo(); // Funciona correctamente
Interface Segregation Principle (ISP) ✓
Las interfaces son específicas y cohesivas:

Reservable → solo métodos de reservas (4 métodos relacionados)
Calificable → solo métodos de calificaciones (4 métodos relacionados)
Descuentable → solo métodos de descuentos (4 métodos relacionados)
Ninguna clase está obligada a implementar métodos que no necesita

Dependency Inversion Principle (DIP) ✓
Dependemos de abstracciones, no de implementaciones concretas:
java// Usando tipo abstracto, no concreto
ClienteBase[] clientes = new ClienteBase[3];
clientes[0] = new ClientePremium(...);

// Usando tipo interface
Reservable servicio = funcionPremium;
servicio.realizarReserva(...);

5. Mejoras Logradas
Antes (Semana 05):

Solo existía una clase Cliente básica sin diferenciación
No había forma de aplicar descuentos específicos por tipo
No existía sistema de reservas
No se podían calificar funciones
El código era menos flexible y extensible

Después (Semana 06):

✅ 3 tipos de clientes con beneficios distintos
✅ Sistema de descuentos polimórfico (cada cliente calcula diferente)
✅ Sistema completo de reservas con códigos únicos
✅ Sistema de calificaciones con promedio y comentarios
✅ Múltiple implementación de interfaces en una sola clase
✅ Mayor flexibilidad: fácil agregar nuevos tipos sin tocar código existente

Ventajas del nuevo diseño:

Extensibilidad: Agregar un ClienteAdultoMayor es trivial
Reutilización: Las interfaces pueden usarse en clases futuras
Mantenibilidad: Cada clase tiene responsabilidad clara
Polimorfismo real: Arrays de tipos abstractos, referencias de interfaces
Testabilidad: Puedo probar cada interface independientemente


6. Diagrama de Clases
        <<abstract>>
       PeliculaBase
            |
    +-------+-------+
    |               |
PeliculaEstreno  PeliculaNormal


        <<abstract>>
        ClienteBase
            |
    +-------+-------+-------+
    |               |       |
ClientePremium  Estudiante  Normal


    <<interface>>          <<interface>>          <<interface>>
     Reservable             Calificable           Descuentable
         |                      |                      |
         +----------+-----------+----------------------+
                    |                                  |
              FuncionPremium                     ComboSnacks
         (implementa las 3)                  (implementa solo
                                               Descuentable)

7. Desafíos y Soluciones
Desafío 1: ¿Hacer Cliente abstracto o usar interfaces?
Problema: No estaba claro si Cliente debía ser abstracta o usar interfaces
Solución:

Analicé que los clientes comparten estado (nombre, puntos, edad)
Decidí usar clase abstracta porque hay herencia clara
Reservé interfaces para capacidades que cruzan jerarquías

Desafío 2: FuncionPremium implementa 3 interfaces
Problema: ¿Es demasiado? ¿Viola Single Responsibility?
Solución:

No viola SRP porque su responsabilidad es "gestionar funciones premium"
Las 3 interfaces son capacidades que naturalmente tiene una función premium
Reservable, Calificable y Descuentable son aspectos cohesivos de una función especial

Desafío 3: Mantener compatibilidad con código de Semana 05
Problema: No quería romper el código existente
Solución:

Mantuve PeliculaBase igual (ya era abstracta)
Creé nueva clase ClienteBase sin tocar la vieja Cliente
El código viejo sigue funcionando, el nuevo agrega capacidades


8. Próximos Pasos
Mejoras futuras:

Persistencia: Guardar reservas y clientes en base de datos
Sistema de horarios: Crear clase Funcion con horarios específicos
Pago online: Interface Pagable con métodos de pago
Notificaciones: Interface Notificable para enviar confirmaciones
Inventario: Controlar stock de ComboSnacks
Reportes: Generar estadísticas de ventas por tipo de cliente
Membresías: Sistema de renovación automática para ClientePremium

Posibles nuevas clases:

ClienteAdultoMayor extends ClienteBase (descuento especial)
PeliculaClasica extends PeliculaBase (recargo negativo = descuento)
SalaVIP extends Sala (con servicios adicionales)
Promocion implements Descuentable (2x1, happy hour, etc.)


9. Conclusión
La implementación de abstracción mediante clases abstractas e interfaces ha mejorado significativamente la arquitectura del sistema CineMax:

Código más limpio y organizado
Mayor flexibilidad para cambios futuros
Reutilización real de código
Polimorfismo aplicado correctamente
Principios SOLID respetados

El sistema ahora está preparado para escalar y agregar nuevas funcionalidades sin modificar código existente.