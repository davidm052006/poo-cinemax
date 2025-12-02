# POLIMORFISMO.md - Semana 05

## 1. Sobrecarga de Métodos (Overloading)

Métodos sobrecargados en la clase Cine:

| Método                          | Parámetros                                   | Uso real |
|---------------------------------|----------------------------------------------|--------|
| venderBoleto(Boleto)            | 1 boleto                                     | Venta normal |
| venderBoleto(Boleto...)         | Varios boletos (varargs)                     | Venta en grupo |
| venderBoleto(Cliente, PeliculaBase, Sala) | Datos básicos                            | Venta rápida |
| venderBoleto(Cliente, PeliculaBase, Sala, String) | Con asiento                      | Venta completa |

Justificación: en un cine real el vendedor puede vender de muchas formas distintas.

## 2. Sobrescritura de Métodos (Overriding)

| Método           | Clase Padre         | PeliculaNormal                 | PeliculaEstreno                     |
|------------------|---------------------|--------------------------------|-------------------------------------|
| getRecargo()     | abstract            | return 0                       | return 8000                         |
| getTipo()        | abstract            | return "Normal"                | return "ESTRENO"                    |
| toString()       | Object              | "Normal → Título..."           | "ESTRENO → Título..."               |

Todos con @Override correcto.

## 3. Polimorfismo Dinámico (Dynamic Binding)

Ejemplo clave:
```java
PeliculaBase[] cartelera = {deadpool, frozen, beetle};
for (PeliculaBase p : cartelera) {
    p.mostrarInfo();        // Se ejecuta la versión correcta según el objeto real
    System.out.println(p.getRecargo());  // 8000 o 0 automáticamente
}