package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

@Table(name = "message")
public class Message {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "message_content", length = 200)
  private String messageContent;

  @Column(name = "count_of_overdued_tests", type = "int")
  private Integer countOfOverduedTests;

  @Column(name = "count_of_overdued_modules", type = "int")
  private Integer countOfOverduedModules;

  @Column(name = "course_info_id", type = "int")
  private Integer courseInfoId;

  public Message() {

  }

  public Message(int id, String messageContent, Integer countOfOverduedTests, Integer countOfOverduedModules, Integer courseInfoId) {
    this.id = id;
    this.messageContent = messageContent;
    this.countOfOverduedTests = countOfOverduedTests;
    this.countOfOverduedModules = countOfOverduedModules;
    this.courseInfoId = courseInfoId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMessageContent() {
    return messageContent;
  }

  public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
  }

  public Integer getCountOfOverduedTests() {
    return countOfOverduedTests;
  }

  public void setCountOfOverduedTests(Integer countOfOverduedTests) {
    this.countOfOverduedTests = countOfOverduedTests;
  }

  public Integer getCountOfOverduedModules() {
    return countOfOverduedModules;
  }

  public void setCountOfOverduedModules(Integer countOfOverduedModules) {
    this.countOfOverduedModules = countOfOverduedModules;
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

    Message comperableMessage = (Message) o;

    if (id != comperableMessage.id) {
      equal = false;
    }

    if (!messageContent.equals(comperableMessage.messageContent)) {
      equal = false;
    }

    if (!countOfOverduedTests.equals(comperableMessage.countOfOverduedTests)) {
      equal = false;
    }

    if (!countOfOverduedModules.equals(comperableMessage.countOfOverduedModules)) {
      equal = false;
    }

    if (!courseInfoId.equals(comperableMessage.courseInfoId)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + messageContent.hashCode();
    hashCode = 31 * hashCode + countOfOverduedModules;
    hashCode = 31 * hashCode + countOfOverduedTests;
    hashCode = 31 * hashCode + courseInfoId;
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %70s   %20s   %20s   %10s ", id, messageContent, countOfOverduedTests, countOfOverduedModules, courseInfoId);
  }

}
