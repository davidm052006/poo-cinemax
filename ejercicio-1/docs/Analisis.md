# Análisis Orientado a Objetos - CineMax

## 1. Identificación del Dominio

**Nombre del negocio:** CineMax  
**Tipo:** Complejo cinematográfico  
**Descripción:** Cine ubicado en el Centro Comercial Gran Estación (Bogotá) con 8 salas de proyección, tecnología 3D, IMAX, XD y sonido Dolby Atmos. Ofrece estrenos, funciones especiales y venta de confitería.

## 2. Objetos Identificados

### Objeto Principal: Pelicula
**¿Qué es?:** Representa una película que se proyecta en el cine.

**Atributos identificados:**
- codigo: String - identificador único (ej: AVN2025)
- titulo: String - nombre comercial de la película
- genero: String - categoría (Acción, Terror, Animación, etc.)
- duracionMinutos: int - duración en minutos
- precioBoleto: double - precio base del boleto
- esEstreno: boolean - indica si es semana de estreno (precio mayor)
- clasificacionEdad: int - restricción de edad (+0, +7, +13, +18)

**Métodos identificados:**
- mostrarInformacion(): muestra todos los datos de la película
- calcularRecaudacionEstimada(int): calcula ingresos según boletos vendidos
- getTitulo(): devuelve el título
- setEsEstreno(boolean): cambia el estado de estreno

### Objeto Secundario: Sala
**¿Qué es?:** Representa una sala física de proyección del cine.

**Atributos identificados:**
- numeroSala: int - número identificador (1 al 8)
- tipoSala: String - tipo (NORMAL, 3D, IMAX, XD)
- capacidadAsientos: int - cantidad de butacas
- tieneSonidoDolby: boolean - indica si tiene sonido premium
- peliculaActual: String - título de la película en proyección

**Métodos identificados:**
- mostrarInformacionSala(): muestra datos de la sala
- asignarPelicula(String): asigna una película a la sala
- estaDisponible(): verifica si no tiene película asignada

## 3. Relación entre Objetos

**Tipo de relación:** Asociación (bidireccional débil)  
**Descripción:** Una Sala proyecta una Pelicula en un horario determinado. Una Pelicula puede proyectarse en varias Salas simultáneamente (por ejemplo, "Avengers" en Sala 5 IMAX y Sala 7 3D). La Sala necesita conocer el título de la Película actual para informar al público.

## 4. Justificación del Diseño

**¿Por qué elegí estos objetos?**  
La Película es el núcleo del negocio del cine (sin películas no hay función). La Sala es el recurso físico esencial. Son los dos elementos más importantes del dominio.

**¿Por qué estos atributos son importantes?**  
Permiten gestionar precios, restricciones de edad, capacidad, tecnología disponible y programación.

**¿Por qué estos métodos son necesarios?**  
- Calcular recaudación → reportes financieros  
- Asignar película → programación diaria  
- Estado de estreno → ajuste automático de precios  
- Disponibilidad de sala → evitar conflictos de programación

## 5. Comparación: POO vs Programación Estructurada

**Sin POO (Estructurado):**  
Tendríamos arreglos paralelos o structs separados:  
```c
String[] titulos = {"Avengers", "Zootopia 2"};
double[] precios = {35000, 28000};
int[] salasAsignadas = {5, 8};