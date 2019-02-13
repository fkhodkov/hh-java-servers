package ru.hh.nab.fkhodkov.todomvc.service;

import ru.hh.nab.fkhodkov.todomvc.dao.TodoDAO;
import ru.hh.nab.fkhodkov.todomvc.dao.TodoNoDBDAOFactory;
import ru.hh.nab.fkhodkov.todomvc.dto.TodoCollectionDTO;
import ru.hh.nab.fkhodkov.todomvc.dto.TodoItemDTO;
import ru.hh.nab.fkhodkov.todomvc.exceptions.TodoNotFoundException;
import ru.hh.nab.fkhodkov.todomvc.model.TodoStatus;

public class TodoService {
  private final TodoDAO todoDAO = new TodoNoDBDAOFactory().getTodoDAO();

  public TodoCollectionDTO getTodoItems() {
    return new TodoCollectionDTO(todoDAO.getAllItems());
  }

  public TodoCollectionDTO getActiveTodoItems() {
    return new TodoCollectionDTO(todoDAO.getActiveItems());
  }

  public TodoCollectionDTO getCompletedTodoItems() {
    return new TodoCollectionDTO(todoDAO.getCompletedItems());
  }

  public void addTodoItem(TodoItemDTO itemDTO) {
    todoDAO.addItem(itemDTO.todoItem());
  }
  
  public void changeTodoStatus(Integer todoId, TodoStatus status) throws TodoNotFoundException {
    todoDAO.changeStatus(todoId, status);
  }

  public void deleteCompletedTodo() {
    todoDAO.deleteCompleted();
  }

  public void deleteTodo(Integer todoId) throws TodoNotFoundException {
    todoDAO.deleteItem(todoId);
  }
}
