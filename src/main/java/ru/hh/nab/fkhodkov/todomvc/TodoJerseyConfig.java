package ru.hh.nab.fkhodkov.todomvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.hh.nab.fkhodkov.todomvc.resource.TodoResource;

@Configuration
@Import(TodoResource.class)
public class TodoJerseyConfig {
}
