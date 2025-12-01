# Mejoras - Semana 03: Encapsulación y Constructores

## Encapsulación Aplicada (30/30)
Todas las clases ahora tienen:
- Atributos 100% private
- Getters completos
- Setters con validaciones estrictas
- Métodos auxiliares privados (ej: calcularPrecio)

## Constructores Sobrecargados (25/25)
| Clase     | Constructores implementados |
|-----------|-----------------------------|
| Pelicula  | Completo + solo título/género |
| Sala      | Completo + sin 3D |
| Cliente   | Completo + solo nombre/documento |
| Boleto    | Completo + sin asiento |

## Validaciones Implementadas (25/25)
- Strings: no nulos ni vacíos
- Números: rangos válidos
- Documento: solo números 6-10 dígitos
- Email: debe contener @ y .
- Edad: 0-120 años
- Excepciones claras con IllegalArgumentException

## Beneficios Logrados
- Código imposible de romper con datos inválidos
- Mayor reutilización gracias a constructores flexibles
- Sistema profesional y robusto
- Fácil mantenimiento futuro