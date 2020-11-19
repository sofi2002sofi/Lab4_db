package com.didula.controller;

import com.didula.buisness.model.metadata.CourseInfo;
import com.didula.buisness.service.implementation.CourseInfoServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class CourseInfoController {
    public List<CourseInfo> getAllCoursesInfo() throws SQLException {
        return new CourseInfoServiceImpl().findAll();
    }

    public CourseInfo getCourseInfo(Integer id) throws SQLException {
        return new CourseInfoServiceImpl().findById(id);
    }

    public int postCourseInfo(CourseInfo courseInfo) throws SQLException {
        return new CourseInfoServiceImpl().create(courseInfo);
    }

    public int putCourseInfo(CourseInfo courseInfo) throws SQLException {
        return new CourseInfoServiceImpl().update(courseInfo);
    }

    public int deleteCourseInfo(Integer id) throws SQLException {
        return new CourseInfoServiceImpl().delete(id);
    }
}
