package com.didula.controller;

import com.didula.buisness.model.metadata.Course;
import com.didula.buisness.service.implementation.CourseServiveImpl;

import java.sql.SQLException;
import java.util.List;

public class CourseController {
  public List<Course> getAllCourses() throws SQLException {
    return new CourseServiveImpl().findAll();
  }

  public Course getCourse(Integer id) throws SQLException {
    return new CourseServiveImpl().findById(id);
  }

  public int postCourse(Course course) throws SQLException {
    return new CourseServiveImpl().create(course);
  }

  public int putCourse(Course course) throws SQLException {
    return new CourseServiveImpl().update(course);
  }

  public int deleteCourse(Integer id) throws SQLException {
    return new CourseServiveImpl().delete(id);
  }
}
