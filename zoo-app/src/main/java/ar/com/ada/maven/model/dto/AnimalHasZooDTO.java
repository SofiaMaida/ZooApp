package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class AnimalHasZooDTO {
    private int id;
    private ZoologicoDTO zoologico;
    private AnimalDTO animal;

    public AnimalHasZooDTO() {
    }

    public AnimalHasZooDTO(int id, ZoologicoDTO zoologico, AnimalDTO animal) {
        this.id = id;
        this.zoologico = zoologico;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZoologicoDTO getZoologico() {
        return zoologico;
    }

    public void setZoologico(ZoologicoDTO zoologico) {
        this.zoologico = zoologico;
    }

    public AnimalDTO getAnimal() {
        return animal;
    }

    public void setAnimal(AnimalDTO animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "AnimalHasZooDTO{" +
                "id=" + id +
                ", zoologico=" + zoologico +
                ", animal=" + animal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalHasZooDTO that = (AnimalHasZooDTO) o;
        return id == that.id &&
                Objects.equals(zoologico, that.zoologico) &&
                Objects.equals(animal, that.animal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zoologico, animal);
    }
}


