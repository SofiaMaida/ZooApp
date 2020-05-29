package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class PaisDTO {
    private int id;
    private String nombre;
    private int isoCod;
    private ContinenteDTO continente;           //foreign key

    public PaisDTO(int id, String nombre, ContinenteDTO continente){}

    public PaisDTO(String nombre, ContinenteDTO continentById){
        this.nombre = nombre;
    }

    public PaisDTO(ContinenteDTO continente) {
        this.continente = continente;
    }

    public PaisDTO(int id, String nombre, int isoCod, ContinenteDTO continente) {
        this.id = id;
        this.nombre = nombre;
        this.isoCod = isoCod;
        this.continente = continente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIsoCod() {
        return isoCod;
    }

    public void setIsoCod(int isoCod) {
        this.isoCod = isoCod;
    }

    public ContinenteDTO getContinente() {
        return continente;
    }

    public void setContinente(ContinenteDTO continente) {
        this.continente = continente;
    }

    @Override
    public String toString() {
        return "PaisDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", isoCod=" + isoCod +
                ", continente=" + continente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaisDTO paisDTO = (PaisDTO) o;
        return id == paisDTO.id &&
                isoCod == paisDTO.isoCod &&
                Objects.equals(nombre, paisDTO.nombre) &&
                Objects.equals(continente, paisDTO.continente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, isoCod, continente);
    }
}
