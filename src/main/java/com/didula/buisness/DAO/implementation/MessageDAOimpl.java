package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.MessageDAO;
import com.didula.buisness.model.metadata.Message;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAOimpl implements MessageDAO {
  private static final String FIND_ALL = "SELECT * FROM message";
  private static final String FIND_BY_ID = "SELECT * FROM message WHERE id=?";
  private static final String CREATE = "INSERT message (id, message_content, count_of_overdued_tests, count_of_overdued_modules, course_info_id) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String DELETE = "DELETE FROM message WHERE id=?";
  private static final String UPDATE = "UPDATE message SET message_content=?, count_of_overdued_tests=?, count_of_overdued_modules=?, course_info_id=? WHERE id=?";

  @Override
  public List<Message> findAll() throws SQLException {
    List<Message> messages = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          messages.add((Message) new Transformer(Message.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return messages;
  }

  @Override
  public Message findById(Integer id) throws SQLException {
    Message entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (Message) new Transformer(Message.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(Message entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getMessageContent());
      preparedStatement.setInt(3, entity.getCountOfOverduedTests());
      preparedStatement.setInt(4, entity.getCountOfOverduedModules());
      preparedStatement.setInt(5, entity.getCourseInfoId());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(Message entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(5, entity.getId());
      preparedStatement.setString(1, entity.getMessageContent());
      preparedStatement.setInt(2, entity.getCountOfOverduedTests());
      preparedStatement.setInt(3, entity.getCountOfOverduedModules());
      preparedStatement.setInt(4, entity.getCourseInfoId());
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
