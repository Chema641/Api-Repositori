package org.amigo.model;

public class Establishment {
    private Integer idLocal; // AUTO_INCREMENT, se llena al leer desde DB
    private String nombre;
    private String descripcion;
    private String direccion;

    // Getters y setters

    public Integer getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Integer idLocal) {
        this.idLocal = idLocal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {return descripcion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}


}
