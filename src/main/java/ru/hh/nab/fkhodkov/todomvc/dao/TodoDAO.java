package ru.hh.nab.fkhodkov.todomvc.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import ru.hh.nab.fkhodkov.todomvc.exceptions.TodoNotFoundException;
import ru.hh.nab.fkhodkov.todomvc.model.TodoItem;
import ru.hh.nab.fkhodkov.todomvc.model.TodoStatus;

@Repository
public interface TodoDAO {
  public int count();
  public int countActive();
  public int countCompleted();

  public void reset();
  public void populate(int numberOfTodos);

  public Collection<TodoItem> getAllItems();
  public Collection<TodoItem> getActiveItems();
  public Collection<TodoItem> getCompletedItems();
  
  public void addItem(TodoItem todoItem);

  public void changeStatus(Integer todoId, TodoStatus status) throws TodoNotFoundException;
  public void deleteItem(Integer todoId) throws TodoNotFoundException;
  public void deleteCompleted();
}
