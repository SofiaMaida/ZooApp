package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.CiudadDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;

/*public class CiudadDAO implements Dao<CiudadDTO> {

    public PaisDAO paisDAO = new PaisDAO(false);
    private Boolean willCloseConnection = true;

    public CiudadDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    public CiudadDAO() {

    }


    @Override
    public ArrayList<CiudadDTO> findAll() {
        String sql = "SELECT FROM * ciudad";
        ArrayList<CiudadDTO> ciudades = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                PaisDTO paisDTO = paisDAO.findById(rs.getInt("Pais_id"));
                CiudadDTO ciudad = new CiudadDTO(rs.getInt("id"), rs.getString("nombre"), paisDTO);
                ciudades.add(ciudad);
            }
            if (willCloseConnection)
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL CIUDAD: " + e.getMessage());
        }

        return ciudades;
    }

    @Override
    public CiudadDTO findById(Integer id) {
        String sql = "SELECT * FROM ciudad WHERE id = ?";
        CiudadDTO ciudad = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                PaisDTO pais = paisDAO.findById(rs.getInt("Pais_id"));
                ciudad = new CiudadDTO(rs.getInt("id"), rs.getString("nombre"), pais);
            }
            if (willCloseConnection)
                connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDBYID CIUDAD: " + e.getMessage());
        }
        return ciudad;
    }

    @Override
    public Boolean save(CiudadDTO ciudad) {
        String sql = "INSERT INTO ciudad (nombre, pais_id) values (?,?)";
        int affectedRows = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ciudad.getNombre());
            preparedStatement.setInt(2, ciudad.getPais().getId());
            affectedRows = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE CIUDAD: " + e.getMessage());
        }
        return affectedRows == 1;
    }


    @Override
    public Boolean update(CiudadDTO ciudad) {
        String sql = "UPDATE ciudad SET nombre = ?, pais_id = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        CiudadDTO ciudadDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, ciudad.getNombre());
            preparedStatement.setInt(2, ciudad.getPais().getId());
            preparedStatement.setInt(3, ciudad.getId());

            if (!(ciudad.getNombre().equals(ciudadDB.getNombre()) &&
                    ciudad.getPais().equals(ciudadDB.getPais())))
                hasUpdate = preparedStatement.executeUpdate();
            if (willCloseConnection)
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR UPDATE CIUDAD: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM ciudad WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE CIUDAD: " + e.getMessage());
        }
            return hasDelete == 1;
        }
    }*/
