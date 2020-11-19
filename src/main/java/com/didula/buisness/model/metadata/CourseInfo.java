package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

import java.math.BigDecimal;
import java.sql.Date;

@Table(name = "course_info")
public class CourseInfo {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "start_date", type = "date")
  private Date startDate;

  @Column(name = "completion_in_percents", type = "BigDecimal")
  private BigDecimal completionInPercents;

  @Column(name = "available_message", type = "bool")
  private Boolean availableMessage;

  @Column(name = "course_id", type = "int")
  private Integer courseId;

  @Column(name = "user_id", type = "int")
  private Integer userId;

  public CourseInfo() {

  }

  public CourseInfo(Integer id, Date startDate, BigDecimal completionInPercents, Boolean availableMessage, Integer courseId, Integer userId) {
    this.id = id;
    this.startDate = startDate;
    this.completionInPercents = completionInPercents;
    this.availableMessage = availableMessage;
    this.courseId = courseId;
    this.userId = userId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }


  public BigDecimal getCompletionInPercents() {
    return completionInPercents;
  }

  public void setCompletionInPercents(BigDecimal completionInPercents) {
    this.completionInPercents = completionInPercents;
  }

  public Boolean getAvailableMessage() {
    return availableMessage;
  }

  public void setAvailableMessage(Boolean availableMessage) {
    this.availableMessage = availableMessage;
  }

  public Integer getCourseId() {
    return courseId;
  }

  public void setCourseId(Integer courseId) {
    this.courseId = courseId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
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

    CourseInfo comperableCourseInfo = (CourseInfo) o;

    if (id != comperableCourseInfo.id) {
      equal = false;
    }

    if (!startDate.equals(comperableCourseInfo.startDate)) {
      equal = false;
    }

    if (!completionInPercents.equals(comperableCourseInfo.completionInPercents)) {
      equal = false;
    }

    if (!availableMessage.equals(comperableCourseInfo.availableMessage)) {
      equal = false;
    }

    if (!courseId.equals(comperableCourseInfo.courseId)) {
      equal = false;
    }

    if (!userId.equals(comperableCourseInfo.userId)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + startDate.hashCode();
    hashCode = 31 * hashCode + completionInPercents.hashCode();
    hashCode = 31 * hashCode + availableMessage.hashCode();
    hashCode = 31 * hashCode + courseId;
    hashCode = 31 * hashCode + userId;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %12s   %16s   %16s   %10s   %8s", id, startDate, completionInPercents, availableMessage, courseId, userId);
  }

}
