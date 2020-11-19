package com.didula.buisness.DAO.implementation;

import com.didula.buisness.model.metadata.TestHasAnswer;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestHasAnswerDAOimpl {
  private static final String FIND_ALL = "SELECT * FROM test_has_answer";
  private static final String FIND_BY_ID = "SELECT * FROM test_has_answer WHERE test_id=? AND answer_id=?";
  private static final String CREATE = "INSERT test_has_answer (test_id, answer_id, correct) VALUES (?, ?, ?)";
  private static final String DELETE = "DELETE FROM test_has_answer WHERE test_id=? AND answer_id=?";
  private static final String UPDATE = "UPDATE test_has_answer SET correct=? WHERE test_id=? AND answer_id=?";

  public List<TestHasAnswer> findAll() throws SQLException {
    List<TestHasAnswer> testHasAnswers = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          testHasAnswers.add((TestHasAnswer) new Transformer(TestHasAnswer.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return testHasAnswers;
  }

  public TestHasAnswer findById(Integer idTest, Integer idAnswer) throws SQLException {
    TestHasAnswer entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, idTest);
      preparedStatement.setObject(2, idAnswer);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (TestHasAnswer) new Transformer(TestHasAnswer.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  public int create(TestHasAnswer entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getTestId());
      preparedStatement.setInt(2, entity.getAnswerId());
      preparedStatement.setBoolean(3, entity.getCorrect());
      return preparedStatement.executeUpdate();
    }
  }

  public int update(TestHasAnswer entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(2, entity.getTestId());
      preparedStatement.setInt(3, entity.getAnswerId());
      preparedStatement.setBoolean(1, entity.getCorrect());
      return preparedStatement.executeUpdate();
    }
  }

  public int delete(Integer idTest, Integer idAnswer) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
      preparedStatement.setObject(1, idTest);
      preparedStatement.setObject(2, idAnswer);
      return preparedStatement.executeUpdate();
    }
  }
}
