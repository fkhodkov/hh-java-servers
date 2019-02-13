package ru.hh.nab.fkhodkov.todomvc.dao;

import java.util.Collection;
import java.util.function.Predicate;

import ru.hh.nab.fkhodkov.todomvc.exceptions.TodoNotFoundException;
import ru.hh.nab.fkhodkov.todomvc.model.TodoItem;
import ru.hh.nab.fkhodkov.todomvc.model.TodoStatus;

public interface TodoDAO {
  public int count();
  public long count(Predicate<TodoItem> predicate);
  public long countActive();
  public long countCompleted();

  public void reset();
  public void populate(int numberOfTodos);

  public Collection<TodoItem> getAllItems();
  public Collection<TodoItem> getMatching(Predicate<TodoItem> predicate);
  public Collection<TodoItem> getActiveItems();
  public Collection<TodoItem> getCompletedItems();
  
  public void addItem(TodoItem todoItem);

  public void changeStatus(Integer todoId, TodoStatus status) throws TodoNotFoundException;
  public void changeStatus(Integer todoId, String status) throws TodoNotFoundException;
  public void deleteItem(Integer todoId) throws TodoNotFoundException;
  public void deleteMatching(Predicate<TodoItem> predicate);
  public void deleteCompleted();
}
