package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class CiudadDTO {
    private int id;
    private String nombre;
    private PaisDTO pais;

    public CiudadDTO(int id, String nombre, PaisDTO pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
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

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "CiudadDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais=" + pais +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiudadDTO ciudadDTO = (CiudadDTO) o;
        return id == ciudadDTO.id &&
                Objects.equals(nombre, ciudadDTO.nombre) &&
                Objects.equals(pais, ciudadDTO.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, pais);
    }
}
