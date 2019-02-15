# Домашнее задание: TodoMVC

## API

* Вернуть все TODO: `GET /todo`
* Вернуть активные TODO: `GET /todo/active`
* Вернуть завершенные TODO: `GET /todo/completed`
* Добавить TODO: `POST /todo` (в теле запроса передать `{"text": <Текст нового TODO>}`)
* Изменить статус TODO: `PUT /todo/{id}` (в теле запроса передать `{"todoStatus": <"active" или "completed">}`)
* Удалить TODO: `DELETE /todo/{id}`
* Удалить завершенные TODO: `DELETE /todo/completed`
