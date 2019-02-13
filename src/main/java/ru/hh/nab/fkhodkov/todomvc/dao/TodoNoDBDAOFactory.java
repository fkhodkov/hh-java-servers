package ru.hh.nab.fkhodkov.todomvc.dao;

public class TodoNoDBDAOFactory extends TodoDAOFactory {

  public static final TodoDAO todoDAO = new TodoNoDBDAO();

  @Override
  public TodoDAO getTodoDAO() {
    return todoDAO;
  }
}
