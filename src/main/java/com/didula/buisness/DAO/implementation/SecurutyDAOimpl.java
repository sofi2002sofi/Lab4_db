package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.SecurityDAO;
import com.didula.buisness.model.metadata.Security;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SecurutyDAOimpl implements SecurityDAO {
  private static final String FIND_ALL = "SELECT * FROM security";
  private static final String FIND_BY_ID = "SELECT * FROM security WHERE id=?";
  private static final String CREATE = "INSERT security (id, password, user_id) VALUES (?, ?, ?)";
  private static final String DELETE = "DELETE FROM security WHERE id=?";
  private static final String UPDATE = "UPDATE security SET password=?, user_id=? WHERE id=?";

  @Override
  public List<Security> findAll() throws SQLException {
    List<Security> securities = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          securities.add((Security) new Transformer(Security.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return securities;
  }

  @Override
  public Security findById(Integer id) throws SQLException {
    Security entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (Security) new Transformer(Security.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(Security entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getPassword());
      preparedStatement.setInt(3, entity.getUserId());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(Security entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(3, entity.getId());
      preparedStatement.setString(1, entity.getPassword());
      preparedStatement.setInt(2, entity.getUserId());
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
