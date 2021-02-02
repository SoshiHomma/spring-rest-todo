# spring-rest-todo

An implemented REST API by me with Java and Spring Framework.
Using Gradle and Java 11.

## Prerequisite
- Java
- Gradle
- PostgreSQL

## Methods

#### `GET /api/v1/todo`

To get all of todos

#### `POST /api/v1/todo`
*body:*
```json
{
    "content": "a todo"
}
```

To create a todo

#### `PUT /api/v1/todo/{todo_id}`
*body:*
```json
{
    "content": "an updated todo"
}
```

To update the specified todo

#### `DELETE /api/v1/todo`

To delete all todos

#### `DELETE /api/v1/todo/{todo_id}`

To delete the specified todo


