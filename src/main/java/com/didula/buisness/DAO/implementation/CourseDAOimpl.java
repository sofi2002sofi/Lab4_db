package com.didula.buisness.DAO.implementation;

import com.didula.buisness.DAO.CourseDAO;
import com.didula.buisness.model.metadata.Course;
import com.didula.buisness.transformer.Transformer;
import com.didula.persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOimpl implements CourseDAO {
  private static final String FIND_ALL = "SELECT * FROM course";
  private static final String FIND_BY_ID = "SELECT * FROM course WHERE id=?";
  private static final String CREATE = "INSERT course (id, course_name, duration_in_hours) VALUES (?, ?, ?)";
  private static final String DELETE = "DELETE FROM course WHERE id=?";
  private static final String UPDATE = "UPDATE course SET course_name=?, duration_in_hours=? WHERE id=?";

  @Override
  public List<Course> findAll() throws SQLException {
    List<Course> courses = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          courses.add((Course) new Transformer(Course.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return courses;
  }

  @Override
  public Course findById(Integer id) throws SQLException {
    Course entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
      preparedStatement.setObject(1, id);
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
          entity = (Course) new Transformer(Course.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(Course entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(CREATE)) {
      preparedStatement.setInt(1, entity.getId());
      preparedStatement.setString(2, entity.getCourseName());
      preparedStatement.setDouble(3, entity.getDurationInHours());
      return preparedStatement.executeUpdate();
    }
  }

  @Override
  public int update(Course entity) throws SQLException {
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
      preparedStatement.setInt(3, entity.getId());
      preparedStatement.setString(1, entity.getCourseName());
      preparedStatement.setDouble(2, entity.getDurationInHours());
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
