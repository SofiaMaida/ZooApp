package ar.com.ada.maven.model.dao;

import ar.com.ada.maven.model.DBConnection;
import ar.com.ada.maven.model.dto.ContinenteDTO;
import ar.com.ada.maven.model.dto.PaisDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinenteDAO implements Dao<ContinenteDTO> {

    private Boolean willCloseConnection = true;
    public ContinenteDAO(Boolean willCloseConnection) {
        this.willCloseConnection = willCloseConnection;
    }

    public ContinenteDAO() {}

    @Override
    public List<ContinenteDTO> findAll() {
        String sql = "SELECT * FROM Continente";
        ArrayList<ContinenteDTO> continentes = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ContinenteDTO continente = new ContinenteDTO(rs.getInt("id"), rs.getString("nombre"));
                continentes.add(continente);
            }
            if (willCloseConnection)
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL CONTINENTE: " + e.getMessage());
        }

        return continentes;
    }

    @Override
        public ContinenteDTO findById(Integer id) {
        String sql = "SELECT * FROM continente WHERE id = ?";
        ContinenteDTO continente = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                continente = new ContinenteDTO(rs.getInt("id"), rs.getString("nombre"));
            if (willCloseConnection)
                connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR FINDBYID CONTINENTE: " + e.getMessage());
        }

        return continente;
    }

    @Override
    public Boolean save(ContinenteDTO continent) {
        String sql = "INSERT INTO Continente (nombre) values (?)";
        int hasInsert = 0;

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continent.getNombre());
            hasInsert = preparedStatement.executeUpdate();
            //para comparar la actualizacion con la base de datos
         //   if (resultSet.next())
           //     continente = new ContinenteDTO(resultSet.getInt("id"), resultSet.getString("America"));
           if (willCloseConnection)
            connection.close();
        } catch (Exception e) {
            System.out.println("CONNECTION ERROR SAVE CONTINENTE: " + e.getMessage());
        }

        return hasInsert == 1;
    }

    @Override
    public Boolean update(PaisDTO pais) {
        return null;
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
        String sql = "UPDATE Continente SET nombre = ? WHERE id = ?";
        int hasUpdate = 0;

        // validacion de actualizacion
        ContinenteDTO continenteDB = findById(id);

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, continente.getNombre());
            preparedStatement.setInt(2, continente.getId());

            if (!continente.getNombre().equals(continenteDB.getNombre()))
                hasUpdate = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR UPDATE CONTINENTE: " + e.getMessage());
        }

        return hasUpdate == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        String sql = "DELETE FROM Continente WHERE id = ?";
        int hasDelete = 0;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            hasDelete = preparedStatement.executeUpdate();
          //  connection.close();

        } catch (Exception e) {
            System.out.println("CONNECTION ERROR DELETE CONTINENTE: " + e.getMessage());
        }
        return hasDelete == 1;
    }

    public ContinenteDTO findByName(String name) {
        String sql = "SELECT * FROM Continente WHERE nombre = ?";
        ContinenteDTO continent = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next())
                continent = new ContinenteDTO(rs.getInt("id"), rs.getString("nombre"));
            if (willCloseConnection)
                connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            ex.printStackTrace();
            System.out.println("CONNECTION ERROR FINDBYNAME CONTINENTE: " + ex.getMessage());
        }
        return continent;
    }

    public List<ContinenteDTO> findAll(int limit, int offset) {
        String sql = "SELECT * FROM Continente LIMIT ? OFFSET ?";
        List<ContinenteDTO> continents = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, limit);
            preparedStatement.setInt(2, offset);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ContinenteDTO continent = new ContinenteDTO(rs.getInt("id"), rs.getString("nombre"));
                continents.add(continent);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR FINDALL II CONTINENTE: " + e.getMessage());
        }

        return continents;
    }

    public int getTotalContinents() {
        String sql = "SELECT COUNT(*) AS total FROM Continente";
        int total = 0;
        try {
            Connection connection = DBConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next())  total = rs.getInt("total");
            connection.close();
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("CONNECTION ERROR GETTOTALCONTINENTS CONTINENTE: " + e.getMessage());
        }

        return total;
    }


}

