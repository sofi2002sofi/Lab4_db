package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.CourseInfoDAO;
import com.didula.buisness.model.metadata.CourseInfo;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseInfoDAOimpl implements CourseInfoDAO {
  private static final String FIND_ALL = "SELECT * FROM course_info";
  private static final String FIND_BY_ID = "SELECT * FROM course_info WHERE id=?";
  private static final String CREATE = "INSERT course_info (id, start_date, completion_in_percents, available_message, course_id, user_id) VALUES (?, ?, ?, ?, ?, ?)";
  private static final String DELETE = "DELETE FROM course_info WHERE id=?";
  private static final String UPDATE = "UPDATE course_info SET start_date=?, completion_in_percents=?, available_message=?, course_id=?, user_id=? WHERE id=?";

  @Override
  public List<CourseInfo> findAll() throws SQLException {
    List<CourseInfo> coursesInfo = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          coursesInfo.add((CourseInfo) new Transformer(CourseInfo.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return coursesInfo;
  }

  @Override
  public CourseInfo findById(Integer id) throws SQLException {
    CourseInfo entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (CourseInfo) new Transformer(CourseInfo.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(CourseInfo entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setDate(2, entity.getStartDate());
      preparedStatement.setBigDecimal(3, entity.getCompletionInPercents());
      preparedStatement.setBoolean(4, entity.getAvailableMessage());
      preparedStatement.setInt(5, entity.getCourseId());
      preparedStatement.setInt(6, entity.getUserId());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(CourseInfo entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(6, entity.getId());
      preparedStatement.setDate(1, entity.getStartDate());
      preparedStatement.setBigDecimal(2, entity.getCompletionInPercents());
      preparedStatement.setBoolean(3, entity.getAvailableMessage());
      preparedStatement.setInt(4, entity.getCourseId());
      preparedStatement.setInt(5, entity.getUserId());
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
