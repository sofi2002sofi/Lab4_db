package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKey;
import com.didula.buisness.model.anotation.Table;

@Table(name = "answer")
public class Answer {

  @PrimaryKey
  @Column(name = "id", type = "int")
  private int id;

  @Column(name = "answer_name", length = 50)
  private String answerName;

  public Answer() {
  }

  public Answer(int id, String answerName) {
    this.id = id;
    this.answerName = answerName;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAnswerName() {
    return answerName;
  }

  public void setAnswerName(String answerName) {
    this.answerName = answerName;
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

    Answer comperableAnswer = (Answer) o;

    if (id != comperableAnswer.id) {
      equal = false;
    }

    if (!answerName.equals(comperableAnswer.answerName)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + id;
    hashCode = 31 * hashCode + answerName.hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%3s   %30s ", id, answerName);
  }
}
