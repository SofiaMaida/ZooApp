package ar.com.ada.maven.model.dto;

import java.util.Date;
import java.util.Objects;


public class AnimalDTO {
    private int id;
    private String sexo;
    private Date nacimiento;
    private EspecieDTO especie;
    private PaisDTO pais;

    public AnimalDTO() {
    }

    public AnimalDTO(int id, String sexo, Date nacimiento, EspecieDTO especie, PaisDTO pais) {
        this.id = id;
        this.sexo = sexo;
        this.nacimiento = nacimiento;
        this.especie = especie;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public EspecieDTO getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieDTO especie) {
        this.especie = especie;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "AnimalDTO{" +
                "id=" + id +
                ", sexo='" + sexo + '\'' +
                ", nacimiento=" + nacimiento +
                ", especie=" + especie +
                ", pais=" + pais +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDTO animalDTO = (AnimalDTO) o;
        return id == animalDTO.id &&
                sexo.equals(animalDTO.sexo) &&
                nacimiento.equals(animalDTO.nacimiento) &&
                especie.equals(animalDTO.especie) &&
                pais.equals(animalDTO.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sexo, nacimiento, especie, pais);
    }
}
