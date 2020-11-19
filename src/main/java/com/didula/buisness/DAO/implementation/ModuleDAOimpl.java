package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.ModuleDAO;
import com.didula.buisness.model.metadata.Module;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleDAOimpl implements ModuleDAO {
  private static final String FIND_ALL = "SELECT * FROM module";
  private static final String FIND_BY_ID = "SELECT * FROM module WHERE id=?";
  private static final String CREATE = "INSERT module (id, module_name, deadline_datetime, completed, overdue, course_info_id) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String DELETE = "DELETE FROM module WHERE id=?";
  private static final String UPDATE = "UPDATE module SET module_name=?, deadline_datetime=?, completed=?, overdue=?, course_info_id=? WHERE id=?";

  @Override
  public List<Module> findAll() throws SQLException {
    List<Module> modules = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          modules.add((Module) new Transformer(Module.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return modules;
  }

  @Override
  public Module findById(Integer id) throws SQLException {
    Module entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (Module) new Transformer(Module.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(Module entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getModuleName());
      preparedStatement.setTimestamp(3, entity.getDeadlineDatetime());
      preparedStatement.setBoolean(4, entity.getCompleted());
      preparedStatement.setBoolean(5, entity.getOverdue());
      preparedStatement.setInt(6, entity.getCourseInfoId());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(Module entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(6, entity.getId());
      preparedStatement.setString(1, entity.getModuleName());
      preparedStatement.setTimestamp(2, entity.getDeadlineDatetime());
      preparedStatement.setBoolean(3, entity.getCompleted());
      preparedStatement.setBoolean(4, entity.getOverdue());
      preparedStatement.setInt(5, entity.getCourseInfoId());
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
