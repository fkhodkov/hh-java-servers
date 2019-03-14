package ru.hh.nab.fkhodkov.todomvc;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.nab.fkhodkov.todomvc.dao.TodoNoDBDAO;
import ru.hh.nab.fkhodkov.todomvc.dao.TodoNoDBDAOFactory;
import ru.hh.nab.fkhodkov.todomvc.service.TodoService;
import ru.hh.nab.testbase.NabTestConfig;

@Configuration
@Import({NabTestConfig.class, TodoService.class, TodoNoDBDAOFactory.class, TodoNoDBDAO.class})
public class TodoTestConfig {

  @Bean
  Function<String, String> serverPortAwareBean(String jettyBaseUrl) {
    return path -> jettyBaseUrl + path;
  }
}
