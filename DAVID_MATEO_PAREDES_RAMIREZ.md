# Semana 01 - Introducción al Paradigma Orientado a Objetos

**Estudiante:** David Mateo Paredes Ramirez  
**Ficha:** 3228973B  
**Dominio Asignado:** Cine "CineMax"

---

## 📋 Contexto del Dominio

**Tipo de Negocio:** Complejo de Cine  
**Nombre Comercial:** CineMax  
**Ubicación:** Bogotá, Centro Comercial Gran Estación  
**Especialidad:** Proyección de películas, venta de boletos y confitería

### Descripción Breve
CineMax es un complejo de cines con 8 salas, tecnología 3D y sonido Dolby Atmos. Ofrece películas de estreno, funciones especiales y venta de combos de confitería. Cuenta con 20 empleados y atiende aproximadamente 1500 espectadores al día.

---

## 🎯 Objetivos de la Semana 01

Al finalizar esta semana, deberás ser capaz de:

1. Identificar objetos del mundo real en el contexto de un cine
2. Comprender las diferencias entre programación estructurada y POO
3. Reconocer los conceptos fundamentales: clase, objeto, atributo, método
4. Crear tu primera clase simple en Java aplicada al dominio

---

## 📝 Actividades Obligatorias

### Actividad 1: Identificación de Objetos (Ejercicio 01)

**Instrucciones:**
- Lee el material teórico de la semana sobre conceptos fundamentales de POO
- Identifica **5 objetos principales** que existen en un cine
- Para cada objeto, describe:
  - ¿Qué es? (definición)
  - ¿Qué características tiene? (atributos)
  - ¿Qué puede hacer? (comportamientos/métodos)

**Ejemplo:**
```
Objeto: Película
- ¿Qué es?: Una producción cinematográfica en cartelera
- Características: título, director, género, duración, clasificación, idioma
- Comportamientos: obtener horarios, verificar disponibilidad, calcular precio entrada
```

**Entregable:** Documento con la identificación de 5 objetos del dominio del cine.

---

### Actividad 2: Comparación de Paradigmas (Ejercicio 02)

**Instrucciones:**
- Investiga las diferencias entre programación estructurada y POO
- Escribe un ejemplo conceptual de cómo se manejaría la información de una película en:
  1. **Programación estructurada** (usando variables sueltas y funciones)
  2. **Programación orientada a objetos** (usando una clase)

**Entregable:** Documento comparativo con ejemplos explicados.

---

### Actividad 3: Primera Clase Simple (Ejercicio 03)

**Instrucciones:**
Crea tu primera clase en Java llamada `Movie` (Película) con:
- **3 atributos** (ej: `title`, `genre`, `duration`)
- **1 constructor** que inicialice los atributos
- **1 método** que muestre la información de la película

**Código de ejemplo:**

```java
public class Movie {
    // Atributos
    String title;
    String genre;
    int duration;
    
    // Constructor
    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }
    
    // Método para mostrar información
    public void showInfo() {
        System.out.println("Película: " + title);
        System.out.println("Género: " + genre);
        System.out.println("Duración: " + duration + " minutos");
    }
}
```

**Instrucciones adicionales:**
1. Crea una clase `Main` con el método `main`
2. Instancia **3 objetos diferentes** de tipo `Movie`
3. Llama al método `showInfo()` para cada objeto

**Entregable:** Archivo `Movie.java` y `Main.java` funcionando correctamente.

---

### Actividad 4: Múltiples Objetos (Ejercicio 04)

**Instrucciones:**
Amplía el ejercicio anterior:
- Crea al menos **5 objetos** de tipo `Movie` con datos diferentes
- Cada película debe tener información coherente con un cine real
- Muestra la información de todas las películas

**Ejemplo de datos:**
- Avatar 2, Ciencia Ficción, 192 minutos
- Spider-Man, Acción, 148 minutos
- La La Land, Musical, 128 minutos
- Interestelar, Ciencia Ficción, 169 minutos
- El Padrino, Drama, 175 minutos

**Entregable:** Código Java con 5 instancias de `Movie` y su salida en consola.

---

## 🎓 Criterios de Evaluación

| Criterio | Peso | Descripción |
|----------|------|-------------|
| **Identificación de objetos** | 25% | Objetos identificados son relevantes al dominio del cine |
| **Comprensión conceptual** | 25% | Demuestra entender diferencias entre paradigmas |
| **Implementación de clase** | 30% | Clase `Movie` implementada correctamente con atributos, constructor y método |
| **Instanciación de objetos** | 20% | Crea múltiples objetos con datos coherentes |

---

## 📚 Recursos de Apoyo

### Material Teórico (Carpeta `1-teoria/`)
- `01-historia-evolucion-poo.md`
- `02-paradigmas-programacion.md`
- `03-conceptos-fundamentales-poo.md`
- `04-primer-programa-poo.md`

### Ejercicios Guiados (Carpeta `2-practica/`)
- `ejercicio-01-comparacion-paradigmas/`
- `ejercicio-02-primera-clase/`
- `ejercicio-03-multiples-objetos/`
- `ejercicio-04-modelado-mundo-real/`

### Glosario
Revisa el archivo `3-recursos/glosario.md` para términos clave de esta semana.

---

## 💡 Consejos

1. **No te compliques:** Esta semana es sobre conceptos básicos, no sobre código complejo
2. **Piensa en objetos reales:** Visualiza cómo funciona un cine real
3. **Pregunta:** Si tienes dudas sobre el dominio o los conceptos, consulta con el instructor
4. **Compila y prueba:** Asegúrate de que tu código compile antes de entregar

---

## 📅 Fecha de Entrega

**Entrega:** Según calendario definido por el instructor  
**Formato:** Código fuente (.java) y documentos en formato Markdown o PDF

---

**Nota Importante:** Este es tu dominio personal para todo el bootcamp. Todas las actividades futuras seguirán en el contexto del cine CineMax. No compartas tu código directamente con otros estudiantes, ya que cada uno tiene un dominio diferente.
