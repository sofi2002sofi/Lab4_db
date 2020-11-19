package com.didula.buisness.model.metadata;

import com.didula.buisness.model.anotation.Column;
import com.didula.buisness.model.anotation.PrimaryKeyComposite;
import com.didula.buisness.model.anotation.Table;

@Table(name = "test_has_answer")
public class TestHasAnswer {
  @PrimaryKeyComposite
  @Column(name = "test_id", type = "int")
  private int testId;

  @PrimaryKeyComposite
  @Column(name = "answer_id", type = "int")
  private int answerId;

  @Column(name = "correct", type = "bool")
  private Boolean correct;

  public TestHasAnswer() {

  }

  public TestHasAnswer(int testId, int answerId, Boolean correct) {
    this.testId = testId;
    this.answerId = answerId;
    this.correct = correct;
  }

  public int getTestId() {
    return testId;
  }

  public void setTestId(int testId) {
    this.testId = testId;
  }

  public int getAnswerId() {
    return answerId;
  }

  public void setAnswerId(int answerId) {
    this.answerId = answerId;
  }

  public Boolean getCorrect() {
    return correct;
  }

  public void setCorrect(Boolean correct) {
    this.correct = correct;
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

    TestHasAnswer comperableTestHasAnswer = (TestHasAnswer) o;

    if (testId != comperableTestHasAnswer.testId) {
      equal = false;
    }

    if (answerId != comperableTestHasAnswer.answerId) {
      equal = false;
    }

    if (!correct.equals(comperableTestHasAnswer.correct)) {
      equal = false;
    }

    return equal;
  }

  @Override
  public int hashCode() {
    int hashCode = 17;
    hashCode = 31 * hashCode + testId;
    hashCode = 31 * hashCode + answerId;
    hashCode = 31 * hashCode + correct.hashCode();
    return hashCode;
  }

  @Override
  public String toString() {
    return String.format("%10s   %10s   %10s ", testId, answerId, correct);
  }
}
