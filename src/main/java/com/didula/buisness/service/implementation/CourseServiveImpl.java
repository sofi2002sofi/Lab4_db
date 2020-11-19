package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.CourseDAO;
import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.implementation.CourseDAOimpl;
import com.didula.buisness.model.metadata.Course;
import com.didula.buisness.service.CourseService;

public class CourseServiveImpl implements CourseService {
  CourseDAO entityDAO;

  @Override
  public GeneralDAO<Course, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new CourseDAOimpl();
    }
    return entityDAO;
  }
}
