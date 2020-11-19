package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

@Table(name = "course")
public class Course {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "course_name", length = 50)
  private String courseName;

  @Column(name = "duration_in_hours", type = "double")
  private double durationInHours;

  public Course() {
  }

  public Course(int id, String courseName, double durationInHours) {
    this.id = id;
    this.courseName = courseName;
    this.durationInHours = durationInHours;
  }

  public int getId() {
    return id;
  }

  public String getCourseName() {
    return courseName;
  }

  public double getDurationInHours() {
    return durationInHours;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setDurationInHours(double durationInHours) {
    this.durationInHours = durationInHours;
  }

  @Override
  public boolean equals(Object o) {

    boolean equal = false;

    if (this == o) {
      equal = true;
    }

    if (o == null || getClass() != o.getClass()) {
      equal = false;
    }

    Course comperableCourse = (Course) o;

    if (id != comperableCourse.id) {
      equal = false;
    }

    if (!courseName.equals(comperableCourse.courseName)) {
      equal = false;
    }

    if (Double.compare(comperableCourse.durationInHours, durationInHours) != 0) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + courseName.hashCode();
    hashCode = 31 * hashCode + (int) durationInHours;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %30s   %15s ", id, courseName, durationInHours);
  }
}
