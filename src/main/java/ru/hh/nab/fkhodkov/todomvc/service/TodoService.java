package ru.hh.nab.fkhodkov.todomvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ru.hh.nab.fkhodkov.todomvc.dao.TodoDAO;
import ru.hh.nab.fkhodkov.todomvc.dao.TodoDAOFactory;
import ru.hh.nab.fkhodkov.todomvc.dto.TodoCollectionDTO;
import ru.hh.nab.fkhodkov.todomvc.dto.TodoItemDTO;
import ru.hh.nab.fkhodkov.todomvc.exceptions.TodoNotFoundException;
import ru.hh.nab.fkhodkov.todomvc.model.TodoStatus;

@Service
@Component
public class TodoService {
  private final TodoDAO todoDAO;

  @Autowired
  public TodoService(TodoDAOFactory todoDAOFactory) {
    todoDAO = todoDAOFactory.getTodoDAO();
  }

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
