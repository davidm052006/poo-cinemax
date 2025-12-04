package com.cinemax.servicio;

import com.cinemax.modelo.*;
import com.cinemax.excepciones.*;

import java.time.LocalDateTime;
import java.util.*;

public class GestorCinemax {
    // ArrayList para historial de todas las funciones
    private List<Funcion> funciones = new ArrayList<>();

    // HashMap para búsqueda rápida por código (O(1))
    private Map<String, Funcion> funcionesPorCodigo = new HashMap<>();

    // HashMap bonus: Agrupar funciones por película (título)
    private Map<String, List<Funcion>> funcionesPorPelicula = new HashMap<>();

    public void agregarFuncion(Funcion f) {
        if (funcionesPorCodigo.containsKey(f.getCodigo())) {
            throw new IllegalArgumentException("Ya existe función con código: " + f.getCodigo());
        }
        funciones.add(f);
        funcionesPorCodigo.put(f.getCodigo(), f);

        // Agrupar por película
        String titulo = f.getPelicula().getTitulo();
        funcionesPorPelicula.computeIfAbsent(titulo, k -> new ArrayList<>()).add(f);
    }

    public Funcion buscarPorCodigo(String codigo) {
        return funcionesPorCodigo.get(codigo);
    }

    public boolean existe(String codigo) {
        return funcionesPorCodigo.containsKey(codigo);
    }

    public Funcion eliminar(String codigo) {
        Funcion f = funcionesPorCodigo.remove(codigo);
        if (f != null) {
            funciones.remove(f);
            // Remover del agrupado
            String titulo = f.getPelicula().getTitulo();
            List<Funcion> lista = funcionesPorPelicula.get(titulo);
            if (lista != null) {
                lista.remove(f);
                if (lista.isEmpty()) funcionesPorPelicula.remove(titulo);
            }
        }
        return f;
    }

    // Filtrado por precio
    public List<Funcion> filtrarPorPrecio(double min, double max) {
        List<Funcion> resultado = new ArrayList<>();
        for (Funcion f : funciones) {
            if (f.getPrecioBase() >= min && f.getPrecioBase() <= max) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    // Filtrado por mes y año
    public List<Funcion> filtrarPorMes(int mes, int año) {
        List<Funcion> resultado = new ArrayList<>();
        for (Funcion f : funciones) {
            LocalDateTime fecha = f.getFechaHora();
            if (fecha.getMonthValue() == mes && fecha.getYear() == año) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    // Estadísticas
    public double calcularTotalVentas() {
        return funciones.stream().mapToDouble(Funcion::getPrecioBase).sum();
    }

    public double calcularPromedioPrecio() {
        if (funciones.isEmpty()) return 0;
        return calcularTotalVentas() / funciones.size();
    }

    public Funcion obtenerFuncionMasCara() {
        if (funciones.isEmpty()) return null;
        return funciones.stream()
                .max(Comparator.comparingDouble(Funcion::getPrecioBase))
                .orElse(null);
    }

    public Map<String, Integer> contarPorPelicula() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Funcion f : funciones) {
            String titulo = f.getPelicula().getTitulo();
            conteo.put(titulo, conteo.getOrDefault(titulo, 0) + 1);
        }
        return conteo;
    }

    public List<Funcion> getFunciones() {
        return funciones;
    }
}