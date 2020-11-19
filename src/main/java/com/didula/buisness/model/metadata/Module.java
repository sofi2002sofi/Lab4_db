package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

import java.sql.Timestamp;

@Table(name = "module")
public class Module {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "module_name", length = 50)
  private String moduleName;

  @Column(name = "deadline_datetime", type = "Timestamp")
  private Timestamp deadlineDatetime;

  @Column(name = "completed", type = "bool")
  private Boolean completed;

  @Column(name = "overdue", type = "bool")
  private Boolean overdue;

  @Column(name = "course_info_id", type = "int")
  private Integer courseInfoId;

  public Module() {

  }

  public Module(int id, String moduleName, Timestamp deadlineDatetime, Boolean completed, Boolean overdue, Integer courseInfoId) {
    this.id = id;
    this.moduleName = moduleName;
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

  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
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

    Module comperableModule = (Module) o;

    if (id != comperableModule.id) {
      equal = false;
    }

    if (!moduleName.equals(comperableModule.moduleName)) {
      equal = false;
    }

    if (!deadlineDatetime.equals(comperableModule.deadlineDatetime)) {
      equal = false;
    }

    if (!completed.equals(comperableModule.completed)) {
      equal = false;
    }

    if (!overdue.equals(comperableModule.overdue)) {
      equal = false;
    }

    if (!courseInfoId.equals(comperableModule.courseInfoId)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + moduleName.hashCode();
    hashCode = 31 * hashCode + deadlineDatetime.hashCode();
    hashCode = 31 * hashCode + completed.hashCode();
    hashCode = 31 * hashCode + overdue.hashCode();
    hashCode = 31 * hashCode + courseInfoId;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %50s   %20s   %10s   %10s   %3s", id, moduleName, deadlineDatetime, completed, overdue, courseInfoId);
  }

}
