package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.UserDAO;
import com.didula.buisness.model.metadata.User;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOimpl implements UserDAO {
  private static final String FIND_ALL = "SELECT * FROM user";
  private static final String FIND_BY_ID = "SELECT * FROM user WHERE id=?";
  private static final String CREATE = "INSERT user (id, full_name, forums_name, email, birth_year, gender_id) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String DELETE = "DELETE FROM user WHERE id=?";
  private static final String UPDATE = "UPDATE user SET full_name=?, forums_name=?, email=?, birth_year=?, gender_id=? WHERE id=?";

  @Override
  public List<User> findAll() throws SQLException {
    List<User> users = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          users.add((User) new Transformer(User.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return users;
  }

  @Override
  public User findById(Integer id) throws SQLException {
    User entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (User) new Transformer(User.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(User entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getFullName());
      preparedStatement.setString(3, entity.getForumsName());
      preparedStatement.setString(4, entity.getEmail());
      preparedStatement.setInt(5, entity.getBirthYear());
      preparedStatement.setInt(6, entity.getGenderId());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(User entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(6, entity.getId());
      preparedStatement.setString(1, entity.getFullName());
      preparedStatement.setString(2, entity.getForumsName());
      preparedStatement.setString(3, entity.getEmail());
      preparedStatement.setInt(4, entity.getBirthYear());
      preparedStatement.setInt(5, entity.getGenderId());
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
