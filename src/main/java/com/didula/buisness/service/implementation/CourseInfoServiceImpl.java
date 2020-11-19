package com.didula.buisness.service.implementation;

import com.didula.buisness.DAO.CourseInfoDAO;
import com.didula.buisness.DAO.GeneralDAO;
import com.didula.buisness.DAO.implementation.CourseInfoDAOimpl;
import com.didula.buisness.model.metadata.CourseInfo;
import com.didula.buisness.service.CourseInfoService;

public class CourseInfoServiceImpl implements CourseInfoService {
  CourseInfoDAO entityDAO;

  @Override
  public GeneralDAO<CourseInfo, Integer> takeDAOObject() {
    if (entityDAO == null) {
      entityDAO = new CourseInfoDAOimpl();
    }
    return entityDAO;
  }
}
