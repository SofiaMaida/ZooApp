package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.EspecieDTO;
import ar.com.ada.maven.model.dto.FamiliaDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;

/*public class EspecieDAO implements Dao<EspecieDTO> {

    private FamiliaDAO familiaDAO = new FamiliaDAO(false);
    private Boolean willCloseConnection = true;
    public EspecieDAO (Boolean willCloseConnection) {this.willCloseConnection = willCloseConnection;}

    public EspecieDAO() {

    }

    @Override
    public ArrayList<EspecieDTO> findAll() {
        String sql = "SELECT FROM * especie";
        ArrayList<EspecieDTO> especie = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                FamiliaDTO familiaDTO = familiaDAO.findById(rs.getInt("Familia_id"));
                EspecieDTO especieDTO = new EspecieDTO(rs.getInt("id"), rs.getString("nombreVulgar"),
                        rs.getString("nombreCientifico"), rs.getString("extincion"), familiaDTO);
                especie.add(especieDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL ESPECIE: " + e.getMessage());
        }
        return especie;
    }

    @Override
    public EspecieDTO findById(Integer id) {
        String sql = "SELECT * FROM especie WHERE id = ?";
        EspecieDTO especieDTO = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                FamiliaDTO familiaDTO = familiaDAO.findById(rs.getInt("Familia_id"));
                especieDTO = new EspecieDTO(rs.getInt("id"), rs.getString("nombreVulgar"), rs.getString("nombreCientifico"),
                        rs.getString("extincion"), familiaDTO);

            } if (willCloseConnection)
                connection.close();

            } catch (Exception e) {
                System.out.println("CONNECTION ERROR FINDBYID ESPECIE: " + e.getMessage());
            }
        return especieDTO;
    }

    @Override
    public Boolean save(EspecieDTO especieDTO) {
        String sql = "INSERT INTO especie (nombreVulgar, nombreCientifico, extincion, familia_id) values (?,?,?,?)";
        int affectedRows = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, especieDTO.getNombreVulgar());
            preparedStatement.setString(2, especieDTO.getNombreCientifico());
            preparedStatement.setString(3, especieDTO.getExtincion());
            preparedStatement.setInt(4, especieDTO.getFamilia().getId());
            affectedRows = preparedStatement.executeUpdate();

            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE ESPECIE: " + e.getMessage());
        }
        return affectedRows == 1;
    }

    @Override
    public Boolean update(PaisDTO especieDTO) {
        String sql = "UPDATE especie SET nombreVulgar = ?, nombreCientifico = ?, extincion = ?, familia_id = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        EspecieDTO especieDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, especieDTO.getNombreVulgar());
            preparedStatement.setString(2, especieDTO.getNombreCientifico());
            preparedStatement.setString(3, especieDTO.getExtincion());
            preparedStatement.setInt(4, especieDTO.getFamilia().getId());


            if (!(especieDTO.getNombreVulgar().equals(especieDB.getNombreVulgar()) &&
                    especieDTO.getNombreCientifico().equals(especieDB.getNombreCientifico()) &&
                    especieDTO.getExtincion().equals(especieDB.getExtincion()) &&
                    especieDTO.getFamilia().equals(especieDB.getFamilia())))
                hasUpdate = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR UPDATE ESPECIE: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM especie WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();
            //  connection.close();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE ESPECIE: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}*/
