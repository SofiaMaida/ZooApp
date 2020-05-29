package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

/*public class AnimalDAO implements Dao<AnimalDTO> {

    private EspecieDAO especieDAO = new EspecieDAO(false);
    private PaisDAO paisDAO = new PaisDAO(false);
    private Boolean willCloseConnection = true;
    public AnimalDAO(Boolean willCloseConnection) {this.willCloseConnection = willCloseConnection;}

    public AnimalDAO() {

    }

    @Override
    public ArrayList<AnimalDTO> findAll() {
        String sql = "SELECT FROM * animal";
        ArrayList<AnimalDTO> animal = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                EspecieDTO especieDTO = especieDAO.findById(rs.getInt("id"));
                PaisDTO paisDTO = paisDAO.findById(rs.getInt("id"));
                AnimalDTO animalDTO = new AnimalDTO(rs.getInt("id"), rs.getString("sexo"), rs.getDate("nacimiento"),
                        especieDTO, paisDTO);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL ANIMAL: " + e.getMessage());
        }
        return animal;
    }

    @Override
    public AnimalDTO findById(Integer id) {
        String sql = "SELECT * FROM animal WHERE id = ?";
        AnimalDTO animal = null;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                EspecieDTO especieDTO = especieDAO.findById(rs.getInt("Especie_id"));
                PaisDTO paisDTO = paisDAO.findById(rs.getInt("Pais_id"));
                animal = new AnimalDTO(rs.getInt("id"), rs.getString("sexo"), rs.getDate("nacimiento"), especieDTO, paisDTO);

            }if (willCloseConnection)
                    connection.close();
        }catch (Exception e) {
            System.out.println("CONNECTION ERROR FINDBYID ANIMAL: " + e.getMessage());
        }
        return animal;
    }

    @Override
    public Boolean save(AnimalDTO animalDTO) {
        String sql = "INSERT INTO animal (sexo, nacimiento, especie_id, pais_id) VALUES (?, ?, ?, ?)";
        int affectedRaws = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animalDTO.getSexo());
            Date date = new Date(animalDTO.getNacimiento().getTime());
            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, animalDTO.getEspecie().getId());
            preparedStatement.setInt(4, animalDTO.getPais().getId());

            affectedRaws = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE ZOO: " + e.getMessage());
        }
        return affectedRaws == 1;
    }

    @Override
    public Boolean update(AnimalDTO animalDTO) {
        String sql = "UPDATE animal SET sexo = ?, nacimiento = ?, especie_id = ?, pais_id = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        AnimalDTO animalDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animalDTO.getSexo());
            preparedStatement.setDate(2, (Date) animalDTO.getNacimiento());
            preparedStatement.setInt(3, animalDTO.getEspecie().getId());
            preparedStatement.setInt(4, animalDTO.getPais().getId());
            preparedStatement.setInt(5, animalDTO.getId());

            if (!(animalDTO.getSexo().equals(animalDB.getSexo()) &&
                    Objects.equals(animalDTO.getNacimiento(), animalDB.getNacimiento()) &&
                    animalDTO.getEspecie().equals(animalDB.getEspecie())) &&
                    animalDTO.getPais().equals(animalDB.getPais()))
                hasUpdate = preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR UPDATE ANIMAL: " + e.getMessage());
        }
        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM animal WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE ANIMAL: " + e.getMessage());
        }
        return hasDelete == 1;
    }
}*/
