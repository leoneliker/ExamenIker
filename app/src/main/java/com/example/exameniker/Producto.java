package com.example.exameniker;
/*Examen de Iker Iturralde Tejido*/
import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private String precio;

    public Producto(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}

