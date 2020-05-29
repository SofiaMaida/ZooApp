package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.CiudadDTO;
import ar.com.ada.maven.model.dto.PaisDTO;
import ar.com.ada.maven.model.dto.ZoologicoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;


/*public class ZoologicoDAO implements Dao<ZoologicoDTO> {

    public CiudadDAO ciudadDAO = new CiudadDAO(false);
    public Boolean willCloseConnection = true;
    public ZoologicoDAO (Boolean willCloseConnection) {this.willCloseConnection = willCloseConnection;}

    public ZoologicoDAO() {

    }

    @Override
    public ArrayList<ZoologicoDTO> findAll() {
        String sql = "SELECT FROM * zoologico";
        ArrayList<ZoologicoDTO> zooDTO = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                CiudadDTO ciudadDTO = ciudadDAO.findById(rs.getInt("id"));
                ZoologicoDTO zoologicoDTO = new ZoologicoDTO(rs.getInt("id"), rs.getString("nombre"), ciudadDTO);
                zooDTO.add(zoologicoDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FIND ALL ZOOLOGICO: " + e.getMessage());
        }
        return zooDTO;
    }

    @Override
    public ZoologicoDTO findById(Integer id) {
        String sql = "SELECT * FROM zoologico WHERE id = ?";
        ZoologicoDTO zoo = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                CiudadDTO ciudadDTO = ciudadDAO.findById(rs.getInt("Ciudad_id"));
                zoo = new ZoologicoDTO(rs.getInt("id"), rs.getString("nombre"), ciudadDTO);
            } if (willCloseConnection)
                connection.close();
            } catch (Exception e) {
                System.out.println("CONNECTION ERROR FINDBYID ZOO: " + e.getMessage());
            }
        return zoo;
    }

    @Override
    public Boolean save(ZoologicoDTO zoologicoDTO) {
        String sql = "INSERT INTO zoologico (nombre, tamaño, presupuesto, ciudad_id) VALUES (?, ?, ?, ?)";
        int affectedRaws = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoologicoDTO.getNombre());
            preparedStatement.setInt(2, zoologicoDTO.getTamaño());
            preparedStatement.setInt(3, zoologicoDTO.getPresupuesto());
            preparedStatement.setInt(4, zoologicoDTO.getCiudad().getId());

            affectedRaws = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE ZOO: " + e.getMessage());
        }
        return affectedRaws ==1;
    }

    @Override
    public Boolean update(ZoologicoDTO zoologicoDTO) {
        String sql = "UPDATE zoologico SET nombre = ?, tamaño = ?, presupuesto = ?, ciudad_id = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        ZoologicoDTO zooDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, zoologicoDTO.getNombre());
            preparedStatement.setInt(2, zoologicoDTO.getTamaño());
            preparedStatement.setInt(3, zoologicoDTO.getPresupuesto());
            preparedStatement.setInt(4, zoologicoDTO.getCiudad().getId());
            preparedStatement.setInt(5, zoologicoDTO.getId());

            if (!(zoologicoDTO.getNombre().equals(zooDB.getNombre()) &&
                    Objects.equals(zoologicoDTO.getTamaño(), zooDB.getTamaño()) &&
                    Objects.equals(zoologicoDTO.getPresupuesto(), zooDB.getPresupuesto()) &&
                    zoologicoDTO.getCiudad().equals(zooDB.getCiudad())))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR UPDATE ZOO: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM zoologico WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE ZOO: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}*/