package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.FamiliaDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;

public class FamiliaDAO implements Dao<FamiliaDTO> {

    private Boolean willCloseConnection = true;
    public FamiliaDAO (Boolean willCloseConnection) {this.willCloseConnection = willCloseConnection;}

    public FamiliaDAO() {

    }

    @Override
    public ArrayList<FamiliaDTO> findAll() {
        String sql = "SELECT FROM * familia";
        ArrayList<FamiliaDTO> familia = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                FamiliaDTO familiaDTO = new FamiliaDTO (rs.getInt("id"), rs.getString("nombre"));
                familia.add(familiaDTO);
            }
            connection.close();

        }catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e){
            System.out.println("CONNECTION ERROR FINDALL FAMILIA: " + e.getMessage());
        }
        return familia;
    }

    @Override
    public FamiliaDTO findById(Integer id) {
        String sql = "SELECT * FROM zoologico WHERE id = ?";
        FamiliaDTO familiaDTO = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next())
                familiaDTO = new FamiliaDTO(rs.getInt("id"), rs.getString("nombre"));
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FINDBYID FAMILIA: " + e.getMessage());
        }
        return familiaDTO;
    }

    @Override
    public Boolean save(FamiliaDTO familiaDTO) {
        String sql = "INSERT INTO (id, nombre) VALUES (?, ?)";
        FamiliaDTO familia = null;
        int hasInsert = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, familiaDTO.getNombre());
            hasInsert = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE FMAILIA: " + e.getMessage());
        }
        return hasInsert == 1;
    }

    @Override
    public Boolean update(PaisDTO familiaDTO) {
        String sql = "UPDATE familia SET nombre = ? WHERE id = ?";
        int hasUpdate = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, familiaDTO.getNombre());
            preparedStatement.setInt(2, familiaDTO.getId());

            if (!familiaDTO.getNombre().equals(familiaDTO.getNombre()))
                hasUpdate = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR UPDATE FAMILIA: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean update(PaisDTO pais, Integer id) {
        return null;
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
        String sql = "DELETE FROM familia WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE FAMILIA: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}
