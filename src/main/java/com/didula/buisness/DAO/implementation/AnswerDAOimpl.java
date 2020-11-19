package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.AnswerDAO;
import com.didula.buisness.model.metadata.Answer;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnswerDAOimpl implements AnswerDAO {
  private static final String FIND_ALL = "SELECT * FROM answer";
  private static final String FIND_BY_ID = "SELECT * FROM answer WHERE id=?";
  private static final String CREATE = "INSERT answer (id, answer_name) VALUES (?, ?)";
  private static final String DELETE = "DELETE FROM answer WHERE id=?";
  private static final String UPDATE = "UPDATE answer SET answer_name=? WHERE id=?";

  @Override
  public List<Answer> findAll() throws SQLException {
    List<Answer> answers = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          answers.add((Answer) new Transformer(Answer.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return answers;
  }

  @Override
  public Answer findById(Integer id) throws SQLException {
    Answer entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (Answer) new Transformer(Answer.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(Answer entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getAnswerName());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(Answer entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(2, entity.getId());
      preparedStatement.setString(1, entity.getAnswerName());
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
