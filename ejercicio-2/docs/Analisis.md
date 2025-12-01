


# Análisis Técnico - Semana 2 CineMax

## Conceptos de POO aplicados correctamente

1. **Encapsulamiento**
   - Todos los atributos `private`
   - Acceso solo mediante getters/setters o métodos controlados

2. **Relaciones entre objetos**
   - `Boleto` → Composición fuerte con `Cliente`, `Pelicula` y `Sala`
   - `Cine` → Agregación con colección de `Boleto`

3. **Colecciones dinámicas**
   - Uso correcto de `ArrayList<Boleto>`
   - Tipo genérico parametrizado (type-safe)

4. **Métodos de negocio reales**
   - Cálculo automático de precios con reglas comerciales
   - Descuentos por edad
   - Formato de moneda colombiana

5. **Separación de responsabilidades**
   - `Boleto` sabe imprimirse solo
   - `Cine` solo administra la colección y hace reportes
   - `Main` solo orquesta la demostración

6. **Polimorfismo implícito**
   - Todos los boletos se tratan como `Boleto` aunque tengan datos diferentes


