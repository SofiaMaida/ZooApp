package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class ZoologicoDTO {
    private int id;
    private String nombre;
    private int tamaño;
    private int presupuesto;
    private CiudadDTO ciudad;

    public ZoologicoDTO(int id, String nombre, CiudadDTO ciudad) {
    }

    public ZoologicoDTO(int id, String nombre, int tamaño, int presupuesto, CiudadDTO ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.tamaño = tamaño;
        this.presupuesto = presupuesto;
        this.ciudad = ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public CiudadDTO getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadDTO ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "ZoologicoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tamaño=" + tamaño +
                ", presupuesto=" + presupuesto +
                ", ciudad=" + ciudad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoologicoDTO that = (ZoologicoDTO) o;
        return id == that.id &&
                presupuesto == that.presupuesto &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(tamaño, that.tamaño) &&
                Objects.equals(ciudad, that.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tamaño, presupuesto, ciudad);
    }

}

