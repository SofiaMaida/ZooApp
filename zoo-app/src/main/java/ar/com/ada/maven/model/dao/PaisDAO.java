package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;


public class PaisDAO implements Dao<PaisDTO> {

    private Boolean willCloseConnection = true;
    public ContinenteDAO continentDAO = new ContinenteDAO(false);
    private int id;


    public PaisDAO(boolean b) {
    }

    public PaisDAO() {

    }

    @Override
    public ArrayList<PaisDTO> findAll() {
        String sql = "SELECT * FROM Pais";
        ArrayList<PaisDTO> paises = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                // con el campo Continent_id busco el continente con el dao de Continent
                ContinenteDTO continente = continentDAO.findById(rs.getInt("Continente_id"));
                PaisDTO pais = new PaisDTO(rs.getInt("id"), rs.getString("nombre"), rs.getInt("isoCod"), continente);
                paises.add(pais);
            }
            if (willCloseConnection)
                connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL PAIS: " + e.getMessage());
        }
        return paises;
    }

    @Override
    //para comparar los objetos de aca con la base de datos
    public PaisDTO findById(Integer id) {
        String sql = "SELECT * FROM pais WHERE id = ?";
        PaisDTO pais = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                ContinenteDTO continente = continentDAO.findById(rs.getInt("Continente_id"));
                pais = new PaisDTO(rs.getInt("id"), rs.getString("nombre"), rs.getInt("iso_cod"), continente);
            }
            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FINDBYID PAIS: " + e.getMessage());
        }
        return pais;
    }

    @Override
    public Boolean save(PaisDTO pais) {
        String sql = "INSERT INTO pais (nombre, iso_cod, continente_id) values (?,?,?)";
        int affectedRows = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pais.getNombre());
            preparedStatement.setInt(2, pais.getIsoCod());
            preparedStatement.setInt(3, pais.getContinente().getId());
            affectedRows = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE PAIS: " + e.getMessage());
        }
        return affectedRows == 1;
    }

    @Override
    public Boolean update(PaisDTO pais) {
        return null;
    }

    @Override
    public Boolean update(PaisDTO pais, Integer id) {
        String sql = "UPDATE pais SET nombre = ?, iso_cod = ?, continente_id = ? WHERE id = ?";
        int hasUpdate = 0;
        // validacion de actualizacion
        PaisDTO paisDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pais.getNombre());
            preparedStatement.setInt(2, pais.getIsoCod());
            preparedStatement.setInt(3, pais.getContinente().getId());
            preparedStatement.setInt(4, pais.getId());

            if (!(pais.getNombre().equals(paisDB.getNombre()) &&
                    Objects.equals(pais.getIsoCod(), paisDB.getIsoCod()) &&
                    pais.getContinente().equals(paisDB.getContinente())))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR UPDATE PAIS: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean update(ContinenteDTO continente) {
        return null;
    }

    @Override
    public Boolean update(ContinenteDTO continente, Integer id) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM pais WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection conexion = DBConnection.getConnection();
            PreparedStatement sentencia = conexion.prepareStatement(sql);
            sentencia.setInt(1, id);

            hasDelete = sentencia.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());

        }
        return hasDelete == 1;
    }

    public PaisDTO findByName(String nombre){
        String sql = "SELECT * FROM pais WHERE nombre = ?";
        PaisDTO country = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                ContinenteDTO continente = continentDAO.findById(rs.getInt("Continente_id"));
                country = new PaisDTO(rs.getInt("id"), rs.getString("nombre"), continente);
            }

            if (willCloseConnection) connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR: " + e.getMessage());
        }

        return country;
    }

    public int getTotalCountries() {
        String sql = "SELECT COUNT(*) AS total FROM pais";
        int total = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())  total = rs.getInt("total");
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR GETTOTALCOUNTRIES: " + e.getMessage());
        }

        return total;
    }

    public ArrayList<PaisDTO> findAll(int limit, int offset) {
        String sql = "SELECT * FROM pais LIMIT ? OFFSET ?";
        ArrayList<PaisDTO> countries = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // con el campo Continente_id busco el continente con el dao de Continente
                ContinenteDTO continente = continentDAO.findById(rs.getInt("Continente_id"));
                PaisDTO country = new PaisDTO(rs.getInt("id"), rs.getString("nombre"), continente);
                countries.add(country);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL II: " + e.getMessage());
        }
        return countries;
    }

}





