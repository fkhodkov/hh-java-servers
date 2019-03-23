package ru.hh.school.fkhodkov.todomvc.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TodoItem")
public class TodoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="todo_id")
  private Integer todoId;

  @Enumerated(EnumType.STRING)
  @Column(name="todo_status")
  private TodoStatus status;

  @Column(name="todo_text", nullable = false)
  private String text;

  public static boolean isActive(TodoItem todoItem) {
    return todoItem.status == TodoStatus.ACTIVE;
  }

  public static boolean isCompleted(TodoItem todoItem) {
    return todoItem.status == TodoStatus.COMPLETED;
  }

  public static void complete(TodoItem todoItem) {
    todoItem.setStatus(TodoStatus.COMPLETED);
  }

  public TodoItem(String text) {
    status = TodoStatus.ACTIVE;
    this.text = text;
  }

  public TodoItem() {
    status = TodoStatus.ACTIVE;
  }

  public TodoItem(Integer todoId, String text, TodoStatus status) {
    this.todoId = todoId;
    this.text = text;
    this.status = status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    TodoItem todoItem = (TodoItem) other;
    return todoId.equals(todoItem.todoId) &&
      status.equals(todoItem.status) &&
      text.equals(todoItem.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(todoId, status, text);
  }

  /**
   * @return the status
   */
  public TodoStatus getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(TodoStatus status) {
    this.status = status;
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @return the todoId
   */
  public Integer getTodoId() {
    return todoId;
  }

  /**
   * @param todoId the todoId to set
   */
  public void setTodoId(Integer todoId) {
    this.todoId = todoId;
  }
}
