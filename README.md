# Домашнее задание: TodoMVC

## Сборка и запуск

```sh
mvn clean install && mvn exec:java
```

## API
После сборки и запуска будет находится по адресу http://localhost:9999

* Вернуть все TODO: `GET /todo`
* Вернуть активные TODO: `GET /todo/active`
* Вернуть завершенные TODO: `GET /todo/completed`
* Добавить TODO: `POST /todo` (в теле запроса передать `{"text": <Текст нового TODO>}`)
* Изменить статус TODO: `PUT /todo/{id}` (в теле запроса передать `{"todoStatus": <"active" или "completed">}`)
* Удалить TODO: `DELETE /todo/{id}`
* Удалить завершенные TODO: `DELETE /todo/completed`
