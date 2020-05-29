package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.AnimalDTO;
import ar.com.ada.maven.model.dto.AnimalHasZooDTO;
import ar.com.ada.maven.model.dto.PaisDTO;
import ar.com.ada.maven.model.dto.ZoologicoDTO;
import java.sql.*;
import java.util.ArrayList;

/*public class AnimalHasZooDAO implements Dao<AnimalHasZooDTO> {

    private ZoologicoDAO zoologicoDAO = new ZoologicoDAO(false);
    private AnimalDAO animalDAO = new AnimalDAO(false);
    public Boolean willCloseConnection = true;
    public AnimalHasZooDAO (Boolean willCloseConnection) {this.willCloseConnection = willCloseConnection;}

    public AnimalHasZooDAO() {

    }

    @Override
    public ArrayList<AnimalHasZooDTO> findAll() {
        String sql = "SELECT FROM * animal_x_zoo";
        ArrayList<AnimalHasZooDTO> animalHasZoo = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                ZoologicoDTO zoologicoDTO = zoologicoDAO.findById(rs.getInt("id"));
                AnimalDTO animalDTO = animalDAO.findById(rs.getInt("id"));
                AnimalHasZooDTO animalHasZooDTO = new AnimalHasZooDTO(rs.getInt("id"), zoologicoDTO, animalDTO);
                animalHasZoo.add(animalHasZooDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FIND ALL ANIMAL-HAS-ZOO: " + e.getMessage());
        }
        return animalHasZoo;
    }

    @Override
    public AnimalHasZooDTO findById(Integer id) {
        String sql = "SELECT * FROM animal_x_zoo WHERE id = ?";
        AnimalHasZooDTO animalHasZoo = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                ZoologicoDTO zoologicoDTO = zoologicoDAO.findById(rs.getInt("Zoologico_id"));
                AnimalDTO animalDTO = animalDAO.findById(rs.getInt("Animal_id"));
                animalHasZoo = new AnimalHasZooDTO(rs.getInt("id"), zoologicoDTO, animalDTO);
            } if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FINDBYID ANIMAL-HAS-ZOO: " + e.getMessage());
        }
        return animalHasZoo;
    }

    @Override
    public Boolean save(AnimalHasZooDTO animalHasZooDTO) {
        String sql = "INSERT INTO animal_x_zoo (zoologico_id, animal_id) VALUES (?, ?)";
        int affectedRaws = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalHasZooDTO.getZoologico().getId());
            preparedStatement.setInt(2, animalHasZooDTO.getAnimal().getId());
            affectedRaws = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE ANIMAL-HAS-ZOO: " + e.getMessage());
        }
        return affectedRaws == 1;
    }

    @Override
    public Boolean update(PaisDTO animalHasZooDTO) {
        String sql = "UPDATE animalHasZoo SET zoologico_id = ?, animal_id = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        AnimalHasZooDTO aDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, animalHasZooDTO.getZoologico().getId());
            preparedStatement.setInt(2, animalHasZooDTO.getAnimal().getId());
            preparedStatement.setInt(5, animalHasZooDTO.getId());

            if (!(animalHasZooDTO.getZoologico().equals(aDB.getZoologico())) &&
                    animalHasZooDTO.getAnimal().equals(aDB.getAnimal()))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR UPDATE ANIMAL-HAS-ZOO: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM animalHasZoo WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE ANIMALHASZOO: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}*/
