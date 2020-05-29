package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.util.Collection;

public interface Dao<T> {

    Collection<T> findAll();

    T findById(Integer id);

    Boolean save(T t);

    Boolean update(PaisDTO pais);

    Boolean update(PaisDTO pais, Integer id);

    Boolean update(ContinenteDTO continente);

    Boolean update(ContinenteDTO continente, Integer id);

    Boolean delete(Integer id);


}
