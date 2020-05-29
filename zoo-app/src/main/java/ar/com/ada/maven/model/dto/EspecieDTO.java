package ar.com.ada.maven.model.dto;

import java.util.Objects;

public class EspecieDTO {
    private int id;
    private String nombreVulgar;
    private String nombreCientifico;
    private String extincion;
    private FamiliaDTO familia;

    public EspecieDTO() {
    }

    public EspecieDTO(int id, String nombreVulgar, String nombreCientifico, String extincion, FamiliaDTO familia) {
        this.id = id;
        this.nombreVulgar = nombreVulgar;
        this.nombreCientifico = nombreCientifico;
        this.extincion = extincion;
        this.familia = familia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreVulgar() {
        return nombreVulgar;
    }

    public void setNombreVulgar(String nombreVulgar) {
        this.nombreVulgar = nombreVulgar;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getExtincion() {
        return extincion;
    }

    public void setExtincion(String extincion) {
        this.extincion = extincion;
    }

    public FamiliaDTO getFamilia() {
        return familia;
    }

    public void setFamilia(FamiliaDTO familia) {
        this.familia = familia;
    }

    @Override
    public String toString() {
        return "EspecieDTO{" +
                "id=" + id +
                ", nombreVulgar='" + nombreVulgar + '\'' +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                ", extincion='" + extincion + '\'' +
                ", familia=" + familia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EspecieDTO that = (EspecieDTO) o;
        return id == that.id &&
                nombreVulgar.equals(that.nombreVulgar) &&
                nombreCientifico.equals(that.nombreCientifico) &&
                extincion.equals(that.extincion) &&
                familia.equals(that.familia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreVulgar, nombreCientifico, extincion, familia);
    }
}