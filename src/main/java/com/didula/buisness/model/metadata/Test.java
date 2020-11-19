package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

import java.sql.Timestamp;

@Table(name = "test")
public class Test {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "test_name", length = 50)
  private String testName;

  @Column(name = "deadline_datetime", type = "timestamp")
  private Timestamp deadlineDatetime;

  @Column(name = "completed", type = "bool")
  private Boolean completed;

  @Column(name = "overdue", type = "bool")
  private Boolean overdue;

  @Column(name = "course_info_id", type = "int")
  private Integer courseInfoId;

  public Test() {

  }

  public Test(int id, String testName, Timestamp deadlineDatetime, Boolean completed, Boolean overdue, Integer courseInfoId) {
    this.id = id;
    this.testName = testName;
    this.deadlineDatetime = deadlineDatetime;
    this.completed = completed;
    this.overdue = overdue;
    this.courseInfoId = courseInfoId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  public Timestamp getDeadlineDatetime() {
    return deadlineDatetime;
  }

  public void setDeadlineDatetime(Timestamp deadlineDatetime) {
    this.deadlineDatetime = deadlineDatetime;
  }

  public Boolean getCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = completed;
  }

  public Boolean getOverdue() {
    return overdue;
  }

  public void setOverdue(Boolean overdue) {
    this.overdue = overdue;
  }

  public Integer getCourseInfoId() {
    return courseInfoId;
  }

  public void setCourseInfoId(Integer courseInfoId) {
    this.courseInfoId = courseInfoId;
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

    Test comperableTest = (Test) o;

    if (id != comperableTest.id) {
      equal = false;
    }

    if (!testName.equals(comperableTest.testName)) {
      equal = false;
    }

    if (!deadlineDatetime.equals(comperableTest.deadlineDatetime)) {
      equal = false;
    }

    if (!completed.equals(comperableTest.completed)) {
      equal = false;
    }

    if (!overdue.equals(comperableTest.overdue)) {
      equal = false;
    }

    if (!courseInfoId.equals(comperableTest.courseInfoId)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + testName.hashCode();
    hashCode = 31 * hashCode + deadlineDatetime.hashCode();
    hashCode = 31 * hashCode + completed.hashCode();
    hashCode = 31 * hashCode + overdue.hashCode();
    hashCode = 31 * hashCode + courseInfoId;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %50s   %20s   %10s   %10s   %3s", id, testName, deadlineDatetime, completed, overdue, courseInfoId);
  }

}
