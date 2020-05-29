package ar.com.ada.maven;/*package ar.com.ada.maven;/*package ar.com.ada.maven;

import ar.com.ada.maven.model.dao.CiudadDAO;
import ar.com.ada.maven.model.dao.ContinenteDAO;
import ar.com.ada.maven.model.dao.PaisDAO;
import ar.com.ada.maven.model.dto.CiudadDTO;
import ar.com.ada.maven.model.dto.ContinenteDTO;*/

import ar.com.ada.maven.contoller.MainController;
import ar.com.ada.maven.model.dao.*;

import ar.com.ada.maven.model.dto.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        MainController.run();

        /*ContinenteDAO continenteDAO = new ContinenteDAO();
        PaisDAO paisDAO = new PaisDAO();
        CiudadDAO ciudadDAO = new CiudadDAO();
        ZoologicoDAO zoologicoDAO = new ZoologicoDAO();
        FamiliaDAO familiaDAO = new FamiliaDAO();
        EspecieDAO especieDAO = new EspecieDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        AnimalHasZooDAO animalHasZooDAO = new AnimalHasZooDAO();

        //Lambda
        //continentList.forEach(continente -> System.out.println(continente.toString()));

        //FIND BY ID
        ContinenteDTO continente = continenteDAO.findById(1);
        System.out.println(continente.toString());

        PaisDTO pais = paisDAO.findById(1);
        System.out.println(pais.toString());

        //CiudadDTO ciudad = ciudadDAO.findById(1);
        //System.out.println(ciudad.toString());

        //SAVE
        ContinenteDTO continenteInsert = new ContinenteDTO("Disney");
        Boolean affectedRows = continenteDAO.save(continenteInsert);
        if (affectedRows) {
            System.out.println("Se añadio un registro en la tabla");
        } else {
            System.out.println("No se añadio ningun registro");
        }

        //ContinenteDTO continent = new ContinenteDTO();
        //continent = continenteDAO.findById(2);

        PaisDTO paisDTO = new PaisDTO(12, "Uruguay", 858, continente);
        affectedRows = paisDAO.save(paisDTO);

        if (affectedRows) {
            System.out.println("Se añadio un registro en la tabla");
        } else {
            System.out.println("No se añadio un registro en la tabla");
        }

        //DELETE
        Boolean hasDelete = continenteDAO.delete(13);
        if (hasDelete)
            System.out.println("Se borro el registro de la tabla");
        else
            System.out.println("No se pudo realizar DELETE CONTINENTE");

        hasDelete = paisDAO.delete(9);
        if (hasDelete)
            System.out.println("Se borro el registro de la tabla");
        else
            System.out.println("No se pudo realizar DELETE PAIS");

        //FIND ALL
        List<ContinenteDTO> continenteDTOList = continenteDAO.findAll();
        continenteDTOList.forEach(continenteDTO -> System.out.println(continenteDTO.toString()));

        //List<PaisDTO> paisDTOList = paisDAO.findAll();
        //paisDTOList.forEach(paisDTO -> System.out.println(paisDTO.toString()));

        List<CiudadDTO> ciudadDTOList = ciudadDAO.findAll();
        ciudadDTOList.forEach(ciudadDTO -> System.out.println(ciudadDTO.toString()));

        // UPDATE
        ContinenteDTO continenteUpdate = new ContinenteDTO("América");
        Integer idUpdate = 2;
        Boolean hasUpdate = continenteDAO.update(continenteUpdate, idUpdate);
        if (hasUpdate)
            System.out.println("Se actualizo el registro " + idUpdate);
        else
            System.out.println("No se pudo realizar la actualizacion");

        PaisDTO paisUpdate = new PaisDTO(13, "Estados Unidos", 840, continente);
        idUpdate = 3;
        paisUpdate.setId(idUpdate);
        hasUpdate = paisDAO.update(paisUpdate, idUpdate);
        if (hasUpdate) {
            System.out.println("Se actualizo registro" + idUpdate);
        } else {
            System.out.println("No se pudo reallizar la actualizacion");
        }


    }*/

    }
}
