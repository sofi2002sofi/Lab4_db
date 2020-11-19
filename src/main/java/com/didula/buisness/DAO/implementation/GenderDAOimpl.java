package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.GenderDAO;
import com.didula.buisness.model.metadata.Gender;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDAOimpl implements GenderDAO {
  private static final String FIND_ALL = "SELECT * FROM gender";
  private static final String FIND_BY_ID = "SELECT * FROM gender WHERE id=?";
  private static final String CREATE = "INSERT gender (id, gender_name) VALUES (?, ?)";
  private static final String DELETE = "DELETE FROM gender WHERE id=?";
  private static final String UPDATE = "UPDATE gender SET gender_name=? WHERE id=?";

  @Override
  public List<Gender> findAll() throws SQLException {
    List<Gender> genders = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          genders.add((Gender) new Transformer(Gender.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return genders;
  }

  @Override
  public Gender findById(Integer id) throws SQLException {
    Gender entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (Gender) new Transformer(Gender.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(Gender entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getGenderName());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(Gender entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(2, entity.getId());
      preparedStatement.setString(1, entity.getGenderName());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int delete(Integer id) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
      preparedStatement.setObject(1, id);
      return preparedStatement.executeUpdate();
    }
  }
}
